package MergeIntervals;
import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    // BruteForce(O(NLogN)
    // public static int[][] merge(int[][] intervals) {
    // ArrayList<int[]> res = new ArrayList<>();
    // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    // for (int i = 0; i < intervals.length; i++) {
    // int start = intervals[i][0];
    // int end = intervals[i][1];
    // for (int j = i + 1; j < intervals.length; j++) {
    // if (end >= intervals[j][0]) {
    // end = Math.max(end, intervals[j][1]);
    // i = j;
    // } else {
    // break;
    // }
    // }
    // res.add(new int[]{start, end});
    // }
    // return res.toArray(new int[res.size()][]);
    // }

    // Optimal
    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> res = new ArrayList<>();

        int[] curr = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (curr[1] < intervals[i][0]) {
                res.add(curr);
                curr = intervals[i];
            } else {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }

        res.add(curr);

        return res.toArray(new int[res.size()][]);
    }

}
