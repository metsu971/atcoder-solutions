fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }

    var allSum = 0L
    var duplicatePairs = 0L

    for (i in 2..N) {
        allSum += i-1
    }

    val countMap = mutableMapOf<Int, Long>()
    for (num in A) {
        countMap[num] = countMap.getOrDefault(num, 0L) + 1
    }

    for((_, count) in countMap) {
        for (i in 1 until count) {
            duplicatePairs += i
        }
    }

    print(allSum - duplicatePairs)
}