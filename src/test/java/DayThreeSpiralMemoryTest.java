import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DayThreeSpiralMemoryTest {

    @ParameterizedTest
    @CsvSource({"1, 0", "12, 3", "23, 2", "1024, 31", "361527, 326"})
    void calculateDistanceToCenter(int value, int result) {
        assertEquals(result, new DayThreeSpiralMemory().calculateDistanceToCenter(value));
    }

    @ParameterizedTest
    @CsvSource({"3, 1", "7, 1", "13, 2", "9, 1", "24, 2", "25, 2", "26, 3", "10, 2", "1, 0"})
    void findLayer(int value, int cornerValue) {
        assertEquals(cornerValue, new DayThreeSpiralMemory().findLayer(value));
    }

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 9", "2, 25", "3, 49"})
    void lastCornerInLayer(int value, int cornerValue) {
        assertEquals(cornerValue, new DayThreeSpiralMemory().lastCornerInLayer(value));
    }
}