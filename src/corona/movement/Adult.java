package corona.movement;

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
public class Adult extends Person {

    private Map map;
    private final int twoWeeks = 14;
    private Integer ID;
    private int age;
    private Character gender;
    private String job;
    private int educationLevel, jobCase;
    private double immunity;
    private double infectionRate;
    private Event[] myEvent;
    private static int ageGroup = 1;
    private int personScore;

    public Adult(Integer ID, int age, Character gender) {
        super(ID, age, gender);
        this.ID = ID;
        this.age = age;
        this.gender = gender;
        myEvent = new Event[twoWeeks];
    }

    public void generateJob() {
        Random r = new Random();
        jobCase = r.nextInt(21);
        switch (jobCase) {
            case 0:
                job = "Doctor";
                break;
            case 1:
                job = "Nurse";
                break;
            case 2:
                job = "Police";
                break;
            case 3:
                job = "Crew Attenant";
                break;
            case 4:
                job = "Secretary";
                break;
            case 5:
                job = "Plumber";
                break;
            case 6:
                job = "Teacher";
                break;
            case 7:
                job = "College Student";
                break;
            case 8:
                job = "Shopkeeper";
                break;
            case 9:
                job = "Bank Clark";
                break;
            case 10:
                job = "Waiter";
                break;
            case 11:
                job = "Chef";
                break;
            case 12:
                job = "Staff";
                break;
            case 13:
                job = "Engineer";
                break;
            case 14:
                job = "Worker";
                break;
            case 15:
                job = "Businessman";
                break;
            case 16:
                job = "Security Guard";
                break;
            case 17:
                job = "Bus Driver";
                break;
            case 18:
                job = "Courier";
                break;
            case 19:
                job = "Pilot";
                break;
            case 20:
                job = "Politician";
                break;
        }
    }

    public void setEducationLevel() throws Exception {
        Random r = new Random();
        if (job == null) {
            throw new Exception("Define the job first");
        }
        switch (jobCase) {
            case 0:
                educationLevel = 20;
                break;
            case 1:
                educationLevel = 17;
                break;
            case 2:
                educationLevel = 11;
                break;
            case 3:
                educationLevel = 12;
                break;
            case 4:
                educationLevel = 14;
                break;
            case 5:
                educationLevel = 6;
                break;
            case 6:
                educationLevel = 18;
                break;
            case 7:
                educationLevel = 14;
                break;
            case 8:
                educationLevel = 8;
                break;
            case 9:
                educationLevel = 14;
                break;
            case 10:
                educationLevel = 6;
                break;
            case 11:
                educationLevel = 9;
                break;
            case 12:
                educationLevel = 11;
                break;
            case 13:
                educationLevel = 15;
                break;
            case 14:
                educationLevel = 5;
                break;
            case 15:
                educationLevel = 12;
                break;
            case 16:
                educationLevel = 7;
                break;
            case 17:
                educationLevel = 6;
                break;
            case 18:
                educationLevel = 6;
                break;
            case 19:
                educationLevel = 15;
                break;
            case 20:
                educationLevel = 14;
                break;
        }
    }

    public void setPersonScore() throws Exception {
        Random r = new Random();
        if (job == null) {
            throw new Exception("Define the job first");
        }
        switch (jobCase) {
            case 0:
                personScore = 10;
                break;
            case 1:
                personScore = 10;
                break;
            case 2:
                personScore = 7;
                break;
            case 3:
                personScore = 8;
                break;
            case 4:
                personScore = 6;
                break;
            case 5:
                personScore = 7;
                break;
            case 6:
                personScore = 7;
                break;
            case 7:
                personScore = 8;
                break;
            case 8:
                personScore = 8;
                break;
            case 9:
                personScore = 7;
                break;
            case 10:
                personScore = 8;
                break;
            case 11:
                personScore = 6;
                break;
            case 12:
                personScore = 7;
                break;
            case 13:
                personScore = 4;
                break;
            case 14:
                personScore = 6;
                break;
            case 15:
                personScore = 9;
                break;
            case 16:
                personScore = 5;
                break;
            case 17:
                personScore = 9;
                break;
            case 18:
                personScore = 8;
                break;
            case 19:
                personScore = 7;
                break;
            case 20:
                personScore = 5;
                break;
        }
    }

    public void setImmunity() {
        //Random r = new Random();
        //immunity = 1 - (5 + ((double) r.nextInt(46))) / 100;
        switch(jobCase){
                    case 0://doctor
                        immunity = 0.887;
                        break;
                    case 1://nurse
                        immunity = 0.887;
                        break;
                    case 2://police
                        immunity = 0.758;
                        break;
                    case 3://crew atttendant
                        immunity = 0.851;
                        break;
                    case 4://secretary
                        immunity = 0.736;
                        break;
                    case 5://plumber
                        immunity = 0.683;
                        break;
                    case 6://teacher
                        immunity = 0.726;
                        break;
                    case 7://college student
                        immunity = 0.785;
                        break;
                    case 8://shopkeeper
                        immunity = 0.859;
                        break;
                    case 9://bank clerk
                        immunity = 0.826;
                        break;
                    case 10://waiter
                        immunity = 0.728;
                        break;
                    case 11://chef
                        immunity = 0.698;
                        break;
                    case 12://staff
                        immunity = 0.758;
                        break;
                    case 13://engineer
                        immunity = 0.773;
                        break;
                    case 14://worker
                        immunity = 0.754;
                        break;
                    case 15://businessman
                        immunity = 0.883;
                        break;
                    case 16://guard
                        immunity = 0.696;
                        break;
                    case 17://bus driver
                        immunity = 0.859;
                        break;
                    case 18://courier
                        immunity = 0.891;
                        break;
                    case 19://pilot
                        immunity = 0.845;
                        break;
                    case 20://politician
                        immunity = 0.826;
                        break;
                }
    }

    public void setInfectionRate() throws Exception {
        if (infectionRate < 0) {
            throw new Exception("Invalid infection rate");
        }
        infectionRate = (1-(immunity + (double) educationLevel / 500)) * (1 + (double) personScore / 50);
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
    
    public String[][] getEvent() {
    	int l = myEvent[0].getEventArr().length;
    	String [][] array = new String[myEvent.length][l];
    	String t;
    	
		for(int i = 0;i<myEvent.length;i++) {
			String[] temp = myEvent[i].getEventArr();
			for(int j = 0;j<temp.length;j++) {
				t = temp[j];
				t = t.replaceAll(" ", "");
				array[i][j] = t;
			}
		}
		return array;
	}

    public void setEvent() throws Exception {
        int day = 0, month = 2, year = 2020;

        for (int i = 0; i < myEvent.length; i++) {
            myEvent[i] = new Event(++day, month, year, this.ID);
            myEvent[i].setEvent(ageGroup, jobCase);
            myEvent[i].shownOnTheMap(getMap());
        }
    }

    public void showEvent(int day_of_month) throws Exception {
        if (day_of_month >= 14 || day_of_month < 1) {
            throw new Exception("Invalid day_of_month");
        }
        myEvent[day_of_month - 1].showEvent();
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
                + getAge() + "\nJob: " + getJob() + "\nImmunity rate: " + String.format("%.005f", getInfectionRate())+"\n";
    	try {
			str+=getEventToString();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return str;
    	
    }

	
	}
