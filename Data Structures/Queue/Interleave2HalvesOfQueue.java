package Queue;

import java.util.LinkedList;
import java.util.Queue;

// QUEUE IS 1 2 3 4 5 6 7 8 9 10
//OUTPUT 1 6 2 7 3 8 4 9 5 10
public class Interleave2HalvesOfQueue {
    public static void make2Halves(Queue<Integer> q){
        Queue<Integer> temp = new LinkedList<>();
        int n = q.size();

        for (int i = 0; i < n; i++) {
            if(i<n/2) temp.add(q.remove());
        }
        for (int i = 0; i < n/2; i++) {
            q.add(temp.remove());
            q.add(q.remove());
        }
        System.out.println(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < 11; i++){
            q.add(i);
        }
        make2Halves(q);
    }
}
