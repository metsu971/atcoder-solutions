fun main() {
    val S = readLine()!!
    val T = readLine()!!
    val atCoder= "atcoder".toSet()

    val sCount = mutableMapOf<Char, Int>()
    val tCount = mutableMapOf<Char, Int>()

    //各文字の出現回数をカウント
    for (c in S) sCount[c] = sCount.getOrDefault(c, 0) + 1
    for (c in T) tCount[c] = tCount.getOrDefault(c, 0) + 1

    //@の出てくる数を記録
    var sAt = sCount.getOrDefault('@', 0)
    var tAt = tCount.getOrDefault('@', 0)

    for (c in ('a'..'z')) {//英小文字 a から z のすべての文字についてループ
        val sc = sCount.getOrDefault(c, 0)
        val tc = tCount.getOrDefault(c, 0)

        if (sc == tc) continue//出現数が一致している場合は次のループ探索へ

        if (c in atCoder) {
            if (sc > tc) {
                val need = sc - tc
                if (tAt >= need) {
                    tAt -= need
                } else {
                    println("No")
                    return
                }
            } else {
                val need = tc - sc
                if (sAt >= need) {
                    sAt -= need
                } else {
                    println("No")
                    return
                }
            }
        } else {
            println("No")
            return
        }
    }
}