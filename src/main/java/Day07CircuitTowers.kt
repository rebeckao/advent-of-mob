import java.util.*

class Day07CircuitTowers {
    fun nameOfBottomTower(towers: List<String>): String {
        val towerTowers = towers.map { parseTower(it) }
        val nonRootTowersNames: List<String> = towerTowers.flatMap { it.children }
        return towerTowers.map { it.name }.find { !nonRootTowersNames.contains(it) }!!
    }

    private fun parseTower(towerString: String): Tower {
        val towerInfo: List<String> = towerString.split(" ")
        val name: String = towerInfo[0]
        val weight: Int = towerInfo[1].substring(1, towerInfo[1].length - 1).toInt()

        if (towerInfo.size == 2) {
            return Tower(name, weight, Collections.emptyList())
        }

        val children: List<String> = towerInfo.subList(3, towerInfo.size).map { it.replace(oldValue = ",", newValue = "") }
        return Tower(name, weight, children)
    }

    data class Tower(val name: String, val weight: Int, val children: List<String>)
}