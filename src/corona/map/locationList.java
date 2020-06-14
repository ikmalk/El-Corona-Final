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
public class locationList<T extends Comparable<T>> {

    protected MapListNode head;

    public locationList() {
        head = null;
    }

    public int length() {
        int count = 0;
        MapListNode currentNode = head;
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
        MapListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }

    // insert at the back
    public void addNode(int i, int j) {
        MapListNode newNode = new MapListNode(i, j, null);
        MapListNode currentNode = head;
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
        MapListNode currentNode = head;
        MapListNode previousNode = head;
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

    public void addFrontNode(int i, int j) {
        head = new MapListNode(i, j, head);
    }

    public void deleteFrontNode() {
        if (head != null) {
            head = head.getLink();
        } else {
            System.out.println("The list is empty.");
        }
    }

    public boolean contains(int i, int j) {
        boolean found = false;
        MapListNode currentNode = head;
        while (currentNode != null) {
            if (i == (int) currentNode.getIndexI() && j == (int) currentNode.getIndexJ()) {
                found = true;
                break;
            }
            currentNode = currentNode.getLink();
        }
        return found;
    }

    public void addNodeByPosition(int i, int j, int index) {
        if (index == 0) {
            addFrontNode(i, j);
        } else if (index == length()) {
            addNode(i, j);
        } else if (index > length()) {
            System.out.println("Invalid index. No node inserted");
        } else {
            MapListNode newNode = new MapListNode(i, j, null);
            MapListNode currentNode = head;
            for (int k = 1; k < index; k++) {
                currentNode = currentNode.getLink();
            }

            MapListNode tempNode = currentNode.getLink();
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
            MapListNode currentNode = head;
            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getLink();
            }
            MapListNode tempNode = currentNode.getLink();
            currentNode.setLink(tempNode.getLink());
            tempNode = null;
        }
    }

    public T getIndexI(int index) throws Exception {
        if (index < 0 || index >= length()) {
            throw new Exception("Invaild index for getter");
        }
        MapListNode currentNode = head;
        if (index == 0) {
            return (T) currentNode.getIndexI();
        }
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.getLink();
        }
        return (T) currentNode.getIndexI();

    }

    public T getIndexJ(int index) throws Exception {
        if (index < 0 || index >= length()) {
            throw new Exception("Invaild index for getter");
        }
        MapListNode currentNode = head;
        if (index == 0) {
            return (T) currentNode.getIndexJ();
        }
        for (int j = 1; j <= index; j++) {
            currentNode = currentNode.getLink();
        }
        return (T) currentNode.getIndexJ();

    }
}
