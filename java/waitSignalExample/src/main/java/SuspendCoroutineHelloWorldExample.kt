import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    val msg = suspendCoroutine<String> { continuation ->
        continuation.resume("Hello World!")
    }
    println(msg)
}