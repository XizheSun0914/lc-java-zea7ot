/**
 * https://leetcode.com/problems/remove-covered-intervals/
 * 
 * Time Complexity:     O(N * lg(N))
 * 
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/remove-covered-intervals/discuss/451284/JavaPython-3-Simple-codes-w-explanation-and-analysis.
 *  https://leetcode.com/problems/remove-covered-intervals/discuss/451277/JavaC%2B%2BPython-Sort-Solution-Test-Cases-are-Trash
 */
package com.zea7ot.lc.lvl3.lc1288;

import java.util.Arrays;

public class SolutionApproach0SweepLine {
    public int removeCoveredIntervals(int[][] intervals) {
        // sanity checl
        if(intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int count = 0, cur = 0;
        for(int[] interval : intervals){
            int end = interval[1];
            if(cur < end){
                cur = end;
                ++count;
            }
        }
        
        return count;
    }
}