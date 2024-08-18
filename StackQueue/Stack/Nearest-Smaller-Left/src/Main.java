import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] nums1 = {19, 19, 19, 19, 19, 19, 19};
        int[] res = nearestSmallerLeftBrute(nums);
        System.out.println(Arrays.toString(res));
        int[] output = nearestSmallerLeft(nums);
        int[] output1 = nearestSmallerLeft(nums1);
        System.out.println(Arrays.toString(output));
        System.out.println(Arrays.toString(output1));
    }

    public static int[] nearestSmallerLeftBrute(int[] nums) {
        int[] res = new int[nums.length];

        //O(N^2) approach
        res[0] = -1;
        for (int i = 1; i < nums.length; i++) {
            boolean temp = true;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    res[i] = nums[j];
                    temp = false;
                    break;
                }
            }
            if (temp) {
                res[i] = -1;
            }
        }
        return res;
    }

    public static int[] nearestSmallerLeft(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        res[0] = -1;
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return res;
    }
}
