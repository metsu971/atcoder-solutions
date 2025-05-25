import kotlin.math.abs

fun main() {
    val (x,y) = readLine()!!.split(" ").map { it.toInt() }

    var count = 0
    for(a in 1..6) {
        for(b in 1..6) {
            val sum = a + b
            val diff =  abs(a-b)
            if (sum >= x || diff >= y) {
                count++
            }
        }
    }

    val probability = count.toDouble() / 36.0
    print(probability)

}