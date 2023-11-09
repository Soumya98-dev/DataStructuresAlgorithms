//FOUND DUPLICATE ELEMENTS USING HASHING. O(N)

import java.util.*;
    //LINEAR(O(N))
public class Main {
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 1 };
        // int[] arr = { 1, 2, 3, 4 };
        // int[] arr = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        int[] arr = { 1, 5, -2, -4, 0 };
        // System.out.println(containsDuplicate(arr));
        containsDuplicate(arr);
    }

    public static void containsDuplicate(int[] arr) {
        ArrayList<Integer> hashMap = new ArrayList<>();
        // CREATING A HASHMAP
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);

        for (int i = 0; i <= max; i++) {
            hashMap.add(0);
        }
        System.out.println(hashMap);

        int i = 0;
        int count = 1;
        while (i < arr.length) {
            if (hashMap.get(arr[i]) >= 1) {
                hashMap.set(arr[i], ++count);
                // return true;
            }
            hashMap.set(arr[i], count);
            i++;
        }
        System.out.println(hashMap);
        // return false;
    }
}
     
}  
           
         
        
        
         
        

          
                
                
                  
                    
                
                
                
            
            
        
        
    