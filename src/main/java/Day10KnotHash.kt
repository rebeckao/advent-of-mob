class Day10KnotHash {
    fun calculateKnotHash(twistLengths: IntArray, elementListLength: Int): Int {
        //val knot = LinkedList((0 until elementListLength).toList())
        var knot = (0 until elementListLength).toList().toMutableList()
        var currentPosition = 0

        for ((skipSize, twistLength) in twistLengths.withIndex()) {
            val endPosition = currentPosition + twistLength
            val tempKnot = mutableListOf<Int>()
            if (endPosition < elementListLength) {
                val sublist = knot.subList(currentPosition, endPosition)
                val before = knot.subList(0, currentPosition)
                val after = knot.subList(endPosition, elementListLength)
                val reversedSublist = sublist.reversed()
                tempKnot.addAll(before)
                tempKnot.addAll(reversedSublist)
                tempKnot.addAll(after)
            } else {
                val left = endPosition % elementListLength
                val firstPartOfSublistSize = elementListLength - currentPosition
                val sublist = knot.subList(currentPosition, elementListLength)
                val restOfSublist = knot.subList(0, left)
                val notPartOfSublist = knot.subList(left, currentPosition)
                sublist.addAll(restOfSublist)
                val reversedSublist = sublist.reversed()
                tempKnot.addAll(reversedSublist.subList(firstPartOfSublistSize, reversedSublist.size))
                tempKnot.addAll(notPartOfSublist)
                tempKnot.addAll(reversedSublist.subList(0, firstPartOfSublistSize))
            }
            knot = tempKnot
            currentPosition = (currentPosition + twistLength + skipSize) % elementListLength
        }


        return knot[0] * knot[1]
    }


}


