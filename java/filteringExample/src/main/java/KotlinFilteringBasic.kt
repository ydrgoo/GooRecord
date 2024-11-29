fun main() {
    val intArr = arrayOf(1, 2, 3, 4, 5)
    intArr.filter { it % 2 == 0 }.forEach {
        // 짝수만 For Each 루프
        println("Odd: $it")
    }
}