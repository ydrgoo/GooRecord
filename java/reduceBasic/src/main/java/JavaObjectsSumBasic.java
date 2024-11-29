import data.Data;

import java.util.Arrays;

public class JavaObjectsSumBasic {
    public static void main(String[] args) {
        Data[] dataArr = new Data[]{
                new Data(1),
                new Data(2),
                new Data(3)};

        System.out.println("Sum: "+Arrays.stream(dataArr).mapToLong(d -> d.getValue()).sum());
    }
}
