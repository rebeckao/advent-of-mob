class DayOneCaptcha {
    fun captchaSum(input: String): Int {
        var workingString = input
        var sum = 0
        workingString += workingString[0]
        for (i in 0 until workingString.length - 1) {
            val next = workingString[i + 1]
            val current = workingString[i]
            if (current == next) {
                sum += Character.getNumericValue(current)
            }
        }
        return sum
    }

    fun captchaHalfwaySum(input: String): Int {
        var sum = 0
        for (i in 0 until input.length / 2) {
            val next = input[i + input.length / 2]
            val current = input[i]
            if (current == next) {
                sum += Character.getNumericValue(current)
            }
        }
        sum *= 2
        return sum
    }
}
