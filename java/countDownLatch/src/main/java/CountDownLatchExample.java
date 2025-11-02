import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executor = Executors.newFixedThreadPool(4);
        final CountDownLatch taskCount = new CountDownLatch(4);
        final Runnable onComplete = taskCount::countDown;

        executor.execute(new RandomTask("A", onComplete));
        executor.execute(new RandomTask("B", onComplete));
        executor.execute(new RandomTask("C", onComplete));
        executor.execute(new RandomTask("D", onComplete));

        System.out.println("4개 작업 대기중...");
        taskCount.await();
        executor.shutdown();
        System.out.println("작업 완료!");
    }
}
