/**
 * https://leetcode.com/problems/maximum-binary-tree/
 * 
 * Time Complexity:     O(N * lg(N))
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/maximum-binary-tree/discuss/106149/Java-solution-recursion
 */
package com.zea7ot.lc.lvl3.lc0654;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // sanity check
        if(nums == null || nums.length == 0) return null;
        final int N = nums.length;
        return buildTree(0, N - 1, nums);
    }
    
    private TreeNode buildTree(int lo, int hi, int[] nums){
        if(lo > hi) return null;
        
        int idxMax = lo;
        for(int i = lo + 1; i <= hi; i++){
            if(nums[i] > nums[idxMax]){
                idxMax = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[idxMax]);
        
        root.left = buildTree(lo, idxMax - 1, nums);
        root.right = buildTree(idxMax + 1, hi, nums);
        
        return root;
    }
}