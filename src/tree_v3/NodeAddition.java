/**
 * Class File for the handling of Node Operations
 *
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v3;


/**
 * Class to handle NodeOperations
 */
public class NodeAddition extends Node {
    public NodeAddition(Node leftNodeOld, Node rightNodeOld) {
        super(leftNodeOld, rightNodeOld, Operation.addition);
    }

    public void acceptVisitor(EvalVisitor v) {
        v.visitAddition(this);
    }
}
