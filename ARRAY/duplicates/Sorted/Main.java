import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		int[] arr = {3,6,8,8,10,12,15,15,15,20};
		System.out.println(duplicates(arr));
		System.out.println(countDuplicates(arr));
	}
	public static ArrayList<Integer> duplicates(int[] arr)
	{
		ArrayList<Integer> res = new ArrayList<>();
		int duplicateValue = 0;
		int i = 0;
		int m = arr.length;

		while(i < m - 1)
		{
			if(arr[i] == arr[i+1] && arr[i] != duplicateValue)
			{
				duplicateValue = arr[i];
				res.add(duplicateValue);
			}
			i++;			
		}
		return res;
	}
	public static ArrayList<Integer> countDuplicates(int[] arr)
	{
		//O(N) -> BECAUSE THE WHILE LOOP IS NOT GETTING RUNNED EVERY TIME
		ArrayList<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0; //TO COUNT THE DUPLICATES
		int m = arr.length;

		while(i < m - 1)
		{
			if(arr[i] == arr[i+1])
			{
				j = i + 1;
				while(arr[j] == arr[i])
				{
					j++;
				}
				res.add(j - i);
				i = j - 1;
			}
			i++;
		}
		return res;
	}
}