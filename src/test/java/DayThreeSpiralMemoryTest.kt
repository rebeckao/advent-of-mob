

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class DayThreeSpiralMemoryTest {

    @ParameterizedTest
    @CsvSource("1, 0", "12, 3", "23, 2", "1024, 31", "361527, 326")
    fun calculateDistanceToCenter(value: Int, result: Int) {
        assertEquals(result, DayThreeSpiralMemory().calculateDistanceToCenter(value))
    }

    @ParameterizedTest
    @CsvSource("3, 1", "7, 1", "13, 2", "9, 1", "24, 2", "25, 2", "26, 3", "10, 2", "1, 0")
    fun findLayer(value: Int, cornerValue: Int) {
        assertEquals(cornerValue, DayThreeSpiralMemory().findLayer(value))
    }

    @ParameterizedTest
    @CsvSource("0, 1", "1, 9", "2, 25", "3, 49")
    fun lastCornerInLayer(value: Int, cornerValue: Int) {
        assertEquals(cornerValue, DayThreeSpiralMemory().lastCornerInLayer(value))
    }

    @ParameterizedTest
    @CsvSource("0, 1", "1, 1", "2, 2", "3, 4", "4, 5", "5, 10", "6, 11", "7, 23", "8, 25", "9, 26", "10, 54", "11, 57", "12, 59", "13, 122", "14, 133", "15, 142", "16, 147", "17, 304", "18, 330")
    fun spiralFibonacci(steps: Int, value: Int) {
        assertEquals(value, DayThreeSpiralMemory().calculateSpiralFibonacciValueAfterSteps(steps))
    }

    @ParameterizedTest
    @CsvSource("9, 10", "700, 747", "122, 133", "361527, 363010")
    fun findFirstSpiralFibonacciValueOver(value: Int, expected: Int) {
        assertEquals(expected, DayThreeSpiralMemory().findFirstSpiralFibonacciValueOver(value))
    }

    @ParameterizedTest
    @CsvSource("0,0, 1,0, 1,-1", "1,0, 1,-1, 0,-1", "1,-1, 0,-1, -1,-1", "0,-1, -1,-1, -1,0", "-1,-1, -1,0, -1,1", "-1,0, -1,1, 0,1", "-1,1, 0,1, 1,1", "0,1, 1,1, 2,1")
    fun getNextPosition(prevX: Int, prevY: Int, curX: Int, curY: Int, nextX: Int, nextY: Int) {
        val previous = Position(x = prevX, y = prevY)
        val current = Position(x = curX, y = curY)
        val next = Position(x = nextX, y = nextY)
        assertEquals(next, DayThreeSpiralMemory().getNextPosition(previous, current))
    }
}