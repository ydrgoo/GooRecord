import io.reactivex.rxjava3.core.Flowable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class RxJavaSubscriberBasic {
    public static void main(String[] args) {
        // 배열 데이터 Flowable
        Publisher<Integer> publisher = Flowable.fromArray(1, 2, 3);
        publisher.subscribe(new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("자원 구독 시작");

                // Flowable로부터 자원 3개를 요구합니다.
                s.request(3);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("자원: "+integer);
            }

            @Override
            public void onError(Throwable t) { /* ERROR 처리 */ }

            @Override
            public void onComplete() {
                System.out.println("자원 구독 완료");
            }
        });
    }
}
