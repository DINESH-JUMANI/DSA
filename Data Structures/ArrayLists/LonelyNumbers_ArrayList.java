package ArrayLists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LonelyNumbers_ArrayList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            if(i>0 && i<arr.size()-1){
                if(arr.get(i-1)!=(arr.get(i)-1) && arr.get(i-1)!=arr.get(i) && arr.get(i+1)!=arr.get(i)+1 && arr.get(i+1)!=arr.get(i)){
                    ans.add(arr.get(i));
                }
            }
            else if (i==0) {
                if(arr.get(i)!= arr.get(i+1) && (arr.get(i)+1)!=arr.get(i+1)) ans.add(arr.get(i));
            }
            else {
                if(arr.get(i)!= arr.get(i-1) && (arr.get(i)-1)!=arr.get(i-1)) ans.add(arr.get(i));
            }
        }
        System.out.println(ans);
    }

}
