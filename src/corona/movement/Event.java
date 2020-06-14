package corona.movement;

import java.util.Random;

import corona.map.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Oliver
 */
public class Event {


    private static final int SIZE = 3;
    private int day_of_month, month, year;
    private int[] event;
    private String[] locationNum;
    private Integer ID;
    private Random r = new Random();

    public Event(int day_of_month, int month, int year, Integer ID) {
        this.day_of_month = day_of_month;
        this.month = month;
        this.year = year;
        this.ID = ID;
        event = new int[SIZE];
        locationNum = new String[SIZE];
    }

    public int getDay_Of_Month() {
        return day_of_month;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setEvent(int ageGroup, int jobCase) {
        Random r = new Random();
        
        switch (ageGroup) {
            case 0://child
                if (jobCase == 0) {//kid
                    for (int i = 0; i < event.length; i++) {
                        int randomNum = r.nextInt(5);
                        switch (randomNum) {
                            case 0:
                                event[i] = 0;
                                break;
                            case 1:
                                event[i] = 1;
                                break;
                            case 2:
                                event[i] = 3;
                                break;
                            case 3:
                                event[i] = 4;
                                break;
                            case 4:
                                event[i] = 9;
                                break;
                        }
                    }
                } else if (jobCase == 1) {//pupil
                    if (r.nextInt(2) == 0) {
                        event[0] = 1;
                        event[1] = r.nextInt(8) + 2;
                        event[2] = 0;
                    } else {
                        event[1] = 1;
                        event[0] = r.nextInt(8) + 2;
                        event[2] = 0;
                    }
                } else {//teen student
                    if (r.nextInt(2) == 0) {
                        event[0] = 1;
                        event[1] = r.nextInt(10) + 2;
                        event[2] = 0;
                    } else {
                        event[1] = 1;
                        event[0] = r.nextInt(11) + 2;
                        event[2] = 0;
                    }
                }
                break;
            case 1://adult
                switch (jobCase) {
                    case 0://doctor
                    case 1://nurse
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = 3;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = 0;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 3;
                        }
                        break;
                    case 2://police
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = 10;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : 12;
                        } else {//night shift
                            event[0] = 0;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 10;
                        }
                        break;
                    case 3://crew attendant
                    case 19://pilot
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = 8;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = 0;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 8;
                        }
                        break;
                    case 4://secretary
                    case 12://staff
                        event[0] = 2;
                        for (int i = 1; i < event.length - 1; i++) {
                            event[i] = r.nextInt(12) + 1;
                        }
                        event[SIZE - 1] = 0;
                        break;
                    case 5://plumber
                        int ran = r.nextInt(3);
                        if (ran == 0) {//day shift
                            event[0] = r.nextInt(2) == 0 ? 2 : 6;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 0;
                        } else if (ran == 1) {//evening shift
                            for (int i = 0; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : 5;
                        } else {//night shift
                            event[0] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 4 : 5;
                        }
                        break;
                    case 6://teacher
                    case 7://college student
                        event[0] = 1;
                        for (int i = 1; i < event.length - 1; i++) {
                            event[i] = r.nextInt(12) + 1;
                        }
                        event[SIZE - 1] = 0;
                        break;
                    case 8://shopkeeper
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = 7;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = 0;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 7;
                        }
                        break;
                    case 9://bank clark
                        event[0] = 5;
                        for (int i = 1; i < event.length - 1; i++) {
                            event[i] = r.nextInt(12) + 1;
                        }
                        event[SIZE - 1] = 0;
                        break;
                    case 10://waiter
                    case 11://chef
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = 4;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = 0;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 4 : 6;
                        }
                        break;
                    case 13://engineer
                        event[0] = r.nextInt(2) == 0 ? 2 : 1;
                        for (int i = 1; i < event.length - 1; i++) {
                            event[i] = r.nextInt(12) + 1;
                        }
                        event[SIZE - 1] = 0;
                        break;
                    case 14:
                        int ran1 = r.nextInt(3);
                        if (ran1 == 0) {//day shift
                            event[0] = 3;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else if (ran1 == 1) {//evening
                            for (int i = 0; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 0;
                        } else {//night shift
                            event[0] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = 3;
                        }
                        break;
                    case 15://businessman
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = 5;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 8 : 11;
                        }
                        break;
                    case 18://courier
                    case 17://bus driver
                        int ran2 = r.nextInt(3);
                        if (ran2 == 0) {//day shift
                            event[0] = r.nextInt(2) == 0 ? 1 : 7;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else if (ran2 == 1) {//noon shift
                            for (int i = 0; i < event.length; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                        } else {//night shift
                            event[0] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 1 ? 2 : 9;
                        }
                        break;
                    case 16://guard
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = r.nextInt(2) == 0 ? 1 : 5;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 8 : 11;
                        }
                        break;
                    case 20://politician
                        event[0] = 11;
                        for (int i = 1; i < event.length - 1; i++) {
                            event[i] = r.nextInt(12) + 1;
                        }
                        event[SIZE - 1] = 0;
                        break;
                }
                break;
            case 2://senior
                switch (jobCase) {
                    case 0:
                    case 3:
                        int rand = r.nextInt(3);
                        event[rand] = r.nextInt(2) == 0 ? 6 : 9;
                        for (int i = 0; i < event.length; i++) {
                            if (i != rand) {
                                event[i] = r.nextInt(13);
                            }
                        }
                        break;
                    case 1://professor
                        event[0] = r.nextInt(2) == 0 ? 1 : 11;
                        for (int i = 1; i < event.length - 1; i++) {
                            event[i] = r.nextInt(12) + 1;
                        }
                        event[SIZE - 1] = 0;
                        break;
                    case 2://self-employed
                    case 4://retail owner
                        if (r.nextInt(2) == 0) {//day shift
                            event[0] = r.nextInt(2) == 0 ? 6 : 7;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 0 : r.nextInt(12) + 1;
                        } else {//night shift
                            event[0] = 0;
                            for (int i = 1; i < event.length - 1; i++) {
                                event[i] = r.nextInt(12) + 1;
                            }
                            event[SIZE - 1] = r.nextInt(2) == 0 ? 5 : 11;
                        }
                        break;
                }
                break;
        }
        /*
        switch(ageGroup){
            case 0://children
                if(jobCase==0){ //kid
                    event[0] = 3;
                    event[1] = 6;
                    event[2] = 0;
                }
                else if(jobCase==1){ //pupil
                    event[0] = 1;
                    event[1] = 9;
                    event[2] = 0;
                }
                else{ //student
                    event[0] = 1;
                    event[1] = 3;
                    event[2] = 0;
                }
                break;
            case 1://adult
                switch(jobCase){
                    case 0://doctor
                        event[0] = 3;
                        event[1] = 6;
                        event[2] = 3;
                        break;
                    case 1://nurse
                        event[0] = 3;
                        event[1] = 7;
                        event[2] = 0;
                        break;
                    case 2://police
                        event[0] = 12;
                        event[1] = 10;
                        event[2] = 0;
                        break;
                    case 3://crew attendant
                        event[0] = 3;
                        event[1] = 7;
                        event[2] = 0;
                        break;
                    case 4://secretary
                        event[0] = 2;
                        event[1] = 7;
                        event[2] = 5;
                        break;
                    case 5://Plumber
                        event[0] = 11;
                        event[1] = 2;
                        event[2] = 4;
                        break;
                    case 6://Teacher
                        event[0] = 2;
                        event[1] = 5;
                        event[2] = 6;
                        break;
                    case 7://college student
                        event[0] = 7;
                        event[1] = 1;
                        event[2] = 9;
                        break;
                    case 8://shopkeeper
                        event[0] = 6;
                        event[1] = 10;
                        event[2] = 4;
                        break;
                    case 9://bank clerk
                        event[0] = 4;
                        event[1] = 5;
                        event[2] = 7;
                        break;
                    case 10://waiter
                        event[0] = 4;
                        event[1] = 9;
                        event[2] = 0;
                        break;
                    case 11://chef
                        event[0] = 4;
                        event[1] = 3;
                        event[2] = 0;
                        break;
                    case 12://staff
                        event[0] = 2;
                        event[1] = 6;
                        event[2] = 11;
                        break;
                    case 13://engineer
                        event[0] = 11;
                        event[1] = 7;
                        event[2] = 5;
                        break;
                    case 14://worker
                        event[0] = 8;
                        event[1] = 9;
                        event[2] = 10;
                        break;
                    case 15://businessman
                        event[0] = 11;
                        event[1] = 5;
                        event[2] = 2;
                        break;
                    case 16://guard
                        event[0] = 5;
                        event[1] = 7;
                        event[2] = 1;
                        break;
                    case 17://bus driver
                        event[0] = 7;
                        event[1] = 12;
                        event[2] = 11;
                        break;
                    case 18://courier
                        event[0] = 2;
                        event[1] = 11;
                        event[2] = 8;
                        break;
                    case 19://pilot
                        event[0] = 8;
                        event[1] = 2;
                        event[2] = 6;
                        break;
                    case 20://politician
                        event[0] = 11;
                        event[1] = 4;
                        event[2] = 3;
                        break;
                }
                break;
            case 2://senior
                switch(jobCase){
                    case 0://retired employee
                        event[0] = 9;
                        event[1] = 7;
                        event[2] = 12;
                        break;
                    case 1://professor
                        event[0] = 2;
                        event[1] = 5;
                        event[2] = 11;
                        break;
                    case 2://self employed
                        event[0] = 2;
                        event[1] = 6;
                        event[2] = 5;
                        break;
                    case 3://retired worker
                        event[0] = 4;
                        event[1] = 9;
                        event[2] = 3;
                        break;
                    case 4://retail owner
                        event[0] = 6;
                        event[1] = 7;
                        event[2] = 4;
                        break;
                }
                break;
        }
        */
    }

    public int[] getEvent() {
        return event;
    }

    public void showEvent() throws Exception {
        if (event == null) {
            throw new Exception("Null Event Array");
        }
        String str;
        for (int i = 0; i < event.length; i++) {

            System.out.print(switchCaseGetStr(event[i]) + locationNum[i] + "--> ");
        }
        System.out.println("");
    }

    public String showEventStr() throws Exception {
        if (event == null) {
            throw new Exception("Null Event Array");
        }
        String str = "";
        for (int i = 0; i < event.length; i++) {

            str += "\n" + switchCaseGetStr(event[i]) + locationNum[i] + "--> ";
        }
        return str;
    }
    
    public String[] getEventArr() {
    	String[] str = new String[event.length];
    	for (int i = 0; i < event.length; i++) {
    		
    		str[i] = ""+switchCaseGetStr(event[i])+locationNum[i];
        }
    	return str;
    }
    
