package rxjava;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DebounceExampleRxJava {
    public static void main(String[] args) {
        PublishSubject<String> subject = PublishSubject.create();

        /*
         observeOn의 경우, 어차피 debounce 에서 버퍼 처리를 담당하므로, 최대한 빨리 통과시켜도 무방합니다.
         debounce 는 굳이 단일 쓰레드를 고집할 필요가 없습니다.
         단, subscribeOn 에서는 1번 실행이 원칙이므로, 단일 쓰레드로 처리해주세요.
         */
        Disposable disposable = subject.observeOn(Schedulers.computation())
                .debounce(2000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.single())
                .subscribe((s) -> {
                    /* [3] 추가 요청이 없으면 화면에 최종 출력 */
                    System.out.println("검색: " + s);
                });

        final Scanner scanner = new Scanner(System.in);
        final StringBuilder builder = new StringBuilder();

        System.out.println("텍스트 입력 후 엔터키를 누르세요.");
        try {
            while(true) {
                Thread.sleep(0);

                /* [1] 엔터를 누를 때마다 입력받은 문자열을 모두 이어붙이고 */
                builder.append(scanner.next());
                scanner.reset();

                /* [2] 화면에 출력 요청 */
                subject.onNext(builder.toString());
            }
        } catch (InterruptedException e) { /* DO_NOTHING */ }
        finally {
            disposable.dispose();
        }
    }
}
