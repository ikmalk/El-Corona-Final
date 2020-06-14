package corona.simulator;

public class MapPlace {
	
	/***********************************
	 * Created at 11/6/2020
	 * -A class that will place all building coordinate according to the map in map package
	 * -Used solely to get the Place array only
	 * 
	 */
	
	private Place[] place;
	
	public MapPlace() {
		int x = 55;
		int y = 55;
		int d = 10;
		
		//Place(float x, float y,int sizeX,int sizeY, TYPE id,String name)
		
		Place[] place = {	//row 1
							new Place(0.0f*x+d,	  0.0f*y+d, x,y,TYPE.Place,"Gym1"),
							new Place(1.0f*x+2*d, 0.0f*y+d, x,y,TYPE.Place,"GovtOffice1"),
							new Place(2.0f*x+3*d, 0.0f*y+d, x,y,TYPE.Place,"GovtOffice2"),
							new Place(3.0f*x+4*d, 0.0f*y+d, x,y,TYPE.Place,"GovtOffice3"),
							new Place(4.0f*x+5*d, 0.0f*y+d, x,y,TYPE.Place,"Bank1"),
							new Place(5.0f*x+6*d, 0.0f*y+d, x,y,TYPE.Place,"Bank2"),
							new Place(6.0f*x+7*d, 0.0f*y+d, x,y,TYPE.Place,"Airport1"),
							new Place(7.0f*x+8*d, 0.0f*y+d, x,y,TYPE.Place,"Airport2"),
							new Place(8.0f*x+9*d, 0.0f*y+d, x,y,TYPE.Place,"Airport3"),
							new Place(9.0f*x+10*d, 0.0f*y+d ,x,y,TYPE.Place,"Airport4"),
							
							//row 2
							new Place(0.0f*x+d,   1.0f*y+2*d, x,y,TYPE.Place,"Gym2"),
							new Place(1.0f*x+2*d, 1.0f*y+2*d, x,y,TYPE.Place,"GovtOffice4"),
							new Place(2.0f*x+3*d, 1.0f*y+2*d, x,y,TYPE.Place,"GovtOffice5"),
							new Place(3.0f*x+4*d, 1.0f*y+2*d, x,y,TYPE.Place,"GovtOffice6"),
							new Place(4.0f*x+5*d, 1.0f*y+2*d, x,y,TYPE.Place,"Bank3"),
							new Place(5.0f*x+6*d, 1.0f*y+2*d, x,y,TYPE.Place,"Bank4"),
							new Place(6.0f*x+7*d, 1.0f*y+2*d, x,y,TYPE.Place,"Airport5"),
							new Place(7.0f*x+8*d, 1.0f*y+2*d, x,y,TYPE.Place,"Airport6"),
							new Place(8.0f*x+9*d, 1.0f*y+2*d, x,y,TYPE.Place,"Airport7"),
							new Place(9.0f*x+10*d, 1.0f*y+2*d, x,y,TYPE.Place,"Airport8"),
							
							//row 3
							new Place(0.0f*x+d,   2.0f*y+3*d, x,y,TYPE.Place,"School1"),
							new Place(1.0f*x+2*d, 2.0f*y+3*d, x,y,TYPE.Place,"Home1"),
							new Place(2.0f*x+3*d, 2.0f*y+3*d, x,y,TYPE.Place,"Office1"),
							new Place(3.0f*x+4*d, 2.0f*y+3*d, x,y,TYPE.Place,"Office2"),
							new Place(4.0f*x+5*d, 2.0f*y+3*d, x,y,TYPE.Place,"Home2"),
							new Place(5.0f*x+6*d, 2.0f*y+3*d, x,y,TYPE.Place,"Home3"),
							new Place(6.0f*x+7*d, 2.0f*y+3*d, x,y,TYPE.Place,"Home4"),
							
							//Hospital
							new Place(7.0f*x+8*d, 2.0f*y+3*d, 3*x+2*d ,3*y+2*d,TYPE.Place,"Hospital"),
							
							//row 4
							new Place(0.0f*x+d,   3.0f*y+4*d, x,y,TYPE.Place,"School2"),
							new Place(1.0f*x+2*d, 3.0f*y+4*d, x,y,TYPE.Place,"Home5"),
							new Place(2.0f*x+3*d, 3.0f*y+4*d, x,y,TYPE.Place,"Office3"),
							new Place(3.0f*x+4*d, 3.0f*y+4*d, x,y,TYPE.Place,"Office4"),
							new Place(4.0f*x+5*d, 3.0f*y+4*d, x,y,TYPE.Place,"Home6"),
							new Place(5.0f*x+6*d, 3.0f*y+4*d, x,y,TYPE.Place,"Home7"),
							new Place(6.0f*x+7*d, 3.0f*y+4*d, x,y,TYPE.Place,"Home8"),
							
							//row 5
							new Place(0.0f*x+d,   4.0f*y+5*d, x,y,TYPE.Place,"Gym3"),
							new Place(1.0f*x+2*d, 4.0f*y+5*d, x,y,TYPE.Place,"Gym4"),
							new Place(5.0f*x+6*d, 4.0f*y+5*d, x,y,TYPE.Place,"Office5"),
							new Place(6.0f*x+7*d, 4.0f*y+5*d, x,y,TYPE.Place,"Office6"),
							
							//park
							new Place(2.0f*x+3*d, 4.0f*y+5*d, 3*x+2*d ,4*y+3*d,TYPE.Place,"Park"),
							
							//Police Station
							new Place(0.0f*x+d, 5.0f*y+6*d, 2*x+1*d ,3*y+2*d,TYPE.Place,"PoliceStation"),
							
							//row 6
							new Place(5.0f*x+6*d, 5.0f*y+6*d, x,y,TYPE.Place,"Office7"),
							new Place(6.0f*x+7*d, 5.0f*y+6*d, x,y,TYPE.Place,"Office8"),
							new Place(7.0f*x+8*d, 5.0f*y+6*d, x,y,TYPE.Place,"Office9"),
							new Place(8.0f*x+9*d, 5.0f*y+6*d, x,y,TYPE.Place,"Office10"),
							new Place(9.0f*x+10*d, 5.0f*y+6*d, x,y,TYPE.Place,"Office11"),
							
							//row 7
							new Place(5.0f*x+6*d, 6.0f*y+7*d, x,y,TYPE.Place,"Supermarket1"),
							new Place(6.0f*x+7*d, 6.0f*y+7*d, x,y,TYPE.Place,"Supermarket2"),
							new Place(7.0f*x+8*d, 6.0f*y+7*d, x,y,TYPE.Place,"Supermarket3"),
							new Place(8.0f*x+9*d, 6.0f*y+7*d, x,y,TYPE.Place,"Supermarket4"),
							new Place(9.0f*x+10*d, 6.0f*y+7*d, x,y,TYPE.Place,"Supermarket5"),
							
							//row 8
							new Place(5.0f*x+6*d, 7.0f*y+8*d, x,y,TYPE.Place,"Supermarket6"),
							new Place(6.0f*x+7*d, 7.0f*y+8*d, x,y,TYPE.Place,"Mall1"),
							new Place(7.0f*x+8*d, 7.0f*y+8*d, x,y,TYPE.Place,"Mall2"),
							new Place(8.0f*x+9*d, 7.0f*y+8*d, x,y,TYPE.Place,"Mall3"),
							new Place(9.0f*x+10*d, 7.0f*y+8*d, x,y,TYPE.Place,"Supermarket7"),
							
							//row 9
							new Place(0.0f*x+d,	  8.0f*y+9*d, x,y,TYPE.Place,"School3"),
							new Place(1.0f*x+2*d, 8.0f*y+9*d, x,y,TYPE.Place,"School5"),
							new Place(2.0f*x+3*d, 8.0f*y+9*d, x,y,TYPE.Place,"Home9"),
							new Place(3.0f*x+4*d, 8.0f*y+9*d, x,y,TYPE.Place,"Home10"),
							new Place(4.0f*x+5*d, 8.0f*y+9*d, x,y,TYPE.Place,"Home11"),
							new Place(5.0f*x+6*d, 8.0f*y+9*d, x,y,TYPE.Place,"Restaurant1"),
							new Place(6.0f*x+7*d, 8.0f*y+9*d, x,y,TYPE.Place,"Mall4"),
							new Place(7.0f*x+8*d, 8.0f*y+9*d, x,y,TYPE.Place,"Mall5"),
							new Place(8.0f*x+9*d, 8.0f*y+9*d, x,y,TYPE.Place,"Mall6"),
							new Place(9.0f*x+10*d, 8.0f*y+9*d ,x,y,TYPE.Place,"Restaurant2"),
							
							//row 10
							new Place(0.0f*x+d,	  8.0f*y+9*d, x,y,TYPE.Place,"School4"),
							new Place(1.0f*x+2*d, 8.0f*y+9*d, x,y,TYPE.Place,"School6"),
							new Place(2.0f*x+3*d, 8.0f*y+9*d, x,y,TYPE.Place,"Home12"),
							new Place(3.0f*x+4*d, 8.0f*y+9*d, x,y,TYPE.Place,"Home13"),
							new Place(4.0f*x+5*d, 8.0f*y+9*d, x,y,TYPE.Place,"Home14"),
							new Place(5.0f*x+6*d, 8.0f*y+9*d, x,y,TYPE.Place,"Restaurant3"),
							new Place(6.0f*x+7*d, 8.0f*y+9*d, x,y,TYPE.Place,"Restaurant4"),
							new Place(7.0f*x+8*d, 8.0f*y+9*d, x,y,TYPE.Place,"Restaurant5"),
							new Place(8.0f*x+9*d, 8.0f*y+9*d, x,y,TYPE.Place,"Restaurant6"),
							new Place(9.0f*x+10*d, 8.0f*y+9*d ,x,y,TYPE.Place,"Restaurant7"),
							
							//Quarantine
							new Place(10.0f*x+11*d, 2.0f*y+3*d ,3*x,3*y,TYPE.Place,"Quarantine"),
							

							
							};
		this.place = place;
	}
	
	public Place[] getPlace() {
		return place;
	}

}
