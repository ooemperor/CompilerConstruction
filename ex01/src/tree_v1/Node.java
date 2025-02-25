/**
 * Class file for the Node implementation then used in a tree
 * @see tree_v2.Tree
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v1;

public abstract class Node {
    Operation operation;

    Node leftChild;
    Node rightChild;

    /**
     * Constructor for a node that is not a leave
     * @param operation the type of the node
     * @param nodeOldLeft the left child of the node
     * @param nodeOldRight the right child of the node
     */
    public Node(Node nodeOldLeft, Node nodeOldRight, Operation operation){
        this.operation = operation;
        this.leftChild = nodeOldLeft;
        this.rightChild = nodeOldRight;
    }

    public int evaluate(){return 0;}

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
