package Hashing;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TypesOfSets {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>(); // O(1)
        hs.add(5);
        hs.add(2);
        hs.add(1);
        hs.add(2);
        hs.add(5);
        hs.add(3);

        // USING ITERATORS
        Iterator<Integer> itr = hs.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println();
        
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(); // O(1)
        lhs.add(5);
        lhs.add(2);
        lhs.add(1);
        lhs.add(2);
        lhs.add(5);
        lhs.add(3);
        System.out.println(lhs);

        TreeSet<Integer> ts = new TreeSet<>(); // O(logn)
        ts.add(1);
        ts.add(2);
        ts.add(3);
        ts.add(2);
        ts.add(5);
        ts.add(3);
        System.out.println(ts);
        
    }
}
