package AImportantProblems;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    public static void main(String[] args) {
        int [] nums = {15,-2,2,-8,1,7,10};
        int sum = 0;
        int len = Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum)) len = Math.max(len,i- map.get(sum));
            else map.put(sum,i);
        }
        System.out.println(len);
    }
}
