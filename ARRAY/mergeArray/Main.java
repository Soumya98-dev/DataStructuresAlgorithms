import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = array1();
//        System.out.println(arr1);
        ArrayList<Integer> arr2 = array2();
//        System.out.println(arr2);
        System.out.println(merge(arr1, arr2));
    }

    public static ArrayList<Integer> array1() {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nums = {3, 8, 16, 20, 25};
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        return arr;
    }

    public static ArrayList<Integer> array2() {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nums = {4, 10, 12, 22, 23};
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        return arr;
    }

    public static ArrayList<Integer> merge(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        //i starts from 1st index of arr1,
        //j starts from 1st index of arr2
        //k starts from first index of arr3
        //compare arr1[i] with arr2[j]
        // COPY whoever is smaller; eg.. arr1[i] is smaller then copy arr1[i] to arr3, then increment i

        ArrayList<Integer> arr3 = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;
        int m = arr1.size();
        int n = arr2.size();

        while (i < m && j < n) {
            if (arr1.get(i) < arr2.get(j)) {
                arr3.add(arr1.get(i));
                i++;
                k++;
            }
            else {
                arr3.add(arr2.get(j));
                j++;
                k++;
            }
        }
        //IF ANY ELEMENT IS LEFT FROM ANY OF THE ARRAYS FROM MERGING
        for(; i < m; i++)
        {
            arr3.add(arr1.get(i));
            k++;
        }
        for(; j < n; j++)
        {
            arr3.add(arr2.get(i));
            k++;
        }
        //Theta(M+N) -> because it is a unknown & (M+N) is for merging
        return arr3;
    }
}