fun main() {
    val (N, K) = readLine()!!.split(" ").map {it.toInt() }
    val A = readLine()!!.split(" ").map {it.toLong() }

    var result = 1L

    for (i in 0 until N) {
        result *= A[i]
        if (result.toString().length > K) {//Longの範囲ギリギリで値が正しく扱えない場合がある
            result = 1L
        }
    }

    print(result)
}