package corona;

import java.awt.Color;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ListIterator;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;

import corona.movement.Adult;
import corona.movement.Children;
import corona.movement.MovementSimulatorAlgorithm;
import corona.movement.Person;
import corona.movement.Senior;
import corona.map.Map;
import corona.simulator.InfectionSimulator;

@SuppressWarnings("serial")
public class MovementSimulatorFrame extends JFrame{

	/**
	 ***************************************
	 ***Created at 31/5/2020
	 *
	 *This the GUI for the Movement Simulator
	 *
	 *
	 ***************************************
	 ***Write all your changes here
	 *
	 *Ikmal 31/5/2020
	 *Set up all the basic GUI stuff
	 *
	 *Ikmal 10/6/2020
	 *Merge the MovementSimulatorAlgorithm to the frame
	 *
	 *Ikmal 11/6/2020
	 *Implement the next and prev button
	 *Add search method
	 *
	 **************************************
	 ***To do list
	 *-implement an iterator from a double-linked list for prev and next button(done)
	 *-implement all handler class action(not done)
	 *-add Scroll for all JTextArea if possible(after two semester, finally found the solution)
	 *-add show adult, children and senior button(not done)
	 *-add search method(done)
	 *
	 **************************************
	 ***Handler class action
	 *
	 **start button
	 *-it will start the simulation
	 *-while the simulation is loading, set result to visible and set text to "Loading"
	 *-after the simulation is complete, call visible method to true
	 *-random a number(for person name), find said person and set the text to result
	 *-set number of children, adult and senior to data
	 *-set iterator for prev and next
	 *
	 **search
	 *-find said person and set the text to result
	 *-reset the iterator pointing at said person
	 *
	 **prev & next
	 *-find the previous or next person from the iterator and set it to result
	 *
	 **NameI & DayI
	 *-Open the simulation frame with the name and day parameter
	 *
	 **************************************
	 */
	
	private JTextField title;
	private JTextField search;
	private JTextField name;
	private JTextField enter;
	private JTextField nameT; //T for title, I for input
	private JTextField nameI;
	private JTextField dayT;
	private JTextField dayI;
	
	private JTextArea result;
	private JTextArea data;
	
	private JButton start;
	private JButton prev;
	private JButton next;
	private JButton sim;
//	private JButton showMap;
		
	private Font font1;
	private Font font2;
	private Font font3;
	private Font font4;
	
	private JPanel topPanel;
	private JPanel bottomRightPanel;
	private JScrollPane midLeftPanel;
	private JScrollPane midRightPanel;
	
	private MovementSimulatorAlgorithm moveAlgo;
	
	private DoubleLinkedList<Children> childList;
	private DoubleLinkedList<Adult> adultList;
	private DoubleLinkedList<Senior> seniorList;
	private DoubleLinkedList<Person> list;
	
	private ListIterator<Children> childIterator;
	private ListIterator<Adult> adultIterator;
	private ListIterator<Senior> seniorIterator;
	private ListIterator<Person> iterator;
	
	private Map map;
	
    private InfectionSimulator simulator;
	
