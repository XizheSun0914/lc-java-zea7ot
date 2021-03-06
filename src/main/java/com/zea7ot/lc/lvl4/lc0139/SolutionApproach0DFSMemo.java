/**
 * https://leetcode.com/problems/word-break/
 * 
 * Time Complexity:     O(N ^ 2)
 * Space Complexity:    O(N)
 * 
 * References:
 *  https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution
 */
package com.zea7ot.lc.lvl4.lc0139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionApproach0DFSMemo {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> visited = new HashSet<Integer>();
        return dfs(s, 0, new HashSet<String>(wordDict), visited);
    }
    
    private boolean dfs(String str, 
                        int index, 
                        Set<String> wordSet, 
                        Set<Integer> visited){
        // the base case
        if(index == str.length()) return true;
        
        // to check memory
        if(visited.contains(index)) return false;
        
        // recursion
        for(int i = index + 1; i <= str.length(); i++){
            String sub = str.substring(index, i);
            if(wordSet.contains(sub) && dfs(str, i, wordSet, visited)) 
                return true;
        }
        
        visited.add(index);
        return false;
    }
}