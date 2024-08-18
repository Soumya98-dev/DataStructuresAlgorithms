import java.util.Arrays;

public class FindDuplicateNumber287 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;//[1-N]
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] - 1 != j)
            {
                return nums[j];
            }
        }
        return 0;
    }

    private static void swap(int[] nums, int first, int last) {
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }


}
