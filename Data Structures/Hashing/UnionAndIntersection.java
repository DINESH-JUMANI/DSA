package Hashing;

import java.util.HashSet;
import java.util.Objects;

public class UnionAndIntersection {
    public static void main(String[] args) {
        int [] arr1 = {7,3,9};
        int [] arr2 = {6,3,9,2,9,4};

        // Union
        HashSet<Integer> hs = new HashSet<>();
        for(int temp : arr1) hs.add(temp);
        for(int temp : arr2) hs.add(temp);
        System.out.println("UNION : " + hs);

        // Intersection
        hs.clear();
        HashSet<Integer> result = new HashSet<>();
        for(int temp : arr1) hs.add(temp);
        for(int temp : arr2){
            if(hs.contains(temp)){
                result.add(temp);
                hs.remove(temp);
            }
        }
        System.out.println("INTERSECTION : " + result);
    }
}
