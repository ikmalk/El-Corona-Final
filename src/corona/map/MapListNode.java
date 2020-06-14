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
public class MapListNode<T> {

    private T indexI;
    private T indexJ;
    private MapListNode link;

    public MapListNode(T indexI, T indexJ, MapListNode link) {
        this.indexI = indexI;
        this.indexJ = indexJ;
        this.link = link;
    }

    public MapListNode() {
        this.indexI = null;
        this.indexJ = null;
        link = null;
    }

    public void setIndexI(T indexI) {
        this.indexI = indexI;
    }

    public void setIndexJ(T indexJ) {
        this.indexJ = indexJ;
    }

    public void setLink(MapListNode link) {
        this.link = link;
    }

    public T getIndexI() {
        return indexI;
    }

    public T getIndexJ() {
        return indexJ;
    }

    public MapListNode getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "i: " + indexI + " j:" + indexJ;
    }

}
