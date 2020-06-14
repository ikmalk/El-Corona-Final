package corona.map;

/*
 * ******************************************************************
 ***Created at 1/6/2020
 *
 *DoubleListNode for DoubleLinkedList class
 *Copied from my sample code. 
 *
 */
public class ListNode<T> {

    private T visitorID, fromWhere, howMove, whoWith;
    private ListNode link;

    public ListNode() {
        visitorID = null;
//        fromWhere =null;
//        howMove = null;
//        whoWith =null;
        link = null;
    }

    public ListNode(T a, ListNode b) {
        visitorID = a;
        link = b;
    }

    public T getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(T visitorID) {
        this.visitorID = visitorID;
    }

//    public T getFromWhere() {
//        return fromWhere;
//    }
//
//    public void setFromWhere(T fromWhere) {
//        this.fromWhere = fromWhere;
//    }
//
//    public T getHowMove() {
//        return howMove;
//    }
//
//    public void setHowMove(T howMove) {
//        this.howMove = howMove;
//    }
//
//    public T getWhoWith() {
//        return whoWith;
//    }
//
//    public void setWhoWith(T whoWith) {
//        this.whoWith = whoWith;
//    }
    public ListNode getLink() {
        return link;
    }

    public void setLink(ListNode link) {
        this.link = link;
    }

    public void setData(T visitorID) {
        this.visitorID = visitorID;
//        this.fromWhere = fromWhere;
//        this.howMove = howMove;
//        this.whoWith = whoWith;
    }
}
