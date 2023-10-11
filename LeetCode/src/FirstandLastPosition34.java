import java.util.Arrays;

public class FirstandLastPosition34 {

    static int[] searchRange(int[] nums, int target)
    {
        int[] res = {-1,-1};
        int startIndex = search(nums, target, true);
        int lastIndex = search(nums, target, false);

        res[0] = startIndex;
        res[1] = lastIndex;

        return res;
    }

    static int search(int[] nums, int target, boolean firstIndex)
    {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end)
        {
            int mid = Math.abs((start + end)/2);
            if(target > nums[mid])
            {
                start = mid + 1;
            }
            else if(target < nums[mid])
            {
                end = mid - 1;
            }
            else
            {
                ans = mid;
                if(firstIndex)
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }

}
