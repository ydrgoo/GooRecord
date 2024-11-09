import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class RxJavaSchedulersBasic {
    public static void main(String[] args) {
        // 단일 스케줄러
        Scheduler singleScheduler = Schedulers.single();

        // 입출력에 용이한 스케줄러
        Scheduler ioScheduler = Schedulers.io();

        // 계산에 용이한 스케줄러
        Scheduler computationScheduler = Schedulers.computation();

        // 기존 Executor 활용
        Executor executor = Executors.newFixedThreadPool(4);
        Scheduler executorScheduler = Schedulers.from(executor);
    }
}
