import kotlinx.coroutines.*

suspend fun main() {
    val myScope = CoroutineScope(Dispatchers.Default)

    // [1] 서울구경
    myScope.launch(Dispatchers.Default) {
        println("goto Seoul...")
        delay(200)
        println("arrival Seoul!")
    }

    // [2] 대전구경
    myScope.launch(Dispatchers.Default) {
        println("goto Deajeon...")
        delay(50)
        println("arrival Deajeon!")
    }

    // [3] 부산구경
    myScope.launch(Dispatchers.Default) {
        println("goto Busan...")
        delay(400)
        println("arrival Busan!")
    }

    delay(100)
    println("Cancel!")
    myScope.cancel()
}