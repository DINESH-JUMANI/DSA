package BinaryTrees;

import java.util.ArrayList;

public class BinarySearchTreeOperations {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node insert(Node root, int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left,val);
        }
        else {
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void printInRange(Node root, int start, int end){
        if(root==null) return;
        printInRange(root.left,start,end);
        if(root.data>=start && root.data<=end) System.out.print(root.data+" ");
        printInRange(root.right,start,end);
    }

    public static boolean search(Node root, int key){
        if(root==null) return false;
        else if(key== root.data) return true;
        else if(key>root.data) return search(root.right,key);
        else return search(root.left,key);
    }


    public static Node delete(Node root, int val){
        if(val>root.data) root.right = delete(root.right,val);
        else if(val<root.data) root.left = delete(root.left,val);
        else{
            // CASE 1 LEAF NODE
            if(root.left == null && root.right == null) return null;

            // CASE 2 ONE CHILD
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;

            // CASE 3 TWO CHILD
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right,inorderSuccessor.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while (root.left!=null) root = root.left;
        return root;
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null) System.out.println(path);
        printRootToLeaf(root.left,path);
        printRootToLeaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root,Node min, Node max){
        if(root==null) return true;
        if(min!=null && root.data<=min.data) return false;
        else if(max!=null && root.data>= max.data) return false;
        return isValidBST(root.left,min,root) && isValidBST(root.right,root,max);
    }

    public static Node mirrorTree(Node root){
        if(root==null) return null;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }

    public static Node createBalanced_BST_UsingSortedArray(int [] arr, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBalanced_BST_UsingSortedArray(arr,start,mid-1);
        root.right = createBalanced_BST_UsingSortedArray(arr,mid+1,end);
        return root;
    }

    static class Info{
        boolean isBST;
        int size;
        int max,min;

        Info(boolean isBST, int size,int min, int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBST = 0;
    public static Info largestBST(Node root){
        if(root==null) return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size+rightInfo.size+1;
        int min = Math.min(root.data,Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        if(root.data<= leftInfo.max || root.data>= rightInfo.min) return new Info(false,size,min,max);
        if(leftInfo.isBST && rightInfo.isBST){
            maxBST = Math.max(maxBST,size);
            return new Info(true,size,min,max);
        }
        return new Info(false,size,min,max);
    }


    public static void main(String[] args) {
        int [] values = {1,2,3,4,5,6,7,8,9};
        Node root2 = createBalanced_BST_UsingSortedArray(values,0,values.length-1);
        inorder(root2);
        System.out.println();
        Info info = largestBST(root2);
        System.out.println(maxBST);
    }
}
