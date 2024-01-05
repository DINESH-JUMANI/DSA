package Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSorting {
    static class Edge{
        int src,dest;
        public Edge(int src, int des){
            this.src = src;
            this.dest = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topologicalSort(ArrayList<Edge>[]graph){
        boolean [] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if(!visited[i]) topSortUtil(graph,i,visited,s);
        }

        while (!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
    public static void topSortUtil(ArrayList<Edge>[]graph, int curr, boolean [] visited, Stack<Integer>s){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSortUtil(graph,e.dest,visited,s);
            }
        }
        s.push(curr);
    }

    public static void topologicalSortUsingBFS(ArrayList<Edge> [] graph){ // Kahn's Algorithm
        int [] inDegree = new int[graph.length];
        calculateInDegree(graph,inDegree);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if(inDegree[i]==0) q.add(i);
        }

        // BFS
        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest]==0) q.add(e.dest);
            }
        }
        System.out.println();
    }
    public static void calculateInDegree(ArrayList<Edge> [] graph,int [] inDegree){
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        createGraph(graph);
        topologicalSort(graph);
        System.out.println();
        topologicalSortUsingBFS(graph);
    }
}
