/**
 * Class File for the handling of Node Operations
 *
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v2;


/**
 * Class to handle NodeOperations
 */
public class NodeAddition extends Node {
    public NodeAddition(Node leftNodeOld, Node rightNodeOld) {
        super(leftNodeOld, rightNodeOld, Operation.addition);
    }

    @Override
    public int evaluate() {
        return this.leftChild.evaluate() + this.rightChild.evaluate();
    }
}
