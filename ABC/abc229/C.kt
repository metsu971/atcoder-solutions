fun main() {
    val (N, W) = readLine()!!.split(" ").map { it.toInt() }

    val items = List(N) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        a to b
    }

    val sortedItems = items.sortedByDescending { it.first }//降順にソート

    var deliciousSum = 0L
    var bSum = 0
    for ((a, b) in sortedItems) {
        if (W - bSum - b < 0) {
            deliciousSum += a.toLong() * (W-bSum)
            print(deliciousSum)
            return
        }
        bSum += b
        deliciousSum += a.toLong() * b
    }
    print(deliciousSum)
}