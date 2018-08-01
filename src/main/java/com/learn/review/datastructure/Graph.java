package com.learn.review.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int V;
    java.util.LinkedList<Integer> adjListArray[];

    public Graph(int V) {
        this.V = V;
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new java.util.LinkedList<>();
        }
    }

    public void addEdge(int src, int dst) {
        adjListArray[src].add(dst);
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            System.out.print(v + " ");

            Iterator<Integer> i = adjListArray[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(int s) {
        boolean visited[] = new boolean[V];
        DFSUtil(s, visited);
    }

    void DFSUtil(int s, boolean[] visited) {
        System.out.print(s + " ");
        visited[s] = true;

        Iterator<Integer> i = adjListArray[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
}

class GraphMain {

    // Driver program to test above functions
    public static void main(String args[])
    {
        testDFS();
    }

    static void testBuildGraph() {
        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

    }

    static void testBFS() {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
    static void testDFS() {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }
}