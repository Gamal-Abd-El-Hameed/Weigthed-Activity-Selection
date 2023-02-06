/**
 * “I acknowledge that I am aware of the academic integrity guidelines of this course, and that I worked
 * on this assignment independently without any unauthorized help”
 */

package Solver;


import Classes.Activity;
import java.util.Arrays;
import java.util.Comparator;

public class Solver {
    public long solve(Activity[] A) {
        Arrays.sort(A, Comparator.comparingInt(Activity::finish));
        int n = A.length, weight, idx;
        long[] DP = new long[n];
        DP[0] = A[0].weight();
        for (int i = 1; i < n; ++i) {
            idx = binarySearch(A, i);
            weight = A[i].weight();
            if (idx != -1)
                weight += DP[idx];
            DP[i] = Math.max(weight, DP[i - 1]);
        }
        return DP[n - 1];
    }

    private int binarySearch(Activity[] A, int targetIndex) {
        int low = 0, high = targetIndex - 1, mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (noOverlapBetween(A[mid].finish(), A[targetIndex].start())) {
                if (noOverlapBetween(A[mid + 1].finish(), A[targetIndex].start()))
                    low = mid + 1;
                else
                    return mid;
            }
            else
                high = mid - 1;
        }
        return -1;
    }

    private boolean noOverlapBetween(int first, int second) {
        return first <= second;
    }
}
