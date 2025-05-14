fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toLong() }
    val X = readLine()!!.toLong()

    //最初にAの合計を求める
    val totalOneRound = A.sum()

    //Xを超えるまでに何周必要かを計算
    val fullRounds = X / totalOneRound
    var sum = fullRounds * totalOneRound
    var count = fullRounds * A.size//Aの数 * 何周かでループ数を算出

    //上記で計算した以外の残りの部分だけループ
    for(a in A) {
        sum += a
        count++
        if (sum > X) {
            print(count)
            return
        }
    }
}