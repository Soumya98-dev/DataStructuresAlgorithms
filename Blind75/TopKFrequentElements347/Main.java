import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums = {1};
//        int k = 2;
        int k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
//        topKFrequent(nums, k);
    }
    /*
    //O(n log n) -> Brute force approach
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        // COUNTING THE FREQUENCY OF EACH ELEMENT IN THE 'nums' ARRAY: O(N) -> Building the counts hashmap
//        for (int num : nums) {
//            counts.put(num, counts.getOrDefault(num, 0) + 1);
//        }
        for(int i = 0; i < nums.length; i++)
        {
            if(!counts.containsKey(nums[i]))
            {
                counts.put(nums[i], 1);
            }
            else
            {
                //counts.get(nums[i]) -> returns the value to which the specific key is mapped
                int currentCount = counts.get(nums[i]);
                currentCount++;
                counts.put(nums[i], currentCount);
            }
        }//{1=3, 2=2, 3=1}
        //CONVERTING HASHMAP ENTRY TO A LIST
        List<Map.Entry<Integer, Integer>> newList = new ArrayList<>(counts.entrySet());
//        System.out.println(newList);
        //SORTING THE LIST FROM BIG TO SMALL
        newList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//        System.out.println(newList);
        //TAKING THE SLICE OF FIRST 2 ELEMENTS FROM THE SORTED LIST
        //USING THE "LINKEDHASHMAP" BECAUSE IT MAINTAINS THE ORDER IN WHICH THE ELEMENTS ARE INSERTED
        Map<Integer, Integer> sortedList = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry: newList.subList(0, k))
        {
            sortedList.put(entry.getKey(), entry.getValue());
        }
//        System.out.println(sortedList);
        return sortedList.keySet().stream().mapToInt(Integer::intValue).toArray();
    }
     */

}
