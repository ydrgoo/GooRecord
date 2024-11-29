import io.reactivex.rxjava3.core.Observable;

import java.util.Arrays;

public class RxJavaMappingBasic {
    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5};

        Observable.fromArray(intArr)
                .map(i -> i * 10)
                .toList()
                .subscribe((result) -> System.out.println(Arrays.toString(result.toArray())));
    }
}
