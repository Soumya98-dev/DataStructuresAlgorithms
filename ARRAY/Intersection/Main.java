import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 6, 10};
        int[] arr2 = {2, 6, 10, 7, 12};
        System.out.println((intersection(arr1, arr2)));
    }

    public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
        ArrayList<Integer> arr3 = new ArrayList<>();

        /*
        //BRUTE FORCE APPROACH(0(N^2))
        for (int k : arr1) {
            for (int i : arr2) {
                if (k == i) {
                    arr3.add(i);
                }
            }
        }

         */

        //LINEAR APPROACH(Theta(M+N))
        int m = arr1.length;
        int n = arr2.length;
        int i = 0;//KEEPS COUNT OF arr1
        int j = 0;//KEEPS COUNT OF arr2

        while (i < m && j < n) {
            if (arr1[i] == arr2[j]) {
                arr3.add(arr1[i]);
                i++;
                j++;
                continue;
            }
            if (arr1[i] < arr2[j]) {
                i++;
                continue;
            }
            if (arr2[j] < arr1[i]) {
                j++;
            }
        }

        return arr3;
    }
}