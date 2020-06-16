package corona.simulator;

import java.awt.Canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ListIterator;
import java.util.Random;

import corona.DoubleLinkedList;
import corona.movement.Person;



@SuppressWarnings("serial")
public class InfectionSimulator extends Canvas implements Runnable {
	
	/***********************************
	 * Created at 11/6/2020
	 * 
	 * -This is the Simulator for the infection
	 * -It will take the DoubleLinkedList from the Movement Simulator and the people who is infected
	 * -It will on a clock that will update every frame, have a loop method that runs until closed
	 * 
	 * *********************************
	 * 
	 */
	
	
	public static final int WIDTH = 900, HEIGHT = 690; 
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	private Handler handler2;
	private Handler handlerPlace;
	private HUD hud;
	private Spawn spawner;
	private Menu menu;
	private DoubleLinkedList<Person> list;
	private Person infected;
	private int dayInfected;
	
	private static int fps;
	
	public static STATE State = STATE.Menu;
	
	
	public InfectionSimulator(DoubleLinkedList<Person> list,int name,int dayInfected) {
		
		this.list = list;
		this.dayInfected = dayInfected;
		ListIterator<Person> iterator = list.getListIterator();
		int index = 0;
		while(iterator.hasNext()) {
			infected = iterator.next();
			index++;
			if(infected.getID()==name)
				break;
		}
		list.deleteNodeByPosition(index);
		
		handler = new Handler();
		handler2 = new Handler();
		handlerPlace = new Handler();
		hud = new HUD();
		menu = new Menu(this, handler, handler2,handlerPlace,hud);
		this.addMouseListener(menu);
		
		
		new Window(WIDTH, HEIGHT, "Simulator", this);
		
	}
	
	/*
	 * -Called from the Menu class
	 * -starts the handler class that will add all the item
	 * -Begins the simulation
	 */
	
			
	public void spawn(double multiplier,double radius,int dayQ){

		Place[] place = new MapPlace().getPlace();
		
		spawner = new Spawn(infected,dayInfected,list,handler, handler2,hud, place,multiplier,radius,dayQ);
				
		
		State = STATE.Simulation;
		if(State == STATE.Simulation) 
		{
			for(int i = 0;i<place.length;i++) { 
				handlerPlace.addObject(place[i]);
			}
		}
			
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
		}
	}
	
	/*
	 * -This is the program main loop
	 * -It will update each frame
	 * -Call the render and tick method
	 */
	public void run(){
		  this.requestFocus();
		  long lastTime = System.nanoTime();				 // get current time to the nanosecond
		  double amountOfTicks = 60.0;						 // set the number of ticks 
		  double ns = 1000000000 / amountOfTicks; 			// this determines how many times we can divide 60 into 1e9 of nano seconds or about 1 second
		  double delta = 0;									 // change in time (delta always means a change like delta v is change in velocity)
		  long timer = System.currentTimeMillis(); 			// get current time
		  int frames = 0; 									// set frame variable
		  while(running){ 
		   long now = System.nanoTime(); 					// get current time in nanoseconds during current loop
		   delta += (now - lastTime) / ns; 					// add the amount of change since the last loop
		   lastTime = now;  								// set lastTime to now to prepare for next loop
		   while(delta >= 1){
														    // one tick of time has passed in the game this 
														    //ensures that we have a steady pause in our game loop 
														    //so we don't have a game that runs way too fast 
														    //basically we are waiting for  enough time to pass so we 
														    // have about 60 frames per one second interval determined to the nanosecond (accuracy)
														    // once this pause is done we render the next frame
		    try{
		    	tick();  
		    }catch(NullPointerException e){
		    	
		    }
		    delta--;  										// lower our delta back to 0 to start our next frame wait
		   }
		   if(running){
		    render(); 										// render the visuals of the game
		   }
		   frames++; 										// note that a frame has passed
		   if(System.currentTimeMillis() - timer > 1000 ){ // if one second has passed
		    timer+= 1000; 									// add a thousand to our timer for next time
		    if(State==STATE.Simulation)
		    	hud.setFps(frames); 			// print out how many frames have happened in the last second
		    frames = 0;						 				// reset the frame count for the next second
		   }
		  }
		  stop();										 	// no longer running stop the thread
		 }
	
	/*
	 * -This is the method that will call all the classes' tick method
	 * -tick method responsible for updating all the value of variable in the class
	 */		
	private void tick() throws NullPointerException{  //sometime the handler class will cause a null pointer exception when pressing the back button
		handler.tick();
		handler2.tick();
		handlerPlace.tick();
		if(State == STATE.Simulation) {			
			spawner.tick();			
			hud.tick();
		}
		else if(State == STATE.Menu) {
			menu.tick();
			
		}
		
		
	}
	
	/*
	 * -This is the method that will call all the render method in each classes
	 * -render method responsible for the graphic of the programs
	 * -this is the one that will visualize the movement of each of the item
	 */
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
						
		try {
			handler.render(g);
			handler2.render(g);
			handlerPlace.render(g);
		} catch (Exception e) {
		}
		
		if(State == STATE.Simulation) {

			hud.render(g);
			menu.render(g);
		}
		else if(State == STATE.Menu) {
			menu.render(g);
		}
				
		g.dispose();
		bs.show();
		
		
	}
	
	public static int getFps() {
		return fps;
	}
	

}
