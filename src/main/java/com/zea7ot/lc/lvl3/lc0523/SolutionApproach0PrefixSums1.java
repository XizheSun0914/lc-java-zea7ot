/**
 * https://leetcode.com/problems/continuous-subarray-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/continuous-subarray-sum/discuss/99499/Java-O(n)-time-O(k)-space
 * 
 * the remainder theorem:
 * (a+(n*x))%x is same as (a%x)
 */
package com.zea7ot.lc.lvl3.lc0523;

import java.util.HashMap;
import java.util.Map;

public class SolutionApproach0PrefixSums1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // sanity check
        if(nums == null || nums.length == 0) return false;
        
        final int N = nums.length;
        Map<Integer, Integer> prefixSums = new HashMap<Integer, Integer>();
        prefixSums.put(0, -1);
        
        int runningSum = 0;
        for(int i = 0; i < N; i++){
            runningSum += nums[i];
            if(k != 0) runningSum %= k;
            Integer prevIdx = prefixSums.get(runningSum);
            if(prevIdx != null){
                if(i - prevIdx > 1) return true;
            }else{
                prefixSums.put(runningSum, i);
            }
        }
        
        return false;
    }
}