/**
 * Class File for the handling of Node Multiplication
 *
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v2;


/**
 * Class to handle NodeMultiplication
 */
public class NodeMultiplication extends Node {
    public NodeMultiplication(Node leftNodeOld, Node rightNodeOld) {
        super(leftNodeOld, rightNodeOld, Operation.mult);
    }

    @Override
    public int evaluate() {
        return this.leftChild.evaluate() * this.rightChild.evaluate();
    }
}