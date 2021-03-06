/**
 * Time Complexity:     O(N)
 * 
 * Space Complexity:    O(H)
 */
package com.zea7ot.algorithm.summaries.traversal.preorder;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.utils.data_structure.tree.TreeNode;

public class DFSRecursive {
    public List<Integer> preorderTraverse(TreeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;

        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode node, List<Integer> res){
        if(node == null) return;

        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }
}