package Graphs;

import java.util.ArrayList;

public class CycleDetectionDirectedGraph {
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
//        graph[0].add(new Edge(0,2));
//        graph[1].add(new Edge(1,0));
//        graph[2].add(new Edge(2,3));
//        graph[3].add(new Edge(3,0));

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,3));
        graph[2].add(new Edge(2,3));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph){
        boolean [] visited = new boolean[graph.length];
        boolean [] stack = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]){
                if(detectCycleUtil(graph,i,visited,stack)) return true;
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[]graph, int curr, boolean [] visited, boolean [] stack){
        visited[curr] = true;
        stack[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) return true;
            if(!visited[e.dest] && detectCycleUtil(graph,e.dest,visited,stack)) return true;
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[4];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
