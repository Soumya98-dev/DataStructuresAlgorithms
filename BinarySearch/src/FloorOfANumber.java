public class FloorOfANumber {
    static int binarySearchFloor(int[] arr, int key)
    {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;
        while(start <= end)
        {
            mid = Math.abs((start + end)/2);
            if(key == arr[mid])
            {
                return mid;
            }
            else if(key > arr[mid])
            {
                start = mid + 1;
            }
            else
            {
                end = mid - 1;
            }
        }
        if(arr[mid] < key)
        {
            return arr[mid];
        }
        return arr[mid - 1];
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 8;
        System.out.println(binarySearchFloor(arr,target));
     }
}
