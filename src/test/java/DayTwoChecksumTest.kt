

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

internal class DayTwoChecksumTest {

    @ParameterizedTest
    @CsvSource("5 1 9 5, 8", "7 5 3, 4", "2 4 6 8, 6")
    fun calculateRowDiffChecksum(row: String, expected: Int) {
        assertEquals(expected, DayTwoChecksum().calculateRowDiffChecksum(row))
    }

    @ParameterizedTest
    @CsvSource("5 1 9 5#" +
            "7 5 3#" +
            "2 4 6 8, 18")
    fun calculateDiffChecksum(rows: String, expected: Int) {
        val input = rows.split("#")
        assertEquals(expected, DayTwoChecksum().calculateDiffChecksum(input))
    }

    @Test
    @Throws(IOException::class)
    fun diffChecksumTest() {
        val rows = Files.lines(Paths.get("./src/test/resources/day2-1.txt")).toList()
        val dayTwoChecksum = DayTwoChecksum()
        assertEquals(51139, dayTwoChecksum.calculateDiffChecksum(rows))
    }

    @ParameterizedTest
    @CsvSource("5 9 2 8, 4", "9 4 7 3, 3", "3 8 6 5, 2")
    fun calculateFactorRowChecksum(row: String, expectedFactor: Int) {
        val dayTwoChecksum = DayTwoChecksum()
        assertEquals(expectedFactor, dayTwoChecksum.calculateFactorRowChecksum(row))
    }

    @ParameterizedTest
    @CsvSource("5 9 2 8#" +
            "9 4 7 3#" +
            "3 8 6 5, 9")
    fun calculateFactorChecksum(rows: String, expected: Int) {
        val input = rows.split("#")
        assertEquals(expected, DayTwoChecksum().calculateFactorCheckSum(input))
    }

    @Test
    @Throws(IOException::class)
    fun factorChecksumTest() {
        val rows = Files.lines(Paths.get("./src/test/resources/day2-2.txt")).toList()
        val dayTwoChecksum = DayTwoChecksum()
        assertEquals(272, dayTwoChecksum.calculateFactorCheckSum(rows))
    }

}

