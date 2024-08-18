public class IfArraySorted {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 8, 9, 12};
        System.out.println(arraySorted(arr));

        System.out.println(arraySortedRecursion(arr, 0));
    }

    static boolean arraySorted(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }

        return true;
    }


    static boolean arraySortedRecursion(int[] arr, int index) {
        if (arr.length <= 1 || index == arr.length - 1) {
            return true;
        }

        return arr[index] <= arr[index + 1] && arraySortedRecursion(arr, index + 1);
    }
}