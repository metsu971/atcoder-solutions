fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }
    val X = readLine()!!.toLong()

    var count = 0L
    var sum = 0L
    var index = 0

    while (true) {
        sum += A[index]
        count++
        if (sum > X) {
            print(count)
            return
        }
        index = (index + 1) % A.size
    }
}