fun main(args: Array<String>) {
    var values = readLine()!!.toInt()
    val valuesPosition = IntArray(10).toMutableList()

    for (i in 0 until 10) {
        valuesPosition[i] = values
        values *= 2
    }

    for ( enumerator in 0 until 10 ) { println("N[$enumerator] = ${valuesPosition[enumerator]}") }
}