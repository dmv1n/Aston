import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Factorial;

public class FactorialTest {
    @Test
    void factorialOfZero() {
        assertEquals(1, Factorial.factorial(0));
    }
    @Test
    void factorialOfPositive() {
        assertEquals(120, Factorial.factorial(5));
    }
}