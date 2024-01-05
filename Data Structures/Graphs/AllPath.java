package Graphs;

import java.util.ArrayList;

public class AllPath {
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
        graph[0].add(new Edge(0,3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,0));

        graph[5].add(new Edge(5,2));
        graph[5].add(new Edge(5,0));
    }

    public static void printAllPath(ArrayList<Edge> [] graph,int src, int dest, String result){ // O(exponential)
        if(src==dest){
            System.out.println(result+dest);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph,e.dest,dest,result+src);
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[6];
        createGraph(graph);
        printAllPath(graph,5,1,"");
    }

}
