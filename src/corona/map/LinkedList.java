package corona.map;

import java.util.Iterator;

/*
 * ******************************************************************
 ***Created at 1/6/2020
 *
 *DoubleLinkedList class copied from my sample code. 
 *Got Iterator because doing while loop every time you want to search is a bad idea
 * 
 *********************************************************************
 ***Write all your changes here
 *-
 *********************************************************************
 ***To do list
 * - Add a sorting algorithm to the class (not done)
 * - Add a method that remove all duplicate in class (not done)
 * - Add a search algorithm (not done)
 **********************************************************************
 */
public class LinkedList<T extends Comparable<T>> {

    protected ListNode head;

    public LinkedList() {
        head = null;
    }

    public int length() {
        int count = 0;
        ListNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }

    public void clear() {
        head = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void showList() {
        ListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }

    // insert at the back
    public void addNode(T visitorID) {
        ListNode newNode = new ListNode(visitorID, null);
        ListNode currentNode = head;
        if (head == null) {
            head = newNode;
        } else {
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setLink(newNode);
        }
    }

    // delete from the back
    public void deleteNode() {
        ListNode currentNode = head;
        ListNode previousNode = head;
        if (head != null) {
            if (currentNode.getLink() == null) {
                head = null;
            } else {
                while (currentNode.getLink() != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }
                previousNode.setLink(null);
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void addFrontNode(T visitorID) {
        head = new ListNode(visitorID, head);
    }

    public void deleteFrontNode() {
        if (head != null) {
            head = head.getLink();
        } else {
            System.out.println("The list is empty.");
        }
    }

    public boolean contains(T t) {
        boolean found = false;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (t.compareTo((T) currentNode.getVisitorID()) == 0) {
                found = true;
                break;
            }
            currentNode = currentNode.getLink();
        }
        return found;
    }

    public void addNodeByPosition(T visitorID, int index) {
        if (index == 0) {
            addFrontNode(visitorID);
        } else if (index == length()) {
            addNode(visitorID);
        } else if (index > length()) {
            System.out.println("Invalid index. No node inserted");
        } else {
            ListNode newNode = new ListNode(visitorID, null);
            ListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }

            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(newNode);
            newNode.setLink(tempNode);
        }
    }

    public void deleteNodeByPosition(int index) {
        if (index == 0) {
            deleteFrontNode();
        } else if (index == length() - 1) {
            deleteNode();
        } else if (index >= length()) {
            System.out.println("Invalid index. No node deleted");
        } else {
            ListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }
            ListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }

    public void set(T visitorID, int index) {
        if (index == 0) {
            setFront(visitorID);
        } else if (index == length() - 1) {
            setBack(visitorID);
        } else if (index >= length()) {
            System.out.println("Invalid index. Update failed.");
        } else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.getLink();
            }
            currentNode.setData(visitorID);
        }
    }

    public void setFront(T visitorID) {
        if (head != null) {
            head.setData(visitorID);
        } else {
            System.out.println("Invalid update. List is empty");
        }
    }

    public void setBack(T visitorID) {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            currentNode.setData(visitorID);
        } else {
            System.out.println("Invalid update. List is empty");
        }
    }

    public T get(int index) {
        if (index == 0) {
            return getFront();
        } else if (index == length() - 1) {
            return getBack();
        } else if (index >= length()) {
            return null;
        } else {
            ListNode currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getVisitorID();
        }
    }

    public T getFront() {
        if (head != null) {
            return (T) head.getVisitorID();
        } else {
            return null;
        }
    }

    public T getBack() {
        if (head != null) {
            ListNode currentNode = head;
            while (currentNode.getLink() != null) {
                currentNode = currentNode.getLink();
            }
            return (T) currentNode.getVisitorID();
        } else {
            return null;
        }
    }

    public Iterator listIterator() {
        LinkedListIterator iterator = new LinkedListIterator();
        return iterator;
    }

    public class LinkedListIterator implements Iterator<T> {

        ListNode currentNode = null, previousNode = null;
        private boolean atHead = true;

        @Override
        public boolean hasNext() {

            if (atHead) {
                atHead = false;
                return true;
            }

            return currentNode.getLink() != null;

        }

        @Override
        public T next() {

            if (currentNode == null) {
                currentNode = head;
                return (T) currentNode.getVisitorID();
            }

            previousNode = currentNode;
            currentNode = currentNode.getLink();
            return (T) currentNode.getVisitorID();

        }

        public void remove() {

            previousNode.setLink(currentNode.getLink());
            currentNode = previousNode;
            previousNode = null;

        }
    }

}
