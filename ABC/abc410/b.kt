fun main() {
    //N 箱の数
    //Q ボールの数
    val (N, Q) = readLine()!!.split(" ").map { it.toInt() }
    val X = readLine()!!.split(" ").map { it.toInt() }

    //mapを用意 最初からvalueを0で初期化しておく
    val map = mutableMapOf<Int, Int>().apply {
        for (i in 1..N) {
            this[i] = 0
        }
    }
    val result = mutableListOf<Int>()
    for (i in 0 until Q){
        if (X[i] >= 1) {
            map[X[i]] = map[X[i]]!! + 1
            result.add(X[i])
        } else if(X[i] == 0) {
            //mapのvalueが最小のうち、keyが一番小さいものに格納する
            val minValue = map.values.minOrNull()
            val minKey = map.filterValues { it == minValue }.keys.minOrNull()!!
            map[minKey] = map[minKey]!! + 1
            result.add(minKey)
        }
    }
    println(result.joinToString(" "))
}