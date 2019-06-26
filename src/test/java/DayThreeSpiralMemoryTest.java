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

    @ParameterizedTest
    @CsvSource({"0, 1", "1, 1", "2, 2", "3, 4", "4, 5", "5, 10", "6, 11", "7, 23", "8, 25",
            "9, 26", "10, 54", "11, 57", "12, 59", "13, 122", "14, 133", "15, 142", "16, 147", "17, 304", "18, 330"})
    void spiralFibonacci(int steps, int value) {
        assertEquals(value, new DayThreeSpiralMemory().calculateSpiralFibonacciValueAfterSteps(steps));
    }

    @ParameterizedTest
    @CsvSource({"9, 10", "700, 747", "122, 133", "361527, 363010"})
    void findFirstSpiralFibonacciValueOver(int value, int expected) {
        assertEquals(expected, new DayThreeSpiralMemory().findFirstSpiralFibonacciValueOver(value));
    }

    @ParameterizedTest
    @CsvSource({"0,0, 1,0, 1,-1", "1,0, 1,-1, 0,-1", "1,-1, 0,-1, -1,-1", "0,-1, -1,-1, -1,0", "-1,-1, -1,0, -1,1",
            "-1,0, -1,1, 0,1", "-1,1, 0,1, 1,1", "0,1, 1,1, 2,1"})
    void getNextPosition(int prevX, int prevY, int curX, int curY, int nextX, int nextY) {
        Position previous = Position.builder().x(prevX).y(prevY).build();
        Position current = Position.builder().x(curX).y(curY).build();
        Position next = Position.builder().x(nextX).y(nextY).build();
        assertEquals(next, new DayThreeSpiralMemory().getNextPosition(previous, current));
    }
}