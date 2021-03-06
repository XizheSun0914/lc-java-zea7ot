/**
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * Time Complexity:     O(N * lg(N)) + O(N) ~ O(N * lg(N))
 *  O(N * lg(N)), consumed by PQ
 *  O(N), consumed by `postorder()`
 * 
 * Space Complexity:    O(N) + O(H)
 * 
 * to sort the children and post order traverse the graph
 * 
 * 
 * References:
 *  https://www.youtube.com/watch?v=4udFSOWQpdg
 *  http://zxi.mytechroad.com/blog/graph/leetcode-332-reconstruct-itinerary/
 *  Hierholzer's algorithm: https://en.wikipedia.org/wiki/Eulerian_path
 */
package com.zea7ot.lc.lvl3.lc0332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionApproach0HierholzersAlgorithm {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<String>();
        // sanity check
        if(tickets == null || tickets.isEmpty()) return ans;
        
        // a tree-like graph, with children sorted lexicographically and greedily
        Map<String, PriorityQueue<String>> graph = new HashMap<String, PriorityQueue<String>>();
        for(List<String> ticket : tickets){
            // this PriorityQueue is a minHeap
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<String>((a, b) -> a.compareTo(b)));
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        
        final String START = "JFK";
        postorder(START, graph, ans);
        Collections.reverse(ans);
        return ans;
    }
    
    private void postorder(String source, 
                           Map<String, PriorityQueue<String>> graph, 
                           List<String> routes){
        
        PriorityQueue<String> destinations = graph.get(source);
        if(destinations != null){
            while(!destinations.isEmpty()){
                String destination = destinations.poll();
                postorder(destination, graph, routes);
            }
        }
        
        routes.add(source);
    }
}