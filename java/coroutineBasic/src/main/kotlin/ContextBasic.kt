import kotlinx.coroutines.*
import java.util.concurrent.Executors


fun main() {
    // 메인 쓰레드 Dispatcher Context
    Dispatchers.Main

    // 입출력용 Dispatcher Context
    Dispatchers.IO

    // 일반적인 작업 쓰레드 Dispatcher Context
    Dispatchers.Default

    // 불특정 Dispatcher Context.
    Dispatchers.Unconfined

    // Executor를 Dispatcher로 사용
    val context = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

    CoroutineScope(context).launch {
        println("Hello World!")
    }
}