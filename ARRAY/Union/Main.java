import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = array1();
        ArrayList<Integer> arr2 = array2();
        System.out.println(arr1 + " " + arr2);
        System.out.println(union(arr1, arr2));
    }

    public static ArrayList<Integer> array1() {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nums = {3, 4, 5, 6, 10};
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        return arr;
    }

    public static ArrayList<Integer> array2() {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] nums = {2, 4, 5, 7, 12};
        for (int i = 0; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        return arr;
    }

    public static ArrayList<Integer> union(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> unionArr = new ArrayList<>();
        /*
        //BRUTE FORCE APPROACH(O(N^2))
        //1ST: COPYING ALL OF arr1 to the unionArr
        for (int i = 0; i < arr1.size(); i++) {
            unionArr.add(arr1.get(i));
        }
        //2nd: Now checking if any elements from arr2 is present in unionArr, then will push it otherwise ignore it
        for (int i = 0; i < arr2.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < unionArr.size(); j++) {
                if (arr2.get(i) == unionArr.get(j)) {
                    flag = false;
                }
            }
            if (flag) {
                unionArr.add(arr2.get(i));
            }
        }
        */

        //LINEAR APPROACH(Theta(M+N))
        int i = 0;//arr1 index
        int j = 0;// arr2 index
//        int k = 0;// unionArr index
        int m = arr1.size();//length of arr1
        int n = arr2.size(); //length of arr2

        while(i < m && j < n)
        {
            if(arr1.get(i) < arr2.get(j))
            {
                unionArr.add(arr1.get(i));
                i++;
//                k++;
                continue;
            }
            if(arr2.get(j) < arr1.get(i))
            {
                unionArr.add(arr2.get(j));
                j++;
//                k++;
                continue;
            }
            if(arr1.get(i) == arr2.get(j))
            {
                unionArr.add(arr2.get(j));
                i++;
                j++;
//                k++;
                continue;
            }
        }

        for (; i < m; i++) {
            unionArr.add(arr1.get(i));
        }
        for (; j < n; j++) {
            unionArr.add(arr2.get(j));
        }

        return unionArr;
    }
}