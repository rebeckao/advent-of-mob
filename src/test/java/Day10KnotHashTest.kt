import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day10KnotHashTest {

    @ParameterizedTest
    @CsvSource(value = ["3, 4, 1, 5; 12"], delimiter = ';')
    fun calculateKnotHash(rawLengths : String, expected : Int) {
        val twistLengths = rawLengths.split(", ").map{it.toInt()}.toIntArray()
        val calculatedKnotHash = Day10KnotHash().calculateKnotHash(twistLengths, 5)
        assertEquals(12, calculatedKnotHash)
    }
}