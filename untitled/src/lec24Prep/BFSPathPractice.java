package lec24Prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSPathPractice {
    public static class Graph {
        private ArrayList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public Graph(int n) {
            adj = (ArrayList<Integer>[]) new ArrayList[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        public ArrayList<Integer> neighbors(int v) {
            return adj[v];
        }

        public int size() {
            return adj.length;
        }
    }

    public static void bfsPaths(Graph g, int s, boolean[] visited, int[] edgeTo) {
        Queue<Integer> q = new LinkedList<>();
        // TODO:
        // 1. mark s visited
        // 2. enqueue s
        // 3. BFS
        // 4. when discovering neighbor:
        //      mark visited
        //      edgeTo[neighbor] = v
        //      enqueue neighbor
        visited[s] = true;
        q.offer(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : g.neighbors(cur)) {
                if (!visited[nei]){
                    visited[nei] = true;
                    edgeTo[nei] = cur;
                    q.offer(nei);
                }
            }
        }
    }

    public static List<Integer> buildPath(int s, int t, boolean[] visited, int[] edgeTo) {
        List<Integer> path = new ArrayList<>();

        // TODO:
        // if t is not visited, return empty path
        // trace backward from t to s using edgeTo
        // add s
        // reverse and return
        if (!visited[t]) return path;
        for (int x = t; x != s; x = edgeTo[x]){
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 3);
        g.addEdge(5, 6);
        g.addEdge(5, 8);
        g.addEdge(6, 7);

        int s = 0;
        boolean[] visited = new boolean[g.size()];
        int[] edgeTo = new int[g.size()];
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = -1;
        }

        bfsPaths(g, s, visited, edgeTo);

        System.out.println(buildPath(0, 7, visited, edgeTo)); // [0, 1, 2, 5, 6, 7]
        System.out.println(buildPath(0, 3, visited, edgeTo)); // [0, 1, 4, 3]
    }
}
