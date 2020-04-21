/**
 * https://leetcode.com/problems/combination-sum-ii/
 */

package main.java.lcidiot.lc0040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionApproachBacktrack{
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); 
        // sanity check
        if(candidates == null || candidates.length == 0 || target < 1) return ans;
        
        Arrays.sort(candidates);
        
        backtrack(new ArrayList<Integer>(), target, 0, candidates, ans);
        
        return ans;
    }
    
    private void backtrack(List<Integer> intermediate, 
                           int target, 
                           int startIdx,
                           int[] candidates,
                           List<List<Integer>> res){
        if(target < 0) return;
        
        if(target == 0){
            res.add(new ArrayList<Integer>(intermediate));
            return;
        }
        
        for(int i = startIdx; i < candidates.length; i++){
            // to avoid repeatitively dealing with any duplicate candidate
            if(i != startIdx && candidates[i - 1] == candidates[i]) continue;
            intermediate.add(candidates[i]);
            backtrack(intermediate, target - candidates[i], i + 1, candidates, res);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}