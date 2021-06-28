
import java.lang.Math.pow
import java.lang.Math.random

fun main() {

    val player = Player("翁子皓")
    player.castFireball()
    //Aura
    val auraColor =player.auraColor()

    printPlayerStatus(player)

    player.auraColor()
}

private fun printPlayerStatus(player:Player)
{
    println("光環顏色：${player.auraColor()} " + "    走運嗎？${if (player.isBlessed) "是的" else "很背"}")
    println("${player.name} ${player.formatHealthStatus()}")
}



