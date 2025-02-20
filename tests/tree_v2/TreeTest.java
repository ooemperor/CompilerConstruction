/**
 * Test cases for the Tree v_2 package
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tree_v3.INode;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    @Test
    public void TreeTest1() throws Exception{
        Node node2 = new NodeNumber(2);
        Node node10 = new NodeNumber(10);
        Node node5 = new NodeNumber(5);

        Node nodeMult1 = new NodeMultiplication(node2, node10);
        Node nodeAdd = new NodeAddition(node5, nodeMult1);
        assertEquals(25, nodeAdd.evaluate());
        assertTrue(Class.forName("tree_v2.NodeAddition").isInstance(nodeAdd));
        assertTrue(Class.forName("tree_v2.NodeNumber").isInstance(node2));
        assertTrue(Class.forName("tree_v2.NodeNumber").isInstance(node5));
        assertTrue(Class.forName("tree_v2.NodeNumber").isInstance(node10));
        assertTrue(Class.forName("tree_v2.NodeMultiplication").isInstance(nodeMult1));
        assertTrue(Class.forName("tree_v2.Node").isInstance(nodeMult1));

    }
}
