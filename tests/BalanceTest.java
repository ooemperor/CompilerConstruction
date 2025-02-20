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
    public void balanceFalse1(){
        assertFalse(this.balancer.checkBalance("static public void main(String args[]) {"));
    }

}
