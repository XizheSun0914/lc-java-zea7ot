/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * 
 * Time Complexity: O(N)
 * 
 * Space Complexity: O(H)
 *  O(H), the call stack
 * 
 * References:
 *  https://leetcode.com/problems/range-sum-of-bst/discuss/192019/JavaPython-3-3-similar-recursive-and-1-iterative-methods-w-comment-and-analysis.
 */
package com.zea7ot.lc.lvl3.lc0938;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class SolutionApproach0DFSBottomUp {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);   // left branch excluded
        if(root.val < L) return rangeSumBST(root.right, L, R);  // right branch excluded
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R); // count in both children
    }
}