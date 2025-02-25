package tree_v2;
/**
 * Class for the concrete implementation of NodeNumber
 * @author Michael Kaiser
 * @version 1.0
 */

/**
 * Concrete NodeNumber class that represents
 * the concrete representation of Node that holds a number and not an operation
 *
 */
public class NodeNumber extends Node {


    private int number;

    public NodeNumber(int number){
        super(null, null, Operation.number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int evaluate(){
        return this.number;
    }
}
