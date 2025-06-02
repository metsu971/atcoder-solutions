fun main() {
    val (N,S) = readLine()!!.split(" ").map { it.toInt() }
    val T = readLine()!!.split(" ").map { it.toInt() }

    var preT = 0

    for (i in 0 until N) {
        if (T[i] - preT > S + 0.5) {
            print("No")
            return
        }
        preT = T[i]
    }

    print("Yes")
}