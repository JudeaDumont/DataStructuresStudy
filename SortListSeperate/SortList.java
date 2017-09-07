package SortListSeperate;

/**
 * Created by Owner on 9/6/2017.
 */
public class SortList<ValueType extends Comparable> {
    Node head;
    //Issue #1:
    // Clone the head and keep track of local state with the cloned head rather than keeping track of state within the class.
    //Issue #2:
    // When a node that is being pointed at is set with a new node, the pointing node must also be reassigned.
    //Issue #3:
    // Sometimes it is required that the problem be taken out of context to allow for faster coding.

    public void insertSort(ValueType value) {
        Node currentNode = head;
        if (head == null) {
            head = new Node();
            head.value = value;
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
                }

                //Insertion has still not occurred, place at end
                else {
                    currentNode = new Node();
                    currentNode.value = value;
                    previousNode.next = currentNode;
                }
            }
        }
    }

    @Override
    public String toString() {
        String aggregateString = "";
        Node currentNode = head;
        while (currentNode != null) {
            aggregateString += currentNode.value.toString();
            currentNode = currentNode.next;
        }
        return aggregateString;
    }
}
