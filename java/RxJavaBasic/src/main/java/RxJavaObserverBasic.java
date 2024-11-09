import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class RxJavaObserverBasic {
    public static void main(String[] args) {
        ObservableSource<Integer> observable = Observable.fromArray(1, 2, 3);
        observable.subscribe(new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("자원 관찰 시작");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("자원: " + integer);
            }

            @Override
            public void onError(Throwable t) { /* ERROR 처리 */ }

            @Override
            public void onComplete() {
                System.out.println("자원 관찰 완료");
            }
        });
    }
}
