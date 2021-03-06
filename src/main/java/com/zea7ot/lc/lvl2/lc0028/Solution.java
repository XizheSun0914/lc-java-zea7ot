/**
 * https://leetcode.com/problems/implement-strstr/
 */
package com.zea7ot.lc.lvl2.lc0028;

public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; ; i++){
            for(int j = 0; ; j++){
                if(j == needle.length()) return i;
                if(i + j == haystack.length()) return -1;
                if(needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }
}