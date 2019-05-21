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
    @CsvSource({"1, 1", "2, 1", "3, 2", "4, 4", "5, 5", "6, 10", "7, 11", "8, 23", "9, 25",
            "10, 26", "11, 54", "12, 57", "13, 59", "14, 122", "15, 133", "16, 142", "17, 147", "18, 304", "19, 330"})
    void spiralFibonacci(int pos, int value) {
        assertEquals(value, new DayThreeSpiralMemory().calculateSpiralFibonacci(pos));
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