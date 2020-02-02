package test;

import impl.MergeIntervals;

public class MergeIntervalsTest {
    public static void main(String[] args) {
        MergeIntervals test = new MergeIntervals();
        int[][] intervals = init();
        int[][] mergedIntervals = test.merge(intervals);
        print(mergedIntervals);
    }

     static int[][] init() {
        int[][] intervals = new int[4][2];
        intervals[0] = new int[]{1,3};
        intervals[0] = new int[]{2,6};
        intervals[0] = new int[]{8,10};
        intervals[0] = new int[]{15,18};

        return intervals;
    }

    static void print(int[][] mergedIntervals) {
        System.out.print("[");
        for (int[] interval : mergedIntervals) {
            System.out.print("[" + interval[0] + "," + interval[1] + "],");
        }
        System.out.println("]");
    }
}
