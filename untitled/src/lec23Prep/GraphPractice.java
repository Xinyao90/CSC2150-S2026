package lec23Prep;

import java.util.ArrayList;

public class GraphPractice {
    public static class Graph {
        private ArrayList<Integer>[] adj;

        @SuppressWarnings("unchecked")
        public Graph(int n) {
            // TODO: create adj with n buckets
            // TODO: initialize each bucket as a new ArrayList<Integer>()
        }

        public void addEdge(int v, int w) {
            // Undirected graph
            // TODO: add w to v's list
            // TODO: add v to w's list
            return;
        }

        public ArrayList<Integer> neighbors(int v) {
            return adj[v];
        }

        public int size() {
            return adj.length;
        }

        public void printGraph() {
            for (int v = 0; v < adj.length; v++) {
                System.out.println(v + " -> " + adj[v]);
            }
        }
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

        g.printGraph();
    }
}