/**
 * Class file for the Node with Adddition implementation then used in a tree
 * @see tree_v1.Tree
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v1;

public abstract class NodeAddition extends Node {
    Node leftChild;
    Node rightChild;

    /**
     * Constructor for a Node
     * @param nodeOldLeft the left child of the node
     * @param nodeOldRight the right child of the node
     */
    public NodeAddition(Node nodeOldLeft, Node nodeOldRight){
        super(nodeOldLeft, nodeOldRight, Operation.addition);
    }

    /*
    Getters and setters
     */

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(Node nodeOld) {
        this.leftChild = nodeOld;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(Node nodeOld) {
        this.rightChild = nodeOld;
    }

}
