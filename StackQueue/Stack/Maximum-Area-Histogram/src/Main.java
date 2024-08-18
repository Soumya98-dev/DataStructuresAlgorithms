import java.util.Stack;
import java.util.Arrays;

class Pair{
    int index;
    int value;

    public Pair(int value, int index){
        this.index = index;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        // int[] arr = {6, 2, 5, 4, 5, 1, 6};
        // int[] arr = {2,1,5,6,2,3};
        // int[] arr = {2,4};
        int[] arr = {1,1};
       System.out.println(mah(arr));
        System.out.println(Arrays.toString(nearestSmallerLeft(arr)));
        System.out.println(Arrays.toString(nearestSmallerRight(arr)));
    }

    //calculating the max area of histogram
    public static int mah(int[] arr) {
        int highestArea = 0;
        int[] areaArr = area(arr);

        for (int i = 0; i < areaArr.length; i++) {
            if (areaArr[i] > highestArea) {
                highestArea = areaArr[i];
            }
        }
        return highestArea;
    }

    //returning the area array
    public static int[] area(int[] arr) {
        int[] width = widthHist(arr);
        int[] ar = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ar[i] = arr[i] * width[i];
        }
        return ar;
    }

    //finding the width of the histogram
    public static int[] widthHist(int[] arr) {
        int[] left = nearestSmallerLeft(arr);
        int[] right = nearestSmallerRight(arr);
        int[] width = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            width[i] = (right[i] - left[i]) - 1;
        }
        return width;
    }

    public static int[] nearestSmallerRight(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && stack.peek().value >= arr[i]){
                stack.pop();
            }

            res[i] = stack.isEmpty() ? arr.length : stack.peek().index;

            stack.push(new Pair(arr[i],i));
        }
        return res;
    }

    public static int[] nearestSmallerLeft(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Pair> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++)
        {
            while(!stack.isEmpty() && stack.peek().value >= arr[i]){
                stack.pop();
            }
            
            res[i] = stack.isEmpty() ? -1 : stack.peek().index;
            
            stack.push(new Pair(arr[i],i));
        }
        return res;
    }
}
