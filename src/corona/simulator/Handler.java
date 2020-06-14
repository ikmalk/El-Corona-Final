package corona.simulator;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class Handler {
	
	/***********************************
	 * Created at 11/6/2020
	 * 
	 * Handler class handles the addition ,deletion and activity of items in the program (Place class and Person class)
	 * 
	 */
		
	LinkedList<Item> object = new LinkedList<Item>();
	
	
	public void tick() {
		Iterator<Item> iterator = object.descendingIterator();
		while(iterator.hasNext()){
		Item tempObject = iterator.next();
		
		tempObject.tick();
		}
	}

	public void render(Graphics g)throws Exception {
		Iterator<Item> iterator = object.descendingIterator();
		while(iterator.hasNext()){
		Item tempObject = iterator.next();
		
		tempObject.render(g);
		}
	}
	
	/*
	 * -Called when the back button is clicked
	 */
	public void clear(){
		object.clear();
	}
	
	/*
	 * -Called each time an item is added
	 */	
	public void addObject(Item object) {
		this.object.add(object);
	}
	
	public void removeObject(Item object) {
		this.object.remove(object);
	}
	
	
}
