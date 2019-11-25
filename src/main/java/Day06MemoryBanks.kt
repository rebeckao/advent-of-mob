class Day06MemoryBanks {
    fun iterationsBeforeRepeat (startSequence: IntArray): Pair<Int, Int> {
        val oldIterations: HashMap<String, Int> = HashMap()
        var iterationsCounter = 0
        val sequence = startSequence.clone()
        while ( !oldIterations.contains(sequence.stringify())) {
            oldIterations[sequence.stringify()] = iterationsCounter
            val indexOfBankWithMostBlocks = resolveIndexOfBankWithMostBlocks(sequence)
            var numberOfBlocksToDistribute = sequence[indexOfBankWithMostBlocks]
            sequence[indexOfBankWithMostBlocks] = 0
            var indexOfBankToIncrease = (indexOfBankWithMostBlocks + 1) % sequence.size
            while (numberOfBlocksToDistribute > 0) {
                numberOfBlocksToDistribute--
                sequence[indexOfBankToIncrease]++
                indexOfBankToIncrease = (indexOfBankToIncrease + 1) % sequence.size
            }
            iterationsCounter++
        }


        val oldIterationCount = oldIterations[sequence.stringify()]
        return Pair(iterationsCounter, iterationsCounter - oldIterationCount!!)
    }

    private fun resolveIndexOfBankWithMostBlocks(sequence: IntArray): Int {
        var indexOfBankWithMostBlocks = 0
        var maxNumberOfBlocks = 0

        for (i in 0 until sequence.size) {
            if (sequence[i] > maxNumberOfBlocks) {
                indexOfBankWithMostBlocks = i
                maxNumberOfBlocks = sequence[i]
            }
        }
        return indexOfBankWithMostBlocks
    }

    private fun IntArray.stringify(): String {
        return this.joinToString(" ")
    }
}
