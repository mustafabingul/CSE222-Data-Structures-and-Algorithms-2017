import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by syucer on 4/24/2017.
 */
public class HashTableChaining<K, V> implements HashMap<K, V> {
    /** The table */
    //private HashTableOpen<Entry<K, V>>[] table;
    //Do not forget you can use more class and methods to do this homework,
    // this project gives you an initial classes an methods to see easily
    //....
    //.... other class members

    /** The table */
    private HashTableOpen<K,Entry<K, V>>[] tablee;
    private LinkedList < Entry < K, V >> [] table;
    /** The number of keys */
    private int numKeys;

    /** The capacity */
    private static final int CAPACITY = 101;

    /** The maximum load factor */
    private static final double LOAD_THRESHOLD = 3.0;

    /** Contains key-value pairs for a hash table. */
    private static class Entry < K, V > {

        /** The key */
        private K key;

        /** The value */
        private V value;

        /** Creates a new key-value pair.
         @param key The key
         @param value The value
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /** Retrieves the key.
         @return The key
         */
        public K getKey() {
            return key;
        }

        /** Retrieves the value.
         @return The value
         */
        public V getValue() {
            return value;
        }

        /** Sets the value.
         @param val The new value
         @return The old value
         */
        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }
    // Constructor
    public HashTableChaining() {
        table = new LinkedList[CAPACITY];
    }

    /** Method get for class HashtableChain.
     @param key The key being sought
     @return The value associated with this key if found;
     otherwise, null
     */
    public V get(Object key) {
        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length;
        if (table[index] == null)
            return null; // key is not in the table.

        // Search the list at table[index] to find the key.
        for (Entry < K, V > nextItem : table[index]) {
            if (nextItem.key.equals(key))
                return nextItem.value;
        }

        // assert: key is not in the table.
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


}
