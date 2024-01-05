package AImportantProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlights_K_Stops {
    static class Edge{
        int src,dest,weight;
        public Edge(int src, int des, int wt){
            this.src = src;
            this.dest = des;
            this.weight = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[]graph, int [][] flights){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int src = flight[0];
            int des = flight[1];
            int wt = flight[2];
            graph[src].add(new Edge(src, des, wt));
        }
    }

    static class Info{
        int vertex,cost,stops;
        public Info(int v, int c, int s){
            this.vertex = v;
            this.cost = c;
            this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int [][]flights, int src, int dest, int k){
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graphs = new ArrayList[n];
        createGraph(graphs,flights);
        int [] distance = new int[n];
        for (int i = 0; i < n; i++) {
            if(i!=src) distance[i] = Integer.MAX_VALUE;
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(0,0,0));
        while (!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops>k) break;
            for (int i = 0; i < graphs[curr.vertex].size(); i++) {
                Edge e = graphs[curr.vertex].get(i);
                int v = e.dest;
                int wt = e.weight;
                if(curr.cost+wt<distance[v] && curr.stops <=k){
                    distance[v] = curr.cost+wt;
                    q.add(new Info(v,distance[v], curr.stops+1));
                }
            }
        }
        if(distance[dest]==Integer.MAX_VALUE) return -1;
        else return distance[dest];
    }

    public static void main(String[] args) {
        int n = 4;
        int [][]flights = {{0,1,100},{1,2,100},{2,0,200},{1,3,600},{2,3,200}};
        int src = 0, des = 3, k=1;
        System.out.println(cheapestFlight(n,flights,src,des,k));
    }
}
