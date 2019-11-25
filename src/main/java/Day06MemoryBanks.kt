class Day06MemoryBanks {
    fun iterationsBeforeRepeat (startSequence: IntArray): Int {
        val oldIterations: HashSet<String> = HashSet()
        var iterationsCounter = 0
        val sequence = startSequence.clone()
        while ( !oldIterations.contains(sequence.joinToString( " " ))) {
            oldIterations.add(sequence.joinToString(" "))
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

        return iterationsCounter
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
}
