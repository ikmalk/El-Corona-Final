/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corona.map;

/**
 *
 * @author Oliver
 */
public class Visitors<T extends Comparable<T>> {
    
    private LinkedList list;
    
    public Visitors() {
        list = new LinkedList();
        
    }
    
    public LinkedList getList() {
    	return list;
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public int length() {
        return list.length();
    }
    
    public void addVisitor(T visitorID) {
        list.addNode((Comparable) visitorID);
    }
    
    public boolean contains(T visitorsID) {
        return list.contains(visitorsID);
    }
    
    public int getIndex(T visitorID) throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty List");
        }
        for (int i = 0; i < length(); i++) {
            if (visitorID.compareTo((T) list.get(i)) == 0) {
                return i;
            }
        }
        return -1;
    }

    public T getVisitorID(int ind) throws Exception {
        if (isEmpty()) {
            throw new Exception("Empty List");
        }
        return (T)list.get(ind);
    }
}
