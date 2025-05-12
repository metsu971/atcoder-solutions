fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    var removeCount = 0

    while (true) {
        val hasAll = (1..M).all { A.contains(it) }

        if (!hasAll) {
            println(removeCount)
            return
        }

        A.removeLast()
        removeCount++
    }
}