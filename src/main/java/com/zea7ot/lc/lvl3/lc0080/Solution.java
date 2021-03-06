/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
package com.zea7ot.lc.lvl3.lc0080;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num : nums){
            if(i < 2 || num > nums[i - 2]){
                nums[i++] = num;
            }
        }
        
        return i;
    }
}