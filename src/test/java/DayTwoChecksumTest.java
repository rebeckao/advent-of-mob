import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoChecksumTest {

    @ParameterizedTest
    @CsvSource({
            "5 1 9 5, 8",
            "7 5 3, 4",
            "2 4 6 8, 6"
    })
    void calculateRowDiffChecksum(String row, int expected) {
        assertEquals(expected, new DayTwoChecksum().calculateRowDiffChecksum(row));
    }

    @ParameterizedTest
    @CsvSource({
            "5 1 9 5#" +
            "7 5 3#" +
            "2 4 6 8, 18"
    })
    void calculateDiffChecksum(String rows, int expected) {
        List<String> input = List.of(rows.split("#"));
        assertEquals(expected, new DayTwoChecksum().calculateDiffChecksum(input));
    }

    @Test
    void diffChecksumTest() throws IOException {
        List<String> rows = Files.lines(Paths.get("./src/test/resources/day2-1.txt")).collect(toList());
        DayTwoChecksum dayTwoChecksum = new DayTwoChecksum();
        assertEquals(51139, dayTwoChecksum.calculateDiffChecksum(rows));
    }

    @ParameterizedTest
    @CsvSource({
            "5 9 2 8, 4",
            "9 4 7 3, 3",
            "3 8 6 5, 2"
    })
    void calculateFactorRowChecksum(String row, int expectedFactor) {
        DayTwoChecksum dayTwoChecksum = new DayTwoChecksum();
        assertEquals(expectedFactor, dayTwoChecksum.calculateFactorRowChecksum(row));
    }

    @ParameterizedTest
    @CsvSource({
            "5 9 2 8#" +
                    "9 4 7 3#" +
                    "3 8 6 5, 9"
    })
    void calculateFactorChecksum(String rows, int expected) {
        List<String> input = List.of(rows.split("#"));
        assertEquals(expected, new DayTwoChecksum().calculateFactorCheckSum(input));
    }

    @Test
    void factorChecksumTest() throws IOException {
        List<String> rows = Files.lines(Paths.get("./src/test/resources/day2-2.txt")).collect(toList());
        DayTwoChecksum dayTwoChecksum = new DayTwoChecksum();
        assertEquals(272, dayTwoChecksum.calculateFactorCheckSum(rows));
    }

}

