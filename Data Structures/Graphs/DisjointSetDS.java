package Graphs;

public class DisjointSetDS {
    static int size = 7;
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


    public static void main(String[] args) {
        init();
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
    }
}
