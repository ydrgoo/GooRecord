package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataFactory {
    public static List<Data> getHugeData(int size) {
        final Random random = new Random(System.currentTimeMillis());
        final List<Data> dataList = new ArrayList<>(size);

        for (int i=0; i<size; i++) {
            dataList.add(new Data(random.nextInt()));
        }

        return dataList;
    }
}
