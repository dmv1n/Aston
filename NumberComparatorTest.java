import org.testng.annotations.Test;
import com.example.NumberComparator;
import static org.testng.Assert.*;

public class NumberComparatorTest {
    @Test
    public void compare() {
        assertEquals(0, NumberComparator.compare(5, 5));
        assertEquals(-1, NumberComparator.compare(3, 5));
        assertEquals(1, NumberComparator.compare(5, 3));
    }
}