//33. Search in Rotated Sorted Array
/*
 * STEPS:
 *  nums = [4,5,6,7,0,1,2]
 * FOR FINDING THE PIVOT
 * CASE 1: Find Pivot(The maximum in the array) -> nums[mid] > nums[mid + 1] => PIVOT: mid
 * CASE 2: nums[mid] < nums[mid - 1] => PIVOT: mid - 1
 * CASE 3: nums[start] >= nums[mid] :: All elements from mid < start. Ignore all these elements because we are looking for pivot. => end = mid - 1
 * CASE 4: nums[start] < nums[mid] :: Then it signifies it is a sorted array => start = mid + 1
 * Search in 1st half(0 - pivot)
 * Search in 2nd half(pivot + 1 - end)
 * FOR SEARCHING AFTER FINDING PIVOT
 * arr = [4,5,6,7,0,1,2]
 * CASE 1: PIVOT ELEMENT = TARGET
 * CASE 2: target > start ; then we can search for our target from start to pivot - 1, because after pivot all elements are smaller than start
 * CASE 3: target < start; then we can search for our target from pivot + 1 to end
 * */
public class SearchinRotatedSortedArray33 {
    public static int search(int[] nums, int target) {
        int pivot = pivot(nums);
        //IF WE CANNOT FIND A PIVOT IT MEANS ARRAY NOT ROTATED
        if (pivot == -1) {
            //NORMAL BINARY SEARCH
            return binarySearch(nums, 0, nums.length - 1, target);
        }

        //CASE 1
        if (nums[pivot] == target) {
            return pivot;
        }
        //CASE 2
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        }
        //CASE 3
        else {
            return binarySearch(nums, pivot + 1, nums.length - 1, target);
        }
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = Math.abs((start + end) / 2);
            if (target < nums[mid]) {
                end = mid - 1;
            }else if (target > nums[mid]) {
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    //FOR PIVOT WITHOUT DUPLICATES
    public static int pivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = Math.abs((start + end) / 2);
            //PIVOT CASE 1
            //mid < end => because while doing nums[mid + 1] it shouldn't exceed the size of array
            if (mid < end && (nums[mid] > nums[mid + 1])) {
                return mid;
            }
            //PIVOT CASE 2
            //mid > start => because while doing nums[mid - 1] it shouldn't exceed the size of array
            if (mid > start && (nums[mid] < nums[mid - 1])) {
                return mid - 1;
            }
            //PIVOT CASE 3
            if (nums[mid] <= nums[start]) {
                end = mid - 1;
            }
            //PIVOT CASE 4
            else {
                start = mid + 1;
            }

        }
        return -1;
    }

    //FOR PIVOT WITH DUPLICATES
    public static int duplicatePivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = Math.abs((start + end) / 2);
            //PIVOT CASE 1
            //mid < end => because while doing nums[mid + 1] it shouldn't exceed the size of array
            if (mid < end && (nums[mid] > nums[mid + 1])) {
                return mid;
            }
            //PIVOT CASE 2
            //mid > start => because while doing nums[mid - 1] it shouldn't exceed the size of array
            if (mid > start && (nums[mid] < nums[mid - 1])) {
                return mid - 1;
            }
            //IF MID=START=END
            if(nums[mid] == nums[start] || nums[start] == nums[end])
            {
                if(nums[start] > nums[start + 1])
                {
                    return start;
                }
                else
                {
                    start++;
                }
                if(nums[end] < nums[end - 1])
                {
                    return end - 1;
                }
                else
                {
                    end--;
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,3,2,1,0};
//        int[] nums = {4,5,6,7,0,1,2};
//        int[] nums = {1};
//        int[] nums = {1,3};
//        int[] nums = {3,5,1};
//        System.out.println(pivot(nums));
        System.out.println(search(nums, 6));
    }
}
