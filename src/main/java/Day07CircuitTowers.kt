import java.util.*

class Day07CircuitTowers {
    fun nameOfBottomTower(towers: List<String>): String {
        val towerTowers = towers.map { parseTower(it) }
        return nameOfRootTower(towerTowers)
    }

    private fun nameOfRootTower(towerTowers: List<Tower>): String {
        val nonRootTowersNames: List<String> = towerTowers.flatMap { it.children }
        return towerTowers.map { it.name }.find { !nonRootTowersNames.contains(it) }!!
    }

    fun correctedWeightOfBalancedTowers(towers: List<String>): Int {
        val towerTowers = towers.map { parseTower(it) }
        val nameOfRootTower = nameOfRootTower(towerTowers)
        val rootTower = towerTowers.find { it.name == nameOfRootTower }!!
        try {
            rootTower.getWeight(towerTowers)
            throw IllegalStateException("Should never get here")
        } catch (ex: WrongWeightedChildException) {
            return ex.desiredWeight
        }
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

    data class Tower(val name: String, val weight: Int, val children: List<String>) {
        fun getWeight(towers: List<Tower>): Int {
            if (children.isEmpty()) {
                return weight
            }

            val childTowers = children.map { child -> towers.find { it.name == child }!! }
            val childWeights = childTowers.map { it.getWeight(towers) }
            val groupByWeight = childTowers.groupBy { it.getWeight(towers) }
            val wrongWeightedChild = groupByWeight.values.find { it.size == 1 }
            if (wrongWeightedChild != null) {
                val correctTotalWeight = groupByWeight.entries.find { it.value.size > 1 } !!.key
                val diff = wrongWeightedChild[0].getWeight(towers) - correctTotalWeight
                throw WrongWeightedChildException(wrongWeightedChild[0].weight - diff)
            }

            return weight + childWeights.sum()
        }
    }

    class WrongWeightedChildException(val desiredWeight: Int, message: String = "Wrong child") : RuntimeException(message)
}