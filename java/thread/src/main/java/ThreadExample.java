public class ThreadExample {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Thread Work");
        }).start();
    }
}
