package LinkedLists;

public class SinglyLinkedList {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null) {
            head=tail=newNode;
            return;
        }
        newNode.next = head;
        head=newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public void add(int index, int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("LinkList is EMPTY");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size==0){
            System.out.println("LinkList is EMPTY");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            int val = head.data;
            head=tail=null;
            size = 0;
            return val;
        }
        int i = 0;
        Node prev = head;
        while (i<size-2){
            prev = prev.next;
            i++;
        }
        int val = tail.data;
        prev.next = null;
        tail=prev;
        size--;
        return val;
    }

    public int itrSearch(int key){
        Node temp = head;
        int idx = 0;
        while (temp!=null){
            if(temp.data==key) return idx;
            idx++;
            temp=temp.next;
        }
        return -1;
    }

    public int helperRecSearch(int key, Node head){
        if(head==null) return -1;
        if(head.data==key) return 0;
        int idx = helperRecSearch(key,head.next);
        if(idx==-1) return -1;
        return idx+1;
    }

    public int recSearch(int key){
        return helperRecSearch(key,head);
    }

    public void printLinkedList(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr!=null){
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n){
        if(size==n){
            head = head.next;
            return;
        }
        int i = 1;
        int itoFind = size-n;
        Node prev=head;
        while (i<itoFind){
            prev = prev.next;
            i++;
        }
        prev.next=prev.next.next;
    }

    public Node findMiddleNode(Node head){
        // SLOW FAST APPROACH
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        // base case
        if(head==null || head.next==null) return true;

        // Find mid Node
        Node midNode = findMiddleNode(head);

        // rev right half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half head
        Node left = head; // left half head
        while (right!=null){
            if(left.data!= right.data) return false;
            left=left.next;
            right=right.next;
        }
        return true;
    }

    public boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

    public void removeCycle(){
        Node slow= head;
        Node fast= head;
        boolean cycleExist = false;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycleExist=true;
                break;
            }
        }
        if(!cycleExist) return;
        slow=head;
        Node prev=null;
        while(slow!=fast){
            prev=fast;
            slow=slow.next;
            fast=fast.next;
        }
        prev.next=null;
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLinkList = new Node(-1);
        Node temp = mergedLinkList;
        while (head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }

        while (head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }

        while (head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLinkList.next;
    }

    public Node mergeSort(Node Head){
        if(head==null || head.next==null) return head;
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next=null;
        // RECURSION
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        return merge(newLeft,newRight);
    }

    public void toZigzagLinkList(){
        // FIND MID NODE
       Node slow = head;
       Node fast= head;
       while (fast!=null && fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       Node midNode = slow;

       // Rev 2nd Half
        Node prev=null;
        Node curr = midNode.next;
        midNode.next=null;
        Node next;
        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        // MERGE
        Node leftHalf= head;
        Node rightHalf = prev;
        Node nextL,nextR;
        while (leftHalf!=null&&rightHalf!=null){
            nextL=leftHalf.next;
            leftHalf.next=rightHalf;
            nextR=rightHalf.next;
            rightHalf.next=nextL;
            leftHalf=nextL;
            rightHalf=nextR;
        }
    }

    public Node reverseMiddleLinkedList(int left, int right){
        // BASE CASE
        if (head==null) return null;
        if (head.next==null){
            printLinkedList();
            return head;
        }

        Node left2=head,left1=head,right1=head,right2=head;
        int originalLeft = left;
        // LEFT NODE FIND
        while(left-->1){
            left1=left2;
            left2=left2.next;
        }
        // RIGHT NODE FIND
        while(right-->=1){
            right2=right1;
            right1=right1.next;
        }

        if (originalLeft!=1)
            left1.next=null;
        right2.next=null;

        // REVERSE
        Node prev=null,next,curr=left2;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        if (originalLeft==1){
            head.next=right1;

            return prev;
        }

        left1.next=prev;
        left2.next=right1;
        return head;
    }

    public void removeElements(int val){
        if(head == null) return;
        while(head!=null && head.data == val) head = head.next;
        Node temp = head;
        while(temp!=null && temp.next !=null) {
            if(temp.next.data == val) {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
    }

    public void oddEvenLinkedList(){
        Node odd = head;
        Node even = odd.next;
        Node eveHead = even;
        int itr=1;
        while (even.next!=null && odd.next!=null){
            if(itr%2!=0){
                odd.next=even.next;
                odd=even.next;
            }
            else {
                even.next=odd.next;
                even=odd.next;
            }
            itr++;
        }
        odd.next = eveHead;
        if(itr%2==0) even.next=null;
        printLinkedList();
    }

    public void removeDuplicates(){
        if(head==null || head.next==null) return;
        Node prev=head;
        Node curr=prev.next;
        while (curr!=null){
            if(prev.data==curr.data){
                prev.next=curr.next;
                curr=curr.next;
            }
            else {
                prev=curr;
                curr=curr.next;
            }
        }
        printLinkedList();
    }

    public void binToInt(){
        Node newNode = head;
        StringBuilder str = new StringBuilder();
        while (newNode!=null){
            str.append(newNode.data);
            newNode=newNode.next;
        }
        int ans = Integer.parseInt(str.toString(),2);
        System.out.println(ans);
    }

    public void removeNthNodeFromEnd(int n){
        Node newNode = head;
        int len = 0;
        while (newNode!=null){
            len++;
            newNode = newNode.next;
        }
        int NthNodeFromStart = (len-n)+1;
        if(NthNodeFromStart==1) {
            head=head.next;
            return;
        }
        Node prev = head;
        int itr=1;
        while (itr!=NthNodeFromStart-1){
            prev = prev.next;
            itr++;
        }
        if(prev.next.next!=null) prev.next = prev.next.next;
        else prev.next=null;

    }

    public void rotateRightByK_Places(int k){
        if(head==null || head.next==null) return;
        Node newNode = head;
        int len=0;
        while (newNode!=null){
            len++;
            newNode=newNode.next;
        }
        if(k>len) k=k%len;
        while (k!=0){
            Node prev=head;
            Node curr = head;
            while (curr.next!=null){
                prev=curr;
                curr=curr.next;
            }
            curr.next=head;
            head=curr;
            prev.next=null;
            k--;
        }
    }

    public void swapNodes(int k){
        Node newNode = head;
        int length = 0;
        while (newNode!=null){
            length++;
            newNode=newNode.next;
        }
        // For Left
        Node left = head;
        int itr=1;
        while (itr!=k){
            left=left.next;
            itr++;
        }
        // For Right
        itr=1;
        int kForBack = length-k+1;
        Node right = head;
        while (itr!=kForBack){
            right=right.next;
            itr++;
        }
        int temp = left.data;
        left.data=right.data;
        right.data=temp;
    }
    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
//        ll.addLast(8);
//        ll.addLast(3);
//        ll.addLast(0);
//        ll.addLast(9);
//        ll.addLast(5);
        ll.swapNodes(2);
       ll.printLinkedList();
    }
}