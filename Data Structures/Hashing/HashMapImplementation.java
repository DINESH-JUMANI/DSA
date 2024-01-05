package Hashing;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation {
    static class HashMap<Key,Value>{
        private class Node{
            Key key;
            Value value;
            Node(Key key, Value value){
                this.key = key;
                this.value = value;
            }
        }
        private int totalNodes;
        private int totalBuckets;
        private LinkedList<Node> [] buckets;

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.totalBuckets = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int  hashFunction(Key key){
            int hc = key.hashCode();
            return Math.abs(hc) % totalBuckets;
        }
        private int searchInLL(Key key, int bucketIndex){
            LinkedList<Node> ll = buckets[bucketIndex];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key==key) return di;
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void reHash(){
            LinkedList<Node> [] oldBucket = buckets;
            buckets = new LinkedList[totalBuckets*2];
            totalBuckets*=2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(Key key, Value value){ // O(lambda) -> O(1)
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);

            if(dataIndex != -1){
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }
            else{
                buckets[bucketIndex].add(new Node(key, value));
                totalNodes++;
            }

            double lambda =(double)totalNodes/totalBuckets;
            double threshold = 2.0;
            if(lambda>threshold) reHash();
        }

        public boolean containsKey(Key key){ // O(lambda) -> O(1)
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);
            return dataIndex != -1;
        }

        public Value get(Key key){ // O(lambda) -> O(1)
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);

            if(dataIndex != -1){
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
            else return null;
        }

        public Value remove(Key key){ // O(lambda) -> O(1)
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(key,bucketIndex);

            if(dataIndex != -1){
                Node node = buckets[bucketIndex].remove(dataIndex);
                totalNodes--;
                return node.value;
            }
            else return null;
        }

        public ArrayList<Key> keySet(){
            ArrayList<Key> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node:ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return totalNodes==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India",200);
        hm.put("Japan",100);
        hm.put("China",300);
        hm.put("USA",800);

        ArrayList<String> keys = hm.keySet();
        System.out.println(keys);
        System.out.println(hm.get("India"));
        System.out.println(hm.remove("USA"));
    }
}
