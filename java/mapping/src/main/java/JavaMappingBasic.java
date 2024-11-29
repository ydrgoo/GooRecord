import java.util.Arrays;

public class JavaMappingBasic {
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5};
        int[] newArr = Arrays.stream(intArr).map((i) -> i * 10).toArray();

        System.out.println(Arrays.toString(newArr));
    }
}
