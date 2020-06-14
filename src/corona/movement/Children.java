package corona.movement;

import java.util.List;
import java.util.Random;

import corona.map.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Oliver
 */
public class Children extends Person {

    private Map map;
    private final int twoWeeks = 14;
    private final int ageGroup = 0;
    private Integer ID;
    private int age;
    private Character gender;
    private String job;
    private int educationLevel;
    private double immunity, infectionRate;
    private Event[] myEvent;
    private int personScore, jobCase;

    public Children(Integer ID, int age, Character gender) {
        super(ID, age, gender);
        this.ID = ID;
        this.age = age;
        this.gender = gender;
        myEvent = new Event[twoWeeks];
    }

    public void generateJob() throws Exception {
        if (age < 0) {
            throw new Exception("Invalid age");
        }
        if (age <= 5) {
            job = "Kid";
            jobCase = 0;
        } else if (age < 12) {
            job = "Pupil";
            jobCase = 1;
        } else {
            job = "Student";
            jobCase = 2;
        }
    }

    public void setEducationLevel() {
        Random r = new Random();
        if (age <= 15) {
            educationLevel = r.nextInt(5) + 1;
        } else {
            educationLevel = r.nextInt(6) + 5;
        }
    }

    public void setPersonScore() throws Exception {
        Random r = new Random();
        if (job == null) {
            throw new Exception("Define the job first");
        }
        personScore = 5 + r.nextInt(5);
    }

    public void setImmunity() {
        //Random r = new Random();
        //immunity = 1 - ((double) r.nextInt(31)) / 100;
            //children
            switch(jobCase){
                case 0://kid
                    immunity = 0.897;
                    break;
                case 1://pupil
                    immunity = 0.854;
                    break;
                case 2://student
                    immunity = 0.796;
                    break;
            }
    }

    public void setInfectionRate() throws Exception {
        if (infectionRate < 0) {
            throw new Exception("Invalid infection rate");
        }
        infectionRate = (1 - (immunity + (double) educationLevel / 500)) * (1 + (double) personScore / 50);
    }

    public Integer getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public Character getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public int getEducationLevel() {
        return educationLevel;
    }

    public double getImmunity() {
        return immunity;
    }

    public double getInfectionRate() {
        return infectionRate;
    }

    public int getPersonScore() {
        return personScore;
    }

    public int[] getEvent(int day_of_month) throws Exception {
        if (day_of_month >= 14 || day_of_month < 1) {
            throw new Exception("Invalid day_of_month");
        }
        return myEvent[day_of_month - 1].getEvent();
    }

    public String getEventToString() throws Exception {
        String str = "";
        for (int i = 0; i < myEvent.length; i++) {
            str += myEvent[i].showEventStr() + "\n";
        }
        return str;
    }

    public void setEvent() throws Exception {
        int day = 0, month = 2, year = 2020;

        for (int i = 0; i < myEvent.length; i++) {
            myEvent[i] = new Event(++day, month, year, this.ID);
            myEvent[i].setEvent(ageGroup, jobCase);
            myEvent[i].shownOnTheMap(getMap());
        }
    }

    public void showEventByDate(int day_of_month) throws Exception {
        if (day_of_month >= 14 || day_of_month < 1) {
            throw new Exception("Invalid day_of_month");
        }
        myEvent[day_of_month - 1].showEvent();
    }

    public void showEventAll() throws Exception {
        for (int i = 0; i < myEvent.length; i++) {
            myEvent[i].showEvent();
        }
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    
    public String toString() {
    	String str = "";
    	str+="ID: " + getID() + "\nGender: " + getGender() + "\nAge: "
                + getAge() + "\nJob: " + getJob() + "\n Infection rate: " + String.format("%.005f", getInfectionRate())+"\n";
    	try {
			str+=getEventToString();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return str;
    	
    }

	@Override
	public String[][] getEvent() {
		int l = myEvent[0].getEventArr().length;
    	String [][] array = new String[myEvent.length][l];
    	
		for(int i = 0;i<myEvent.length;i++) {
			String[] temp = myEvent[i].getEventArr();
			String t;
			for(int j = 0;j<temp.length;j++) {
				t = temp[j];
				t = t.replaceAll(" ", "");
				array[i][j] = t;
			}
		}
		return array;
	}


}
