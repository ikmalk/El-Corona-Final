package corona.movement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Oliver
 */
public abstract class Person {

    private Integer ID;
    private int age;
    private Character gender;
    private String job;
    private int educationLevel, personScore;
    private double immunity, infectionRate;

    public Person(Integer ID, int age, Character gender) {
        this.ID = ID;
        this.age = age;
        this.gender = gender;
    }

    public abstract int[] getEvent(int day_of_month) throws Exception;
    public abstract String[][] getEvent();
    
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

}
