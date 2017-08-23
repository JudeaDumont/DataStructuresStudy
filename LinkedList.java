package cs230individualproject;

public interface LinkedList <Item> extends Iterable<Item>{
    void insertAfter(Item item);
    void deleteNext();
    boolean hasNext();
    Item next();
}
