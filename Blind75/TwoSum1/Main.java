import java.util.*;

public class Main {
    public static void main(String[] args) {
       
        int[] nums = {3,3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /*
        public static int[] twoSum(int[] nums, int target) {
            int[] res = new int[2];
            HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
            //INSERTING THE ELEMENTS IN THE HASH TABLE AS KEY-VALUE PAIRS
            for (int i = 0; i < nums.length; i++) {
                hash.put(nums[i], i);
            }

            //Checking for the sum
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (hash.containsKey(diff)) {
                    res[0] = hash.get(diff);
                    res[1] = i;
                }
            }
            return res;
        }
    */

    public static int[] twoSum(int[] nums, int target)
    {
        int[] res = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++)
        {   
            int diff = target - nums[i];
            if(hash.containsKey(diff))
            {
                res[0] = hash.get(diff);
                res[1] = i;
            }
            hash.put(nums[i], i);
        }
        return res;
    }
}










