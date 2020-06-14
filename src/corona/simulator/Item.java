package corona.simulator;

import java.awt.Graphics;

import java.awt.Rectangle;

public abstract class Item {
	
	/***********************************
	 * Created at 11/6/2020
	 * An abstract class that will be inherited to the Person and Place class
	 */
	
	protected float x;
	protected float y;
	protected float velX, velY;
	protected TYPE id;
	
	
	public Item(float x, float y, TYPE id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	
	public abstract void tick();		
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x=x;		
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setId(TYPE id) {
		this.id = id;
	}
	
	public TYPE getId() {
		return id;
	}
	
	public void setVelX(int x) {
		this.velX = x;
	}
	
	public void setVelY(int y) {
		this.velY=y;
	}
	public float getVelY() {
		return velY;
	}
	
	public float getVelX() {
		return velX;
	}
}
