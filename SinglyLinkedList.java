package cs230individualproject;

//LinkedList Interface defines operations that a singly linked list can perform
public interface SinglyLinkedList<Item> extends Iterable<Item> {

    //Insert an node after this current node
    void insertAfter(Item item);

    //Delete the next node and replace with the node after if there is one
    void deleteNext();

    //Check if there is a next node
    boolean hasNext();

    //Return the current nodes item and iterate to the next node
    Item next();
}
