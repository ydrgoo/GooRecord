import io.reactivex.rxjava3.core.Observable;

public class RxJavaHelloWorld {
    public static void main(String[] args) {
        Observable.just("Hello World!")
                .subscribe(System.out::println);
    }
}
