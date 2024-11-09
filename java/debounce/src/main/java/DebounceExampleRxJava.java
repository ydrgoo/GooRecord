import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import org.reactivestreams.Publisher;

public class DebounceExampleRxJava {
    public static void main(String[] args) {
        // 빈 데이터 Flowable
        Flowable.empty();

        // 단일 데이터 Flowable
        Flowable.just(1);

        // 배열 데이터 Flowable
        Flowable.fromArray(new int[]{1, 2, 3});

        // 실행 결과 데이터 Flowable
        Flowable.fromCallable(() -> {
            return new int[]{1, 2, 3};
        });


    }
}
