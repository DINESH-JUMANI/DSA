package BackTracking;

public class SubsetStrings_Backtracking {

    public static void findSubsets(String str, String ans, int i){
        if(str.length()==i){
            if(ans.length()==0) System.out.println("null");
            else System.out.println(ans);
            return;
        }
        findSubsets(str,ans+str.charAt(i),i+1);
        findSubsets(str,ans,i+1);
    }
    public static void main(String[] args) {
        findSubsets("abc","",0);
    }
}
