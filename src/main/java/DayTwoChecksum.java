import java.util.List;
import java.util.stream.Stream;

public class DayTwoChecksum {

    int calculateCheckSum(List<String> rows) {
        return rows.stream().mapToInt(this::calculateRowChecksum).sum();
    }

    int calculateRowChecksum(String row) {
        String[] numbers = row.split("\\W");
        int max = Stream.of(numbers).mapToInt(Integer::parseInt).max().orElse(0);
        int min = Stream.of(numbers).mapToInt(Integer::parseInt).min().orElse(0);
        return max - min;
    }

}
