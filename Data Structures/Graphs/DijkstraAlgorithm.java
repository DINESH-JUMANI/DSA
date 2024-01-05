package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

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

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    static class Pair implements Comparable<Pair>{
        int value,path;
        public Pair(int n, int path){
            this.value = n;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[]graph,int src){ // O(V + E*logV)
        int [] distance = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(i!=src) distance[i] = Integer.MAX_VALUE;
        }
        boolean [] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));

        // BFS
        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.value]){
                visited[curr.value]=true;
                for (int i = 0; i < graph[curr.value].size(); i++) {
                    Edge e = graph[curr.value].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    if(distance[u]+wt<distance[v]){
                        distance[v] = distance[u]+wt;
                        pq.add(new Pair(v,distance[v]));
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i]+" ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        int source = 0;
        dijkstra(graph,source);
    }
}
