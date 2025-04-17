fun main() {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    val queries = List(q) {
        val (l,r) = readLine()!!.split(" ").map { it.toInt() }
        l to r
    }

    //Sのなかで「AC」が現れる位置を記録しておく
    val positions = mutableListOf<Int>()//valは再代入の禁止であって中身の変更は禁止してない。そのためmutableを利用するのは変ではない
    for (i in 0 until s.length - 1) {
        if (s[i] == 'A' && s[i + 1] == 'C') {
            positions.add(i)
        }
    }

    //取得したpositionsがl~rの範囲内にあるものだけを出力対象とする
    positions.sort()

    for((l,r) in queries) {
        val from = positions.binarySearch(l-1).let { if(it < 0) -it-1 else it }
        val to = positions.binarySearch(r-1).let { if(it < 0) -it-1 else it }
        println(to - from)
    }
}