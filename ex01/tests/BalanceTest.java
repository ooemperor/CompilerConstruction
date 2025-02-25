/**
 * Test cases for the Balance class
 * @author Michael Kaiser
 * @version 1.0
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BalanceTest {
    BalanceChecker balancer = new BalanceChecker();

    @BeforeEach
    public void prepare(){
        this.balancer = new BalanceChecker();
    }

    @Test
    public void balanceTrue1(){
        assertTrue(this.balancer.checkBalance("(hello) (world)"));
    }

    @Test
    public void balanceTrue2(){
        assertTrue(this.balancer.checkBalance("(hello) {world}"));
    }

    @Test
    public void balanceTrue3(){
        assertTrue(this.balancer.checkBalance("(hello) { world *[]}"));
    }

    @Test
    public void balanceFalse1(){
        assertFalse(this.balancer.checkBalance("static public void main(String args[]) {"));
    }

    @Test
    public void balanceFalse2(){
        assertFalse(this.balancer.checkBalance("(Hello()"));
    }

    @Test
    public void balanceFalse3(){
        assertFalse(this.balancer.checkBalance("(Hello{)"));
    }

}
