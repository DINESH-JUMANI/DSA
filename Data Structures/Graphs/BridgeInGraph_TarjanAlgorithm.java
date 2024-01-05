package Graphs;

import java.util.ArrayList;

public class BridgeInGraph_TarjanAlgorithm {
    public static class Edge{
        int src,des;
        public Edge(int s, int d){
            this.src = s;
            this.des = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[]graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }

    public static void dfs(ArrayList<Edge>[]graph,int curr,int par, int []dt, int []ldt,boolean[]vis, int time){
        vis[curr] = true;
        dt[curr]=ldt[curr]=++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(e.des==par) continue;
            else if(!vis[e.des]){
                dfs(graph,e.des,curr,dt,ldt,vis,time);
                ldt[curr] = Math.min(ldt[curr],ldt[e.des]);
                if(dt[curr]<ldt[e.des]) System.out.println("Bridge: "+curr+"----"+e.des);
            }
            else ldt[curr] = Math.min(ldt[curr],dt[e.des]);
        }
    }

    public static void tarjanGetBridge(ArrayList<Edge>[]graph,int vertices){
        int [] discoveryTime = new int[vertices];
        int [] lowestTime = new int[vertices];
        int time = 0;
        boolean [] visited = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) dfs(graph,i,-1,discoveryTime,lowestTime,visited,time);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[vertices];
        createGraph(graph);
        tarjanGetBridge(graph,vertices);
    }
}
