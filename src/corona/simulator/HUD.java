package corona.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
		
	/***********************************
	 * Created at 11/6/2020
	 * -Handles the day, suspected, infection and removed count
	 * -Updates it accordingly
	 */
	
	private int suspected;
	private int infected;
	private int removed;
	private int day;
	private int count;
	private int fps;
	private int event;
	private LogUpdate log;

	
	public HUD() {
		suspected = 0;
		infected = 0;
		removed = 0;
		day = 0;
		count = 0;
		event = 0;
		log = null;
	}
	
	public void tick() {
		if(day==0)
			if(log==null)
				setLog();
		if(day>0) {
			// one day is equal to 1500 ticks
			if(count==0)
				event = 0;
			else if(count==500)
				event=1;
			else if(count==1000)
				event=2;
			count++;
			if(count==1500) {
				day++;
				count=0;
			}
			
		}
		
		
	}
	
	private void setLog() {
		log = new LogUpdate();
		log.setSize(285,330);
		log.setVisible(true);
		log.reset();
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		Font font2 = new Font("arial", 1, 9);
		g.drawString("fps: " + fps, InfectionSimulator.WIDTH-62, 20);
		font2 = new Font("arial", 1, 18);
		g.setFont(font2);
		g.drawString("Day: " + day, InfectionSimulator.WIDTH-222, 34);
		g.drawString("Suspected: " + suspected, InfectionSimulator.WIDTH-222, 64);
		g.drawString("Infected: " + infected, InfectionSimulator.WIDTH-222, 94);
		g.drawString("Removed: "+removed, InfectionSimulator.WIDTH-222, 124);
		
		if(day>0&&infected==0)
			g.drawString("Eradication successful", InfectionSimulator.WIDTH-227, 334);

		
		
	}
	
	public void append(int name,int day,String building) {
		log.setLog(name,day,building);
	}
	
	public void reset() {
		try {
		log.reset();
		}catch(NullPointerException e) {}
	}
	
	public void setSuspected(int suspected) {
		this.suspected = suspected;
	}
	
	public int getSuspected() { 
		return suspected;
	}
	
	
	public int getDay() {
		return day;
	
	}
	public void setDay(int day) {
		this.day = day;
	}
	
	public int getEvent() {
		return event;
	}
	
	public void setFps(int fps) {
		this.fps = fps;
	}

	public int getInfected() {
		return infected;
	}

	public void setInfected(int infected) {
		this.infected = infected;
	}
	
	
	public int getRemoved() {
		return removed;
	}

	public void setRemoved(int removed) {
		this.removed = removed;
	}

}
