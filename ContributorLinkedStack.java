package cs230individualproject;

import java.util.Iterator;

//LinkedStack Manual Implementation:
public class ContributorLinkedStack implements Stack<Contributor>, SinglyLinkedList<Contributor> {
    public Node currentNode; //the first node
    private int size; // number of contributors

    //Warning, insertAfter has not been tested
    @Override
    public void insertAfter(Contributor contributor) {
        Node oldHead = currentNode;
        Node oldHeadNext = null;
        currentNode = new Node();
        if (oldHead.next != null) {
            oldHeadNext = oldHead.next;
        }
        oldHead.next = currentNode;
        currentNode.contributor = contributor;
        currentNode.next = oldHeadNext;
        currentNode = oldHead;
        size++;
    }

    //Warning, deleteNext has not been tested
    @Override
    public void deleteNext() {
        if (currentNode.next != null) {
            currentNode.next = currentNode.next.next;
        }
    }

    //Checks if the head has a next node
    @Override
    public boolean hasNext() {
        return currentNode.next != null;
    }

    //Return the current contributor orf the node and traverse to the next node
    @Override
    public Contributor next() {
        if (hasNext()) {
            currentNode = currentNode.next;
            return currentNode.contributor;
        }
        return null;
    }

    //Nested class to define node
    public class Node {
        Contributor contributor;
        Node next;
    }

    //Zero argument constructor
    public ContributorLinkedStack() {
        currentNode = null;
        size = 0;
    }

    //Check if stack is empty
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    //Remove contributor from the beginning of the list.
    @Override
    public Contributor pop() {
        Contributor contributor = currentNode.contributor;
        currentNode = currentNode.next;
        size--;
        return contributor;
    }

    //Add contributor to the beginning of the list.
    @Override
    public void push(Contributor contributor) {
        Node oldHead = currentNode;
        currentNode = new Node();
        currentNode.contributor = contributor;
        currentNode.next = oldHead;
        size++;
    }

    //Return number of contributors present in the stack
    @Override
    public int size() {
        return size;
    }

    //Iterator for traversing stack contributors
    @Override
    public Iterator<Contributor> iterator() {
        return new LinkedStackIterator();
    }

    //Inner class to implement iterator interface
    private class LinkedStackIterator implements Iterator<Contributor> {

        private int i = size;
        private Node first = currentNode; //the first node

        @Override
        public boolean hasNext() {
            return (i > 0);
        }

        @Override
        public Contributor next() {
            Contributor contributor = first.contributor;
            first = first.next;
            i--;
            return contributor;
        }

        @Override
        public void remove() {
            // not needed
        }
    }
}
