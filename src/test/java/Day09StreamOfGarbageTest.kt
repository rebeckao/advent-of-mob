import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.nio.file.Files
import java.nio.file.Paths

internal class Day09StreamOfGarbageTest {

    @ParameterizedTest
    @CsvSource(value = [
        "{}; 1",
        "{{{}}}; 6",
        "{{},{}}; 5",
        "{{{},{},{{}}}}; 16",
        "{<a>,<a>,<a>,<a>}; 1",
        "{{<ab>},{<ab>},{<ab>},{<ab>}}; 9",
        "{{<!!>},{<!!>},{<!!>},{<!!>}}; 9",
        "{{<a!>},{<a!>},{<a!>},{<ab>}}; 3"
    ],
            delimiter = ';'
    )
    fun sumOfGroupScores(stream: String, expected: Int) {
        assertEquals(expected, Day09StreamOfGarbage(0, stream).sumOfGroupScores())
    }

    @Test
    fun sumOfGroupsScoresReal() {
        val chars = Files.lines(Paths.get("./src/test/resources/day9.txt")).findFirst().orElse("0")
        assertEquals(20530, Day09StreamOfGarbage(0, chars).sumOfGroupScores())
    }

}