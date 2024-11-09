import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class RxJavaSubjectBasic {
    public static void main(String[] args) throws InterruptedException {
        Subject<Integer> subject = PublishSubject.create();

        subject.subscribe(new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("자원 관찰 시작");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("subscribeOn: "+Thread.currentThread());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("자원: " + integer);
            }

            @Override
            public void onError(Throwable t) { /* ERROR 처리 */ }

            @Override
            public void onComplete() {
                System.out.println("자원 관찰 완료");
            }
        });


        // 자원 제공
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);

        Thread.sleep(2000);

        // 자원 제공 완료
        subject.onComplete();
    }
}
