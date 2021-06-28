import java.io.File

class Player(_name: String,
             var healthPoints: Int = 100,
             val isBlessed: Boolean,
             private val isImmortal: Boolean) {

    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    val hometown by lazy {selectHometown()}
    private fun selectHometown() = File("data/data.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()


init{
        require(healthPoints >0 ,{"健康值必須大於0"})
        require(name.isNotBlank(),{"玩家必須有名字"})
    }
    constructor(name:String) : this(name,
            isBlessed = true,
            isImmortal = false) {
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

        fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "綠色" else "沒有"
        return auraColor
    }
    fun formatHealthStatus()=
        when (healthPoints) {
            100 -> "健康狀態極佳"
            in 90..99 -> "有一些小擦傷"
            in 75..89 -> if (isBlessed) {
                "雖有一些傷口，但恢復很快"
            } else {
                "有一些傷口"
            }
            in 15..74 -> "嚴重受傷"
            //顯示玩家狀態
            else -> "情況不妙"
        }


    fun castFireball(numFireballs: Int = 2)=
        println("一個FireBall出現了. (x$numFireballs)")
}