package BackTracking;

public class PermutationStrings_Backtracking {
    public static void findPermutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for (int j = 0; j < str.length(); j++) {
            char curr = str.charAt(j);
            String temp = str.substring(0,j) + str.substring(j+1);
            findPermutations(temp,ans+curr);
        }
    }

    public static void main(String[] args) {
        findPermutations("abc","");
    }
}
