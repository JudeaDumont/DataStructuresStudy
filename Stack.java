package cs230individualproject;

//Stack interface defines the methods that are available to a stack data structure
public interface Stack<Item> {

    Item pop(); // return the top item and removes it from stack

    void push(Item item); // adds an item to the stack

    boolean isEmpty(); // returns true if stack is empty, false otherwise

    int size();  // returns the number of items in stack right now
}
