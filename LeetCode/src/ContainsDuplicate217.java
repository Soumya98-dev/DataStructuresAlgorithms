import java.util.Arrays;

public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i; j < nums.length - 1; j++) {
                if (nums[i] == nums[j+1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
