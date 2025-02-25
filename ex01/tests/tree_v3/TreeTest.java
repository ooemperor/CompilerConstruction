/**
 * Test cases for the Tree v_3 package
 * @author Michael Kaiser
 * @version 1.0
 */
package tree_v3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    @Test
    public void TreeTest1() throws Exception{
        NodeNumber node2 = new NodeNumber(2);
        NodeNumber node10 = new NodeNumber(10);
        NodeNumber node5 = new NodeNumber(5);

        NodeMultiplication nodeMult1 = new NodeMultiplication(node2, node10);
        NodeAddition nodeAdd = new NodeAddition(node5, nodeMult1);

        EvalVisitor visitor = new EvalVisitor();

        assertTrue(Class.forName("tree_v3.NodeAddition").isInstance(nodeAdd));
        assertTrue(Class.forName("tree_v3.NodeNumber").isInstance(node2));
        assertTrue(Class.forName("tree_v3.NodeNumber").isInstance(node5));
        assertTrue(Class.forName("tree_v3.NodeNumber").isInstance(node10));
        assertTrue(Class.forName("tree_v3.NodeMultiplication").isInstance(nodeMult1));

        assertEquals(2, visitor.visitNumber(node2));
        assertEquals(10, visitor.visitNumber(node10));
        assertEquals(5, visitor.visitNumber(node5));

        assertEquals(20, visitor.visitMultiplication(nodeMult1));

        assertEquals(25, visitor.visitAddition(nodeAdd));
    }


    @Test
    public void TreeTestAdditionOnly() throws Exception{

        NodeNumber node5 = new NodeNumber(5);

        NodeAddition nodeAdd = new NodeAddition(node5, node5);

        EvalVisitor visitor = new EvalVisitor();

        assertTrue(Class.forName("tree_v3.NodeNumber").isInstance(node5));

        assertEquals(5, visitor.visitNumber(node5));
        assertEquals(10, visitor.visitAddition(nodeAdd));
    }

    @Test
    public void TreeTestMultiplicationOnly() throws Exception{

        NodeNumber node5 = new NodeNumber(5);

        NodeMultiplication nodeMulti = new NodeMultiplication(node5, node5);

        EvalVisitor visitor = new EvalVisitor();

        assertTrue(Class.forName("tree_v3.NodeNumber").isInstance(node5));

        assertEquals(5, visitor.visitNumber(node5));
        assertEquals(25, visitor.visitMultiplication(nodeMulti));
    }
}
