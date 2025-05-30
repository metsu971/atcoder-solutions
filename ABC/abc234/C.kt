fun main() {
    val K = readLine()!!.toLong()
    val binary = K.toString(2)
    val sb = StringBuilder()
    for (ch in binary) {
        if (ch == '1') sb.append('2')
        else sb.append('0')
    }

    print(sb.toString())
}