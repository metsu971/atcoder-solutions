fun main() {

    val (H,W,N) = readLine()!!.split(" ").map { it.toInt() }

    val aList = mutableListOf<Int>()
    val bList = mutableListOf<Int>()
    val points = mutableListOf<Pair<Int, Int>>()

    repeat(N) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        aList.add(a)
        bList.add(b)
        points.add(a to b)
    }

    val rowMap = aList.distinct().sorted().withIndex().associate { it.value to it.index + 1 }
    val colMap = bList.distinct().sorted().withIndex().associate { it.value to it.index + 1 }

    // 圧縮後の座標を出力
    for ((a, b) in points) {
        println("${rowMap[a]} ${colMap[b]}")
    }
}


