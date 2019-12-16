import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.toList

internal class Day07CircuitTowersTest {

    @Test
    fun nameOfBottomTower() {
        val towers = listOf("pbga (66)",
                "xhth (57)",
                "ebii (61)",
                "havc (66)",
                "ktlj (57)",
                "fwft (72) -> ktlj, cntj, xhth",
                "qoyq (66)",
                "padx (45) -> pbga, havc, qoyq",
                "tknk (41) -> ugml, padx, fwft",
                "jptl (61)",
                "ugml (68) -> gyxo, ebii, jptl",
                "gyxo (61)",
                "cntj (57)")
        assertEquals("tknk", Day07CircuitTowers().nameOfBottomTower(towers))
    }

    @Test
    fun nameOfBottomTowerForReal() {
        val towers = Files.lines(Paths.get("./src/test/resources/day7.txt")).toList()
        assertEquals("tknk", Day07CircuitTowers().nameOfBottomTower(towers))
    }
}