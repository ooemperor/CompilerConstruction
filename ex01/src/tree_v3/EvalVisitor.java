package tree_v3;

public class EvalVisitor implements IVisitor{
    public int visitNumber(NodeNumber node){
        return node.getNumber();
    }

    public int visitAddition(NodeAddition node){
        return (node.getLeftChild().acceptVisitor(this) + node.getRightChild().acceptVisitor(this));
    }

    public int visitMultiplication(NodeMultiplication node){
        return node.getLeftChild().acceptVisitor(this) * node.getRightChild().acceptVisitor(this);
    }
}
