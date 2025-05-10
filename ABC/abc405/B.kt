fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    val A = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    val seen = mutableListOf<
    var removeCount = 0

    for (i in 1 .. N) {
        for (j in 1 .. M) {
            if (!A.contains(j)) {
                print(removeCount)
                return
            }
            if (j == M) {
                removeCount++
                A.removeLast()
            }
        }
    }
}