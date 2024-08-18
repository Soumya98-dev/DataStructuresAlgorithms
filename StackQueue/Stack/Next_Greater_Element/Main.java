import java.util.*;

public class Main {
    public static void main(String[] args){
        // int[] arr = {1,3,0,0,1,4,2};
        int[] arr = {13 , 7, 6 , 12};
        System.out.println(oneArr(arr));
    }

    public static ArrayList<Integer> oneArr(int[] arr)
    {
        ArrayList<Integer> res = new ArrayList<>();
        boolean temp = true;

        //O(N^2): Brute force Approach
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = i + 1; j <= arr.length; j++)
            {
                if(j == arr.length){
                    res.add(-1);
                    break;
                }
                if(arr[j] > arr[i])
                {
                    res.add(arr[j]);  
                    temp = false;
                    break;                     
                }
            }
            if(temp == true){
                res.add(-1);
            }
        }
        return res;
    }
}