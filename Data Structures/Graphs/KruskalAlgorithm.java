package Graphs;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
    static class Edge implements Comparable<Edge>{
        int src,dest,weight;
        public Edge(int src, int des,int weight){
            this.src = src;
            this.dest = des;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }

    public static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }
    static int size = 4;
    static int [] parent = new int[size];
    static int [] rank = new int[size];

    public static void init(){
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    public static int find(int x){
        if(x==parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(rank[parentA]==rank[parentB]){
            parent[parentB] = parentA;
            rank[parentA]++;
        }
        else if(rank[parentA]<rank[parentB]) parent[parentA] = parentB;
        else  parent[parentB] = parentA;
    }

    public static void kruskalMST(ArrayList<Edge>edges, int vertices){ // O(V+ElogE)
        init();
        Collections.sort(edges);
        int finalCost = 0;
        int count = 0;
        for (int i = 0; count < vertices-1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);
            int parB = find(e.dest);
            if(parA != parB){
                union(e.src,e.dest);
                finalCost+=e.weight;
                count++;
            }
        }
        System.out.println(finalCost);
    }

    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalMST(edges,vertices);
    }
}
