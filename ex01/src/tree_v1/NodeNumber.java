/**
 * Class file for the Node with a Number implementation then used in a tree
 * @see tree_v1.Tree
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v1;

public abstract class NodeNumber {
    private final int number;

    /**
     * Constructor for a Node
     * @param number the value of the Node
     */
    public NodeNumber(int number){
        this.number = number;
    }

    /*
    Getters and setters
     */

    public int getNumber(){
        return this.number;
    }
}
