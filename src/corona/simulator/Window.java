package corona.simulator;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Window extends Canvas{
		
	/*
	 * JFrame for the simulator
	 */
	
	
	
	public Window(int width, int height, String title, InfectionSimulator simulator) {
		JFrame frame = new JFrame(title);
						
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(simulator);
		frame.setVisible(true);
		simulator.start();
		
		
	}

}
