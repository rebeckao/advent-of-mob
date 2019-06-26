import java.util.HashMap;
import java.util.Map;

public class DayThreeSpiralMemory {
    int lastCornerInLayer(int layer) {
        return (int) Math.pow(layer * 2 + 1, 2);
    }

    public int calculateDistanceToCenter(int value) {
        int layer = findLayer(value);
        int lastCornerInPreviousLayer = lastCornerInLayer(layer - 1);
        int lastCornerInLayer = lastCornerInLayer(layer);
        int distanceInLayer = value - lastCornerInPreviousLayer;
        int layerLength = lastCornerInLayer - lastCornerInPreviousLayer;
        int distanceFromPreviousCorner = layerLength == 0 ? 0 : distanceInLayer % (layerLength / 4);
        int offsetFromMiddle = Math.abs(distanceFromPreviousCorner - layer);
        return offsetFromMiddle + layer;
    }

    public int findLayer(int value) {
        int layer = 0;
        while (Math.pow(1 + 2 * layer, 2) < value) {
            layer++;
        }
        return layer;
    }


    Position getNextPosition(Position previous, Position current) {
        if (current.x > 0 && current.y == -current.x) {
            return Position.builder().x(current.x - 1).y(current.y).build();
        }
        if (current.x < 0 && current.y == current.x) {
            return Position.builder().x(current.x).y(current.y + 1).build();
        }
        if (current.x < 0 && current.y == -current.x) {
            return Position.builder().x(current.x + 1).y(current.y).build();
        }
        if (current.x > 0 && current.y == current.x - 1) {
            return Position.builder().x(current.x).y(current.y - 1).build();
        }

        return Position.builder()
                .x(current.x + (current.x - previous.x))
                .y(current.y + (current.y - previous.y))
                .build();
    }

    int calculateSpiralFibonacciValueAfterSteps(int steps) {
        Position prev = Position.builder().x(1).y(0).build();
        Position current = Position.builder().x(1).y(-1).build();
        Map<Position, Integer> map = new HashMap<>();
        map.put(Position.builder().x(0).y(0).build(), 1);
        map.put(Position.builder().x(1).y(0).build(), 1);

        int sumOfAll = 1;
        for (int i = 2; i <= steps; i++) {
            sumOfAll = 0;
            for (int x = current.x - 1; x <= current.x + 1; x++) {
                for (int y = current.y - 1; y <= current.y + 1; y++) {
                    sumOfAll += map.getOrDefault(Position.builder().x(x).y(y).build(), 0);
                }
            }
            map.put(current, sumOfAll);
            Position next = getNextPosition(prev, current);
            prev = current;
            current = next;

        }
        return sumOfAll;
    }

    /*private void sumOfAdjacent(Position current, Map<Position, Integer> map) {
        IntStream.range(current.x - 1, current.x + 2)
                .mapToObj(x -> IntStream.range(current.y - 1, current.y + 2)
                        .mapToObj(y -> Position.builder().x(x).y(y).build()))
                .flatMap(Function.identity())
                .mapToInt(p -> map.getOrDefault(p, 0))
                .sum();
    }*/
}
