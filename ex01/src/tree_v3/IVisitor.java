/**
 * File for the definitioni of the Visitor interface
 */
package tree_v3;

/**
 * Interface of the visitor
 */
public interface IVisitor {
    public int visitNumber(NodeNumber node);
    public int visitAddition(NodeAddition node);
    public int visitMultiplication(NodeMultiplication node);
}
