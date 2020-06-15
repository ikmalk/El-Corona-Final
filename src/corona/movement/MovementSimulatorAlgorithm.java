package corona.movement;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Random;

import corona.*;
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
public class MovementSimulatorAlgorithm {

    private Map map;
    private final int numOfCitizens = 600;
    private DoubleLinkedList<Children> child;
    private DoubleLinkedList<Adult> adult;
    private DoubleLinkedList<Senior> senior;
    private int numOfChildren, numOfAdult, numOfSenior;
    private int count = 1000;
    private MovementSimulatorFrame frame;


    public MovementSimulatorAlgorithm() throws Exception {
        Random r = new Random();
        numOfAdult = 270 + r.nextInt(60);
        numOfSenior = 150 + r.nextInt(60);
        numOfChildren = numOfCitizens - numOfAdult - numOfSenior;

        child = new DoubleLinkedList<Children>();
        adult = new DoubleLinkedList<Adult>();
        senior = new  DoubleLinkedList<Senior>();
        

    }
    
    public MovementSimulatorAlgorithm(MovementSimulatorFrame frame, Map map) throws Exception {
        Random r = new Random();
        numOfAdult = 270 + r.nextInt(60);
        numOfSenior = 150 + r.nextInt(60);
        numOfChildren = numOfCitizens - numOfAdult - numOfSenior;

        child = new DoubleLinkedList<Children>();
        adult = new DoubleLinkedList<Adult>();
        senior = new  DoubleLinkedList<Senior>();
        
        this.frame = frame;
        this.map = map;
        initiate();
        writeLogFile();

    }
    
    public DoubleLinkedList<Children> getChildList(){
    	return child;
    }

    public DoubleLinkedList<Adult> getAdultList(){
    	return adult;
    }

    public DoubleLinkedList<Senior> getSeniorList(){
    	return senior;
    }
    
    public void initiate() throws Exception {
    	Children tempC;
    	Adult tempA;
    	Senior tempS;
    	
    	frame.setLoad("Initiating Children...");
        for (int i = 0; i < numOfChildren; i++) {
            ++count;
            tempC = new Children(count, getAge(0), getGender());
            tempC.generateJob();
            tempC.setEducationLevel();
            tempC.setMap(getMap());
            tempC.setEvent();
            tempC.setImmunity();
            tempC.setPersonScore();
            tempC.setInfectionRate();
            child.addRightNode(tempC);
        }
        frame.setLoad("Initiating Adult...");
        for (int i = 0; i < numOfAdult; i++) {
            ++count;
            tempA = new Adult(count, getAge(1), getGender());
            tempA.generateJob();
            tempA.setEducationLevel();
            tempA.setMap(getMap());
            tempA.setEvent();
            tempA.setImmunity();
            tempA.setPersonScore();
            tempA.setInfectionRate();
            adult.addRightNode(tempA);
        }
        frame.setLoad("Initiating Senior...");
        for (int i = 0; i < numOfSenior; i++) {
            ++count;
            tempS = new Senior(count, getAge(2), getGender());
            tempS.generateJob();
            tempS.setEducationLevel();
            tempS.setMap(getMap());
            tempS.setEvent();
            tempS.setImmunity();
            tempS.setPersonScore();
            tempS.setInfectionRate();
            senior.addRightNode(tempS);
        }
    }

    public int getAge(int i) throws Exception {
        Random r = new Random();
        int age = -1;
        switch (i) {
            case 0://for children
                age = r.nextInt(18);
                break;
            case 1://for adult
                age = 18 + r.nextInt(43);
                break;
            case 2://for senior
                age = 60 + r.nextInt(25);
                break;
        }
        if (age == -1) {
            throw new Exception("Invalid age generation");
        }
        return age;
    }

    public Character getGender() {
        Random r = new Random();

        Character gender = r.nextInt(2) == 0 ? 'M' : 'F';
        return gender;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void writeLogFile() throws IOException, Exception {
    	
    	Children tempC;
    	Adult tempA;
    	Senior tempS;

        FileWriter myWriter1 = new FileWriter("child.txt");
        FileWriter myWriter2 = new FileWriter("adult.txt");
        FileWriter myWriter3 = new FileWriter("senior.txt");
        
        ListIterator<Children> childIterator = child.getListIterator();
        ListIterator<Adult> adultIterator = adult.getListIterator();
        ListIterator<Senior> seniorIterator = senior.getListIterator();
        
        frame.setLoad("Writing Child...");
        while(childIterator.hasNext()) {
        	tempC = childIterator.next();
        	 myWriter1.write("\nID: " + tempC.getID() + " gender: " + tempC.getGender() + " age: "
                     + tempC.getAge() + " job: " + tempC.getJob() + " infection rate: " + tempC.getInfectionRate());
             myWriter1.write(tempC.getEventToString());
        }
        frame.setLoad("Writing Adult...");
       while(adultIterator.hasNext()) {
    	   tempA = adultIterator.next();
    	   myWriter2.write("\nID: " + tempA.getID() + " gender: " + tempA.getGender() + " age: "
                   + tempA.getAge() + " job: " + tempA.getJob() + " infection rate: " + tempA.getInfectionRate());
           myWriter2.write(tempA.getEventToString());
       }
       frame.setLoad("Writing Senior...");
       while(seniorIterator.hasNext()) {
    	   tempS = seniorIterator.next();
    	   myWriter3.write("\nID: " + tempS.getID() + " gender: " + tempS.getGender() + " age: "
                   + tempS.getAge() + " job: " + tempS.getJob() + " infection rate: " + tempS.getInfectionRate());
           myWriter3.write(tempS.getEventToString());
       }
       

    }
}
