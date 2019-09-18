import kotlin.streams.toList

class DayTwoChecksum {

    internal fun calculateDiffChecksum(rows: List<String>): Int {
        return rows.stream().mapToInt { this.calculateRowDiffChecksum(it) }.sum()
    }

    internal fun calculateRowDiffChecksum(row: String): Int {
        val numbers = row.split(Regex("\\W"))
        val max = numbers.stream().mapToInt { Integer.parseInt(it) }.max().orElse(0)
        val min = numbers.stream().mapToInt { Integer.parseInt(it) }.min().orElse(0)
        return max - min
    }

    fun calculateFactorRowChecksum(row: String): Int {
        val integers = row.split(Regex("\\W")).stream()
                .mapToInt { Integer.parseInt(it) }
                .boxed()
                .toList()

        for (i in 0 until integers.size - 1) {
            for (j in i + 1 until integers.size) {
                val numberone = integers[i]
                val numbertwo = integers[j]
                if (numberone % numbertwo == 0) {
                    return numberone / numbertwo
                }
                if (numbertwo % numberone == 0) {
                    return numbertwo / numberone
                }
            }
        }
        return 0
    }

    fun calculateFactorCheckSum(rows: List<String>): Int {
        return rows.stream().mapToInt { this.calculateFactorRowChecksum(it) }.sum()
    }
}
