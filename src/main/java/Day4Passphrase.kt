class Day4Passphrase {
    fun passphraseContainsUniqueWords(passphrase: String): Boolean {
        val words = passphrase.split(" ")
        return words.size == words.toSet().size
    }

    fun numberOfPassphrasesWithUniqueWords(passphrases: List<String>): Long {
        return passphrases.stream().filter { passphraseContainsUniqueWords(it) }.count()
    }
}