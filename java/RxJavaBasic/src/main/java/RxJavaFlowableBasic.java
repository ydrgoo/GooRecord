import io.reactivex.rxjava3.core.Flowable;

public class RxJavaFlowableBasic {
    public static void main(String[] args) {
        // 빈 데이터 Flowable
        Flowable.empty();

        // 단일 데이터 Flowable
        Flowable.just(1);

        // 배열 데이터 Flowable
        Flowable.fromArray(1, 2, 3);

        // 실행 결과 데이터 Flowable
        Flowable.fromCallable(() -> {
            return new int[]{1, 2, 3};
        });
    }
}
