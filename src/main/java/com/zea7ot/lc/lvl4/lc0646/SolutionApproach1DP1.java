/**
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-length-of-pair-chain/discuss/105602/easy-dp/155950
 */
package com.zea7ot.lc.lvl4.lc0646;

import java.util.Arrays;

public class SolutionApproach1DP1 {
    public int findLongestChain(int[][] pairs) {
        // sanity check
        if(pairs == null || pairs.length < 2) return 0;
        
        final int L = pairs.length;
        Arrays.sort(pairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int[] dp = new int[L];
        Arrays.fill(dp, 1);
        
        for(int i = 0; i < L; i++){
            for(int j = i - 1; j >= 0; j--){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        
        return dp[L - 1];
    }
}