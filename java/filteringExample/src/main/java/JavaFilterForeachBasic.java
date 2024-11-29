import java.util.Arrays;

public class JavaFilterForeachBasic {
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        Arrays.stream(intArr).filter(i -> i % 2 == 0)
                .forEach(j -> {
                    // 짝수만 For Each 루프
                    System.out.println("Odd: " + j);
                });
    }
}
