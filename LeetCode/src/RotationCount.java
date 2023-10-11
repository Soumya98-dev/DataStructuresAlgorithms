/*
arr[] = {15, 18, 2, 3, 6, 12} -> OUTPUT:2
FIND HOW MANY TIMES THE ARRAY IS ROTATED:
For e.g.,
The array before rotation was arr[] = {2,3,6,12,15,18}
1st Rotation: arr[] = {18,2,3,6,12,15}
2nd Rotation: arr[] = {15,18,2,3,6,12}
*/


public class RotationCount {
    //LINEAR SEARCH
    // TIME COMPLEXITY: O(N)
    public static int rotationCountLS(int[] nums)
    {
        int output = 0;
        int min = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] < min)
            {
                min = nums[i];
                output = i;
            }
        }
        return output;
    }
    //BINARY SEARCH
    //TIME: 0(LOG N)
    public static int rotationCountBS(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end)
        {
            int mid = Math.abs((start + end)/2);
            if(nums[mid - 1] > nums[mid])
            {
                return mid;
            }

        }
        return -1;
    }
    public static void main(String[] args) {
//        int[] arr = {15, 18, 2, 3, 6, 12};
        int[] arr = {7, 9, 11, 12, 15};
        System.out.println(rotationCountLS(arr));
    }
}
