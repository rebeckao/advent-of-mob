import java.util.*
import kotlin.math.abs
import kotlin.math.pow

class DayThreeSpiralMemory {
    internal fun lastCornerInLayer(layer: Int): Int {
        return (layer * 2 + 1).toDouble().pow(2.0).toInt()
    }

    fun calculateDistanceToCenter(value: Int): Int {
        val layer = findLayer(value)
        val lastCornerInPreviousLayer = lastCornerInLayer(layer - 1)
        val lastCornerInLayer = lastCornerInLayer(layer)
        val distanceInLayer = value - lastCornerInPreviousLayer
        val layerLength = lastCornerInLayer - lastCornerInPreviousLayer
        val distanceFromPreviousCorner = if (layerLength == 0) 0 else distanceInLayer % (layerLength / 4)
        val offsetFromMiddle = abs(distanceFromPreviousCorner - layer)
        return offsetFromMiddle + layer
    }

    fun findLayer(value: Int): Int {
        var layer = 0
        while ((1 + 2 * layer).toDouble().pow(2.0) < value) {
            layer++
        }
        return layer
    }


    internal fun getNextPosition(previous: Position, current: Position): Position {
        if (current.x > 0 && current.y == -current.x) {
            return Position(x = current.x - 1, y = current.y)
        }
        if (current.x < 0 && current.y == current.x) {
            return Position(x = current.x, y = current.y + 1)
        }
        if (current.x < 0 && current.y == -current.x) {
            return Position(x = current.x + 1, y = current.y)
        }
        return if (current.x > 0 && current.y == current.x - 1) {
            Position(x = current.x, y = current.y - 1)
        } else Position(
                x = current.x + (current.x - previous.x),
                y = current.y + (current.y - previous.y)
        )

    }

    internal fun calculateSpiralFibonacciValueAfterSteps(steps: Int): Int {
        var prev = Position(x = 1, y = 0)
        var current = Position(x = 1, y =-1)
        val map = HashMap<Position, Int>()
        map[Position(x = 0, y = 0)] = 1
        map[Position(x = 1, y = 0)] = 1

        var sumOfAll = 1
        for (i in 2..steps) {
            sumOfAll = 0
            for (x in current.x - 1..current.x + 1) {
                for (y in current.y - 1..current.y + 1) {
                    sumOfAll += map.getOrDefault(Position(x = x, y = y), 0)
                }
            }
            map[current] = sumOfAll
            val next = getNextPosition(prev, current)
            prev = current
            current = next

        }
        return sumOfAll
    }

    internal fun findFirstSpiralFibonacciValueOver(value: Int): Int {
        var counter = 0
        var fibonacciValue = 0
        while (fibonacciValue <= value) {
            counter++
            fibonacciValue = calculateSpiralFibonacciValueAfterSteps(counter)
        }
        return fibonacciValue
    }

}
