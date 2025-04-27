fun main() {

    //入力値を受け取る
    val N = readLine()!!.toInt()

    val AListStr = readLine()!!.split(" ").toList()
    val AList = AListStr.map { it.toInt() }

    var result = 0
    for (i in AList.indices) {
        if (i % 2 != 0) {continue}
        result += AList[i]
    }
    println(result)

}
