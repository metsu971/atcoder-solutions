fun main() {
    val N = readLine()!!.toInt()
    val A = readLine()!!.split(" ").map { it.toInt() }

    var allSum = 0L
    var distinctCount = 0L

    for (i in 2..N) {
        allSum += i-1
    }

    val countMap = mutableMapOf<Int, Long>()
    for (num in A) {
        countMap[num] = countMap.getOrDefault(num, 0L) + 1
    }

    for((_, count) in countMap) {
        distinctCount += count * (count -1) / 2
    }

    print(allSum - distinctCount)
}