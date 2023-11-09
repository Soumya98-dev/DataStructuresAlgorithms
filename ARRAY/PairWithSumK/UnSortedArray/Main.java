import java.util.*;

// WITHOUT HASHTABLE
/*
 * public class Main {
 * public static void main(String[] args) {
 * int[] arr = { 6, 3, 8, 10, 16, 7, 5, 2, 9, 14 };
 * int sum = 10;
 * pairSum(arr, sum);
 * }
 * 
 * public static void pairSum(int[] arr, int sum) {
 * for (int i = 0; i < arr.length; i++) {
 * for (int j = i + 1; j < arr.length; j++) {
 * if (arr[i] + arr[j] == sum) {
 * System.out.println(arr[i] + " " + arr[j]);
 * }
 * }
 * }
 * }
 * }
 */

//USING HASHING
public class Main {
    public static void main(String[] args) {
        int[] arr = { 6, 3, 8, 10, 16, 7, 5, 2, 9, 14 };
        int sum = 10;
        pairSum(arr, sum);
    }

    public static void pairSum(int[] arr, int sum) {
        ArrayList<Integer> hashMap = new ArrayList<>();
        // CREATING A HASHMAP
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i <= max; i++) {
            hashMap.add(0);
        }
        int i = 0;
        while (i < arr.length) {
            hashMap.set(arr[i], 1);
            int diff = sum - arr[i];
            if (diff > 0 && diff != arr[i] && hashMap.get(diff) == 1) {
                System.out.println(arr[i] + " " + diff);
            }
            i++;
        }
        System.out.println(hashMap);
    }
}
