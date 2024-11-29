import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JavaExecutorBasic {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<String> future = executorService.submit(() -> {
            System.out.println("Executor: 작업 실행");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) { /* DO_NOTHING */ }
            finally {
                System.out.println("Executor: 작업 완료");
            }

            return "Hello World!";
        });

        System.out.println("Future: 작업 대기중...");
        System.out.println("Future: 작업 완료. "
                + "결과: " + future.get());
    }
}
