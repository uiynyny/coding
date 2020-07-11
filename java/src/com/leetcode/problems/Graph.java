package com.leetcode.problems;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int v;
    private int time;
    private List<Integer>[] adj;

    Graph(int numNode) {
        v = numNode;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdges(int[][] edges) {
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
    }

    private void apUtil(int u, boolean[] visited, int[] parent, int[] low, int[] disc, boolean[] ap,
            List<int[]> bridges) {
        visited[u] = true;
        disc[u] = low[u] = time++;
        int children = 0;

        for (int v : adj[u]) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                apUtil(v, visited, parent, low, disc, ap, bridges);
                // update low link of u
                low[u] = Math.min(low[v], low[u]);
                // if u is root of the tree and has more than one child
                if (parent[u] == -1 && children > 1) {
                    ap[u] = true;
                }
                // if u is not a root node and child low value is bigger than disc of u
                // which means v can not reach any vertex smaller than u
                if (parent[u] != -1 && low[v] >= disc[u]) {
                    ap[u] = true;
                    bridges.add(new int[]{u,v});

                }
            } else if (v != parent[u]) {
                // update low link u to the already visited node low link, if the already
                // visited non-parent node is smaller,
                // means the node can reach a smaller id node
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[v];
        int[] parent = new int[v];
        // disc is the discovery time of node i in DFS
        int[] disc = new int[v];
        // low represent the earliest node discovered by DFS can be reach from node i
        int[] low = new int[v];
        // articulation point
        boolean[] ap = new boolean[v];
        // cutting edges
        List<int[]> bridges = new LinkedList<>();

        // initialize information for each node array
        for (int i = 0; i < v; i++) {
            parent[i] = -1;
            visited[i] = false;
            ap[i] = false;
        }
        // call dfs on every point
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                apUtil(i, visited, parent, low, disc, ap, bridges);
        }
        for (int i = 0; i < v; i++)
            if (ap[i] == true)
                System.out.println(i + " ");
        for(int[] b:bridges){
            System.out.println(b[0]+" "+b[1]);
        }
    }

    public static void main(String[] args) {
        int nodes = 7;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 }, { 2, 5 }, { 3, 4 }, { 5, 6 } };
        Graph g = new Graph(nodes);
        g.addEdges(edges);
        g.DFS();
    }
}