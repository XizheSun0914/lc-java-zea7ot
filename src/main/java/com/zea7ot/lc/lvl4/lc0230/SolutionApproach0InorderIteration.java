/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(H)
 * 
 * The follow-up question makes this problem a 4-star.
 *  What if the BST is modified (insert/delete operations) 
 *  often and you need to find the kth smallest frequently? 
 *  How would you optimize the kthSmallest routine
 */
package com.zea7ot.lc.lvl4.lc0230;

import java.util.Stack;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0InorderIteration {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        while(root != null || ! stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
        
        return Integer.MIN_VALUE;
    }
}