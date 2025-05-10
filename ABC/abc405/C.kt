fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    var sum :Long = 0

    for (i in 0 until N){
        for (j in 0 until N) {
            if (i >= j) {
                continue
            }
            sum += A[i] * A[j]
        }
    }
    print(sum)
}