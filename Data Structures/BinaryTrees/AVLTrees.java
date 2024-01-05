package BinaryTrees;

public class AVLTrees {
    static class Node{
        int data, height;
        Node left,right;
        Node(int data){
            this.data = data;
            height = 1;
            left = null;
            right = null;
        }
    }
    public static int height(Node root){
        if(root==null) return 0;
        else return root.height;
    }

    public static int getBalanceFactor(Node root){
        if(root==null) return 0;
        return height(root.left)-height(root.right);
    }

    public static Node rightRotate(Node topRoot){
        Node midRoot = topRoot.left;
        Node bottomRoot = midRoot.right;
        midRoot.right = topRoot;
        topRoot.left = bottomRoot;
        topRoot.height = Math.max(height(topRoot.right),height(topRoot.left)) + 1;
        midRoot.height = Math.max(height(topRoot.right),height(topRoot.left)) + 1;
        return midRoot;
    }

    public static Node leftRotate(Node topRoot){
        Node midRoot = topRoot.right;
        Node bottomRoot = midRoot.left;
        midRoot.left = topRoot;
        topRoot.right = bottomRoot;
        topRoot.height = Math.max(height(topRoot.right),height(topRoot.left)) + 1;
        midRoot.height = Math.max(height(topRoot.right),height(topRoot.left)) + 1;
        return midRoot;

    }

    public static Node insert(Node root, int val){
        if(root==null) return new Node(val);
        if(val< root.data) root.left = insert(root.left,val);
        else if(val> root.data) root.right = insert(root.right,val);
        else return root;

        root.height = Math.max(height(root.left),height(root.right))+1;
        int balanceFactor = getBalanceFactor(root);
        // LL ROTATION
        if(balanceFactor>1 && val<root.left.data) return rightRotate(root);
        // RR Rotation
        if(balanceFactor < -1 && val > root.right.data) return leftRotate(root);
        // LR Rotation
        if(balanceFactor>1 && val > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // RL Rotation
        if(balanceFactor<-1 && val < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void preorder(Node root){
        if(root==null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = null;

        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        root = insert(root,25);
        preorder(root);
    }
}
