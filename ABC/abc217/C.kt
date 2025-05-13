fun main() {
    val N = readLine()!!.toInt()
    val p = readLine()!!.split(" ").map { it.toInt() }
    val q = IntArray(N)

    for (i in 0 until N) {
        q[p[i] - 1] = i + 1
    }

    print(q.joinToString(" "))
}