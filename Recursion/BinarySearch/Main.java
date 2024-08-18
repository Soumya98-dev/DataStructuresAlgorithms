public class Main{
	public static void main(String[] args){
		int[] arr = {1,2,3,4,55,66,78};
		int target = 66;
		System.out.println(binSea(arr, 0, arr.length - 1,target));
	}
	public static int binSea(int[] arr, int start, int end, int target){
		if(start > end){
			return -1;
		}

		int mid = (start + end) / 2;
//		System.out.println(mid);

		if(arr[mid] == target){
			return mid;
		} 

		if(target < arr[mid]){
			return binSea(arr, start, mid - 1, target);
		}

		return binSea(arr,mid + 1, end, target);
	}
}