fun main() {

    //入力値を受け取る
    val (S, K) = readLine()!!.split(" ")

    val result = mutableListOf<String>()
    makePermutation(S.toList(), "", result)
    val sorted = result.distinct().sorted()

    println(sorted[K.toInt() - 1])

}

fun makePermutation(remaining: List<Char>, current: String, result: MutableList<String>) {
    if (remaining.isEmpty()) {
        result.add(current)
        return
    }

    for (i in remaining.indices) {//=0 until size
        val nextChar = remaining[i]
        val nextRemaining = remaining.toMutableList().apply { removeAt(i) }
        makePermutation(nextRemaining, current + nextChar, result)
    }
}


