import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Calculator;

public class CalculatorTest {
    @Test
    void add() {
        assertEquals(5, Calculator.add(2, 3));
    }
    @Test
    void subtract() {
        assertEquals(1, Calculator.subtract(5, 4));
    }
    @Test
    void multiply() {
        assertEquals(6, Calculator.multiply(2, 3));
    }
    @Test
    void divide() {
        assertEquals(2.0, Calculator.divide(10, 5));
    }
    @Test
    void divideByZeroThrowsException() {
        assertThrows(ArithmeticException.class, () -> Calculator.divide(1, 0));
    }
}