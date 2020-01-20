class Day08UnusualInstructions {
    val register: MutableMap<String, Int> = hashMapOf()
    fun largestRegisterValue(instructions: List<String>) : Int {
        instructions.forEach{
            executeInstruction(it)
        }
    }

    private fun executeInstruction(instruction: String) {
        val instructionParts = instruction.split(" ")
        val registerToCheck = instructionParts[4]
        register.putIfAbsent(registerToCheck, 0)
        val valueToCheck = register[registerToCheck]!!
        val predicate = instructionParts[5]
        val valueToCheckAgainst = instructionParts[6].toInt()
        val blaha = when(predicate) {
            "<" -> valueToCheck < valueToCheckAgainst
            ">"  ->   valueToCheck > valueToCheckAgainst
        }
        if (blaha) {
            val initialValue = register.getOrDefault(instructionParts[0], 0)
            if (instructionParts[1].equals("inc")) {

            }
            register.put(, )
        }
    }
}