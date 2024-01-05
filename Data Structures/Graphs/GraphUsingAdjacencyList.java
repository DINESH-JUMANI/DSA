package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphUsingAdjacencyList {

    static class Edge{
        int src,dest,weight;
        public Edge(int src, int des, int weight){
            this.src = src;
            this.dest = des;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertex 0
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        // vertex 1
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        // vertex 2
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        // vertex 3
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        // vertex 4
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        // vertex 5
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        // vertex 6
        graph[6].add(new Edge(6,5,1));

    }

    public static void getNeighbour(ArrayList<Edge>[] graph,int vertex){
        for (int i = 0; i < graph[vertex].size(); i++) {
            Edge e = graph[vertex].get(i);
            System.out.print(e.dest+" ");
        }
        System.out.println();
    }

    public static void breadthFirstSearch(ArrayList<Edge>[] graph){
        boolean [] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]) breadthFirstSearchUtil(graph,visited);
        }
    }
    public static void breadthFirstSearchUtil(ArrayList<Edge>[] graph, boolean [] visited){ // O(V+E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0); // Source or root = 0
        while (!q.isEmpty()){
            int curr = q.remove();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void depthFirstSearch(ArrayList<Edge>[] graph){
        boolean [] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            depthFirstSearchUtil(graph,i,visited);
        }
    }
    public static void depthFirstSearchUtil(ArrayList<Edge>[] graph, int curr, boolean [] visited){ // O(V+E)
        System.out.print(curr+" ");
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) depthFirstSearchUtil(graph,e.dest,visited);
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph,int src, int dest, boolean [] visited){ // O(V+E)
        if(src==dest) return true;
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph,e.dest,dest,visited)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int vertices = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        getNeighbour(graph,4);
        breadthFirstSearch(graph);
        depthFirstSearch(graph);
        System.out.println();
        System.out.println(hasPath(graph,0,5,new boolean[vertices]));
    }
}
