public class PeakInMountainArray852 {
    public static int search(int[] arr, int target)
    {
        int peak = peakIndexInAMountainArray(arr);
        int bSearch = binarySearch(arr, target, 0, peak);
        if(bSearch != -1)
        {
            return bSearch;
        }
        return binarySearch(arr, target, peak+1, arr.length - 1);
    }
    public static int peakIndexInAMountainArray(int[] arr)
    {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while(start < end)
        {
            mid = Math.abs((start + end)/2);
            if(arr[mid] > arr[mid + 1])
            {
                //FOR THE DESCENDING PART OF ARRAY
                end = mid;
            }
            else
            {
                //FOR ASCENDING PART OF ARRAY
                start = mid + 1;
            }
        }
        return mid;
    }
    public static int binarySearch(int[] arr, int target, int start, int end)
    {
        while(start <= end)
        {
            int mid = Math.abs((start + end) / 2);
            if(target == arr[mid])
            {
                return mid;
            }
            else if(target > mid)
            {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
//        System.out.println(peakIndexInAMountainArray(arr));
//        System.out.println(binarySearch(arr, 10, 0, 3));
        System.out.println(search(arr,3));
    }
}