	public MovementSimulatorFrame() {
		
		/*
		 *********************************************************
		 * The constructor is just for GUI code, all action were *
		 * determined at the private Handler class at the bottom *
		 *********************************************************
		 */
		
		super("Movement");
		requestFocus();
		
		
		font1 = new Font("SansSerif", Font.BOLD, 30);
		font2 = new Font("Arial", Font.BOLD, 20);
		font3 = new Font("Arial", Font.PLAIN, 18);
		font4 = new Font("Arial",Font.PLAIN,10);
		
		/*
		 * JButton
		 */
		
		topPanel = new JPanel();
		
		midLeftPanel = new JScrollPane();
		
		midRightPanel = new JScrollPane();
		
		bottomRightPanel = new JPanel();
		bottomRightPanel.setLayout(null);
		
		sim = new JButton();
		sim.setFont(new Font("Tahoma", Font.BOLD, 12));
		sim.setBounds(68, 159, 71, 28);
		sim.setText("Start");
		bottomRightPanel.add(sim);
		
		//Title for enter simulation
		enter = new JTextField("Simulation");
		enter.setBounds(25, 10, 159, 45);
		bottomRightPanel.add(enter);
		enter.setHorizontalAlignment(SwingConstants.CENTER);
		enter.setEditable(false);
		enter.setForeground(Color.DARK_GRAY);
		enter.setFont(font1);
		
		//Name sim indicator
		nameT = new JTextField("Name");
		nameT.setBounds(25, 84, 56, 28);
		bottomRightPanel.add(nameT);
		nameT.setHorizontalAlignment(SwingConstants.CENTER);
		nameT.setEditable(false);
		nameT.setFont(new Font("Arial", Font.BOLD, 18));
		
		//Day sim indicator
		dayT = new JTextField("Day");
		dayT.setBounds(25, 118, 56, 28);
		bottomRightPanel.add(dayT);
		dayT.setHorizontalAlignment(SwingConstants.CENTER);
		dayT.setEditable(false);
		dayT.setFont(new Font("Arial", Font.BOLD, 18));
		
		//Name sim input
		nameI = new JTextField();
		nameI.setBounds(99, 84, 85, 28);
		bottomRightPanel.add(nameI);
		nameI.setFont(new Font("Arial", Font.BOLD, 18));
		
		//Day sim input
		dayI = new JTextField();
		dayI.setBounds(99, 118, 85, 28);
		bottomRightPanel.add(dayI);
		dayI.setFont(new Font("Arial", Font.BOLD, 18));

		SpringLayout sl_topPanel = new SpringLayout();
		sl_topPanel.putConstraint(SpringLayout.NORTH, sim, 6, SpringLayout.SOUTH, dayT);
		sl_topPanel.putConstraint(SpringLayout.WEST, sim, 96, SpringLayout.EAST, nameT);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, sim, 91, SpringLayout.NORTH, nameT);
		sl_topPanel.putConstraint(SpringLayout.EAST, sim, -74, SpringLayout.EAST, bottomRightPanel);
		topPanel.setLayout(sl_topPanel);
		
		//Start Button
		start = new JButton();
		sl_topPanel.putConstraint(SpringLayout.NORTH, start, 28, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, start, 304, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, start, 64, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, start, 388, SpringLayout.WEST, topPanel);
		start.setFont(new Font("Tahoma", Font.BOLD, 14));
		start.setText("Start");
		topPanel.add(start);
	
		//Previous Button
		prev = new JButton();
		sl_topPanel.putConstraint(SpringLayout.NORTH, prev, 11, SpringLayout.SOUTH, start);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, prev, -1, SpringLayout.SOUTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, prev, -209, SpringLayout.EAST, topPanel);
		prev.setFont(new Font("Tahoma", Font.BOLD, 12));
		prev.setText("Prev");
		topPanel.add(prev);
		
		//Next Button
		next = new JButton();
		sl_topPanel.putConstraint(SpringLayout.NORTH, next, 75, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, next, -191, SpringLayout.EAST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.SOUTH, next, -1, SpringLayout.SOUTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, next, -101, SpringLayout.EAST, topPanel);
		next.setFont(new Font("Tahoma", Font.BOLD, 12));
		next.setText("Next");
		topPanel.add(next);
		
				
		//Will show the data of person
		result = new JTextArea("",5,5);
		result.setLocation(37, 128);
		result.setSize(393, 490);
		result.setWrapStyleWord(true);
		result.setFont(font3);
