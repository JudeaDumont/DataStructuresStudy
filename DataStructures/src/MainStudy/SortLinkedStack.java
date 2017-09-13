package cs230individualproject;

import java.util.Iterator;

//LinkedStack Manual Implementation:
public class SortLinkedStack<ValueType extends Comparable> implements Stack<ValueType>, SinglyLinkedList<ValueType>, SortList<ValueType> {

    public Node head;
    Node current = head;
    private int size; // number of contributors

    //Insert node after the current node
    @Override
    public void insertNext(ValueType value) {
        if (head == null) {
            head = new Node();
            head.value = value;
            current = head;
        } else {
            if (current.next != null) {
                Node insertingNode = new Node(value);
                Node oldNext = current.next;
                current.next = insertingNode;
                insertingNode.next = oldNext;
            } else {
                Node insertingNode = new Node(value);
                current.next = insertingNode;
            }
        }
        ++size;
    }

    //Delete the node that the current node is pointing at via its next property
    @Override
    public void deleteNext() {
        if (current.next != null) {
            current.next = current.next.next;
            --size;
        }
    }

    //Checks if there is a next node to be traversed in the current node
    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    //Return the current contributor of the node and traverse to the next node
    @Override
    public ValueType next() {
        if (hasNext()) {
            current = current.next;
            return (ValueType) current.value;
        }
        return null;
    }

    //Insert a node with regard to its compareto method 
    //The inserted value must conform to extending the compareTo class.
    @Override
    public void sortInsert(ValueType value) {
        Node currentNode = head;
        if (head == null) {
            head = new Node();
            head.value = value;
            current = head;
        } else {
            //Inserting Node gets placed before head
            if (currentNode.value.compareTo(value) > 0) {
                Node oldHead = head;
                head = new Node();
                head.value = value;
                head.next = oldHead;
            } else {
                //Iterate to place where inserted node gets placed
                Node previousNode = null;
                while (currentNode != null && currentNode.value.compareTo(value) <= 0) {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
                if (currentNode != null && currentNode.value.compareTo(value) > 0) {
                    Node oldCurrent = currentNode;
                    currentNode = new Node();
                    currentNode.value = value;
                    currentNode.next = oldCurrent;
                    previousNode.next = currentNode;
                } //place node at end of linked list
                else {
                    currentNode = new Node();
                    currentNode.value = value;
                    previousNode.next = currentNode;
                }
            }
        }
        ++size;
    }

    //Zero argument constructor
    public SortLinkedStack() {
        current = null;
        size = 0;
    }

    //Check if stack is empty
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    //Remove contributor from the end of the list, 
    //thus conforming to the last in first out principle
    //of a stack
    @Override
    public ValueType pop() {
        ValueType returnValue = null;
        if (head != null) {
            Node currentNode = head;
            if (size == 1) {
                returnValue = (ValueType) currentNode.value;
                currentNode = null;
            } else {
                Node previousNode = null;
                while (currentNode.next != null) {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
                returnValue = (ValueType) currentNode.value;
                previousNode.next = null;
            }
            size--;
        }
        return returnValue;
    }

    //Add contributor to the end of the list,
    //once again to confrom to the last in first out principle
    @Override
    public void push(ValueType value) {
        Node currentNode = head;
        if (head == null) {
            head = new Node();
            head.value = value;
            current = head;
        } else {
            Node previousNode = currentNode;
            while (currentNode.next != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            Node insertingNode = new Node(value);
            previousNode.next = insertingNode;
        }
        ++size;
    }

    //Return number of contributors present in the stack
    @Override
    public int size() {
        return size;
    }

    //Iterator for traversing stack contributors in a general setting
    @Override
    public Iterator iterator() {
        return new LinkedStackIterator();
    }

    @Override
    public ValueType sequentialSearch(ValueType value) {
        Node currentNode = head;
        ValueType returnedNode = null;
        while(currentNode.next!=null && currentNode.value.compareTo(value)!=0)
        {
            currentNode = currentNode.next;
        }
        if(currentNode.value.compareTo(value)==0)
        {
            returnedNode = (ValueType)currentNode.value;
        }
        return returnedNode;
    }

    //Inner class to implement iterator interface
    private class LinkedStackIterator implements Iterator<ValueType> {

        private int iteratorSize = size;
        private Node currentNode = head; //the first node

        @Override
        public boolean hasNext() {
            return (iteratorSize > 0);
        }

        @Override
        public ValueType next() {
            ValueType value = (ValueType) currentNode.value;
            currentNode = currentNode.next;
            iteratorSize--;
            return value;
        }

        @Override
        public void remove() {
            // not needed
        }
    }

    //Retruns a string that displays the contributors as 
    //contained in the sortedlinkedstack
    @Override
    public String toString() {
        String aggregateString = "";
        Node currentNode = head;
        while (currentNode != null) {
            aggregateString += currentNode.value.toString() + "\n";
            currentNode = currentNode.next;
        }
        return aggregateString;
    }
}
