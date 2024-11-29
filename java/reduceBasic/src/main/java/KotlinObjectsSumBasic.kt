import data.Data

fun main() {
    val dataArr = arrayOf(Data(1), Data(2), Data(3))

    println("Sum: ${dataArr.sumOf { it.value }}")
}