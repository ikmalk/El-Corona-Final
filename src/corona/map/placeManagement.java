/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona.map;


/**
 *
 * @author farhan
 */
public class placeManagement<T extends Comparable<T>> {
    
    private static final int SIZE = 14;
    private String nameofPlace;
    Visitors[] visitorByDate;
    
    public placeManagement(String nameofPlace) {
        this.nameofPlace = nameofPlace;
        visitorByDate = new Visitors[SIZE];
        for (int i = 0; i < SIZE; i++) {
            visitorByDate[i] = new Visitors();
        }
    }
    
    public String getNameofPlace() {
        return nameofPlace;
    }
    
    public void setNameofPlace(String nameofPlace) {
        this.nameofPlace = nameofPlace;
    }
    
    public void setVisitorByDate(int date, T visitorID) throws Exception {
        if (date < 0 || date >= SIZE) {
            throw new Exception("Date index out of bound ");
        }
        visitorByDate[date].addVisitor(visitorID);
    }
    
    //get Visitors Linked List
    public T getVisitorByDate(int date) throws Exception {
        if (date < 0 || date >= SIZE) {
            throw new Exception("Date index out of bound ");
        }
        return (T) visitorByDate[date].getList();
    }
    
    //check if there is any visitor in said place
    public boolean containsVisitorByDate(int date, T visitorID) throws Exception {
        if (date < 0 || date >= SIZE) {
            throw new Exception("Date index out of bound ");
        }
        return visitorByDate[date].contains(visitorID);
    }
    
    
    public int getIndexByDate(int date, T visitorID) throws Exception {
        if (date < 0 || date >= SIZE) {
            throw new Exception("Date index out of bound ");
        }
        return visitorByDate[date].getIndex(visitorID);
    }

    //display all the visitor in the place at one day
    public void displayVisitorsByDate(int date) throws Exception {
        if (date < 0 || date >= SIZE) {
            throw new Exception("Date index out of bound ");
        }
        for (int i = 0; i < visitorByDate[date].length(); i++) {
            System.out.print(visitorByDate[date].getVisitorID(i)+" -->");
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        
        return nameofPlace;
    }
    
}
