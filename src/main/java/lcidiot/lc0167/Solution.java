/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
package main.java.lcidiot.lc0167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        
        while(left < right){
            int sum = numbers[left] + numbers[right];
            
            if(sum == target) return new int[]{left + 1, right + 1};
            else if(sum > target) right--;
            else left++;
        }
        
        // since it is guaranteed that 
        // "each input would have exactly one solution and you may not use the same element twice."
        return new int[2];
    }
}