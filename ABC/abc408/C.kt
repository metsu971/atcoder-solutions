fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    // 城壁1〜Nを守っている放題の数を数えるための差分配列
    val diff = IntArray(N + 2)
    val intervals = mutableListOf<Pair<Int, Int>>() //砲台の区間

    repeat(M) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        diff[l] += 1
        diff[r + 1] -= 1
        intervals.add(l to r)
    }

    //各城壁iを守っている砲台数
    val cover = IntArray(N + 2)
    for (i in 1..N) {
        cover[i] = cover[i - 1] + diff[i]
    }

    // 一番守られている砲台が少ない城壁を探す
    var minCover = Int.MAX_VALUE
    var targetWall = -1
    for(i in 1..N) {
        if(cover[i] < minCover) {
            minCover = cover[i]
            targetWall = i
        }
    }

    // その城壁 targetWallを守っている砲台を数える
    var result = intervals.count{ (l,r) -> targetWall in l..r}
    print(result)
}