import java.lang.IllegalStateException

class Day08UnusualInstructions {
    val register: MutableMap<String, Int> = hashMapOf()
    fun largestRegisterValue(instructions: List<String>) : Int {
        instructions.forEach{
            executeInstruction(it)
        }
        return register.values.max()!!
    }

    private fun executeInstruction(instruction: String) {
        val instructionParts = instruction.split(" ")
        val registerToCheck = instructionParts[4]
        register.putIfAbsent(registerToCheck, 0)
        val valueToCheck = register[registerToCheck]!!
        val predicate = instructionParts[5]
        val valueToCheckAgainst = instructionParts[6].toInt()
        val predicateResult = when(predicate) {
            "<" -> valueToCheck < valueToCheckAgainst
            ">"  ->   valueToCheck > valueToCheckAgainst
            "<=" -> valueToCheck <= valueToCheckAgainst
            ">=" -> valueToCheck >= valueToCheckAgainst
            "!=" -> valueToCheck != valueToCheckAgainst
            "==" -> valueToCheck == valueToCheckAgainst
            else -> throw IllegalStateException()
        }
        if (predicateResult) {
            var initialValue = register.getOrDefault(instructionParts[0], 0)
            if (instructionParts[1].equals("inc")) {
                initialValue += instructionParts[2].toInt()
            } else {
                initialValue -= instructionParts[2].toInt()
            }

            register.put(instructionParts[0], initialValue);
        }
    }
}