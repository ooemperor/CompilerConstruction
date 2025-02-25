/**
 * Class File for the handling of Node Multiplication
 *
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v3;


/**
 * Class to handle NodeMultiplication
 */
public class NodeMultiplication extends Node {
    public NodeMultiplication(Node leftNodeOld, Node rightNodeOld) {
        super(leftNodeOld, rightNodeOld, Operation.mult);
    }

    @Override
    public int acceptVisitor(IVisitor v) {
        return v.visitMultiplication(this);
    }
}