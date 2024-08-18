public class SumNNaturalNumber {
    public static void main(String[] args) {
        sum(5, 0, 0);
    }

    static void sum(int n, int i, int sum) {
        if (i == n) {
            sum = sum + i;
            System.out.println(sum);
            return;
        }

        sum = sum + i;

        sum(n, i + 1, sum);
    }
}
