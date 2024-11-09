import kotlinx.coroutines.*

fun main() {
    println("Seoul")
    CoroutineScope(Dispatchers.Unconfined).launch {
        println("Daejeon")
    }
    println("Busan")
}