fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }

    val resultSet = A.toSet().sorted()

    println(resultSet.size)
    resultSet.forEachIndexed { index, i ->
        if (index == resultSet.lastIndex) {
            print("$i")
        } else {
            print("$i ")
        }
    }
}