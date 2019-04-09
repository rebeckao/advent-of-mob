import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
    void captchaSumTest(String input, int expected){
        DayOneCaptcha dayOneCaptcha = new DayOneCaptcha();
        assertEquals(expected,dayOneCaptcha.captchaSum(input));
    }


}