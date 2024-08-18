import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] nums1 = {4, 1, 2};
//        int[] nums2 = {1, 3, 4, 2};
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] res = nextGreaterElement(nums1, nums2);
        for (int r : res) {
            System.out.print(r+" ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<Integer, Integer>();
        int[] result = new int[nums1.length];

        //Putting the element and their rightmost greater in the hashmap
        for (int nums : nums2) {
            while (!stack.isEmpty() && stack.peek() < nums) {
                nextGreaterMap.put(stack.pop(), nums);
            }
            stack.push(nums);
        }

        //checking the element from nums1 and matching with hashmap to check the rightmost greater in nums1
        for (int nums = 0; nums < nums1.length; nums++) {
            result[nums] = nextGreaterMap.getOrDefault(nums1[nums], -1);
        }
        return result;
    }
}
