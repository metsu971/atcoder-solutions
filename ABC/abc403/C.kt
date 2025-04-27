fun main() {

    //入力値を受け取る
    val (N,M,Q) = readLine()!!.split(" ").map { it.toInt() }

    var userAvailableMap = mutableMapOf<Int, MutableList<Int>>()
    val allGrantedUserList = mutableListOf<Int>()
    //先にクエリを計算
    for (i in 1..Q) {
        val qxyList = readLine()!!.split(" ").map { it.toInt() }
        if (qxyList[0] == 1) {
            if (allGrantedUserList.contains(qxyList[1])){continue}
            if (userAvailableMap[qxyList[1]] != null) {
                val list = userAvailableMap[qxyList[1]]
                list?.add(qxyList[2])
                userAvailableMap[qxyList[1]] = list!!
            } else {
                userAvailableMap[qxyList[1]] = mutableListOf(qxyList[2])
            }
        } else if (qxyList[0] == 2) {
            allGrantedUserList.add(qxyList[1])
        } else if(qxyList[0] == 3) {
            if (userAvailableMap.get(qxyList[1]) == null) {
                println("No")
            } else if (userAvailableMap.get(qxyList[1])!!.contains(qxyList[2]) || allGrantedUserList.contains(qxyList[1])) {
                println("Yes")
            } else {
                println("No")
            }
        }
    }
}



