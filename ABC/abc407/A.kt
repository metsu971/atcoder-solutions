import kotlin.math.roundToInt

fun main() {
    val (a,b) = readLine()!!.split(" ").map { it.toInt() }

    val result = (a.toDouble() / b).roundToInt()//round()はDoubleにしかないため一度Doubleに変換

    print(result)
}
