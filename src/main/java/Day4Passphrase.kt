class Day4Passphrase {
    fun passphraseIsValid(passphrase: String): Boolean {
        val words = passphrase.split(" ")
        return words.size == words.toSet().size
    }

    fun numberOfValidPassphrases(passphrases: List<String>): Long {
        return passphrases.stream().filter { passphraseIsValid(it) }.count()
    }
}