//		result.setLineWrap(true);
		result.setEditable(false);
		midLeftPanel.setViewportView(result);
		midLeftPanel.getViewport().setViewPosition( new Point(0, 0) );
	
		
		//show number of child, adult and senior
		data = new JTextArea("",5,5);
		data.setLocation(450, 128);
		data.setSize(169, 260);
		data.setWrapStyleWord(true);
		data.setFont(font3);
		data.setEditable(false);
		midRightPanel.setViewportView(data);
		
		/*
		 * JTextField
		 */
		
		//That Movement text
		title = new JTextField("Movement");
		sl_topPanel.putConstraint(SpringLayout.NORTH, title, 12, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, title, 100, SpringLayout.WEST, topPanel);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setEditable(false);
		title.setForeground(Color.DARK_GRAY);
		title.setFont(font1);
		topPanel.add(title);
		
		//name button
		name = new JTextField("Name");
		sl_topPanel.putConstraint(SpringLayout.NORTH, name, 76, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, name, 48, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, name, 121, SpringLayout.WEST, topPanel);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setEditable(false);
		name.setFont(font2);
		topPanel.add(name);
		
		//Will search name in text file folder and show it on result
		search = new JTextField(20);
		sl_topPanel.putConstraint(SpringLayout.WEST, prev, 36, SpringLayout.EAST, search);
		sl_topPanel.putConstraint(SpringLayout.NORTH, search, 76, SpringLayout.NORTH, topPanel);
		sl_topPanel.putConstraint(SpringLayout.WEST, search, 131, SpringLayout.WEST, topPanel);
		sl_topPanel.putConstraint(SpringLayout.EAST, search, 312, SpringLayout.WEST, topPanel);
		search.setFont(font2);
		topPanel.add(search);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(midLeftPanel, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(7)
									.addComponent(midRightPanel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
								.addComponent(bottomRightPanel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(midLeftPanel, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(midRightPanel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(bottomRightPanel, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))))
		);
		getContentPane().setLayout(groupLayout);
		
		
				
		
		DefaultCaret caret = (DefaultCaret)result.getCaret();
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);

		
		//Call to set everything but Start button to invisible
		visible(false);
		
		
		
		//Will handle all action on item it set
		Handler handler = new Handler();
		start.addActionListener(handler);
		dayI.addActionListener(handler);
		nameI.addActionListener(handler);
		next.addActionListener(handler);
		prev.addActionListener(handler);
		search.addActionListener(handler);
		sim.addActionListener(handler);
	}
	
	//only called once
	private void visible(boolean b) { 

		search.setVisible(b);
		name.setVisible(b);
		data.setVisible(b);
		prev.setVisible(b);
		next.setVisible(b);
		enter.setVisible(b);
		nameT.setVisible(b);
		nameI.setVisible(b);
		dayT.setVisible(b);
		dayI.setVisible(b);
		midRightPanel.setVisible(b);
		sim.setVisible(b);
		
	}
	
	/*
	 *-called when the start button is clicked
	 *-This to start the movement simulation algorithm that will be conducted in another class
	 *-Initiate map class, initiate Algorithm and automatically start the algorithm
	 *-get the children, adult and senior linked list
	 *-calls randomize method to set the text area at random id
	 *-set the iterator for each list at the randomize method
	 *-use the iterator for the DoubleLinkedList list
	 *-initiate the list iterator
	 *-set result text to random id
	 */
	private void startSimulation() {
		start.setEnabled(false);
		map = new Map();
		list = new DoubleLinkedList<>();
		try {
			moveAlgo = new MovementSimulatorAlgorithm(this,map);
			childList = moveAlgo.getChildList();
			adultList = moveAlgo.getAdultList();
			seniorList = moveAlgo.getSeniorList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		start.setVisible(false);
		visible(true);
		randomize();
		/*
		 * Add key event to the result text area so
		 * pressing left and right arrow key will also call
		 * the next and prev method
		 */
		result.addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_RIGHT)
					setNext();
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
					setPrev();
			}
			public void keyReleased(KeyEvent e) {
			}
			public void keyTyped(KeyEvent e) {				
			}
		});
	}
	
	
	//called only once, see explanation at startSimulation method
		private void randomize() {			
	    	Person tempP = null;
			
			childIterator = childList.getListIterator();
			adultIterator = adultList.getListIterator();
			seniorIterator = seniorList.getListIterator();
			
			
			while(childIterator.hasNext())
				list.addRightNode(childIterator.next());
			while(adultIterator.hasNext())
				list.addRightNode(adultIterator.next());
			while(seniorIterator.hasNext())
				list.addRightNode(seniorIterator.next());
					
			String str = String.format("Child:\n"
										+ "%d\n"
										+ "Adult:\n"
										+ "%d\n"
										+ "Senior:\n"
										+ "%d",childList.length(),adultList.length(),seniorList.length());
			
			data.setText(str);
			
			iterator = list.getListIterator();
			
			tempP = iterator.next();
			result.setText(tempP.toString());
			
			/*
			 * There was an error here when the prev button is clicked first and it
			 * will call the NullPointerException error, and strangely enough clicking
			 * the next button solves it, thus the method called below
			 */
			setNext();
			result.requestFocus();
		}

	private void search(int id) {
		boolean found = false;
		Person tempP = null;
		if(iterator.hasNext())
			tempP = iterator.next();
		else if(iterator.hasPrevious())
			tempP = iterator.previous();
		
		int n = tempP.getID();
		if(n<id) {
			while(iterator.hasNext()) {
				tempP=iterator.next();
				if(tempP.getID()==id) {
					found = true;
					break;
				}
			}				
		}
		else {
			while(iterator.hasPrevious()) {
				tempP=iterator.previous();
				if(tempP.getID()==id) {
					found = true;
					break;
				}				
			}
		}
		
		
		
		if(found)
			result.setText(tempP.toString());
		else { //to reset the iterator
			result.setText("Id not found");
			if(iterator.hasNext()) {
			while(iterator.hasNext()) {
				tempP=iterator.next();
				if(tempP.getID()==n) {
					return;
				}
			}
			}
			else {
				while(iterator.hasPrevious()) {
					tempP=iterator.previous();
					if(tempP.getID()==n) {
						return;
					}
				}
			}
		}
	}
	
	
	
	//called when next button is clicked
	private void setNext() {
		if(iterator.hasNext()) {
			result.setText(iterator.next().toString());			
			if(!prev.isEnabled())
				prev.setEnabled(true);
		}
		if(!iterator.hasNext()) {
			next.setEnabled(false);
		}
			
	}
	
	//called when prev button is clicked
	private void setPrev() {
		if(iterator.hasPrevious()) {
			result.setText(iterator.previous().toString());
			if(!next.isEnabled())
				next.setEnabled(true);
		}
		if(!iterator.hasPrevious()) {
			prev.setEnabled(false);
		}
			
	}
	
	
	
	public void setLoad(String str) {
		result.setText(str);
	}
	
	
	
		
	
	

	/**
	 * 
	 *-All action for the item in constructor will be handled here
	 *-More at Handler Class Action at above description
	 *
	 */
private class Handler implements ActionListener{
		
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource()==start) {
				startSimulation();

			}
			
			if(event.getSource()==dayI||event.getSource()==nameI||event.getSource()==sim) {
				if(!dayI.getText().isEmpty()&&!nameI.getText().isEmpty()) {
					try {
						int name = Integer.parseInt(nameI.getText());
						int day = Integer.parseInt(dayI.getText());
						if((name<1001||name>1600)&&day>0) {
							result.setText("Invalid Input");
						}else
							simulator = new InfectionSimulator(list,name,day);
					}catch(NumberFormatException e) {
						result.setText("Invalid input");
					}
					
				}
			}
			if(event.getSource()==next) {
				setNext();
			}
			if(event.getSource()==prev) {
				setPrev();
			}
			if(event.getSource()==search) {
				try {
					int id = Integer.parseInt(search.getText());
					search(id);
				}catch(NumberFormatException e) {
					result.setText("Invalid input");
				}
			}
			
			
				
		}
}
}
