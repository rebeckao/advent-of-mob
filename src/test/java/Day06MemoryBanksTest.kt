import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

internal class Day06MemoryBanksTest {

    @Test
    fun iterationsBeforeRepeat() {
        val sequence = intArrayOf(0, 2, 7, 0)
        Assertions.assertEquals(5, Day06MemoryBanks().iterationsBeforeRepeat(sequence).first)
    }

    @Test
    fun iterationsBeforeRepeatForFile() {
        val sequence: IntArray = readIntArray("./src/test/resources/day6.txt")
        Assertions.assertEquals(6681, Day06MemoryBanks().iterationsBeforeRepeat(sequence).first)
    }

    @Test
    fun loopSize() {
        val sequence = intArrayOf(0, 2, 7, 0)
        Assertions.assertEquals(4, Day06MemoryBanks().iterationsBeforeRepeat(sequence).second)
    }

    @Test
    fun loopSizeForFile() {
        val sequence = readIntArray("./src/test/resources/day6.txt")
        Assertions.assertEquals(2392, Day06MemoryBanks().iterationsBeforeRepeat(sequence).second)
    }

    private fun readIntArray(path: String): IntArray {
        return Files.lines(Paths.get(path))
                .findFirst()
                .get()
                .split("\t").stream()
                .mapToInt { it.toInt() }
                .toArray()
    }

}