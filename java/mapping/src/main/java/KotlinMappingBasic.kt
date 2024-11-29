fun main() {
    val intArr = arrayOf(1, 2, 3, 4, 5)
    val newArr = intArr.map { it * 10 }.toIntArray()

    println(newArr.contentToString())
}