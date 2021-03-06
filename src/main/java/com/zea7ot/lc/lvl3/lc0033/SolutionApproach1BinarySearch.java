/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * Time Complexity: O(lg(N))
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl3.lc0033;

public class SolutionApproach1BinarySearch {
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]){
                return mid;
            }else if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]){
                    right = mid;
                }else{
                    left = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }

        return nums[left] == target ? left : -1;
    }
}