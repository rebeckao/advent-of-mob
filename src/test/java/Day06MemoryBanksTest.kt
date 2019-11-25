import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

internal class Day06MemoryBanksTest {

    @Test
    fun iterationsBeforeRepeat() {
        val sequence = intArrayOf(0, 2, 7, 0)
        Assertions.assertEquals(5, Day06MemoryBanks().iterationsBeforeRepeat(sequence))
    }

    @Test
    fun iterationsBeforeRepeatForFile() {
        val sequence: IntArray = Files.lines(Paths.get("./src/test/resources/day6.txt"))
                .findFirst()
                .get()
                .split("\t").stream()
                .mapToInt { it.toInt() }
                .toArray()
        Assertions.assertEquals(6681, Day06MemoryBanks().iterationsBeforeRepeat(sequence))
    }

}