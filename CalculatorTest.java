import org.testng.annotations.Test;
import com.example.Calculator;
import static org.testng.Assert.*;

public class CalculatorTest {
    @Test
    public void add() {
        assertEquals(5, Calculator.add(2, 3));
    }
    @Test
    public void subtract() {
        assertEquals(1, Calculator.subtract(5, 4));
    }
    @Test
    public void multiply() {
        assertEquals(6, Calculator.multiply(2, 3));
    }
    @Test
    public void divide() {
        assertEquals(2.0, Calculator.divide(10, 5));
    }
    @Test(expectedExceptions = ArithmeticException.class)
    public void divideByZeroThrowsException() {
        Calculator.divide(1, 0);
    }
}