/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.lc.lvl3.lc0129;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSTopDown {
    private int total;
    
    public int sumNumbers(TreeNode root) {
        total = 0;
        dfs(root, 0);
        return total;
    }
    
    private void dfs(TreeNode root, int sum){
        if(root == null) return;
        
        sum = sum * 10 + root.val;
        
        if(root.left == null && root.right == null){
            total += sum;
            return;
        }
        
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}