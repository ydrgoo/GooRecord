import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JavaExecutorExceptionBasic {
    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        final Future<String> future = executorService.submit(() -> {
            System.out.println("Executor: 작업 실행");
            try {
                String wrong = null;
                System.out.println("Executor: 글자 길이는 " + wrong.length());
            } finally {
                System.out.println("Executor: 작업 완료");
            }

            return null;
        });

        System.out.println("Future: 작업 대기중...");
        try {
            future.get();
        } catch (ExecutionException e) {
            System.out.println("Future: 작업 오류 발생! \n"
                    + e.getMessage());
        }
    }
}
