package Graphs;

import java.util.ArrayList;

public class ArticulationPoint_TarjanAlgorithm {
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

        graph[4].add(new Edge(4,3));
    }

    public static void dfs(ArrayList<Edge>[]graph, int curr, int par, int []dt, int []ldt, boolean[]vis, int time,boolean[]ap){
        vis[curr] = true;
        dt[curr]=ldt[curr]=++time;
        int children = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neighbour = e.des;
            if(par==neighbour) continue;
            else if(vis[neighbour]) ldt[curr] = Math.min(ldt[curr],dt[neighbour]);
            else{
                dfs(graph,neighbour,curr,dt,ldt,vis,time,ap);
                ldt[curr] = Math.min(ldt[curr],ldt[neighbour]);
                if(par!=-1 && dt[curr]<=ldt[neighbour]) ap[curr]=true;
                children++;
            }
        }
        if(par==-1 && children>1) ap[curr]=true;
    }

    public static void tarjanGetAp(ArrayList<Edge>[]graph, int vertices){ // O(V+E)
        int [] discoveryTime = new int[vertices];
        int [] lowestTime = new int[vertices];
        int time = 0;
        boolean [] visited = new boolean[vertices];
        boolean [] ap = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if(!visited[i]) dfs(graph,i,-1,discoveryTime,lowestTime,visited,time,ap);
        }
        for (int i = 0; i < vertices; i++) {
            if(ap[i]) System.out.println("Ap : "+i);
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> [] graph = new ArrayList[vertices];
        createGraph(graph);
        tarjanGetAp(graph,vertices);
    }
}
