import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 18, 18, 9, 18};
        int target = 18;
//        System.out.println(linearSearch(arr, target, 0));
        System.out.println(linearSearchAll(arr, target, 0, new ArrayList<>()));
    }

    static int linearSearch(int[] arr, int target, int index) {
        if (arr.length < 1 || index == arr.length - 1) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        } else {
            return linearSearch(arr, target, index + 1);
        }

    }

//    static ArrayList<Integer> list = new ArrayList<>();

    static ArrayList<Integer> linearSearchAll(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (arr.length <= index) {
            return list;
        }

        if (arr[index] == target) {
            list.add(index);
        }
        return linearSearchAll(arr, target, index + 1, list);

    }
}
