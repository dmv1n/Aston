import org.testng.annotations.Test;
import com.example.Factorial;
import static org.testng.Assert.*;

public class FactorialTest {
    @Test
    public void factorialOfZero() {
        assertEquals(1, Factorial.factorial(0));
    }
    @Test
    public void factorialOfPositive() {
        assertEquals(120, Factorial.factorial(5));
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void factorialNegativeThrowsException() {
        Factorial.factorial(-1);
    }
}