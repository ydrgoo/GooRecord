import java.util.concurrent.*;

public class DebounceExecutor implements Executor {
    /* [1] 작업을 실행시킬 수 있는 ScheduledExecutorService 를 정의한다. */
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /* [2] Debounce 지연시간 */
    private final long delay;

    /* [3] 이미 실행 중인 작업 */
    private volatile ScheduledFuture<?> currentTask;

    public DebounceExecutor(long delay) {
        this.delay = delay;
    }

    @Override
    public synchronized void execute(Runnable command) {
        /* [3] 만약 다른 작업이 요청되었다면, 이미 작업이 있으면 해당 작업을 취소시키고 다시 예약한다. */
        if (currentTask != null && !currentTask.isCancelled() && !currentTask.isDone()) {
            currentTask.cancel(false);
        }
        /* [2] 작업을 Executor에 일정 딜레이만큼의 시간을 두고 예약한다. */
        currentTask = executor.schedule(command, delay, TimeUnit.MILLISECONDS);
    }
}
