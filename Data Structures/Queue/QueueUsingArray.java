package Queue;

public class QueueUsingArray {

    static class Queue{
        static int [] arr;
        static int size;
        static int rear;
        Queue(int n){
            size = n;
            arr = new int[size];
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear==-1;
        }

        public static void add(int data){ // O(1)
            if(rear==size-1){
                System.out.println("QUEUE IS FULL");
                return;
            }
            rear = rear +1;
            arr[rear] = data;
        }

        public static int remove(){ //O(n)
            if(isEmpty()){
                System.out.println("EMPTY QUEUE");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public static int peek(){ //O(1)
            if(isEmpty()){
                System.out.println("EMPTY QUEUE");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
