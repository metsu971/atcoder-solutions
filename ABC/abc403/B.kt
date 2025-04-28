fun main() {
    val T = readLine()!!
    val U = readLine()!!

    val tLength = T.length
    val uLength = U.length

    for (i in 0..(tLength - uLength)) {
        var match = true
        for (j in 0 until uLength) {
            if (T[i + j] != '?' && T[i + j] != U[j]) {
                match = false
                break
            }
        }
        if (match) {
            println("Yes")
            return
        }
    }
    println("No")
}