import java.util.concurrent.Executor
import java.util.concurrent.Executors

val executor: Executor by lazy {
    Executors.newSingleThreadExecutor()
}

fun main() {
    val task = Runnable {
        println("Thread Work")
    }
    executor.execute(task)
    executor.execute(task)
    executor.execute(task)
}