import data.DataFactory;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.List;

public class JavaThreadWaitSignalExample {
    public static void main(String[] args) throws InterruptedException {
        // 이 부분은 그냥 랜덤하게 숫자 2억개 리스트를 생성하는 부분입니다.
        final List<Integer> integerList = DataFactory.getHugeData(200000000);
        final Object obj = new Object();

        synchronized (obj) {
            System.out.println("작업 시작");
            Observable.fromIterable(integerList).observeOn(Schedulers.computation())
                    .reduce(0L, (acc, integer) -> {
                        return acc + integer;
                    })
                    .subscribe(result -> {
                        System.out.println("작업 완료 (합: "+result+")");

                        // 중단점으로 완료 신호 전달
                        synchronized (obj) {
                            obj.notifyAll();
                        }
                    });

            // 중단점에서 신호가 올 때까지 대기
            obj.wait();
        }
        System.out.println("프로그램 종료");
    }
}
