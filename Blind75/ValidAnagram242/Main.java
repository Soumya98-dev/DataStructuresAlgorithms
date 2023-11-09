public class Main {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        int[] nums = new int[26]; //No of alphabets: 26

        for (int i = 0; i < s.length(); i++) {
            //WE ARE TAKING 'a' because 'a'(97) - 'a' = 0 z'(122) - 'a'(97)= 25 nad we have created an array of length of only 26
            nums[s.charAt(i) - 'a']++;
            nums[t.charAt(i) - 'a']--;
        }

        for (int n : nums) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}