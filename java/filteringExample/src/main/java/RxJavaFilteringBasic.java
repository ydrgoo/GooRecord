import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

public class RxJavaFilteringBasic {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5};
        Observable<Integer> observable = Observable.fromArray(intArr).filter(i -> i % 2 == 0);
        observable.toList().subscribe((newArr) -> {
            // 짝수만 모인 배열 전체
            System.out.println("짝수 배열: "+Arrays.toString(newArr.toArray()));
        });
        observable.forEach(j -> {
            // 짝수만 For Each 루프
            System.out.println("Odd: " + j);
        });
    }
}
