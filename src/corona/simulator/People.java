package corona.simulator;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Random;
import corona.movement.Person;

public class People extends Item{
	
	/***********************************
	 * Created at 11/6/2020
	 * -This is the people class
	 * -It will have a String[][] event that will determine the movement of the people
	 * -It will get the Place that have the same name as in the event and get the place coordinate and and went to that place
	 * -Have 3 states, Suspected, Infected, Removed
	 * -Suspected will become Infected if collides with Infected INSIDE the place
	 * -Infected becomes Removed after 5 days
	 * 
	 */
	
	private Handler handler;
	private Handler handler2;
	private Place target;
	private Place[] place;
	private Random r = new Random();
	private int n = 0;
	private int chance;
	private HEALTH health;
	private HUD hud;
	private int dayInfected;
	private int size = 5;
	private double multiplier, radius;
	private int dayQ;
	private double immunity;
	private int event;
	private String[][] activities;
	private Person person;
	

	
	public People(Person person,int x, int y, TYPE id, Handler handler,Handler handler2,Place[] place,HEALTH health,HUD hud,double multiplier,double radius,int dayQ) {
		super(x, y, id);		
		this.handler = handler;
		this.place = place;
		
		this.health = health;
		this.hud = hud;
		this.handler2 = handler2;
		this.multiplier = multiplier;
		this.radius=radius;
		this.dayQ = dayQ;
		this.person = person;
		event = hud.getEvent();
		activities = person.getEvent();
		immunity = person.getImmunity()/200;
		chance = (int)(1000*immunity*this.multiplier);
		for(int i=0;i<place.length;i++) {
			if(place[i].getName().equals(activities[(hud.getDay())%14][hud.getEvent()])) {
				target = place[i];

				break;			
			}
		}

	}
	
	public void setHealth(HEALTH health) {
		this.health = health;
	}
	
