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
        int distanceFromPreviousCorner = layerLength == 0? 0 : distanceInLayer % (layerLength/4);
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
}
