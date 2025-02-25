/**
 * Class for the implementation of our stack interface
 * @author: Michael Kaiser
 * @version 1.0
 */
package utils;


import java.util.Stack;

/**
 * Custom implementation of the utils.Stack interface with the default stack in a custom class
 * @param <String>
 */
public class MyStack<String> implements IStack<String> {
    private Stack<String> chars;

    /**
     * Constructor
     */
    public MyStack(){
        this.chars = new Stack<>();
    }

    /**
     * Check if the stack is empty
     * @return True if stack is empty
     */
    public boolean isEmpty(){
        return this.chars.isEmpty();
    }

    /**
     * Check the size of the stack and return it
     * @return the size of the stack
     */
    public int size(){
        return this.chars.size();
    }

    /**
     * Push a given item into the stack
     * @param item The item to push
     */
    public void push(String item){
        this.chars.push(item);
    }

    /**
     * Fetch the first element out of the stack but dont remove it
     * @return The first element in the Stack
     */
    public String top(){
        return this.chars.peek();
    }

    /**
     * remove the first element of the stack without removing it
     */
    public void pop(){
        this.chars.pop();
    }
}
