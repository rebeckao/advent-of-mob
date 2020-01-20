import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

internal class Day08UnusualInstructionsTest {
    @Test
    fun largestRegisterValue() {
        val instructions: List<String> = listOf(
                "b inc 5 if a > 1",
                "a inc 1 if b < 5",
                "c dec -10 if a >= 1",
                "c inc -20 if c == 10"
        )
        Assertions.assertEquals(1, Day08UnusualInstructions().largestRegisterValue(instructions))
    }

    @Test
    fun largestRegisterValueSampleData() {
        val instructions: List<String> = Files.lines(Paths.get("./src/test/resources/day8.txt")).toList()
        Assertions.assertEquals(1, Day08UnusualInstructions().largestRegisterValue(instructions))
    }
}