class Day5Jump {

    fun numberOfJumpsToEscape(sequence: IntArray): Int {
        var currentIndex = 0
        var numberOfJumps = 0
        while (currentIndex >= 0 && currentIndex < sequence.size) {
            numberOfJumps++

            val oldJumpValue = sequence[currentIndex]
            sequence[currentIndex]++
            currentIndex += oldJumpValue
        }

        return numberOfJumps

    }

    fun numberOfPartTwoJumpsToEscape(sequence: IntArray): Int {
        var currentIndex = 0
        var numberOfJumps = 0
        while (currentIndex >= 0 && currentIndex < sequence.size) {
            numberOfJumps++

            val oldJumpValue = sequence[currentIndex]
            if (oldJumpValue >= 3) {
                sequence[currentIndex]--
            } else {
                sequence[currentIndex]++
            }
            currentIndex += oldJumpValue
        }

        return numberOfJumps

    }

}