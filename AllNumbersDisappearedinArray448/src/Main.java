import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();

        //SORTING USING CYCLIC SORT
        int i = 0;
        int N = nums.length;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;//because [1-N]
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }
//        System.out.println(Arrays.toString(nums));//[1, 2, 3, 4, 3, 2, 7, 8]
        for(int j = 0; j < nums.length; j++)
        {
            if(nums[j] - 1 != j )
            {
                res.add(j+1);
            }
        }
        return res;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }
}