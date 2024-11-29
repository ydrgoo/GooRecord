public class JavaVarianceBasic {
    public static void main(String[] args) {
        int[] intArr = new int[]{1, 2, 3, 4, 5};

        int s2sum = 0;
        int sum = 0;

        for (int i : intArr) {
            s2sum += i * i;
            sum += i;
        }
        int avg = sum / intArr.length;
        int variance = s2sum / intArr.length - avg * avg;

        System.out.println("Variance: "+variance);
    }
}
