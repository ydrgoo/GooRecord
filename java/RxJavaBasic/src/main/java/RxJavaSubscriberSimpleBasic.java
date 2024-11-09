import io.reactivex.rxjava3.core.Flowable;

public class RxJavaSubscriberSimpleBasic {
    public static void main(String[] args) {
        // 배열 데이터 Flowable
        Flowable<Integer> publisher = Flowable.fromArray(1, 2, 3);
        publisher.subscribe((i) -> {
            System.out.println("자원: "+i);
        });
    }
}
