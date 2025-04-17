fun main() {
    val (D, G) = readLine()!!.split(" ").map { it.toInt() }

    val p = IntArray(D)
    val c = IntArray(D)

    repeat(D) { i ->
        val (pi, ci) = readLine()!!.split(" ").map { it.toInt() }
        p[i] = pi
        c[i] = ci
    }

    var minCounter = Int.MAX_VALUE

    for (bit in 0 until (1 shl D)) {//0から2^Dまで変数bitをループ
        //D=3の時 bit=0~7(000 ~ 111)の値を取る。

        var score = 0
        var count = 0

        for (i in 0 until D) {// コンプリートした問題を先に計算
            if ((bit shr i) and 1 == 1) {//bit shr i : bitをiだけずらす.
                //and 1 : 末尾の値を取り出す
                // bitの考えが1=コンプリート対象
                score += 100 * (i + 1) * p[i] + c[i]
                count += p[i]//カウンタを更新
            }
        }

        // 残りのスコア計算
        if (score < G) {
            for (i in D - 1 downTo 0) {
                if ((bit shr i) and 1 == 1) continue//コンプリート対象を弾く
                val point = 100 * (i + 1)
                val need = ((G - score) + point - 1) / point//Gを超えるための必要な問題数
                if (need < p[i]) {//必要な問題数よりも問題が多い場合
                    score += need * point
                    count += need
                    break
                } else {
                    score += point * p[i]
                    count += p[i]
                }
            }
        }

        if (score >= G) {
            minCounter = minOf(minCounter, count)
        }
    }

    print(minCounter)
}
