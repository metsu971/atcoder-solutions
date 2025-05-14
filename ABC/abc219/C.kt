fun main() {
    val x = readLine()!!
    val n = readLine()!!.toInt()
    val s = List(n) { readLine()!! }

    //文字の加算を利用
    //'a' + 2 → 'c'
    val order = x.mapIndexed { index, c ->  c to ('a' + index)}.toMap()

    val sorted = s.sortedWith(compareBy {word ->
        word.map { order[it]!! }.joinToString("")
    })

    sorted.forEach { println(it) }

}

