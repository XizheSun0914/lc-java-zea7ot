/**
 * https://leetcode.com/problems/meeting-scheduler/
 * 
 * Time Complexity:     O(max(N1, N2) * lg(max(N1, N2)))
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/meeting-scheduler/discuss/408491/JavaC%2B%2B-Two-Pointer-Clean-code-O(NlogN)-for-Sorting-Beat-100
 */
package com.zea7ot.lc.lvl3.lc1229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproach0TwoPointers {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));

        int idx1 = 0, idx2 = 0;
        final int N1 = slots1.length, N2 = slots2.length;
        while(idx1 < N1 && idx2 < N2){
            int intersectStart = Math.max(slots1[idx1][0], slots2[idx2][0]);
            int intersectEnd = Math.min(slots1[idx1][1], slots2[idx2][1]);

            if(intersectStart + duration <= intersectEnd){
                return Arrays.asList(intersectStart, intersectStart + duration);
            }else if(slots1[idx1][1] < slots2[idx2][1]) ++idx1;
            else ++idx2;
        }

        return new ArrayList<Integer>();
    }
}