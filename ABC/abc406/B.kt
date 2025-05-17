import kotlin.math.pow
fun main() {
    val (N, K) = readLine()!!.split(" ").map {it.toInt() }
    val A = readLine()!!.split(" ").map {it.toLong() }

    val limit = 10.0.pow(K).toLong()
    var result = 1L

    for (i in 0 until N) {
        result *= A[i]
        if (result >= limit) {//result >= 10^Kで比較
            result = 1L
        }
    }

    print(result)
}