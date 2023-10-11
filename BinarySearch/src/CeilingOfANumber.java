//ELEMENT GREATER THAN OR EQUAL TO TARGET

public class CeilingOfANumber {
    static int binarySearchCeiling(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low <= high)
        {
            mid = Math.abs((low + high) /2);
            if(target == arr[mid])
            {
                return mid;
            }
            else if(target > arr[mid])
            {
                low = mid + 1;
            }
            else if(target < arr[mid])
            {
                high = mid - 1;
            }
        }
        if(arr[mid] > target)
        {
            return arr[mid];
        }
        return arr[mid + 1];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 4;
        System.out.println(binarySearchCeiling(arr,target));
    }
}
