package corona.simulator;

import java.util.ListIterator;

import java.util.Random;

import corona.DoubleLinkedList;
import corona.movement.Person;

public class Spawn {
	
	/*
	 * Will handle all the spawning of people
	 */
	
	private Handler handler;
	private Handler handler2;
	private HUD hud;
	private Random g = new Random();	
	private int n;
	private Place[] place;
	private double multiplier, radius;
	private int dayQ;
	private DoubleLinkedList<Person> list;
	private ListIterator<Person> iterator;
	private Person infected;
	private boolean added = true;
	private boolean dayAdded = true;
	private int dayInfected;
	
	
	
	public Spawn(Person infected,int dayInfected,DoubleLinkedList<Person> list,Handler handler,Handler handler2, HUD hud,Place[] place,double multiplier,double radius,int dayQ) {
		this.handler = handler;
		this.hud = hud;
		this.place = place;
		this.handler2 = handler2;
		this.multiplier = multiplier;
		this.radius = radius;
		this.dayQ = dayQ;
		n=0;
		this.infected=infected;
		this.dayInfected = dayInfected;
		this.iterator = list.getListIterator();
	}
	
	public void tick() throws NullPointerException{
		
		if(iterator.hasNext()) {
			Person temp = iterator.next();
			handler.addObject(new People(temp,g.nextInt(600),g.nextInt(600),TYPE.People,handler,handler2,place,HEALTH.Suspected,hud,multiplier,radius,dayQ));
			hud.setSuspected(hud.getSuspected()+1);
			if(iterator.hasNext()) {
				temp = iterator.next();
				handler2.addObject(new People(temp,g.nextInt(600),g.nextInt(600),TYPE.People,handler,handler2,place,HEALTH.Suspected,hud,multiplier,radius,dayQ));
				hud.setSuspected(hud.getSuspected()+1);
			}
			
		}
		else {
			if(dayAdded) {
				/*
				 * Set the day to 1 so the activity of people will start
				 */
				hud.setDay(1); 
				dayAdded= false;
			}
			
			if(added&&hud.getDay()==dayInfected) {
				People temp = new People(infected,g.nextInt(600),g.nextInt(600),TYPE.People,handler,handler2,place,HEALTH.Infected,hud,multiplier,radius,dayQ);
				temp.setDayInfected(dayInfected);
				temp.append();
				handler.addObject(temp);
				hud.setInfected(hud.getInfected()+1);
				added = false;
				
			}
		}

	}
		
}
	

