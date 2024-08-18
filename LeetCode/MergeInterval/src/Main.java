import java.util.*;

public class Main {

    //Brute Force App
    public static List<List<Integer>> mergeIntervalBrute(int[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int lengthArr = arr.length;

        Comparator<int[]> com = new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        };

        Arrays.sort(arr, com);

        for (int i = 0; i < lengthArr; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            for (int j = i + 1; j < lengthArr; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }

    public static int[][] convertFromList(List<List<Integer>> lis){
        int 
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeIntervalBrute(arr);
        System.out.println(ans);
    }
}