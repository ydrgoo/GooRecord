import kotlinx.coroutines.*

fun main() {
    CoroutineScope(Dispatchers.Default).launch {
        println("Seoul")

        // Default Context에서 다른 코루틴 실행 후 대기
        withContext(Dispatchers.Default) {
            println("goto Daejeon...")
            delay(500)
            println("arrival Deajeon!")
        }

        println("Busan")
    }

    // 위 작업 종료 시까지 대기
    Thread.sleep(1000)
}