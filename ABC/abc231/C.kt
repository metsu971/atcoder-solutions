fun main() {
    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }
    val A = readLine()!!.split(" ").map { it.toInt() }.sorted()

    repeat(Q) {
        val x = readLine()!!.toInt()

        val idx = A.binarySearch(x).let {//2分探索
            if (it >= 0) it else -it - 1
        }

        println(A.size - idx)
    }
}