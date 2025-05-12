fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() } 

    var result = 0L
    var suffixSum = A.sum()

    for(i in 0 until N) {
        suffixSum -= A[i]
        result += A[i] * suffixSum
    }

    print(result)
}