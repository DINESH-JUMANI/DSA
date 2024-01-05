package SegmentTree;

public class SegmentTreeMaxMinQuery {

    static int [] tree;
    public static void init(int n){
        tree = new int[4*n];
    }

    public static void createMaxST(int [] arr, int index, int start, int end){ // O(n)
        if(start==end){
            tree[index] = arr[start];
            return;
        }
        int mid = (start + end)/2;
        createMaxST(arr,2*index+1,start,mid);
        createMaxST(arr,2*index+2,mid+1,end);
        tree[index] = Math.max(tree[2*index+1],tree[2*index+2]);
    }
    public static int getMaxInRange(int [] arr, int qi, int qj){ // O(logn)
        int n = arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);

    }
    public static int getMaxUtil(int index, int si, int sj, int qi, int qj){
        // Non Overlapping
        if(qj<si || qi>sj) return Integer.MIN_VALUE;
            // Complete overlapping
        else if(si>=qi && sj<=qj) return tree[index];
            // Partial overlapping
        else{
            int mid =  (si+sj)/2;
            int left = getMaxUtil(2*index+1,si,mid,qi,qj);
            int right = getMaxUtil(2*index+2,mid+1,sj,qi,qj);
            return Math.max(left,right);
        }
    }

    public static void update(int [] arr, int changeIdx, int newVal){
        arr[changeIdx] = newVal;
        updateUtil(0,0,arr.length-1,changeIdx,newVal);
    }
    public static void updateUtil(int index, int si, int sj, int changeIdx,int newVal){
        if(changeIdx<si || changeIdx>sj) return;
        else if(si==sj) tree[index] = newVal;
        if(si!=sj){
            tree[index]=Math.max(tree[index],newVal);
            int mid = (si+sj)/2;
            updateUtil(2*index+1,si,mid,changeIdx,newVal);
            updateUtil(2*index+2,mid+1,sj,changeIdx,newVal);
        }
    }

    public static void main(String[] args) {
        int [] arr = {6,8,-1,2,17,1,3,2,4};
        init(arr.length);
        createMaxST(arr,0,0,arr.length-1);
        System.out.println(getMaxInRange(arr,2,5));
        update(arr,4,0);
        System.out.println(getMaxInRange(arr,2,5));
    }
}
