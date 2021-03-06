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
    fun passphraseContainsUniqueWords(passphrase: String, expected: Boolean) {
        assertEquals(expected, Day4Passphrase().passphraseContainsUniqueWords(passphrase))
    }

    @Test
    fun numberOfPassphrasesWithUniqueWords() {
        val rows = Files.lines(Paths.get("./src/test/resources/day4-1.txt")).toList()
        assertEquals(455L, Day4Passphrase().numberOfPassphrasesWithUniqueWords(rows))
    }

    @ParameterizedTest
    @CsvSource("abcde fghij, true",
            "abcde xyz ecdab, false",
            "a ab abc abd abf abj, true",
            "iiii oiii ooii oooi oooo, true",
            "oiii ioii iioi iiio, false")
    fun passphraseContainsNoDuplicateAnagrams(passphrase: String, expected: Boolean) {
        assertEquals(expected, Day4Passphrase().passphraseContainsNoDuplicateAnagrams(passphrase))
    }

    @Test
    fun numberOfPassphrasesWithNoDuplicateAnagrams() {
        val rows = Files.lines(Paths.get("./src/test/resources/day4-1.txt")).toList()
        assertEquals(186L, Day4Passphrase().numberOfPassphrasesContainsNoAnagrams(rows))
    }

}