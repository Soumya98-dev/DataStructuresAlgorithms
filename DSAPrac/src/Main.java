import java.util.*;

public class Main {

    public static void main(String[] args) {
        // int[] nums = {-1,0,1,2,-1,-4};
        // int[] nums = {-2,0,3,-1,4,0,3,4,1,1,1,-3,-5,4,0};
        // int[] nums = {-2,0,1,3};
        // int target = 2;
        // System.out.println(threeSum(nums));
        // System.out.println(threeSumSmaller(nums, target));

        // int[] nums = {0,1,1,1};
        // int target = -100;
        // System.out.println(threeSumClosest(nums, target));

        // int[] nums = { -1, 0, -5, -2, -2, -4, 0, 1, -2};
        // int target = -9;
        // System.out.println(fourSum(nums, target));

        // int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15,
        // 14, 12, 16 } };
        // rotate(matrix);
        // String s = "leetcode";
        // System.out.println(firstUniqChar(s));
        // String s = "anagram";
        // String t = "nagaram";
        // System.out.println(isAnagram(s, t));
//        String s1 = "abcabcbb";
//        String s2 = "pwwkew";
//        String s3 = "bbbbb";
//        String s4 = " ";
//        String s5 = "au";
//        System.out.println(lengthOfLongestSubstring(s1));
//        System.out.println(lengthOfLongestSubstring(s2));
//        System.out.println(lengthOfLongestSubstring(s3));
//        System.out.println(lengthOfLongestSubstring(s4));
//        System.out.println(lengthOfLongestSubstring(s5));
//        String s = "abccccdd";
//        String s = "a";
//        String s = "ccc";
//        String s = "bananas";
//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
//        int[] nums = {-1, -100, 3, 99};
//        int k = 2;
//        rotate(nums, k);
//        System.out.println(Arrays.toString(nums));

//        int n = 5;
//        int[] arr = {1, 2, 3, 4, 5};
//        int n = 6;
//        int[] arr = {2, 4, 7, 8, 9, 10};
//        convertToWave(n, arr);
//        System.out.println(Arrays.toString(arr));
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
//        merge(nums1, m, nums2, n);
//        System.out.println(Arrays.toString(nums1));

//        int[] nums = {4,2,4,0,0,3,0,5,1,0};
//        moveZeroes(nums);
//        System.out.println(Arrays.toString(nums));

//        int[] nums = {1,2,3,4};
//        System.out.println(containsDuplicate(nums));

//        int[] nums = {1, 2, 3, 1, 2, 3};
//        int k = 2;
//        System.out.println(containsNearbyDuplicate(nums, k));

//        int[] nums = {0, 1, 2, 4, 5, 7};
//        System.out.println(summaryRanges(nums));

//        int[] nums = {3, 2, 2, 3};
//        int val = 3;

//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int val = 2;
//        System.out.println(removeElement(nums, val));

//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};
//        System.out.println(Arrays.toString(intersection(nums1, nums2)));

//        int[] nums1 = {1, 2, 2, 1};
//        int[] nums2 = {2, 2};

//        int[] nums1 = {4, 9, 5};
//        int[] nums2 = {9, 4, 9, 8, 4};
//        System.out.println(Arrays.toString(intersect(nums1, nums2)));

//        int[] arr = {3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
//        System.out.println(minSetSize(arr));


    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                    Collections.sort(temp);
                    if (set.add(temp)) {
                        res.add(temp);
                    }
                    j++;
                    k--;
                    if (nums[j] == nums[j - 1])
                        j++;
                    if (nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
        return res;
    }

    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        int n = nums.length;

        // Edge Cases: if length of nums < 3
        if (n < 3) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum >= target) {
                    right--;
                } else {
                    count += right - left;
                    left++;
                }
            }
        }
        return count;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // Edge Case:
        if (n < 3) {
            return 0;
        }
        int closestSum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // System.out.println("Sum" +sum);
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
                // System.out.println("Closest Sum" +closestSum);
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    break;
                }
            }
        }
        return closestSum;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 4) {
            return result;
        }
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;// after j
                int l = n - 1;// last element of the nums array
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> temp = new ArrayList<>(List.of(nums[i], nums[j], nums[k], nums[l]));
                        if (set.add(temp)) {
                            result.add(temp);
                        }
                        k++;
                        l--;
                    }
                }
            }
        }
        return result;
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // System.out.println(Arrays.deepToString(matrix));

        // Reverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][(matrix[i].length - 1) - j];
                matrix[i][(matrix[i].length - 1) - j] = temp;

            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();

        for (char ch : s.toCharArray())
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        // System.out.println(counts);

        for (int i = 0; i < s.length(); i++) {
            if (counts.get(s.charAt(i)) == 1)
                return i;
        }
        return 0;
    }

    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> frequencyS = new HashMap<>();
        // Counting occurances for s
        for (char ch : s.toCharArray())
            frequencyS.put(ch, frequencyS.getOrDefault(ch, 0) + 1);
        // Steps for checking anagram
        // 1. The length of the Strings
        if (s.length() != t.length()) {
            return false;
        }
        // 2. Making the counts is the hashmap 0
        for (int i = 0; i < t.length(); i++) {
            if (frequencyS.containsKey(t.charAt(i))) {
                frequencyS.put(t.charAt(i), frequencyS.get(t.charAt(i)) - 1);
            }
        }
        // 3. Verifying all the counts are 0
        for (int count : frequencyS.values()) {
            if (count != 0)
                return false;
        }
        return true;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) {
            return 1;
        }
        // Sliding Window
        int i = 0, j = 0;
        int maxCount = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (i < s.length()) {
            //1.Check if element is present in the hashmap
            if (hs.containsKey(s.charAt(i))) {
                hs.remove(s.charAt(j));
                j++;
            } else {
                hs.put(s.charAt(i), j);
                i++;
            }
            if (hs.size() > maxCount) {
                maxCount = hs.size();
            }
        }
        return maxCount;
    }

    public static int longestPalindrome(String s) {
        int maxCount = 0;
        boolean hasOdd = false;
        HashMap<Character, Integer> freq = new HashMap<>();
        //1.Counting frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        if (freq.size() == 1) {
            for (int count : freq.values()) {
                maxCount = count;
            }
            return maxCount;
        }
        //2.Calculating no. of pairs to be formed from this frequency
        //2.a) Even: means all the maxCount
        for (int count : freq.values()) {
            if (count % 2 == 0) {
                maxCount += count;
            }
        }
        //2,b) Odd: Only add one of it
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                maxCount += count - 1;
                hasOdd = true;
            }

        }

        if (hasOdd) {
            maxCount += 1;
        }

        return maxCount;
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static int[] reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        return nums;
    }

    public static void convertToWave(int n, int[] arr) {
        for (int i = 0; i < arr.length - 1; i = i + 2) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        Output: [1,2,2,3,5,6]
//        if (nums1.length == 1 && nums2.length == 1) {
//            nums1[0] = nums2[0];
//        }
//
//        for (int i = 0; i < nums2.length; i++) {
//            nums1[nums1.length - (i + 1)] = nums2[i];
//        }
//
//        Arrays.sort(nums1);
        int i = m - 1;
        int k = nums1.length - 1;
        int j = n - 1;

        for (int l = 0; l < nums1.length; l++) {
            if (nums1[i] > nums2[j]) {

            }
        }

    }

    public static void moveZeroes(int[] nums) {
        int curr = 0;
        int lNonZero = 0;

        while (curr != nums.length) {
            if (nums[curr] != 0) {
                int temp = nums[lNonZero];
                nums[lNonZero] = nums[curr];
                nums[curr] = temp;
                lNonZero++;
            }
            curr++;
        }

    }

    public static boolean containsDuplicate(int[] nums) {
        //O(nlogn)-time, O(1) -Space
//        Arrays.sort(nums);
//        int i = 0;
//        while (i < nums.length - 1) {
//            if (nums[i] == nums[i + 1]) {
//                return true;
//            }
//            i++;
//        }
//        return false;

        //O(n)
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int ele : nums) {
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }
        for (int count : freq.values()) {
            if (count >= 2) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (dict.containsKey(nums[i])) {
                if (Math.abs(i - dict.get(nums[i])) <= k) {
                    return true;
                }
            }
            dict.put(nums[i], i);
        }
        return false;
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();
        //Edge Case
        if (nums.length == 0) {
            return ranges;
        }
        //1st pointer
        int start = nums[0];
        //2nd pointer
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                //For checking if there is a range
                if (start == nums[i - 1]) {
                    ranges.add(String.valueOf(nums[i]));
                } else {
                    ranges.add(start + "->" + nums[i - 1]);
                }
                start = nums[i];
            }
        }

        //For the last range
        if (start == nums[nums.length - 1]) {
            ranges.add(String.valueOf(start));
        } else {
            ranges.add(start + "->" + nums[nums.length - 1]);
        }

        return ranges;
    }

    class NumArray {
        private static int[] prefixSum;

        public NumArray(int[] nums) {
            prefixSum = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    prefixSum[0] = nums[0];
                } else {
                    prefixSum[i] = prefixSum[i - 1] + nums[i];
                }
            }
        }

        public static int sumRange(int left, int right) {
            if (left == 0) {
                return prefixSum[right];
            }
            return prefixSum[right] - prefixSum[left - 1];
        }
    }

    class NumMatrix {
        int[][] prefixSum;

        public NumMatrix(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            prefixSum = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int top = i > 0 ? prefixSum[i - 1][j] : 0;
                    int left = j > 0 ? prefixSum[i][j - 1] : 0;
                    int topLeft = i > 0 && j > 0 ? prefixSum[i - 1][j - 1] : 0;
                    prefixSum[i][j] = top + left - topLeft + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int top = row1 > 0 ? prefixSum[row1 - 1][col2] : 0;
            int left = col1 > 0 ? prefixSum[row2][col1 - 1] : 0;
            int topLeft = row1 > 0 && col1 > 0 ? prefixSum[row1 - 1][col1 - 1] : 0;
            return prefixSum[row2][col2] - top - left + topLeft;
        }
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        //Converting nums1 to a set
        Set<Integer> nums1Set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums1Set.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i] = num;
            i++;
        }
        return res;

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //To store the results temporarily
        ArrayList<Integer> res = new ArrayList<>();

        //To store the count of elements of nums1
        HashMap<Integer, Integer> count = new HashMap<>();

        //Calculating the frequencies of the nums1
        for (int ele : nums1) {
            count.put(ele, count.getOrDefault(ele, 0) + 1);
        }

        //Filling the res
        for (int ele : nums2) {
            if (count.containsKey(ele) && count.get(ele) > 0) {
                res.add(ele);
                count.put(ele, count.get(ele) - 1);
            }
        }

        int[] result = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;

    }

    public static int minSetSize(int[] arr) {
        int n = arr.length;

        //Determine the threshold
        int toRemove = (int) Math.ceil(n / 2);
        System.out.println(toRemove);
        int res = 0;
        HashMap<Integer, Integer> frequencies = new HashMap<>();

        //Counting frequencies
        for (int ele : arr) {
            frequencies.put(ele, frequencies.getOrDefault(ele, 0) + 1);
        }

        //Convert the values(frequencies) from hashmap into a list
        ArrayList<Integer> vals = new ArrayList<>(frequencies.values());

        //Sorting the array in reverse order
        Collections.sort(vals, Collections.reverseOrder());


        System.out.println(vals);

        System.out.println(frequencies);
        return res;
    }



}

