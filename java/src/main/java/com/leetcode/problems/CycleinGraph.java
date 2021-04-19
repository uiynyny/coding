package com.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class CycleinGraph {
    public static void main(String[] args) {
        CycleinGraph o = new CycleinGraph();
        Graph g = o.new Graph(3);
        g.addEdges(0, 1);
        g.addEdges(1, 2);
        g.addEdges(2, 0);
        System.out.println(o.solve(g));
    }

    /**
     * Graph
     */
    class Graph {
        int V;
        List<Integer>[] edges;

        Graph(int V) {
            this.V = V;
            edges = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                edges[i] = new ArrayList<>();
            }
        }

        void addEdges(int u, int v) {
            if (u == v)
                return;
            edges[u].add(v);
            edges[v].add(u);
        }
    }

    boolean solve(Graph g) {
        boolean[] vis = new boolean[g.V];

        for (int u = 0; u < g.V; u++) {
            if (!vis[u] && cycleUtil(g, u, vis, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean cycleUtil(Graph g, int u, boolean[] vis, int parent) {
        vis[u] = true;
        for (int v : g.edges[u]) {
            if (!vis[v]) {
                if (cycleUtil(g, v, vis, u))
                    return true;
            } else if (parent != v)
                return true;
        }
        return false;
    }
}
