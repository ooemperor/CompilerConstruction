package utils;

/**
 * Definition of the utils.Stack interface given by the exercise sheet 1
 * @param <E>
 */
public interface IStack<E> {
    public boolean isEmpty();
    public int size();
    public void push(E item);
    public E top();
    public void pop();
}
