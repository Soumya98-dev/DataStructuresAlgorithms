import java.util.*;

public class Main {
    public static void main(String[] args) {
        // int[] arr = { 5, 8, 3, 9, 6, 2, 10, 7, -1, 4 };
        int[] arr = { 10, 9, 8, 7, 2, 1 };
        maxmin(arr);
    }

    public static void maxmin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        int i = 0;
        while (i < arr.length) {
            if (max > arr[i]) {
                max = arr[i];
            }
            if (min < arr[i]) {
                min = arr[i];
            }
            i++;
        }
        System.out.println(max + " " + min);
    }
}