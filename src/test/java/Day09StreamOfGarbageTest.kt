import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day09StreamOfGarbageTest {

    @ParameterizedTest
    @CsvSource(value = ["{}; 1"
//                    "{{{}}}; 6",
//                    "{{},{}}; 5",
//                    "{{{},{},{{}}}}; 16",
//                    "{<a>,<a>,<a>,<a>}; 1",
//                    "{{<ab>},{<ab>},{<ab>},{<ab>}}; 9",
//                    "{{<!!>},{<!!>},{<!!>},{<!!>}}; 9",
//                    "{{<a!>},{<a!>},{<a!>},{<ab>}}; 3"
    ],
            delimiter = ';'
    )
    fun sumOfGroupScores(stream : String, expected : Int) {
        assertEquals(expected, Day09StreamOfGarbage(0, stream).sumOfGroupScores())
    }
}