import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

suspend fun main() {
    println("Seoul")

    // Default Context에서 다른 코루틴 실행 후 대기
    withContext(Dispatchers.Default) {
        gotoDaejeon()
    }

    println("Busan")
}

suspend fun gotoDaejeon() {
    println("goto Daejeon...")
    delay(500)
    println("arrival Deajeon!")
}