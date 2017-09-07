package MainStudy;
/*
 * @param <ValueType>
 */

//The ndoe type is a generic implementation to manifest an item ina  linked list
public class Node<ValueType extends Comparable> {

    ValueType value;
    Node<ValueType> next;

    //Constructors used to shorten the creation of nodes
    public Node(ValueType value) {
        this.value = value;
    }

    public Node() {
    }

    public Node(ValueType value, Node<ValueType> next) {
        this.value = value;
        this.next = next;
    }

}
