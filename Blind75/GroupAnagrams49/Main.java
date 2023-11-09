//import java.util.Arrays;
//import java.util.HashMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
//        System.out.println(rough(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //STEP1: SORT EACH STR
        //STEP2:
        
//        char[] newArr = new char[3];
//        String strs0 = strs[0];
//        for (int i = 0; i < strs0.length(); i++) {
//            char ch = strs0.charAt(i);
//            newArr[i] = ch;
//        }
//        Arrays.sort(newArr);
//        String str = String.valueOf(newArr);
////        System.out.println(str);
//        //STEP2: CREATE A HASHMAP
//        HashMap<String, List<String>> hashMap = new HashMap<>();
//        for (int i = 0; i < strs.length; i++) {
//            hashMap.put(str, new ArrayList<>());
//        }
//        return new ArrayList<>(hashMap.values());
    }

//    public static boolean rough(String[] strs) {
//
//        return false;
//    }
}