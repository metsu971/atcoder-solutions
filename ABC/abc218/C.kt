fun main() {
    val n = readLine()!!.toInt()
    val S = List(n) { readLine()!! }
    val T = List(n) { readLine()!! }

    var rotated = S
    repeat(4) { // 0度〜270度の4パターンを試す
        if (normalize(rotated) == normalize(T)) { // 正規化して一致すれば
            println("Yes")
            return
        }
        rotated = rotate90(rotated) // 90度回転
    }
    println("No")
}

fun rotate90(grid: List<String>): List<String> {
    val n = grid.size
    return List(n) { i ->
        (0 until n).map { j -> grid[n - j - 1][i] }.joinToString("")
    }
}

fun normalize(grid: List<String>): List<String> {
    val n = grid.size
    val points = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == '#') points.add(i to j)
        }
    }

    if (points.isEmpty()) return emptyList()

    val minI = points.minOf { it.first }//???
    val minJ = points.minOf { it.second }

    // 相対位置に変換して、新しい盤面を作る
    val shape = MutableList(n) { CharArray(n) { '.' } }
    for ((i, j) in points) {
        shape[i - minI][j - minJ] = '#'
    }

    //無駄な行・列を削除
    val maxI = shape.indexOfLast { it.contains('#') }
    val maxJ = shape[0].indices.filter { j -> shape.any { it[j] == '#'} }.maxOrNull() ?: -1

    return (0..maxI).map { i ->
        (0..maxJ).map { j-> shape[i][j] }.joinToString("")
    }
}