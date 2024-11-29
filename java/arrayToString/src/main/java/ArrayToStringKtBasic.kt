fun main() {
    val intArr = arrayOf(1, 2, 3, 4, 5)
    println(intArr.contentToString())

    val intItr: Iterable<Int> = arrayListOf(1, 2, 3, 4, 5)
    intItr.toList().toIntArray().contentToString()
}