import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

internal class Day4PassphraseTest {

    @ParameterizedTest
    @CsvSource("aa bb cc dd ee, true",
            "aa bb cc dd aa, false",
            "aa bb cc dd aaa, true")
    fun passphraseIsValid(passphrase: String, expected: Boolean) {
        assertEquals(expected, Day4Passphrase().passphraseIsValid(passphrase))
    }

    @Test
    fun numberOfValidPassphrases() {
        val rows = Files.lines(Paths.get("./src/test/resources/day4-1.txt")).toList()
        assertEquals(455L, Day4Passphrase().numberOfValidPassphrases(rows))
    }

}