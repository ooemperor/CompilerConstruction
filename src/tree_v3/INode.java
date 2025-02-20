package tree_v3;

/**
 * Interface for the Node
 */
public interface INode {
    public void acceptVisitor(IVisitor v);
}
