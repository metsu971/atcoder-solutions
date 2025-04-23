fun main() {
    val N = readLine()!!.toInt()
    val S = readLine()!!.split(" ").map { it.toLong() }
    val T = readLine()!!.split(" ").map { it.toLong() }

    val receive = T.toMutableList()

    var updated = true
    while (updated) {
        updated = false
        for (i in 0 until N) {
            val next = (i + 1) % N
            val newTime = receive[i] + S[i]
            if (receive[next] > newTime) {
                receive[next] = newTime
                updated = true // 1回でも更新されたら、もう1周必要
            }
        }
    }

    receive.forEach { println(it) }
}