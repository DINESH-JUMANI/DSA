package Graphs;

import java.util.ArrayList;
import java.util.Stack;

// Strongly connected components : where all the nodes form a cycle
// Reverse DFS
public class KosarajuAlgorithm {

    static class Edge{
        int src,dest;
        public Edge(int src, int des){
            this.src = src;
            this.dest = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
    }

    public static void topSort(ArrayList<Edge>[]graph, int curr, boolean [] visited, Stack<Integer> s){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph,e.dest,visited,s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> [] graph,int curr, boolean [] visited){
        visited[curr] = true;
        System.out.print(curr+" ");
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph,e.dest,visited);
            }
        }
    }

    public static void kosaraju(ArrayList<Edge>[]graph, int vertices){ //O(V+E)
        Stack<Integer> s = new Stack<>();
        boolean [] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) topSort(graph,i,visited,s);
        }

        // Transpose A graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] transpose = new ArrayList[vertices];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            transpose[i] = new ArrayList<>();
        }
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        while (!s.isEmpty()){
            int curr = s.pop();
            if(!visited[curr]) dfs(transpose,curr,visited);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[vertices];
        createGraph(graph);
        kosaraju(graph,vertices);
    }
}
