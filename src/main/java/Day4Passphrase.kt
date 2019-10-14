class Day4Passphrase {
    fun passphraseContainsUniqueWords(passphrase: String): Boolean {
        val words = passphrase.split(" ")
        return words.size == words.toSet().size
    }

    fun numberOfPassphrasesWithUniqueWords(passphrases: List<String>): Long {
        return passphrases.stream().filter { passphraseContainsUniqueWords(it) }.count()
    }

    fun passphraseContainsNoDuplicateAnagrams(passphrase: String): Boolean {
        val words = passphrase.split(" ")

        val uniqueAnagrams = words.map {
            val array = it.toCharArray()
            array.sort()
            array.joinToString("")
        }.toSet()

        return words.size == uniqueAnagrams.size
    }

    fun numberOfPassphrasesContainsNoAnagrams(passphrases: List<String>): Long {
        return passphrases.stream().filter { passphraseContainsNoDuplicateAnagrams(it) }.count()
    }

}