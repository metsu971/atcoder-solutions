import kotlin.math.pow

fun main() {
    val (A, B, C) = readLine()!!.split(" ").map { it.toDouble() }

    if (pow(A, C) == pow(B, C)) {
        print("=")
    } else if (pow(A, C) < pow(B, C)) {
        print("<")
    } else {
        print(">")
    }
}

fun pow(value1: Double, value2: Double): Double {
    return value1.pow(value2)
}