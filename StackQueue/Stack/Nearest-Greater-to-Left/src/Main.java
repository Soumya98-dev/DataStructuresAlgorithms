import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
//        int[] res = nextGreaterLeftBrute(nums);
        int[] res = nextGreaterLeft(nums);
        System.out.println(Arrays.toString(res));
    }

//    public static int[] nextGreaterLeftBrute(int[] nums) {
//        int[] res = new int[nums.length];
//        res[0] = -1;
//
//        for (int i = 1; i < nums.length; i++) {
//            boolean temp = true;
//            for (int j = 0; j < i; j++) {
//                if (nums[j] > nums[i]) {
//                    res[i] = nums[j];
//                    temp = false;
//                    break;
//                }
//            }
//            if (temp) {
//                res[i] = -1;
//            }
//        }
//
//        return res;
//    }

    public static int[] nextGreaterLeft(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        res[0] = -1;
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}