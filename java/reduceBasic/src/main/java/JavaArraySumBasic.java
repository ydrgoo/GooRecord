import java.util.Arrays;

public class JavaArraySumBasic {
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5};

        System.out.println("Sum: "+Arrays.stream(intArr).sum());
        System.out.println("Avg: "+Arrays.stream(intArr).average());
        System.out.println("Min: "+Arrays.stream(intArr).min());
        System.out.println("Max: "+Arrays.stream(intArr).max());
    }
}
