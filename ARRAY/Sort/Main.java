import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = insertNums();
//		System.out.println(insertInSorted(nums, 18));
//		System.out.println(isSorted(nums));
        negativeOnLeft(nums);
        System.out.println(nums);
    }

    public static int sortedArray(int[] nums) {

        return 0;
    }

    public static ArrayList<Integer> insertNums() {
        ArrayList<Integer> nums = new ArrayList<>();
//		int[] arr = {4,8,13,18,20,25,28,33};
        int[] arr = {-6, 3, -8, 10, 5, -7, -9, 12, -4, 2};
        for (int i = 0; i < arr.length; i++) {
            nums.add(arr[i]);
        }
        return nums;

    }

    //	public static ArrayList<Integer> insertInSorted(ArrayList<Integer> nums, int element)
//	{
//		//SHIFT FROM THE LAST ELEMENT
//		int i = nums.size() - 1;
//		while(nums.get(i) > element)
//		{
//			nums.set(i + 1, nums.get(i));
//			i--;
//		}
//		return nums;
//	}
    public static boolean isSorted(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }//O(N)

    public static void negativeOnLeft(ArrayList<Integer> nums) {
        //int[] arr = {-6,3,-8,10,5,-7,-9,12,-4,2};
        //2 INDEX POINTERS(I,J)
        // i -> +ve numbers, j -> -ve numbers
        // i-> will continue until it finds a +ve no.
        // j -> will continue until it finds a -ve no.
        //swap the numbers; till i is less than j
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            while (nums.get(i) < 0) i++;
            while (nums.get(j) >= 0) j--;
            if (i < j) {
                int temp = nums.get(j);
                nums.set(j, i);
                nums.set(i, temp);
            }
        }
    }//O(N)
}


