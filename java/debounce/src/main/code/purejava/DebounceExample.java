package purejava;

import java.util.Scanner;
import java.util.concurrent.Executor;

public class DebounceExample {
    public static void main(String[] args) throws InterruptedException {
        final Scanner scanner = new Scanner(System.in);
        final Executor executor = new DebounceExecutor(2000);
        final StringBuilder builder = new StringBuilder();

        System.out.println("텍스트 입력 후 엔터키를 누르세요.");
        while(true) {
            Thread.sleep(0);

            /* [1] 엔터를 누를 때마다 입력받은 문자열을 모두 이어붙이고 */
            builder.append(scanner.next());
            scanner.reset();

            /* [2] 화면에 출력 요청 */
            executor.execute(() -> {
                /* [3] 추가 요청이 없으면 화면에 최종 출력 */
                System.out.println("검색: "+builder);
            });
        }
    }
}
