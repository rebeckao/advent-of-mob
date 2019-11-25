
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths

internal class Day5JumpTest {

    @Test
    fun numberOfJumpsToEscape() {
        val startSequence = intArrayOf(0, 3, 0, 1, -3)
        Assertions.assertEquals(5, Day5Jump().numberOfJumpsToEscape(startSequence))

    }

    @Test
    fun numberOfJumpsToEscapeForFile() {
        val sequence: IntArray = Files.lines(Paths.get("./src/test/resources/day5-1.txt")).mapToInt { it.toInt() }.toArray()
        Assertions.assertEquals(360603, Day5Jump().numberOfJumpsToEscape(sequence))
    }

    @Test
    fun numberOfPartTwoJumpsToEscape() {
        val startSequence = intArrayOf(0, 3, 0, 1, -3)
        Assertions.assertEquals(10, Day5Jump().numberOfPartTwoJumpsToEscape(startSequence))
    }

    @Test
    fun numberOfPartTwoJumpsToEscapeForFile() {
        val sequence: IntArray = Files.lines(Paths.get("./src/test/resources/day5-1.txt")).mapToInt { it.toInt() }.toArray()
        Assertions.assertEquals(25347697, Day5Jump().numberOfPartTwoJumpsToEscape(sequence))
    }


}