//import java.util.Arrays;
//import java.util.HashMap;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
//        System.out.println(rough(strs));
    }

//    public static List<List<String>> groupAnagrams(String[] strs) {
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
//    }

    //TIME: m*nlogn -> m: length of the input array, nlogn: sorting
    public static List<List<String>> groupAnagrams(String[] strs) {
        //CREATING A HASHMAP
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // "toCharArray" -> converts the string to a new character array
            char[] charArr = strs[i].toCharArray();
            //SORTING EVERY STRING IN THE ARRAY
            Arrays.sort(charArr);
            //"String.valueOf()" -> returns the string representation of the char array
            String sortedStr = String.valueOf(charArr);
            if (!hashMap.containsKey(sortedStr)) {
                //EVERYTIME THE "hashMap" ENCOUNTERS A NEW STR IT WILL ADD IT AND CREATE A SUBSEQUENT NEW LIST FOR IT
                hashMap.put(sortedStr, new ArrayList<>());
            }
            hashMap.get(sortedStr).add(strs[i]);
        }
        //"hashMap.values()" returns all the values of the HASHMAP
        return new ArrayList<>(hashMap.values());
    }
}