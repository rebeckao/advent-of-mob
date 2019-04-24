import java.util.List;
import java.util.stream.Collectors;
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

    public int calculateFactorChecksum(String row) {
        String[] numbers = row.split("\\W");
        List<Integer> integers = Stream.of(numbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        for (int i = 0; i < integers.size() - 1; i++) {
            for (int j = i + 1; j < integers.size(); j++) {
                Integer numberone = integers.get(i);
                Integer numbertwo = integers.get(j);
                if (numberone % numbertwo == 0) {
                    return numberone / numbertwo;
                }
                if (numbertwo % numberone == 0) {
                    return numbertwo / numberone;
                }
            }
        }
        return 0;
    }
}
