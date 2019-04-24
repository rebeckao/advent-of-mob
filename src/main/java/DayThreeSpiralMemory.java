public class DayThreeSpiralMemory {
    public int calculateDistanceToCenter(int value) {
        int layer = findLayer(value);
        int rowLength =
        int previousCorner = Math.pow(layer *2, 2);
        return 0;
    }

    public int findLayer(int value) {
        int layer = 0;
        while (Math.pow(1 + 2 * layer, 2) < value) {
            layer++;
        }
        return layer;
    }
}
