import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 8, 5, 2, 25};
        int[] res = nearestSmallerRightBrute(nums);
        int[] res1 = nearestSmallerRight(nums);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res1));
    }

    public static int[] nearestSmallerRightBrute(int[] nums) {
        int[] res = new int[nums.length];

        //O(N^2)
        for (int i = 0; i < nums.length; i++) {
            boolean temp = true;
            for (int j = i + 1; j < nums.length; j++) {
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

    public static int[] nearestSmallerRight(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            res[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return res;
    }
}
