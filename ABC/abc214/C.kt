fun main() {

    val N = readLine()!!.toInt()

    val S = readLine()!!.split(" ").map { it.toInt() }
    val T = readLine()!!.split(" ").map { it.toInt() }

    val firstReceivedTime = mutableListOf<Int>()
    //Tから先に受け取るのか、Sから先に受け取るのかを考えていく
    //3番目のスヌけが最初に受け取る時刻はT[3]またはT[2]+S[2+1]の早い方！！

    for (i in 1 until 10 * N) {//Nでループする
        if (firstReceivedTime.size == N) break

        if (i == 1) {//Siは機能しないので特別扱い
            firstReceivedTime.add(T[i])
            continue
        }
        //SiとTiの代償比較
        if (T[i - 1] > T[i - 2] + S[i - 2]) {// i+1番目のすぬけが受け取る時間
            firstReceivedTime.add(T[i - 1])
        } else {
            firstReceivedTime.add(T[i - 2] + S[i - 2])
        }
    }

    for (i in firstReceivedTime) {
        println(i)
    }

}


