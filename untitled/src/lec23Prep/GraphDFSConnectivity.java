package lec23Prep;

import java.util.ArrayList;

public class GraphDFSConnectivity {
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

    public static boolean pathExists(Graph g, int s, int t) {
        boolean[] visited = new boolean[g.size()];
        return dfs(g, s, t, visited);
    }

    private static boolean dfs(Graph g, int current, int target, boolean[] visited) {
        // TODO: if current is target, return true

        // TODO: mark current as visited

        // TODO: for each neighbor
        //         if not visited, recursively search
        //         if recursive call returns true, return true

        // TODO: if no path found, return false
        return false;
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

        System.out.println(pathExists(g, 0, 8)); // true
        System.out.println(pathExists(g, 2, 8)); // false if disconnected in your chosen graph
    }
}
