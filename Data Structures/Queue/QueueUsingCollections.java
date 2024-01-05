package Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCollections {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        System.out.println(q1);
        q1.remove();
        q1.remove();
        System.out.println(q1);

    }
}
