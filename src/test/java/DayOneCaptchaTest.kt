

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource

internal class DayOneCaptchaTest {

    @ParameterizedTest
    @CsvSource("1122, 3", "1111, 4", "1234, 0", "91212129, 9")
    fun captchaSumTest(input: String, expected: Int) {
        val dayOneCaptcha = DayOneCaptcha()
        assertEquals(expected, dayOneCaptcha.captchaSum(input))
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/day1.txt"])
    fun captchaFileTest(input: String) {
        val dayOneCaptcha = DayOneCaptcha()
        assertEquals(1089, dayOneCaptcha.captchaSum(input))
    }

    @ParameterizedTest
    @CsvSource("1212, 6", "1221, 0", "123425, 4", "123123, 12", "12131415, 4")
    fun captchaHalfwaySumTest(input: String, expected: Int) {
        val dayOneCaptcha = DayOneCaptcha()
        assertEquals(expected, dayOneCaptcha.captchaHalfwaySum(input))
    }

    @ParameterizedTest
    @CsvFileSource(resources = ["/day1-2.txt"])
    fun captchaFileHalfWayTest(input: String) {
        val dayOneCaptcha = DayOneCaptcha()
        assertEquals(1156, dayOneCaptcha.captchaHalfwaySum(input))
    }


}