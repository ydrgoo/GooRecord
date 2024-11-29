import data.Data;
import data.DataFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RxJavaVarianceBasic {
    public static void main(String[] args) throws InterruptedException {
        final int size = 500000;
        List<Data> list = DataFactory.getHugeData(size);
        final CountDownLatch taskCounter = new CountDownLatch(2);

        // 관찰 가능한 전체 데이터 정의
        Observable<Long> listLongObservable = Observable.fromIterable(list).observeOn(Schedulers.computation())
                .map(data -> data.getValue());

        // 평균 구하는 Observable
        Single<Long> avgObservable = listLongObservable.reduce(0L, (acc, i) -> acc + i)
                        .map((sumResult) -> sumResult / size);
        avgObservable.subscribe((result) -> {
            System.out.println("평균: "+result);
            taskCounter.countDown();
        });

        // 제곱합 구하는 Observable
        SingleSource<Long> sum2Observable = listLongObservable.reduce(0L, (acc, i) -> acc + (long) i * i);

        Single.zip(avgObservable, sum2Observable, (avg, sum2) -> sum2 / size - avg * avg)
                .subscribe(result -> {
                    System.out.println("분산: "+result);
                    taskCounter.countDown();
                });
        taskCounter.await();
    }
}
