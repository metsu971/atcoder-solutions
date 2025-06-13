fun main() {
    // N 点の数
    // L 円周
    // d 一部の長さ
    val n = readLine()!!.toInt()
    val l = readLine()!!.toLong()
    val d = readLine()!!.split(" ").map{ it.toLong()}

    // 各点の位置を計算 (点1は0)
    val positions = mutableListOf<Long>()
    positions.add(0L)
    for (i in 0 until n -1) {
        val next = (positions.last() + d[i]) % l
        positions.add(next)
    }

    val positionSet = positions.toSet()

    if (l % 3 != 0L) {
        println(0)
        return
    }

    val step = l / 3
    var count = 0

    // 各点を視点として正三角形を構成できるか調べる
    for (p in positionSet) {
        val p1 = (p + step) % l
        val p2 = (p + 2 * step) % l
        if (p1 in positionSet && p2 in positionSet) {
            count++
        }
    }

    // 1つの正三角形が3つの点からカウントされているので、3で割る
    print(count / 3)

}