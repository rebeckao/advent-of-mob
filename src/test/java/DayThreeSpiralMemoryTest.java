import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DayThreeSpiralMemoryTest {

    @ParameterizedTest
    @CsvSource({"1, 0", "12, 3", "23, 2", "1024, 31"})
    void superMegaDance(int value, int result) {

        DayThreeSpiralMemory dayThreeSpiralMemory = new DayThreeSpiralMemory();
        assertEquals(result, dayThreeSpiralMemory.calculateDistanceToCenter(value));
    }

    @ParameterizedTest
    @CsvSource({"3, 1", "7, 1", "13, 2", "9, 1", "24, 2", "25, 2", "26,3"})
    void findLayer(int value, int cornerValue) {
        DayThreeSpiralMemory dayThreeSpiralMemory = new DayThreeSpiralMemory();
        assertEquals(cornerValue, dayThreeSpiralMemory.findLayer(value));
    }
}