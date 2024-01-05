package Graphs;

import java.util.ArrayList;

public class BellmanFordAlgorithm {
    static class Edge{
        int src,dest,weight;
        public Edge(int src, int des,int weight){
            this.src = src;
            this.dest = des;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    }

    public static void bellmanFord(ArrayList<Edge>[] graph,int src){ // O(V*E)
        int [] distance = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            if(i!=src) distance[i]= Integer.MAX_VALUE;
        }
        int verticesNumber = graph.length;
        for (int i = 0; i < verticesNumber-1; i++) {
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    if(distance[u]!=Integer.MAX_VALUE && distance[u]+wt<distance[v]){
                        distance[v] = distance[u]+wt;
                    }
                }
            }
        }
        for (int temp : distance) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        createGraph(graph);
        int source = 0;
        bellmanFord(graph,source);
    }
}
