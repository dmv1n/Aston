import org.testng.annotations.Test;
import com.example.TriangleArea;
import static org.testng.Assert.*;

public class TriangleAreaTest {
    @Test
    public void areaOfValidTriangle() {
        assertEquals(6.0, TriangleArea.area(3, 4, 5), 0.0001);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void invalidTriangleThrowsException() {
        TriangleArea.area(1, 1, 3);
    }
}