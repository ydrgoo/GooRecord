fun main() {
    val intArr = arrayOf(1, 2, 3, 4, 5)

    val result = object {
        var s2sum: Int = 0
        var sum: Int = 0

        val avg = sum / intArr.size
        val s2avg = s2sum / intArr.size
        val variance get() = s2avg - avg * avg
    }
    intArr.scan(result, { acc, i ->
        acc.s2sum += i * i
        acc.sum += i
        return@scan acc
    })

    println("Variance: ${result.variance}")
}