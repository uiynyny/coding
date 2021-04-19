package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CriticalConnection
 */
public class CriticalConnection {
    public static void main(String[] args) {
        CriticalConnection o = new CriticalConnection();
        List<List<Integer>> conns=new ArrayList<>();
        conns.add(Arrays.asList(0,1));
        conns.add(Arrays.asList(1,2));
        conns.add(Arrays.asList(2,0));
        conns.add(Arrays.asList(1,3));
        
        System.out.println(o.criticalConnections(4,conns));
    }

    class Graph {
        int V;
        List<Integer>[] adj;
        int[] low, disc, parent;
        boolean[] ap;
        int timer;

        List<List<Integer>> bridge;

        Graph(int n, List<List<Integer>> edges) {
            V = n;
            adj = new ArrayList[n];
            low = new int[n];
            disc = new int[n];
            parent = new int[n];

            ap = new boolean[n];
            bridge = new ArrayList<>();
            timer = 1;
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
                parent[i] = -1;
            }
            for (List<Integer> e : edges) {
                adj[e.get(0)].add(e.get(1));
                adj[e.get(1)].add(e.get(0));
            }
        }

        public void bridge(int u) {
            int children=0;
            disc[u] = low[u] = timer++;
            // loop all neighbor of u
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (disc[v] == 0) {
                    children++;
                    parent[v] = u;
                    bridge(v);
                    // update low of u to low of v
                    low[u] = Math.min(low[u], low[v]);
                    // if u is root and u has multiple direct child in visit then u is cutting vertex
                    if (disc[u] == 1 && children > 1) {
                        ap[u] = true;
                    }
                    // if v can't reach any point upper than u, then u->v is cutting edge
                    if (low[v] > disc[u]) {
                        bridge.add(Arrays.asList(u, v));
                        // if u is not root
                        if (parent[u] != -1)
                            ap[u] = true;
                    }
                } else if (v != parent[u]) {
                    // already visited, update low u to disc v
                    // low v may depends on this low u
                    low[u] = Math.min(low[u], disc[v]);
                }
            }
        }
        
        
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if (connections == null || connections.size() == 0)
            return null;
        Graph g = new Graph(n, connections);
        g.bridge(connections.get(0).get(0));
        System.out.println(Arrays.toString(g.ap));
        return g.bridge;
    }
}