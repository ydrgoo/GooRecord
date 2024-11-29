public class WaitNotifyWrongExample {
    public static void main(String[] args) {
        final DataFactory factory = new DataFactory();

        new Thread(() -> {
            System.out.println("데이터 준비");
            factory.prepareData();
        }).start();

        factory.waitData();
        System.out.println("데이터 준비 완료");
    }
}

class DataFactory {
    public synchronized void waitData() {
        try {
            this.wait();
        } catch (InterruptedException e) { /* DO_NOTHING */ }
    }

    public synchronized void prepareData() {
        this.notifyAll();
    }
}
