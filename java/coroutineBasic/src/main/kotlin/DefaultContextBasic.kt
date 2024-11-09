import kotlinx.coroutines.*

fun main() {
    println("Seoul")
    CoroutineScope(Dispatchers.Default).launch {
        println("Daejeon")
    }
    println("Busan")

    // 위 작업 종료 시까지 대기
    Thread.sleep(1000)
}