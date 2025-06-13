fun main() {
    val N = readLine()!!.toInt()
    val T = readLine()!!
    val A = readLine()!!

    for (i in 0 until N) {
        if (T[i] == 'o' && A[i] == 'o') {
            print("Yes")
            return
        }
    }
    print("No")
}