	public HEALTH getHealth() {
		return health;
	}

	
	/*
	 * will return the radius of the people
	 */
	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, (int)radius*size, (int)radius*size);
	}



	public void tick(){
		if(hud.getDay()>0) {
			if(health==HEALTH.Infected) {
				
				if(hud.getDay()-dayInfected>=5) {
					health=HEALTH.Removed;
					hud.setInfected(hud.getInfected()-1);
					hud.setRemoved(hud.getRemoved()+1);
					collision();
				}
				else if((hud.getDay()-dayInfected)>=(dayQ)&&dayQ>0) {
					quarantine();
				}				
				else
					collision();
			}
			else
				collision();	
		}
	}


	public void render(Graphics g) {
		if(health==HEALTH.Suspected)
			g.setColor(Color.green);
		else if(health==HEALTH.Infected)
			g.setColor(Color.red);
		else if(health==HEALTH.Removed)
			g.setColor(Color.gray);
		g.fillRect((int)x , (int)y, size, size);
	}
	
	/*
	 * Determine the movement
	 */
	
	private void collision() { //it returns boolean because I used it for debugging, now it is redundant
	
		//Person is inside the Place
		if(getBounds().intersects(target.getBounds())) {
			if(event==hud.getEvent()) {
				x += velX;
				y += velY;
				n++;
				int h;
				if(r.nextInt(2)==1)
					h=-1;
				else
					h=1;				
				x+=1/(r.nextInt(6)+1)*h*1.0f;
				y+=1/(r.nextInt(6)+1)*h*1.0f;
				int k = 50;
				int l = 50;
				if(target.getName().equals("Hospital")) {
					k = 165;
					l=165;
				}
				else if(target.getName().equals("Park")) {
					k=175;
					l=220;
				}
				else if(target.getName().equals("PoliceStation")) {
					k = 120;
					l=175;
				}
					
					
				if(n>30) {
					if(y <= target.getBounds().y || y >= target.getBounds().y+l) 
						velY *= -1;
					if(x <= target.getBounds().x || x >= target.getBounds().x+k) 
						velX *= -1;
				}
												
				if(health==HEALTH.Suspected) { //where the infection happen
					Iterator<Item> iterator = handler.object.descendingIterator();
					while(iterator.hasNext()){
						People tempP = (People)iterator.next();
						if(tempP.getHealth()==HEALTH.Infected) {
							if(getBounds().intersects(tempP.getBounds())) {
								if(r.nextInt(2000)<chance) {    
									setHealth(HEALTH.Infected);
									dayInfected = hud.getDay();
									hud.setInfected(hud.getInfected()+1);
									hud.setSuspected(hud.getSuspected()-1);
									hud.append(person.getID(), hud.getDay(), target.getName());
									return;
								}
							}
						}
					}					
					iterator = handler2.object.descendingIterator();
					while(iterator.hasNext()){
						People tempP = (People)iterator.next();
						if(tempP.getHealth()==HEALTH.Infected) {
							if(getBounds().intersects(tempP.getBounds())) {
								if(r.nextInt(2000)<chance) {    
									setHealth(HEALTH.Infected);
									dayInfected = hud.getDay();
									hud.setInfected(hud.getInfected()+1);
									hud.setSuspected(hud.getSuspected()-1);
									hud.append(person.getID(), hud.getDay(), target.getName());
								}
							}
						}
					}
					
					
				}
				
			}
			else {
				for(int i=0;i<place.length;i++) {
					if(place[i].getName().equals(activities[(hud.getDay()-1)%14][hud.getEvent()])) {
						target = place[i];
						break;			
					}
				}				
				event = hud.getEvent();			
			}
			return;
		}
		//Outside place
		else { 
			n=0;
		//so that there will be no confusion in collision
			x += velX;
			y += velY;
			
			int l = 15;
			if(target.getName().equals("Hospital")) {
				l=80;
			}
			else if(target.getName().equals("Park")) {
				l=60;
			}
			else if(target.getName().equals("PoliceStation")) {
				l=40;
			}
			
			float diffX = x - target.getX()-l;
			float diffY = y - target.getY()-l;
			/*
			 * The equation to get the place coordinate
			 */
			float distance = (float) Math.sqrt((x- target.getX())*(x-target.getX()) + (y - target.getY())*(y-target.getY()));
			
			/*
			 * The person will chase the place according to coordinate
			 */			
			velX = (float)((-1.0/distance)* 1.9*diffX);
			velY =  (float)((-1.0/distance)* 1.9*diffY);
			
			if(y <= 0 || y >= InfectionSimulator.HEIGHT - 64 + 16) velY *= -1;
			if(x <= 0 || x >= InfectionSimulator.WIDTH - 32) velX *= -1;
		}
		
		
	}
	
	/*
	 * Called for quarantine
	 */
	
	private void quarantine() {
		if(!target.getName().equals("Quarantine")) {
			for(int i = 0;i<place.length;i++) {
				if(place[i].getName().equals("Quarantine")) {
					target = place[i];
					break;
				}
			}
		}
		if(getBounds().intersects(target.getBounds())) {
			x += velX;
			y += velY;
			n++;
			int k = 175;
			int l = 175;
			int h;
			if(r.nextInt(2)==1)
				h=-1;
			else
				h=1;
			
			x+=1/(r.nextInt(6)+1)*h*1.0f;
			y+=1/(r.nextInt(6)+1)*h*1.0f;
			
			if(n>30) {
				if(y <= target.getBounds().y || y >= target.getBounds().y+l) 
					velY *= -1;
				if(x <= target.getBounds().x || x >= target.getBounds().x+k) 
					velX *= -1;
			}
						
		}
		else { 
			n=0;
		//so that there will be no confusion in collision
			x += velX;
			y += velY;
			
			float diffX = x - target.getX()-55;
			float diffY = y - target.getY()-55;
			/*
			 * The equation to get the place coordinate
			 */
			float distance = (float) Math.sqrt((x- target.getX())*(x-target.getX()) + (y - target.getY())*(y-target.getY()));
			
			/*
			 * The person will chase the place according to coordinate
			 */			
			velX = (float)((-1.0/distance)* 1.85*diffX);
			velY =  (float)((-1.0/distance)* 1.85*diffY);
			
		}
	}
	
	public void setDayInfected(int dayInfected) {
		this.dayInfected = dayInfected;
	}
	
	public void append() {
		hud.append(person.getID(), hud.getDay(), target.getName());
	}
	
}
	
