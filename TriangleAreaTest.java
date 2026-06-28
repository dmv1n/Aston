import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.TriangleArea;

public class TriangleAreaTest {
    @Test
    void areaOfValidTriangle() {
        assertEquals(6.0, TriangleArea.area(3, 4, 5), 0.0001);
    }
    @Test
    void invalidTriangleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> TriangleArea.area(1, 1, 3));
    }
}