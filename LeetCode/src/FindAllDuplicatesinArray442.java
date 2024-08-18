import java.util.*;

public class FindAllDuplicatesinArray442 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();

        //Cycle Sort
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1; //[1-N]
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
//        System.out.println(Arrays.toString(nums));
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] - 1 != j)
            {
                res.add(nums[j]);
            }
        }
        return res;
    }

    public static void swap(int[] nums, int first, int last) {
        int temp = nums[first];
        nums[first] = nums[last];
        nums[last] = temp;
    }
}
