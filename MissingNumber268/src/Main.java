import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
//        System.out.println(Arrays.toString(nums));
    }

    public static int missingNumber(int[] nums) {
        int i = 0;
        int N = nums.length;
        //SORTS THE ARRAY
        while (i < nums.length) {
            int currentIndex = nums[i];
//            System.out.println(currentIndex);
            if (nums[i] != N && nums[i] != nums[currentIndex]) {
//                System.out.println(nums[i]);
                swap(nums, i, currentIndex);
            } else {
                i++;
            }
        }
        //FINDS THE MISSING INDEX
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i) {
                return i;
            }
            i++;
        }
        return nums.length;
    }

    private static void swap(int[] nums, int first, int last) {
        int temp = nums[last];
        nums[last] = nums[first];
        nums[first] = temp;
    }

}