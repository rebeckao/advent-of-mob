import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day10KnotHashTest {

    @Test
    fun calculateKnotHash() {
        val twistLengths = intArrayOf(3, 4, 1, 5)
        val calculatedKnotHash = Day10KnotHash().calculateKnotHash(twistLengths, 5)
        assertEquals(12, calculatedKnotHash)
    }
}