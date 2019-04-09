import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DayOneCaptchaTest {

    @ParameterizedTest
    @CsvSource({
            "1122, 3",
            "1111, 4",
            "1234, 0",
            "91212129, 9"
    })
    void captchaSumTest(String input, int expected) {
        DayOneCaptcha dayOneCaptcha = new DayOneCaptcha();
        assertEquals(expected, dayOneCaptcha.captchaSum(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources="/day1.txt")
    void captchaFileTest(String input) {
        DayOneCaptcha dayOneCaptcha = new DayOneCaptcha();
        assertEquals(1089, dayOneCaptcha.captchaSum(input));
    }

    @ParameterizedTest
    @CsvSource({
            "1212, 6",
            "1221, 0",
            "123425, 4",
            "123123, 12",
            "12131415, 4"
    })
    void captchaHalfwaySumTest(String input, int expected) {
        DayOneCaptcha dayOneCaptcha = new DayOneCaptcha();
        assertEquals(expected, dayOneCaptcha.captchaHalfwaySum(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources="/day1-2.txt")
    void captchaFileHalfWayTest(String input) {
        DayOneCaptcha dayOneCaptcha = new DayOneCaptcha();
        assertEquals(1156, dayOneCaptcha.captchaHalfwaySum(input));
    }


}