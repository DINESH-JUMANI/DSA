package SegmentTree;

public class SegmentTreeSumQuery {

    static int [] tree;
    public static void init(int n){
        tree = new int[4*n];
    }

    public static void buildSegmentTree(int [] arr, int index, int start, int end){ // O(n)
        if(start==end){
            tree[index] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        buildSegmentTree(arr,2*index+1,start,mid);
        buildSegmentTree(arr,2*index+2,mid+1,end);
        tree[index] = tree[2*index+1] + tree[2*index+2];
    }

    public static int getSumInRange(int [] arr, int qi, int qj){ // O(logn)
        int n = arr.length;
        return getSumUtil(0,0,n-1,qi,qj);

    }
    public static int getSumUtil(int index, int si, int sj, int qi, int qj){
        // Non Overlapping
        if(qj<=si || qi>=sj) return 0;
        // Complete overlapping
        else if(si>=qi && sj<=qj) return tree[index];
        // Partial overlapping
        else{
            int mid =  (si+sj)/2;
            int left = getSumUtil(2*index+1,si,mid,qi,qj);
            int right = getSumUtil(2*index+2,mid+1,sj,qi,qj);
            return left+right;
        }
    }

    public static void update(int [] arr, int changeIdx, int newVal){
        int diff = newVal-arr[changeIdx];
        arr[changeIdx] = newVal;
        updateUtil(0,0,arr.length-1,changeIdx,diff);
    }
    public static void updateUtil(int index, int si, int sj, int changeIdx,int diff){
        if(changeIdx<si || changeIdx>sj) return;
        tree[index]+=diff;
        if(si!=sj){
            int mid = (si+sj)/2;
            updateUtil(2*index+1,si,mid,changeIdx,diff);
            updateUtil(2*index+2,mid+1,sj,changeIdx,diff);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildSegmentTree(arr,0,0,n-1);
        System.out.println(getSumInRange(arr,2,5));
        update(arr,2,2);
        System.out.println(getSumInRange(arr,2,5));
    }
}
