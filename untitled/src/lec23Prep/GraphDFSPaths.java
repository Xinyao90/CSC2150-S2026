package lec23Prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphDFSPaths {
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

    public static void dfsPaths(Graph g, int s, boolean[] visited, int[] edgeTo) {
        visited[s] = true;

        for (int neighbor : g.neighbors(s)) {
            if (!visited[neighbor]) {
                // TODO: record how we reached neighbor
                // TODO: recursively dfs from neighbor
                edgeTo[neighbor] = s;
                dfsPaths(g, neighbor, visited, edgeTo);
            }
        }
    }

    public static List<Integer> buildPath(int s, int t, boolean[] visited, int[] edgeTo) {
        List<Integer> path = new ArrayList<>();

        // TODO: if t is not visited, return empty path

        // TODO: walk backward from t to s using edgeTo
        // TODO: add s
        // TODO: reverse list before returning
        if (!visited[t]) return path;
        for(int x = t; x != s; x = edgeTo[x]){
            path.add(x);
        }
        path.add(s);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Graph g = new Graph(9);

        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(5, 4);
        g.addEdge(3, 6);
        g.addEdge(6, 7);
        g.addEdge(6, 8);

        int s = 0;
        boolean[] visited = new boolean[g.size()];
        int[] edgeTo = new int[g.size()];
        for (int i = 0; i < edgeTo.length; i++) {
            edgeTo[i] = -1;
        }

        dfsPaths(g, s, visited, edgeTo);

        System.out.println(buildPath(0, 8, visited, edgeTo)); // example: [0, 3, 6, 8]
        System.out.println(buildPath(0, 5, visited, edgeTo)); // depends on traversal order
    }
}
