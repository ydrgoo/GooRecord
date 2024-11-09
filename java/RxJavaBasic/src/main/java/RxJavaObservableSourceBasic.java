import io.reactivex.rxjava3.core.Observable;

public class RxJavaObservableSourceBasic {
    public static void main(String[] args) {
        // 빈 데이터 Observable
        Observable.empty();

        // 단일 데이터 Observable
        Observable.just(1);

        // 배열 데이터 Observable
        Observable.fromArray(1, 2, 3);

        // 실행 결과 데이터 Observable
        Observable.fromCallable(() -> {
            return new int[]{1, 2, 3};
        });
    }
}
