import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day10KnotHashTest {

    @ParameterizedTest
    @CsvSource(value = [
        "3; 5; 2",
        "3, 4; 5; 12",
        "3, 4, 1; 5; 12",
        "3, 4, 1, 5; 5; 12",
        "1, 4; 5; 0",
        "1, 2, 2; 5; 8",
        "1, 3; 3; 0",
        "3; 3; 2",
        "3; 3; 2",
        "3, 3; 3; 0",
        "3, 2; 5; 2",
        "3, 2, 3; 3; 0"
    ], delimiter = ';')
    fun calculateKnotHash(rawLengths : String, elementListLength : Int, expected : Int) {
        val twistLengths = rawLengths.split(", ").map{it.toInt()}.toIntArray()
        val calculatedKnotHash = Day10KnotHash().calculateKnotHash(twistLengths, elementListLength)
        assertEquals(expected, calculatedKnotHash)
    }
}