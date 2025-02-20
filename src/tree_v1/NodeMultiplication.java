/**
 * Class file for the Node with Multiplication implementation then used in a tree
 * @see tree_v1.Tree
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v1;

public abstract class NodeMultiplication {
    Node leftChild;
    Node rightChild;

    /**
     * Constructor for a Node
     * @param nodeOldLeft the left child of the node
     * @param nodeOldRight the right child of the node
     */
    public NodeMultiplication(Node nodeOldLeft, Node nodeOldRight){
        this.leftChild = nodeOldLeft;
        this.rightChild = nodeOldRight;
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
