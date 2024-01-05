package BinaryTrees;
import java.util.*;

public class BinaryTreeOperations {

    static class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    static class BinaryTree{

        static int index = -1;
        public static Node buildTree(int [] nodes){
            index++;
            if(nodes[index]==-1) return null;
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root){ // ROOT LEFT RIGHT
            if(root==null) return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){ // LEFT ROOT RIGHT
            if(root==null) return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){ // LEFT RIGHT ROOT
            if(root==null) return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root){
            if(root==null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()) break;
                    else q.add(null);
                }
                else {
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null) q.add(currNode.left);
                    if(currNode.right!=null) q.add(currNode.right);
                }
            }
        }

        public static int height(Node root){
            if(root==null) return 0;
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;
        }

        public static int countNodes(Node root){
            if(root==null) return 0;
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);
            return leftCount+rightCount+1;
        }

        public static int sumNodes(Node root){
            if(root==null) return 0;
            int leftSum = sumNodes(root.left);
            int rightSum = sumNodes(root.right);
            return leftSum + rightSum + root.data;
        }

        public static int diameter2(Node root){ // O(n2)
            if(root==null) return 0;
            int leftDiameter = diameter2(root.left);
            int rightDiameter = diameter2(root.right);
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            int selfDiameter = leftHeight+rightHeight+1;
            return Math.max(selfDiameter,Math.max(rightDiameter,leftDiameter));
        }

        static class InfoDiameter{
            int diam;
            int ht;
            public InfoDiameter(int diam, int ht){
                this.diam = diam;
                this.ht = ht;
            }
        }
        public static InfoDiameter diameter(Node root){
            if(root==null) return new InfoDiameter(0,0);
            InfoDiameter leftInfo = diameter(root.left);
            InfoDiameter rightInfo = diameter(root.right);
            int diam = Math.max(leftInfo.ht + rightInfo.ht + 1,Math.max(leftInfo.diam, rightInfo.diam));
            int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new InfoDiameter(diam,ht);
        }

        public static boolean isIdentical(Node root, Node subRoot){
            if(root==null && subRoot==null) return true;
            else if(root==null || subRoot==null || root.data!=subRoot.data) return false;
            if(!isIdentical(root.left,subRoot.left)) return false;
            if(!isIdentical(root.right,subRoot.right)) return false;
            return true;
        }
        public static boolean isSubtree(Node root, Node subRoot){
            if(root==null) return false;
            if(root.data==subRoot.data){
                if(isIdentical(root,subRoot)) return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        static class InfoView{
            Node node;
            int hd;
            public InfoView(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        public static void topView(Node root){
            Queue<InfoView> q = new LinkedList<>();
            HashMap<Integer,Node> map = new HashMap<>();
            int min = 0, max = 0;
            q.add(new InfoView(root,0));
            q.add(null);

            while (!q.isEmpty()){
                InfoView currInfo = q.remove();
                if(currInfo==null){
                    if(q.isEmpty()) break;
                    else q.add(null);
                }
                else{
                    if(!map.containsKey(currInfo.hd)) map.put(currInfo.hd, currInfo.node);
                    if(currInfo.node.left!=null){
                        q.add(new InfoView(currInfo.node.left, currInfo.hd-1));
                        min = Math.min(min, currInfo.hd-1);
                    }
                    if(currInfo.node.right!=null){
                        q.add(new InfoView(currInfo.node.right, currInfo.hd+1));
                        max = Math.max(max, currInfo.hd+1);
                    }
                }
            }
            for (int i = min; i <= max ; i++) {
                System.out.print(map.get(i).data+" ");
            }
            System.out.println();
        }

        public static void KthLevelIterative(Node root, int k){
            if(root==null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int currLevel = 1;
            while (!q.isEmpty()){
                if(currLevel>k) break;
                Node currNode = q.remove();
                if(currNode==null){
                    if(q.isEmpty()) break;
                    else{
                        q.add(null);
                        currLevel++;
                    }
                }
                else {
                    if(currLevel==k) System.out.print(currNode.data+" ");
                    if(currNode.left!=null) q.add(currNode.left);
                    if(currNode.right!=null)q.add(currNode.right);
                }
            }
        }

        public static void KthLevelRecursive(Node root, int level, int k){
            if(root==null) return;
            if(level==k){
                System.out.print(root.data+" ");
                return;
            }
            KthLevelRecursive(root.left,level+1,k);
            KthLevelRecursive(root.right,level+1,k);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node>path){
            if(root==null) return false;
            path.add(root);
            if(root.data==n) return true;
            boolean checkRight = getPath(root.right,n,path);
            boolean checkLeft = getPath(root.left,n,path);
            if(checkRight || checkLeft) return true;
            path.remove(path.size()-1);
            return false;
        }
        public static Node leastCommonAncestor(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();
            getPath(root,n1,path1);
            getPath(root,n2,path2);

            int i;
            for (i = 0; i <path1.size() && i<path2.size(); i++) {
                if(path1.get(i)!=path2.get(i)) break;
            }
            return path1.get(i-1);
        }

        public static Node leastCommonAncestor2(Node root, int n1, int n2){
            if(root==null || root.data==n1 || root.data==n2) return root;

            Node leftLca = leastCommonAncestor2(root.left,n1,n2);
            Node rightLca = leastCommonAncestor2(root.right,n1,n2);

            if(leftLca==null) return rightLca;
            if(rightLca==null) return leftLca;
            return root;
        }

        public static int leastCommonAncestorDistance(Node root, int n){
            if(root==null) return -1;
            if(root.data==n) return 0;
            int leftDistance = leastCommonAncestorDistance(root.left,n);
            int rightDistance = leastCommonAncestorDistance(root.right,n);
            if(leftDistance==-1 && rightDistance==-1) return -1;
            else if(leftDistance==-1) return rightDistance+1;
            else return leftDistance+1;
        }
        public static int minDistance(Node root, int n1, int n2){
            Node lca = leastCommonAncestor(root, n1, n2);
            int dist1 = leastCommonAncestorDistance(lca,n1);
            int dist2 = leastCommonAncestorDistance(lca,n2);
            return dist1+dist2;
        }

        public static int KthAncestor(Node root, int n, int k){
            if(root==null) return -1;
            if(root.data==n) return 0;
            int leftDistance = KthAncestor(root.left,n,k);
            int rightDistance = KthAncestor(root.right,n,k);
            if(leftDistance==-1 && rightDistance==-1) return -1;
            int distance = Math.max(leftDistance,rightDistance)+1;
            if(distance==k) System.out.println(root.data);
            return distance;
        }

        public static int getSum(Node root){
            if(root==null) return 0;
            int data = root.data;
            int leftSum = getSum(root.left);
            int rightSum = getSum(root.right);
            int newLeft = root.left==null ? 0 : root.left.data;
            int newRight = root.right==null ? 0 : root.right.data;
            root.data = leftSum + rightSum + newLeft + newRight;
            return data;
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.getSum(root);
        BinaryTree.preOrder(root);
    }
}
