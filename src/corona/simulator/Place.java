package corona.simulator;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Place extends Item{
	

	/***********************************
	 * Created at 11/6/2020
	 * A building class
	 * Created at the MapPlace class
	 */

	private int sizeX;
	private int sizeY;
	private String name;
	
	public Place(float x, float y,int sizeX,int sizeY, TYPE id,String name) {
		super(x, y, id);
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public int getSizeX() {
		return sizeX;
	}
	
	public int getSizeY() {
		return sizeY;
	}
	public void render(Graphics g) {
		Font font2 = new Font("arial", 1, 10);
		g.setFont(font2);
		g.setColor(Color.white);
		g.drawRect((int)x, (int)y, sizeX, sizeY);
		g.drawString(name, (int)x+2, (int)y+15);
	}

	@Override
	public Rectangle getBounds() {

		return new Rectangle((int)x, (int)y, sizeX, sizeY);
	}

}
