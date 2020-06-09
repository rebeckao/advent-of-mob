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
        "{{<a!>},{<a!>},{<a!>},{<ab>}}; 3",
        "{<>}; 1",
        "{<random characters>}; 1",
        "{<<<<>}; 1",
        "{<{!>}>}; 1",
        "{<!!>}; 1",
        "{<!!!>>}; 1",
        "{<{o\"i!a,<{i<a>}; 1"
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

    @ParameterizedTest
    @CsvSource(value = [
        "<>; 0",
        "<random characters>; 17",
        "<<<<>; 3",
        "<{!>}>; 2",
        "<!!>; 0",
        "<!!!>>; 0",
        "<{o\"i!a,<{i<a>; 10"
    ],
            delimiter = ';'
    )
    fun sumOfGarbage(stream: String, expected: Int) {
        val day09StreamOfGarbage = Day09StreamOfGarbage(1, stream)
        day09StreamOfGarbage.parseGarbage()
        assertEquals(expected, day09StreamOfGarbage.garbageCount)
    }

    @Test
    fun sumOfGarbageReal() {
        val chars = Files.lines(Paths.get("./src/test/resources/day9.txt")).findFirst().orElse("0")
        val day09StreamOfGarbage = Day09StreamOfGarbage(0, chars)
        day09StreamOfGarbage.parseCharacterStream()
        assertEquals(9978, day09StreamOfGarbage.garbageCount)
    }
}