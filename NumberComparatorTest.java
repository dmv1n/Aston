import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.NumberComparator;

public class NumberComparatorTest {
    @Test
    void compare() {
        assertEquals(0, NumberComparator.compare(5, 5));
        assertEquals(-1, NumberComparator.compare(3, 5));
        assertEquals(1, NumberComparator.compare(5, 3));
    }
}