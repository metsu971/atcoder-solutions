fun main() {
    val (A, B, C) = readLine()!!.split(" ").map { it.toLong() }

    val result = if (C % 2 == 0L) {
        // 絶対値での比較
        when {
            kotlin.math.abs(A) < kotlin.math.abs(B) -> "<"
            kotlin.math.abs(A) > kotlin.math.abs(B) -> ">"
            else -> "="
        }
    } else {
        when {
            A < B -> "<"
            A > B -> ">"
            else -> "="
        }
    }

    print(result)
}