package Tries;

import java.util.ArrayList;

public class TrieImplementation {
    static class Node{
        Node [] children = new Node[26];
        boolean endOfWord = false;
        Node(){
            for (int i = 0; i < 26; i++) {
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){ // O(Length of longest word)
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx]==null) curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String word){ // O(Length of longest word)
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]==null) return false;
            else curr = curr.children[idx];
        }
        return curr.endOfWord;
    }

    public static boolean wordBreak(String key){
        if (key.length()==0) return true;
        for (int i = 1; i <= key.length(); i++) {
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))) return true;
        }
        return false;
    }

    public static int countNodes(Node root){
        if(root==null) return 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null) count+=countNodes(root.children[i]);
        }
        return count+1;
    }

    public static String ans="";
    public static void longestWord(Node root, StringBuilder temp){
        if(root==null) return;
        for (int i = 0; i < 26; i++) {
            if(root.children[i]!=null && root.children[i].endOfWord){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String [] str = {"a","banana","app","appl","apply","apple","ap"};
        for (int i = 0; i < str.length; i++) {
            insert(str[i]);
        }
        longestWord(root,new StringBuilder(""));
        System.out.println(ans);

    }
}
