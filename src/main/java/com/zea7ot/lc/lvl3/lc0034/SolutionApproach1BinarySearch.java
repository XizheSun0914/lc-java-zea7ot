/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Time Complexity: O(2 * lg(N)) ~ O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0034;

public class SolutionApproach1BinarySearch {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if(nums == null || nums.length == 0) return range;
        
        int leftIdx = search(nums, target, true);
        if(leftIdx == nums.length || nums[leftIdx] != target) return range;
        
        range[0] = leftIdx;
        range[1] = search(nums, target, false) - 1;
        
        return range;
    }
    
    private int search(int[] nums, int target, boolean left){
        int low = 0, high = nums.length;
        
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > target || (left && nums[mid] == target))
                high = mid;
            else low = mid + 1;
        }
        
        return low;
    }
}