/*
 * a + b > 10 : j --
 * a + b < 10 : i ++
 * 
 */

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 5, 6, 8, 9, 10, 12, 14 };
        int sum = 10;
        pairSum(arr, sum);
    }

    public static void pairSum(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] > sum) {
                j--;
            }
            if (arr[i] + arr[j] < sum) {
                i++;
            }
            if (arr[i] + arr[j] == sum) {
                System.out.println(arr[i] + " " + arr[j]);
                i++;
                j--;
            }
        }
    }
}