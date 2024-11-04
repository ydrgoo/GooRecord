import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadExample {
    private static final Executor executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Thread Work");

        executor.execute(task);
        executor.execute(task);
        executor.execute(task);
    }
}
