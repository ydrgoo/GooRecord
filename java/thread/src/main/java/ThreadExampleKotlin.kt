import java.util.concurrent.Executor
import java.util.concurrent.Executors

fun main() {
    val t = Thread({
        println("Thread Work")
    }, "이름")
    t.join()
    t.start()

    t.start()

    Executors.newSingleThreadExecutor()
}

class ThreadExampleKotlin {

}