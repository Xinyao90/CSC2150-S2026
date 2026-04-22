package lec24Prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFSDistancePractice {
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

    public static int[] bfsDistances(Graph g, int s) {
        boolean[] visited = new boolean[g.size()];
        int[] distTo = new int[g.size()];
        Arrays.fill(distTo, -1);

        Queue<Integer> q = new LinkedList<>();

        // TODO:
        // 1. mark s visited
        // 2. set distTo[s] = 0
        // 3. enqueue s
        // 4. BFS
        // 5. when discovering neighbor:
        //      mark visited
        //      distTo[neighbor] = distTo[v] + 1
        //      enqueue neighbor
        visited[s] = true;
        distTo[s] = 0;
        q.offer(s);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nei : g.neighbors(cur)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    distTo[nei] = distTo[cur] + 1;
                    q.offer(nei);
                }
            }
        }
        return distTo;
    }

        public static void main (String[]args){
            Graph g = new Graph(9);

            g.addEdge(0, 1);
            g.addEdge(1, 2);
            g.addEdge(1, 4);
            g.addEdge(2, 5);
            g.addEdge(4, 3);
            g.addEdge(5, 6);
            g.addEdge(5, 8);
            g.addEdge(6, 7);

            System.out.println(Arrays.toString(bfsDistances(g, 0)));
            // expected: [0, 1, 2, 3, 2, 3, 4, 5, 4]
        }
    }