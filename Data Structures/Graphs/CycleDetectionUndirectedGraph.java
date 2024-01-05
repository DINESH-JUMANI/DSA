package Graphs;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {

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

    public static boolean detectCycle(ArrayList<Edge> [] graph){ // O(V+E)
        boolean [] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i,-1)) return true;
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> [] graph, boolean [] visited, int curr, int parent){
        visited[curr] = true;
        for (int i = 0; i < graph.length; i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                if(detectCycleUtil(graph,visited,e.dest,curr)) return true;
            }
            else if(visited[e.dest] && e.dest!=parent) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int vertices = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
