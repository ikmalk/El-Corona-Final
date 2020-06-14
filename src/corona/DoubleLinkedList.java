package corona;

import java.util.ListIterator;

/*
 * ******************************************************************
 ***Created at 31/5/2020
 *
 *DoubleLinkedList class copied from my lab work. 
 *Got ListIterator because doing while loop every time you want to search is a bad idea
 *
 *********************************************************************
 ***Write all your changes here
 *-
 *********************************************************************
 ***To do list
 * - Add a sorting algorithm to the class (not done)
 * - Add a method that remove all duplicate in class (not done)
 * - Add a search algorithm (not done)
 * ********************************************************************
 */

public class DoubleLinkedList<T> {
    protected DoubleListNode head;
    
    public DoubleLinkedList() {
        head = null;
    }
    
    public void addLeftNode(T a) {        
        head = new DoubleListNode(a, null, head);
    }
    
    public void addRightNode(T a) {
        DoubleListNode newNode =new DoubleListNode(a, null ,null);
        DoubleListNode currentNode = head;
       
        if (head==null) {
            head = newNode;
        }
        else {        
            while (currentNode.getNextLink() != null) 
                currentNode = currentNode.getNextLink();
            currentNode.setNextLink(newNode);
            newNode.setPreviousLink(currentNode);
        }
    }
    
    public void addNodeByPosition(T a, int index) {        
        if (index==0) 
            addLeftNode(a);        
        else if (index==length())
            addRightNode(a);
        else if (index>length())
            System.out.println("Invalid index. No node inserted");   
        else {
            DoubleListNode newNode =new DoubleListNode(a, null, null);
            DoubleListNode currentNode = head;
            for(int i=1; i<index; i++)
                currentNode = currentNode.getNextLink();
            
            DoubleListNode tempNode = currentNode.getNextLink();
            currentNode.setNextLink(newNode);
            newNode.setLink(currentNode, tempNode);
            if (tempNode!=null)
                tempNode.setPreviousLink(newNode);            
        }
    }
    
   
    
    public void clear() {
        head=null;
    }
       
    public void deleteLeftNode() {
        if (head != null) {
            head = head.getNextLink();
            head.setPreviousLink(null);
        }
        else
            System.out.println("The list is empty.");
    }

    public void deleteNodeByPosition(int index) {
        if (index==0) 
            deleteLeftNode();
        else if (index==length()-1)
            deleteRightNode();
        else if (index>=length())
            System.out.println("Invalid index. No node deleted");
        else {
            DoubleListNode currentNode = head;
            for(int i=1; i<index; i++)
                currentNode = currentNode.getNextLink();
            DoubleListNode tempNode = currentNode.getNextLink();
            currentNode.setNextLink(tempNode.getNextLink());
            if (tempNode.getNextLink()!=null) 
                tempNode.getNextLink().setPreviousLink(currentNode);
            tempNode = null;
    
        }
   }
    
    public void deleteRightNode() {
        DoubleListNode currentNode = head;
        DoubleListNode previousNode = head;
        if (head != null) {
            if (currentNode.getNextLink() == null)
                head = null;
            else {
                while (currentNode.getNextLink() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getNextLink();
                }
                currentNode=null;
                previousNode.setNextLink(null);   
            }
        }
        else
            System.out.println("The list is empty.");
    }
    
    public T get(int index) {
        if (index==0) {
            return getFront();
        }
        else if (index==length()-1)
            return getBack();
        else if (index>=length())
            return null;
        else {
            DoubleListNode currentNode = head;                        
            for(int i=1; i<=index; i++)
                currentNode = currentNode.getNextLink();
            return (T) currentNode.getData();            
        }
   }
    
    public T getFront() {
        if (head != null)
            return (T) head.getData();
        else
            return null;
    }
    
    public T getBack() {
        if (head != null) {
           DoubleListNode currentNode = head;
            while(currentNode.getNextLink() != null)
                currentNode = currentNode.getNextLink();
            return (T) currentNode.getData();        
        }    
        else
            return null;
    }
    
    public boolean isEmpty() {
        return (head==null);
    }
    
    public int length() {
        int count=0;    
        DoubleListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getNextLink();
            count++;
        }
        return count;
    }
    
    public void set(T a, int index) {
        if (index==0) {
        	setFront(a);
        }
        else if (index==length()-1)
            setBack(a);
        else if (index>=length())
            System.out.println("Invalid index. Update failed.");
        else {
            DoubleListNode currentNode = head;
            for(int i=1; i<=index; i++)
                currentNode = currentNode.getNextLink();    
            currentNode.setData(a);   
        }
    }
    
    public void setBack(T t) {
        if (head != null) {
            DoubleListNode currentNode = head;
            while(currentNode.getNextLink() != null)
                currentNode = currentNode.getNextLink();
            currentNode.setData(t);
        }
        else
            System.out.println("Invalid update. List is empty");
    } 
    
    public void setFront(T t) {
        if (head != null)
            head.setData(t);
        else
            System.out.println("Invalid update. List is empty");
    }
    
    public void showList() {
        DoubleListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getNextLink();
        }
    }
    
    public ListIterator<T> getListIterator() {
    	ListIterator<T> iterator = new DoubleLinkedListIterator();
    	return iterator;
    	
    }
    
    public ListIterator<T> getListIteratorPointsAtEnd() {
    	ListIterator<T> iterator = new DoubleLinkedListIterator();
    	T temp;
    	while(iterator.hasNext()) {
    		temp = iterator.next();
    	}
    	return iterator;
    }
    
    private class DoubleLinkedListIterator implements ListIterator<T>{
    	

    	private DoubleListNode currentNode = null,previousNode = null;
    	private boolean atHead = true;
    	private int index = 0;
    	
		@Override
		public boolean hasNext() {
			
			if(atHead) {
				atHead = false;
				return true;
			}

			return currentNode.getNextLink()!=null;
			
		
		}
		

		@Override
		public T next() {
			
			
			if(currentNode==null) {
				 currentNode = head;
				 return (T)currentNode.getData();
			}
			index++;
			previousNode = currentNode;
			currentNode = currentNode.getNextLink();
			return (T)currentNode.getData();
			
			
		}

		@Override
		public boolean hasPrevious() {
			if(atHead) {
				atHead = false;
				return true;
			}
			
			return currentNode.getPreviousLink()!=null;
		}

		@Override
		public T previous() {
			
			if(currentNode==null) {
				 currentNode = head;
				 return (T)currentNode.getData();
			}
			index--;
			previousNode = currentNode;
			currentNode = currentNode.getPreviousLink();
			return (T)currentNode.getData();

		}

		public void remove() {
			
			if(previousNode.getPreviousLink()==currentNode) {
				previousNode = currentNode.getPreviousLink();
			}
			previousNode.setNextLink(currentNode.getNextLink());
			currentNode = previousNode;
			previousNode = null;
			
		}
		
		@Override
		public int nextIndex() {
			return index+1;
		}

		@Override
		public int previousIndex() {
			return index-1;
		}

		@Override
		public void set(T e) {
			currentNode.getPreviousLink().setData(e);			
		}

		@Override
		public void add(T e) {		
			//No need to add anything atm
		}
		
	}
    
    
   
    
   
   
}