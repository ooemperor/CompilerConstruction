/**
 * Class File for the handling of a Tree
 *
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v2;

public class Tree {
    Node root;

    /**
     * Constructor of the Tree
     * @param node the root node of the tree
     */
    public Tree(Node node) {
        this.root = node;
    }

    /**
     * traverse the tree and calculate all the results of the tree
     */
    public int eval() {
        return this.root.evaluate();
    }
}
