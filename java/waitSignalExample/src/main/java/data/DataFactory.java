package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataFactory {
    public static List<Integer> getHugeData(int size) {
        final Random random = new Random(System.currentTimeMillis());
        final List<Integer> integerList = new ArrayList<>(size);

        for (int i=0; i<size; i++) {
            integerList.add(random.nextInt());
        }

        return integerList;
    }
}
