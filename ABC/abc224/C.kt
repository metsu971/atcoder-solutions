fun main() {
    val used = mutableSetOf<Int>()
    val N = readLine()!!.toInt()

    val total = 2 * N + 1

    while (true) {
        val myMove = (1..total).firstOrNull { it !in used } ?: return
        println(myMove)
        System.out.flush()
        used.add(myMove)

        val opponent = readLine()!!.toInt()
        if (opponent == 0) return
        used.add(opponent)
    }
}