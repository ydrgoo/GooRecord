import kotlinx.coroutines.*

fun main() {
    println("Seoul = ${Thread.currentThread()}")
    CoroutineScope(Dispatchers.Unconfined).launch {
        println("Daejeon = ${Thread.currentThread()}")
        delay(500)         // 코루틴 일시 중단
        println("Daegu = ${Thread.currentThread()}")

    }
    println("Busan = ${Thread.currentThread()}")

    // 위 작업 종료 시까지 대기
    Thread.sleep(1000)
}