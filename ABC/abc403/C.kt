/**
 * allGrantedUserList: MutableList<Int> だと、毎回containsでリストをなめるので O(N) → 遅い
 * → allGrantedUserSet: MutableSet<Int> にしたほうがいい。（SetはO(1)探索！）
 */
fun main() {

    //入力値を受け取る
    val (N,M,Q) = readLine()!!.split(" ").map { it.toInt() }

    var userAvailableMap = mutableMapOf<Int, MutableSet<Int>>()
    val allGrantedUserSet = mutableSetOf<Int>()

    for (i in 1..Q) {
        val query = readLine()!!.split(" ").map { it.toInt() }
        if (query[0] == 1) {
            val (x, y) = query.drop(1)
            if (!allGrantedUserSet.contains(x)) {
                userAvailableMap.getOrPut(x) { mutableSetOf() }.add(y)
            }
        } else if (query[0] == 2) {
            val x = query[1]
            allGrantedUserSet.add(x)
        } else if(query[0] == 3) {
            val (x, y) = query.drop(1)
            if (allGrantedUserSet.contains(x)) {
                println("Yes")
            } else if (userAvailableMap[x]?.contains(y) == true) {
                println("Yes")
            } else {
                println("No")
            }
        }
    }
}