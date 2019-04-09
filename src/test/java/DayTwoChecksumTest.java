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
    void calculateRowChecksum(String row, int expected) {
        assertEquals(expected, new DayTwoChecksum().calculateRowChecksum(row));
    }

    @ParameterizedTest
    @CsvSource({
            "5 1 9 5#" +
            "7 5 3#" +
            "2 4 6 8, 18"
    })
    void calculateChecksum(String rows, int expected) {
        List<String> input = List.of(rows.split("#"));
        assertEquals(expected, new DayTwoChecksum().calculateCheckSum(input));
    }

    @Test
    void checksumTest() throws IOException {
        List<String> rows = Files.lines(Paths.get("./src/test/resources/day2-1.txt")).collect(toList());
        DayTwoChecksum dayTwoChecksum = new DayTwoChecksum();
        assertEquals(51139, dayTwoChecksum.calculateCheckSum(rows));
    }
}