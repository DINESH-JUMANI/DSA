// Linked Hash Map returns the order as same as insertion order.
// Treemap return the value in sorted order lexicographically according to key
// Hash map return in random order

package Hashing;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TypesOfMaps {
    public static void main(String[] args) {

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",1);
        hm.put("China",2);
        hm.put("USA",3);
        hm.put("Japan",4);
        System.out.println(hm);

        LinkedHashMap<String,Integer> lhm = new LinkedHashMap<>();
        lhm.put("India",1);
        lhm.put("China",2);
        lhm.put("USA",3);
        lhm.put("Japan",4);
        System.out.println(lhm);

        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("India",1);
        tm.put("China",2);
        tm.put("USA",3);
        tm.put("Japan",4);
        System.out.println(tm);

    }
}
