import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RandomTask implements Runnable {
    final static Random random = new Random(System.currentTimeMillis());

    final String name;
    final Runnable onComplete;
    final long waitTime = random.nextLong(10000);

    public RandomTask(String name, Runnable onComplete) {
        this.name = name;
        this.onComplete = onComplete;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " 작업 시작... (예상 시간: " + waitTime + " ms)");
            Thread.sleep(waitTime);
        } catch (InterruptedException ignored) {
        } finally {
            System.out.println(name + " 작업 종료");
            onComplete.run();
        }
    }
}
