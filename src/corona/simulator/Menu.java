package corona.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Random;




public class Menu extends MouseAdapter{
	
	/***********************************
	 * Created at 11/6/2020
	 * 
	 * -Determine the state of the game (the STATE enum)
	 * -Will call the spawn method in the game if the start button is clicked
	 * -will return the variable for the manipulator of the simulation(not done)
	 * 
	 */
	
	private InfectionSimulator simulator;
	private Handler handler;
	private Handler handler2;
	private Handler handlerPlace;
	private double multiplier,radius;
	private int dayQ;
	private HUD hud;
	
	private Random g = new Random();
	private DecimalFormat df;
	
	
	public Menu(InfectionSimulator simulator,Handler handler,Handler handler2, Handler handlerPlace,HUD hud) {
		this.simulator = simulator;
		this.handler = handler;
		this.handler2 = handler2;
		this.handlerPlace = handlerPlace;
		this.hud = hud;
		multiplier = 1.0f;
		radius = 1.0f;
		dayQ = 0;
		df = new DecimalFormat("#.##");
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		
		
		if(InfectionSimulator.State == STATE.Menu) {																
			//Start button
			if(mouseOver(mx, my, 370, 150, 150, 60)) {
				InfectionSimulator.State = STATE.Simulation;
				simulator.spawn(multiplier,radius,dayQ);				
			}
			//multiplier
			if(mouseOver(mx, my, 293, 272, 20, 20)) {
				if(multiplier<3.0) {
					multiplier+=0.1;
					multiplier = Double.parseDouble(df.format(multiplier));
				}
			}
			if(mouseOver(mx, my, 315, 272, 20, 20)) {
				if(multiplier>0.5) {
					multiplier-=0.1;
					multiplier = Double.parseDouble(df.format(multiplier));
				}
			}
			//radius
			if(mouseOver(mx, my, 293, 302, 20, 20)) {
				if(radius<3) {
					radius+=0.1;
					radius = Double.parseDouble(df.format(radius));
				}
			}
			if(mouseOver(mx, my, 315, 302, 20, 20)) {
				if(radius>1) {
					radius-=0.1;
					radius = Double.parseDouble(df.format(radius));
				}
			}
			//day
			if(mouseOver(mx, my, 293, 332, 20, 20)) {
				if(dayQ<3)
					dayQ++;
			}
			if(mouseOver(mx, my, 315, 332, 20, 20)) {
				if(dayQ>0)
					dayQ--;
			}

		}
		if(InfectionSimulator.State==STATE.Simulation) {
			
			if(mouseOver(mx, my, InfectionSimulator.WIDTH-180, InfectionSimulator.HEIGHT-107, 100, 35)) {
								
				handler.clear();
				handler2.clear();
				handlerPlace.clear();
				hud.setSuspected(0);
				hud.setInfected(0);
				hud.setRemoved(0);
				hud.setDay(0);
				hud.reset();
				InfectionSimulator.State = STATE.Menu;
				
								
			}
		}						
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}
			else return false;
		}
		else return false;
	}
	
	public void tick() {
	
		
	}
	
	public void render(Graphics g) {
		if(InfectionSimulator.State == STATE.Menu) {
			Font font = new Font("arial", 1, 50);
			Font font2 = new Font("arial", 1, 30);
			
			
			g.setFont(font);		
			g.setColor(Color.white);
			
			g.drawString("Infection Simulation", 200, 100);
			
			g.setFont(font2);
			
			g.drawString("Start", 410, 190);
			g.drawRect(370, 150, 150, 60);
			
			font2 = new Font("arial", 1, 20);
			g.setFont(font2);
			g.drawString("Infection Multiplier: "+multiplier, 340, 290);
			g.drawString("+", 297, 289);
			g.drawRect(315, 272, 20, 20);
			g.drawString("-", 321, 287);
			g.drawRect(293, 272, 20, 20);
			
			g.drawString("Infection Radius: "+radius, 340, 320);
			g.drawString("+", 297, 320);
			g.drawRect(315, 302, 20, 20);
			g.drawString("-", 321, 317);
			g.drawRect(293, 302, 20, 20);
			
			String d = "";
			if(dayQ==0)
				d = "None";
			else
				d+=dayQ;
			
			g.drawString("Infected will be isolated at day : "+d, 340, 350);
			g.drawString("+", 297, 350);
			g.drawRect(315, 332, 20, 20);
			g.drawString("-", 321, 347);
			g.drawRect(293, 332, 20, 20);
			
			
		}
		else if(InfectionSimulator.State==STATE.Simulation) {
			Font font2 = new Font("arial",1, 20);
			g.setFont(font2);
			g.setColor(Color.white);
			g.drawString("Back", InfectionSimulator.WIDTH-150, InfectionSimulator.HEIGHT-85);
			g.drawRect(InfectionSimulator.WIDTH-180, InfectionSimulator.HEIGHT-107, 100, 35);
		}
		
		
	}
}
