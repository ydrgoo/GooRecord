import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class RxJavaSubjectNonSchedulersBasic {
    public static void main(String[] args) {
        Subject<Integer> subject = PublishSubject.create();

        subject.subscribe(new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) { /* DO_NOTHING */ }

            @Override
            public void onNext(Integer integer) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public void onError(Throwable t) { /* DO_NOTHING */ }

            @Override
            public void onComplete() { /* DO_NOTHING */ }
        });

        // 자원 제공
        System.out.println("자원 전달 시작");
        subject.onNext(1);

        // 자원 전달 및 처리가 5초 후 완료됩니다.
        // 그동안 메인 쓰레드가 Blocking 처리

        // 자원 제공 완료
        subject.onComplete();
        System.out.println("자원 전달 완료");
    }
}
