import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt();

    val xList = mutableListOf<Int>()
    val yList = mutableListOf<Int>()
    val hList = mutableListOf<Int>()

    repeat(n) {
        val (x, y, h) = readLine()!!.split(" ").map { it.toInt() }
        xList.add(x)
        yList.add(y)
        hList.add(h)
    }

    //Cx, Cy, Hを求める。
    //全ての点を元に高さを出す。そうすることで出力に対する答えも得られる。
    //Cx, Cyは100までの数なのでせいぜい10^4なので全探索可能

    //h(x,y) = maxOf(H- (x-Cx) - (Y-Cy), 0)
    //上記はh > 0ならば　H = h + (x-Cx) +(y - Cy)とできる!

    //cx,cyが決まればHもきまる。
    //Hが同じものを最終的に比較するので、ループの構造はcx -> cy -> H
    for (cx in 0..100) {
        for (cy in 0..100) {
            var H = -1
            for (i in 0 until n) {
                if (hList[i] > 0) {
                    H = hList[i] + abs(xList[i] - cx) + abs(yList[i] - cy)
                    break
                }
            }

            if (H == -1) continue // h> 0の点が存在しない場合

            var isOk = true
            for (i in 0 until n) {
                val expectedH = maxOf(H - abs(xList[i] - cx) - abs(yList[i] - cy), 0)
                if (expectedH != hList[i]) {//理論値と観測値は式でイコールで成り立つはずなので。
                    isOk = false
                    break
                }
            }

            if (isOk) {
                println("$cx $cy $H")
                return
            }
        }
    }

}
