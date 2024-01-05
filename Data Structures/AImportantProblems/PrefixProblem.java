package AImportantProblems;

public class PrefixProblem {
    static class Node{
        Node [] children = new Node[26];
        boolean endOfWord = false;
        int noOfChildren;

        public Node(){
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
            noOfChildren = 1;
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null) curr.children[idx] = new Node();
            else curr.children[idx].noOfChildren++;
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static void findPrefix(Node root, String ans){ // MAIN FUNCTION OF QUESTION
        if(root==null) return;
        if(root.noOfChildren==1){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i]!=null) findPrefix(root.children[i],ans+(char)(i+'a'));
        }
    }
    public static void main(String[] args) {
        String [] words = {"zebra","dog","duck","dove"};
        for (String temp : words) insert(temp);
        root.noOfChildren = -1;
        findPrefix(root,"");
    }
}
