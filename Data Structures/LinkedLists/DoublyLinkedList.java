package LinkedLists;
public class DoublyLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }

    public void printLinkedList(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public int removeFirst(){
        if(head==null){
            System.out.println();
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val= head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val = head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    public void reverseLinkedList(){
        Node prev=null;
        Node curr =head;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();
        ddl.addFirst(5);
        ddl.addFirst(4);
        ddl.addFirst(3);
        ddl.addFirst(2);
        ddl.addFirst(1);
        ddl.printLinkedList();
        ddl.reverseLinkedList();
        ddl.printLinkedList();

    }
}
