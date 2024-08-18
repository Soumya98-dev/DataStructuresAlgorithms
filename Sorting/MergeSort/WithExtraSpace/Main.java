public class Main {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        divide(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void divide(int[] arr, int s, int e) {
        int mid = s + (e - s) / 2;

        if (s >= e) {
            return;
        }

        //recursive calls
        //left array
        divide(arr, s, mid);
        //right array
        divide(arr, mid + 1, e);

        //conquer
        conquer(arr, s, e, mid);
    }

    public static void conquer(int[] arr, int start, int end, int mid) {
        int[] mergedArr = new int[(end - start + 1)];
        int index1 = start;//left array
        int index2 = mid + 1;//right array
        int x = 0;//for the merged array
        while (index1 <= mid && index2 <= end) {
            if (arr[index1] <= arr[index2]) {
                mergedArr[x] = arr[index1];
                x++;
                index1++;
            } else {
                mergedArr[x] = arr[index2];
                x++;
                index2++;
            }
        }
        while (index1 <= mid) {
            mergedArr[x] = arr[index1];
            x++;
            index1++;
        }

        while (index2 <= end) {
            mergedArr[x] = arr[index2];
            x++;
            index2++;
        }

        for (int i = 0, j = start; i < mergedArr.length; i++, j++) {
            arr[j] = mergedArr[i];
        }
    }

}