//    public String[][] getEventString(){
//    	String[][]
//    }

    @SuppressWarnings("unchecked")
	public void shownOnTheMap(Map map) throws Exception {
        int i;
        int j;
        int ranInd;
        if (event == null) {
            throw new Exception("Null Event Array");
        }
        for (int k = 0; k < event.length; k++) {
            switch (event[k]) {
                case 0:
                    ranInd = r.nextInt(map.locationlist[0].length());
                    i = (int) map.locationlist[0].getIndexI(ranInd);
                    j = (int) map.locationlist[0].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 1:
                    ranInd = r.nextInt(map.locationlist[1].length());
                    i = (int) map.locationlist[1].getIndexI(ranInd);
                    j = (int) map.locationlist[1].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 2:
                    ranInd = r.nextInt(map.locationlist[2].length());
                    i = (int) map.locationlist[2].getIndexI(ranInd);
                    j = (int) map.locationlist[2].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 3:
                    ranInd = r.nextInt(map.locationlist[3].length());
                    i = (int) map.locationlist[3].getIndexI(ranInd);
                    j = (int) map.locationlist[3].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = "";
                    break;
                case 4:
                    ranInd = r.nextInt(map.locationlist[4].length());
                    i = (int) map.locationlist[4].getIndexI(ranInd);
                    j = (int) map.locationlist[4].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 5:
                    ranInd = r.nextInt(map.locationlist[5].length());
                    i = (int) map.locationlist[5].getIndexI(ranInd);
                    j = (int) map.locationlist[5].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 6:
                    ranInd = r.nextInt(map.locationlist[6].length());
                    i = (int) map.locationlist[6].getIndexI(ranInd);
                    j = (int) map.locationlist[6].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 7:
                    ranInd = r.nextInt(map.locationlist[7].length());
                    i = (int) map.locationlist[7].getIndexI(ranInd);
                    j = (int) map.locationlist[7].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 8:
                    ranInd = r.nextInt(map.locationlist[8].length());
                    i = (int) map.locationlist[8].getIndexI(ranInd);
                    j = (int) map.locationlist[8].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 9:
                    ranInd = r.nextInt(map.locationlist[9].length());
                    i = (int) map.locationlist[9].getIndexI(ranInd);
                    j = (int) map.locationlist[9].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = "";
                    break;
                case 10:
                    ranInd = r.nextInt(map.locationlist[10].length());
                    i = (int) map.locationlist[10].getIndexI(ranInd);
                    j = (int) map.locationlist[10].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = "";
                    break;
                case 11:
                    ranInd = r.nextInt(map.locationlist[11].length());
                    i = (int) map.locationlist[11].getIndexI(ranInd);
                    j = (int) map.locationlist[11].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
                    break;
                case 12:
                    ranInd = r.nextInt(map.locationlist[12].length());
                    i = (int) map.locationlist[12].getIndexI(ranInd);
                    j = (int) map.locationlist[12].getIndexJ(ranInd);
                    map.map[i][j].setVisitorByDate(this.day_of_month - 1, this.ID);
                    locationNum[k] = " " + (ranInd + 1);
            }
        }
    }

    public String switchCaseGetStr(int ind) {
        String str = "";
        switch (ind) {
            case 0:
                str = "Home";
                break;
            case 1:
                str = "School";
                break;
            case 2:
                str = "Office";
                break;
            case 3:
                str = "Hospital";
                break;
            case 4:
                str = "Restaurant";
                break;
            case 5:
                str = "Bank";
                break;
            case 6:
                str = "Supermarket";
                break;
            case 7:
                str = "Mall";
                break;
            case 8:
                str = "Airport";
                break;
            case 9:
                str = "Park";
                break;
            case 10:
                str = "Police Station";
                break;
            case 11:
                str = "GovtOffice";
                break;
            case 12:
                str = "Gym";

        }
        return str;
    }
}
