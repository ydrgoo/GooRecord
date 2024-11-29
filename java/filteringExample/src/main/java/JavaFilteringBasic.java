import java.util.Arrays;

public class JavaFilteringBasic {
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        int[] newArr = Arrays.stream(intArr).filter(i -> i % 2 == 0).toArray();

        System.out.println(Arrays.toString(newArr));
    }
}
