package lec24Prep;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSOrderPractice {
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

    public static void bfsOrder(Graph g, int s) {
        boolean[] visited = new boolean[g.size()];
        Queue<Integer> q = new LinkedList<>();

        // TODO:
        // 1. mark s visited
        // 2. enqueue s
        // 3. while queue not empty:
        //      dequeue a vertex
        //      print it
        //      for each unvisited neighbor:
        //          mark visited
        //          enqueue it
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

        bfsOrder(g, 0);
        // one possible output: 0 1 2 4 5 3 6 8 7
    }
}
