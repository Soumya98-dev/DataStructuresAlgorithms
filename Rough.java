import java.util.*;

public class Rough {
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
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
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
        // Sliding Window
        char first = s.charAt(0);
        char last = s.charAt(0);
        int maxCount = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hs.containsKey(s.charAt(i))) {
                first++;
                hs.remove(first);
                if (hs.size() > maxCount) {
                    maxCount = hs.size();
                }
            } else {
                hs.put(lastPtr, i);
                lastPtr++;
            }

        }
        return count;
    }

}
