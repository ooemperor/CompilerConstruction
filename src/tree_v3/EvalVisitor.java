package tree_v3;

public class EvalVisitor implements IVisitor{
    public int visitNumber(NodeNumber node){
        return node.getNumber();
    }

    public int visitAddition(NodeAddition node){
        return 0;
    }

    public int visitMultiplication(NodeMultiplication node){
        return 0;
    }
}
