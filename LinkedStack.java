package cs230individualproject;

import java.util.Iterator;

//LinkedStack Manual Implementation:
public class LinkedStack<Item> implements Stack<Item>, SinglyLinkedList<Item> {

    private Node head; //the first node
    private int size; // number of items

    //Warning, insertAfter has not been tested
    @Override
    public void insertAfter(Item item) {
        Node oldHead = head;
        Node oldHeadNext = null;
        head = new Node();
        if (oldHead.next != null) {
            oldHeadNext = oldHead.next;
        }
        oldHead.next = head;
        head.item = item;
        head.next = oldHeadNext;
        head = oldHead;
        size++;
    }

    //Warning, deleteNext has not been tested
    @Override
    public void deleteNext() {
        if (head.next != null) {
            head.next = head.next.next;
        }
    }

    //Checks if the head has a next node
    @Override
    public boolean hasNext() {
        return head.next != null;
    }

    //Return the current item orf the node and traverse to the next node
    @Override
    public Item next() {
        if (hasNext()) {
            head = head.next;
            return head.item;
        }
        return null;
    }

    //Nested class to define node
    private class Node {

        Item item;
        Node next;
    }

    //Zero argument constructor
    public LinkedStack() {
        head = null;
        size = 0;
    }

    //Check if stack is empty
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    //Remove item from the beginning of the list.
    @Override
    public Item pop() {
        Item item = head.item;
        head = head.next;
        size--;
        return item;
    }

    //Add item to the beginning of the list.
    @Override
    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        size++;
    }

    //Return number of items present in the stack
    @Override
    public int size() {
        return size;
    }

    //Iterator for traversing stack items
    @Override
    public Iterator<Item> iterator() {
        return new LinkedStackIterator();
    }

    //Inner class to implement iterator interface
    private class LinkedStackIterator implements Iterator<Item> {

        private int i = size;
        private Node first = head; //the first node

        @Override
        public boolean hasNext() {
            return (i > 0);
        }

        @Override
        public Item next() {
            Item item = first.item;
            first = first.next;
            i--;
            return item;
        }

        @Override
        public void remove() {
            // not needed
        }
    }
}
