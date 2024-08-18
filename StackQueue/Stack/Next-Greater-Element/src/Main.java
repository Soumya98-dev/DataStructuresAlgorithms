import java.util.*;

public class Main {
    public static void main(String[] args) {
        long[] arr = {7, 8, 1, 4};
//        System.out.println(oneArr(arr));
        long[] res = nextLargerElement(arr, arr.length);
        for (long item : res) {
            System.out.println(item);
        }
    }

//    public static ArrayList<Integer> oneArr(int[] arr) {
//        ArrayList<Integer> res = new ArrayList<>();
//        boolean temp = true;
//
//        //O(N^2): Brute force Approach
//        for (int i = 0; i < arr.length; i++) {
//            if (i == arr.length - 1) {
//                res.add(-1);
//                break;
//            }
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > arr[i]) {
//                    res.add(arr[j]);
//                    temp = false;
//                    break;
//                }
//            }
//            if (temp) {
//                res.add(-1);
//            }
//        }
//        return res;
//    }

    //O(N^2): Brute force Approach
//    public static long[] nextLargerElement(long[] arr, int n) {
//        // Your code here
//        ArrayList<Long> res = new ArrayList<>();
//
//        for (int i = 0; i < arr.length; i++) {
//            boolean temp = true;
//            if (i == arr.length - 1) {
//                res.add(-1L);
//                break;
//            }
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[j] > arr[i]) {
//                    res.add(arr[j]);
////                    System.out.println(res);
//                    temp = false;
//                    break;
//                }
//            }
//            if (temp) {
//                res.add(-1L);
//            }
//        }
//        long[] outputArr = new long[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            outputArr[i] = res.get(i);
//        }
//
//        return outputArr;
//    }

    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long[] result = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return result;
    }

}
