import kotlin.math.pow

fun main() {
    val intArr = arrayOf(1, 2, 3, 4, 5)

    val avg = intArr.average()
    val variance = intArr.map { (it - avg).pow(2) }.sum() / intArr.size
    println("Variance: ${variance}")
}