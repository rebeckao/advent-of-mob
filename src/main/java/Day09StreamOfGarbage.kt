class Day09StreamOfGarbage(var index: Int, val characterStream: String) {

    fun sumOfGroupScores(): Int {
        val rootGroup = parseCharacterStream()
        return rootGroup.sumOfScores(0)
    }

    fun parseCharacterStream(): CharacterGroup {
        val subGroups: MutableList<CharacterGroup> = arrayListOf()
        val rootGroup = CharacterGroup(subGroups)

        index++

        parseGroup(subGroups)

        return rootGroup
    }

    private fun parseGroup(siblingGroups: MutableList<CharacterGroup>) {
        var nextCharacter = characterStream[index]
        while (nextCharacter != '}') {
            if (nextCharacter == '!') {
                index += 2
                nextCharacter = characterStream[index]
            } else if (nextCharacter == '<') {
                index++
                parseGarbage()
                nextCharacter = characterStream[index]
            } else if (nextCharacter == '{') {
                index++
                val subGroups: MutableList<CharacterGroup> = arrayListOf()
                val childGroup = CharacterGroup(subGroups)
                siblingGroups.add(childGroup)
                parseGroup(subGroups)
            } else {
                index++
            }
        }
    }

    private fun parseGarbage() {
        while (characterStream[index] != '>') {
            if (characterStream[index] == '!') {
                index += 2
            } else {
                index++
            }
        }
        index++
    }
}

class CharacterGroup(val subGroups: List<CharacterGroup>) {

    fun sumOfScores(parentScore: Int): Int {
        val ourScore = 1 + parentScore
        if (subGroups.isEmpty()) {
            return ourScore
        }
        return subGroups.stream()
                .mapToInt{it.sumOfScores(ourScore)}
                .sum() + ourScore
    }
}
