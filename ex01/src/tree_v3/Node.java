/**
 * Class file for the Node implementation then used in a tree
 * @see tree_v2.Tree
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v3;

public abstract class Node implements INode {
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
        assert invariant();
    }

    /**
     * invariant method to check the contract on this object
     * @return boolean that indicates the validity of DBC
     */
    private boolean invariant(){
        if (this.operation == Operation.number){
            return (this.rightChild == null && this.leftChild == null);
        }
        else if (this.operation == Operation.mult || this.operation == Operation.addition){
            return (this.rightChild != null && this.leftChild != null);
        }
        else{
            return false;
        }
    }

    public abstract int acceptVisitor(IVisitor v);

    /*
    Getters and setters
     */

    public Node getLeftChild() {
        assert invariant();
        return this.leftChild;
    }

    public void setLeftChild(Node nodeOld) {
        assert invariant();
        this.leftChild = nodeOld;
        assert invariant();
    }

    public Node getRightChild() {
        assert invariant();
        return this.rightChild;
    }

    public void setRightChild(Node nodeOld) {
        assert invariant();
        this.rightChild = nodeOld;
        assert invariant();
    }
}
