/**
 * Created by syucer on 4/24/2017.
 */
/**
 * Rewrite by Mustafa Bingül 141044077
 */

import javafx.scene.control.SortEvent;

import java.util.*;

public class BinaryNavMap<K,V> extends AbstractMap<K,V>
        implements NavigableMap<K,V>, Cloneable, java.io.Serializable
{

    private boolean status;
    public BinaryNavMap(){
        root = new BSTNode<K,V>();
        status=true;
    }

    /**
     * Set return eder.
     * @return
     */
    @Override
    public Set<Entry<K, V>> entrySet() {
        inOrderIter(root);
        Set<Entry<K,V>> st = new TreeSet<Entry<K, V>>();
        for(int i=0; i<mpArray.size(); ++i){
            st.add(mpArray.get(i));
        }
        return st;
    }

    /**
     * Returns a key-value mapping associated with the greatest key
     * strictly less than the given key, or {@code null} if there is
     * no such key.
     *
     * @param key the key
     * @return an entry with the greatest key less than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> lowerEntry(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        for(int i=0; i<mpArrayNode.size();++i){
            if(mpArrayNode.get(i).compareTo(key) == 1){
                tmp = mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp;
    }

    /**
     * Returns the greatest key strictly less than the given key, or
     * {@code null} if there is no such key.
     *
     * @param key the key
     * @return the greatest key less than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K lowerKey(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        for(int i=0; i<mpArrayNode.size();++i){
            if(mpArrayNode.get(i).compareTo(key) == 1){
                tmp = mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp.getKey();
    }

    /**
     * Returns a key-value mapping associated with the greatest key
     * less than or equal to the given key, or {@code null} if there
     * is no such key.
     *
     * @param key the key
     * @return an entry with the greatest key less than or equal to
     * {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> floorEntry(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        for(int i=0; i<mpArrayNode.size();++i){
            if(mpArrayNode.get(i).compareTo(key) == 1 || mpArrayNode.get(i).compareTo(key) == 0){
                tmp = mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp;
    }

    /**
     * Returns the greatest key less than or equal to the given key,
     * or {@code null} if there is no such key.
     *
     * @param key the key
     * @return the greatest key less than or equal to {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K floorKey(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        for(int i=0; i<mpArrayNode.size();++i){
            if(mpArrayNode.get(i).compareTo(key) == 1 || mpArrayNode.get(i).compareTo(key) == 0){
                tmp = mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp.getKey();
    }

    /**
     * Returns a key-value mapping associated with the least key
     * greater than or equal to the given key, or {@code null} if
     * there is no such key.
     *
     * @param key the key
     * @return an entry with the least key greater than or equal to
     * {@code key}, or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> ceilingEntry(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        int local=0;
        for(int i=mpArrayNode.size()-1; i>0; --i ) {
            if(mpArrayNode.get(i).compareTo(key) == -1 || mpArrayNode.get(i).compareTo(key) == 0){
                tmp=mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp;
    }

    /**
     * Returns the least key greater than or equal to the given key,
     * or {@code null} if there is no such key.
     *
     * @param key the key
     * @return the least key greater than or equal to {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K ceilingKey(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        int local=0;
        for(int i=mpArrayNode.size()-1; i>0; --i ) {
            if(mpArrayNode.get(i).compareTo(key) == -1 || mpArrayNode.get(i).compareTo(key) == 0){
                tmp=mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp.getKey();
    }

    /**
     * Returns a key-value mapping associated with the least key
     * strictly greater than the given key, or {@code null} if there
     * is no such key.
     *
     * @param key the key
     * @return an entry with the least key greater than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public Entry<K, V> higherEntry(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        int local=0;
        for(int i=mpArrayNode.size()-1; i>=0;--i ) {
            if(mpArrayNode.get(i).compareTo(key) == -1){
                tmp=mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp;
    }

    /**
     * Returns the least key strictly greater than the given key, or
     * {@code null} if there is no such key.
     *
     * @param key the key
     * @return the least key greater than {@code key},
     * or {@code null} if there is no such key
     * @throws ClassCastException   if the specified key cannot be compared
     *                              with the keys currently in the map
     * @throws NullPointerException if the specified key is null
     *                              and this map does not permit null keys
     */
    @Override
    public K higherKey(K key) {
        inOrderIter(root);
        Entry<K,V> tmp=null;
        int local=0;
        for(int i=mpArrayNode.size()-1; i>=0;--i ) {
            if(mpArrayNode.get(i).compareTo(key) == -1){
                tmp=mpArrayNode.get(i);
            }
        }
        if(tmp==null){
            throw new NullPointerException();
        }
        return tmp.getKey();
    }

    /**
     * Returns a key-value mapping associated with the least
     * key in this map, or {@code null} if the map is empty.
     *
     * @return an entry with the least key,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> firstEntry() {

        inOrderIter(root);
        Entry<K,V> entry = mpArray.get(0);

        return entry;
    }

    /**
     * Returns a key-value mapping associated with the greatest
     * key in this map, or {@code null} if the map is empty.
     *
     * @return an entry with the greatest key,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> lastEntry() {
        inOrderIter(root);

        Entry<K,V> entry = mpArray.get(mpArray.size()-1);
        //System.out.println("LASTENTRY -> "+entry.getKey());
        return entry;
    }

    /**
     * Removes and returns a key-value mapping associated with
     * the least key in this map, or {@code null} if the map is empty.
     *
     * @return the removed first entry of this map,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> pollFirstEntry() {
        return null;
    }

    /**
     * Removes and returns a key-value mapping associated with
     * the greatest key in this map, or {@code null} if the map is empty.
     *
     * @return the removed last entry of this map,
     * or {@code null} if this map is empty
     */
    @Override
    public Entry<K, V> pollLastEntry() {return null;  }

    /**
     * Returns a reverse order view of the mappings contained in this map.
     * The descending map is backed by this map, so changes to the map are
     * reflected in the descending map, and vice-versa.  If either map is
     * modified while an iteration over a collection view of either map
     * is in progress (except through the iterator's own {@code remove}
     * operation), the results of the iteration are undefined.
     * <p>
     * <p>The returned map has an ordering equivalent to
     * <tt>{@link Collections#reverseOrder(Comparator) Collections.reverseOrder}(comparator())</tt>.
     * The expression {@code m.descendingMap().descendingMap()} returns a
     * view of {@code m} essentially equivalent to {@code m}.
     *
     * @return a reverse order view of this map
     */
    @Override
    public NavigableMap<K, V> descendingMap() {
        inOrderIter(root);
        NavigableMap<K,V> nvmap=new TreeMap<K, V>();

        for(int i=mpArray.size()-1; i>=0;--i){
            nvmap.put(mpArray.get(i).getKey(),mpArray.get(i).getValue());
            System.out.println("descendingMap -> "+ mpArray.get(i).getKey());
        }

        return nvmap;
    }

    /**
     * Returns a {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in ascending order.
     * The set is backed by the map, so changes to the map are reflected in
     * the set, and vice-versa.  If the map is modified while an iteration
     * over the set is in progress (except through the iterator's own {@code
     * remove} operation), the results of the iteration are undefined.  The
     * set supports element removal, which removes the corresponding mapping
     * from the map, via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
     * It does not support the {@code add} or {@code addAll} operations.
     *
     * @return a navigable set view of the keys in this map
     */
    @Override
    public NavigableSet<K> navigableKeySet() {
        inOrderIter(root);
        NavigableSet<K> nvset = new TreeSet<K>();

        for(int i=0; i<mpArray.size(); ++i){
            nvset.add(mpArray.get(i).getKey());
            //System.out.println(mpArray.get(i).getKey());
        }

        return nvset;
    }

    /**
     * Returns a reverse order {@link NavigableSet} view of the keys contained in this map.
     * The set's iterator returns the keys in descending order.
     * The set is backed by the map, so changes to the map are reflected in
     * the set, and vice-versa.  If the map is modified while an iteration
     * over the set is in progress (except through the iterator's own {@code
     * remove} operation), the results of the iteration are undefined.  The
     * set supports element removal, which removes the corresponding mapping
     * from the map, via the {@code Iterator.remove}, {@code Set.remove},
     * {@code removeAll}, {@code retainAll}, and {@code clear} operations.
     * It does not support the {@code add} or {@code addAll} operations.
     *
     * @return a reverse order navigable set view of the keys in this map
     */
    @Override
    public NavigableSet<K> descendingKeySet() {
        inOrderIter(root);
        NavigableSet<K> nvset=new TreeSet<K>();

        for(int i=mpArray.size()-1; i>=0; --i){
            nvset.add(mpArray.get(i).getKey());
            //System.out.println("descendingKeySet -> "+mpArray.get(i).getKey());
        }
        return nvset;
    }

    /**
     * Returns a view of the portion of this map whose keys range from
     * {@code fromKey} to {@code toKey}.  If {@code fromKey} and
     * {@code toKey} are equal, the returned map is empty unless
     * {@code fromInclusive} and {@code toInclusive} are both true.  The
     * returned map is backed by this map, so changes in the returned map are
     * reflected in this map, and vice-versa.  The returned map supports all
     * optional map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside of its range, or to construct a
     * submap either of whose endpoints lie outside its range.
     *
     * @param fromKey       low endpoint of the keys in the returned map
     * @param fromInclusive {@code true} if the low endpoint
     *                      is to be included in the returned view
     * @param toKey         high endpoint of the keys in the returned map
     * @param toInclusive   {@code true} if the high endpoint
     *                      is to be included in the returned view
     * @return a view of the portion of this map whose keys range from
     * {@code fromKey} to {@code toKey}
     * @throws ClassCastException       if {@code fromKey} and {@code toKey}
     *                                  cannot be compared to one another using this map's comparator
     *                                  (or, if the map has no comparator, using natural ordering).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromKey} or {@code toKey}
     *                                  cannot be compared to keys currently in the map.
     * @throws NullPointerException     if {@code fromKey} or {@code toKey}
     *                                  is null and this map does not permit null keys
     * @throws IllegalArgumentException if {@code fromKey} is greater than
     *                                  {@code toKey}; or if this map itself has a restricted
     *                                  range, and {@code fromKey} or {@code toKey} lies
     *                                  outside the bounds of the range
     */
    @Override
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
        inOrderIter(root);
        int local1=0,local2=0;
        int flag1=1,flag2=1;

        NavigableMap<K,V> nvmap= new TreeMap<K, V>();

        for(int i=0; i<mpArray.size() && flag1==1; ++i){
            if(mpArray.get(i).getKey().equals(fromKey)){
                local1=i;
                flag1=0;
            }
        }

        for(int j=0; j<mpArray.size() && flag2==1; ++j){
            if(mpArray.get(j).getKey().equals(toKey)){
                local2=j;
                flag2=0;
            }
        }

        if(fromInclusive==true && toInclusive==true){

            while(local1<=local2){
                nvmap.put(mpArray.get(local1).getKey(),mpArray.get(local1).getValue());
                System.out.println("subMap -> "+mpArray.get(local1).getKey()+" "+mpArray.get(local1).getValue());
                local1++;
            }
        }
        else if(fromInclusive==true && toInclusive==false){
            while(local1<local2){
                nvmap.put(mpArray.get(local1).getKey(),mpArray.get(local1).getValue());
                System.out.println("subMap -> "+mpArray.get(local1).getKey()+" "+mpArray.get(local1).getValue());
                local1++;
            }
        }
        else if(fromInclusive==false && toInclusive==true){
            local1++;
            while(local1<=local2){
                nvmap.put(mpArray.get(local1).getKey(),mpArray.get(local1).getValue());
                System.out.println("subMap -> "+mpArray.get(local1).getKey()+" "+mpArray.get(local1).getValue());
                local1++;
            }
        }
        else if(fromInclusive==false && toInclusive==false){
            local1++;
            while(local1<local2){
                nvmap.put(mpArray.get(local1).getKey(),mpArray.get(local1).getValue());
                System.out.println("subMap -> "+mpArray.get(local1).getKey()+" "+mpArray.get(local1).getValue());
                local1++;
            }
        }
        return nvmap;
    }

    /**
     * Returns a view of the portion of this map whose keys are less than (or
     * equal to, if {@code inclusive} is true) {@code toKey}.  The returned
     * map is backed by this map, so changes in the returned map are reflected
     * in this map, and vice-versa.  The returned map supports all optional
     * map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param toKey     high endpoint of the keys in the returned map
     * @param inclusive {@code true} if the high endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this map whose keys are less than
     * (or equal to, if {@code inclusive} is true) {@code toKey}
     * @throws ClassCastException       if {@code toKey} is not compatible
     *                                  with this map's comparator (or, if the map has no comparator,
     *                                  if {@code toKey} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code toKey} cannot be compared to keys
     *                                  currently in the map.
     * @throws NullPointerException     if {@code toKey} is null
     *                                  and this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *                                  restricted range, and {@code toKey} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
        inOrderIter(root);
        int local=0;
        int flag=1;
        int k=0;
        NavigableMap<K,V> nvmap= new TreeMap<K, V>();
        for(int i=0; i<mpArray.size() && flag==1; ++i){
            if(mpArray.get(i).getKey().equals(toKey)){
                local=i;
                flag=0;
            }
        }
        if(inclusive==true){
            while(k<=local){
                nvmap.put(mpArray.get(k).getKey(),mpArray.get(k).getValue());
                System.out.println("headMap -> "+mpArray.get(k).getKey()+" "+mpArray.get(k).getValue());
                k++;
            }
        }
        else if(inclusive==false){
            while(k<local){
                nvmap.put(mpArray.get(k).getKey(),mpArray.get(k).getValue());
                System.out.println("headMap -> "+mpArray.get(k).getKey()+" "+mpArray.get(k).getValue());
                k++;
            }
        }

        return nvmap;
    }

    /**
     * Returns a view of the portion of this map whose keys are greater than (or
     * equal to, if {@code inclusive} is true) {@code fromKey}.  The returned
     * map is backed by this map, so changes in the returned map are reflected
     * in this map, and vice-versa.  The returned map supports all optional
     * map operations that this map supports.
     * <p>
     * <p>The returned map will throw an {@code IllegalArgumentException}
     * on an attempt to insert a key outside its range.
     *
     * @param fromKey   low endpoint of the keys in the returned map
     * @param inclusive {@code true} if the low endpoint
     *                  is to be included in the returned view
     * @return a view of the portion of this map whose keys are greater than
     * (or equal to, if {@code inclusive} is true) {@code fromKey}
     * @throws ClassCastException       if {@code fromKey} is not compatible
     *                                  with this map's comparator (or, if the map has no comparator,
     *                                  if {@code fromKey} does not implement {@link Comparable}).
     *                                  Implementations may, but are not required to, throw this
     *                                  exception if {@code fromKey} cannot be compared to keys
     *                                  currently in the map.
     * @throws NullPointerException     if {@code fromKey} is null
     *                                  and this map does not permit null keys
     * @throws IllegalArgumentException if this map itself has a
     *                                  restricted range, and {@code fromKey} lies outside the
     *                                  bounds of the range
     */
    @Override
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
        inOrderIter(root);
        int local=0;
        int flag=1;
        NavigableMap<K,V> nvmap= new TreeMap<K, V>();
        for(int i=0; i<mpArray.size() && flag==1; ++i){
            if(mpArray.get(i).getKey().equals(fromKey)){
                local=i;
                flag=0;
            }
        }
        if(inclusive==true){
            while(local<mpArray.size()){
                nvmap.put(mpArray.get(local).getKey(),mpArray.get(local).getValue());
                System.out.println("tailMap -> "+mpArray.get(local).getKey()+" "+mpArray.get(local).getValue());
                local++;
            }
        }
        else if(inclusive==false){
            local++;
            while(local<mpArray.size()){
                nvmap.put(mpArray.get(local).getKey(),mpArray.get(local).getValue());
                System.out.println("tailMap -> "+mpArray.get(local).getKey()+" "+mpArray.get(local).getValue());
                local++;
            }
        }

        return nvmap;
    }

    /**
     * Returns the comparator used to order the keys in this map, or
     * {@code null} if this map uses the {@linkplain Comparable
     * natural ordering} of its keys.
     *
     * @return the comparator used to order the keys in this map,
     * or {@code null} if this map uses the natural ordering
     * of its keys
     */
    @Override
    public Comparator<? super K> comparator() {
        return null;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code subMap(fromKey, true, toKey, false)}.
     *
     * @param fromKey
     * @param toKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        inOrderIter(root);
        int flag1=1;
        int flag2=1;
        int local1=0,local2=0;
        SortedMap<K,V> strmp = new TreeMap<K,V>();
        for(int i=0; i<mpArray.size() && flag1==1; ++i){
            if(mpArray.get(i).getKey().equals(fromKey)){
                local1=i;
                flag1=0;
            }
        }
        for(int j=0; j<mpArray.size() && flag2==1; ++j){
            if(mpArray.get(j).getKey().equals(toKey)){
                flag2=0;
                local2 = j;
            }
        }
        while(local1<local2){
            strmp.put(mpArray.get(local1).getKey(),mpArray.get(local1).getValue());
            System.out.println("subMap -> "+mpArray.get(local1).getKey()+" "+mpArray.get(local1).getValue());
            local1++;
        }

        return strmp;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code headMap(toKey, false)}.
     *
     * @param toKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> headMap(K toKey) {////////////////////////////////////////////////////////////////////
        inOrderIter(root);
        int c=0;
        SortedMap<K,V> strmp = new TreeMap<K, V>();
        int flag=1;
        int local=0;
        for(int i=0; i<mpArray.size() && flag==1; ++i){
            if(mpArray.get(i).getKey().equals(toKey)){
                flag=0;
                local=i;
            }
        }
        while(c<local){
            strmp.put(mpArray.get(c).getKey(),mpArray.get(c).getValue());
            System.out.println("headMap -> "+mpArray.get(c).getKey()+" "+mpArray.get(c).getValue());
            c++;
        }
        return strmp;
    }

    /**
     * {@inheritDoc}
     * <p>
     * <p>Equivalent to {@code tailMap(fromKey, true)}.
     *
     * @param fromKey
     * @throws ClassCastException       {@inheritDoc}
     * @throws NullPointerException     {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     */
    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        inOrderIter(root);
        SortedMap<K,V> strmp = new TreeMap<K, V>();
        int local=0;
        int flag=1;
        for(int i=0; i<mpArray.size() && flag==1; ++i){
            if(mpArray.get(i).getKey().equals(fromKey)){
                flag=0;
                local=i;
            }
        }
        while(local<mpArray.size()){
            strmp.put(mpArray.get(local).getKey(),mpArray.get(local).getValue());
            System.out.println("tailMap -> "+mpArray.get(local).getKey()+" "+mpArray.get(local).getValue());
            local++;
        }

        return strmp;
    }

    /**
     * Returns the first (lowest) key currently in this map.
     *
     * @return the first (lowest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    @Override
    public K firstKey() {
        inOrderIter(root);
        return mpArray.get(0).getKey();
    }

    /**
     * Returns the last (highest) key currently in this map.
     *
     * @return the last (highest) key currently in this map
     * @throws NoSuchElementException if this map is empty
     */
    @Override
    public K lastKey() {
        inOrderIter(root);
        return mpArray.get(mpArray.size()-1).getKey();
    }

    /**
     * BST için root objem.
     */
    private BSTNode<K,V> root;

    @Override
    public V get(Object aa){
        V val = root.getValue();
        return val;
    }

    /**
     * put methodu için gerekli yardımcı wrapper methodu.
     * @param nroot
     * @param key
     * @param value
     * @return
     */
    private V insert(BSTNode<K,V> nroot, K key, V value )
    {
        if(nroot==null){
            nroot= new BSTNode(key,value);
            return value;
        }
        if ( nroot.compareTo( key ) < 0 )
        {
            if ( nroot.left != null )
            {
                insert(nroot.left, key, value );
            }
            else
            {
                nroot.left = new BSTNode( key, value );
            }
        }
        else if ( nroot.compareTo( key ) > 0 )
        {
            if ( nroot.right != null )
            {
                insert(nroot.right, key, value );
            }
            else
            {
                nroot.right = new BSTNode( key, value );
            }
        }

        return value;
    }

    /**
     * İstediğimiz şekilde çalışan put methodu.
     * @param key
     * @param value
     * @return
     */
    @Override
    public V put(K key,V value)
    {
        BSTNode<K,V> tvalue =  new BSTNode<K,V>();
        tvalue.value=value;
        if(status==true){
            insertFirst(key,value);
            status=false;
            //System.out.println("PUUUUUUUUTT******11--"+key);
        }
        else {
            //System.out.println("PUUUUUUUUTT******11--"+key);
            tvalue.value = insert(root, key, value);
        }
        return tvalue.value;
    }

    /**
     * put methodu için yazılmış ikinci yardımcı method.
     * @param key
     * @param value
     * @return
     */
    private V insertFirst(K key, V value){
        root.setValue(value);
        root.setKey(key);
        return value;
    }

    /**
     * Entrylerimi tuttuğum yerler. datafields.
     */
    private ArrayList<Map.Entry<K,V>> mpArray = new ArrayList<Entry<K, V>>();
    private ArrayList<BSTNode<K,V>> mpArrayNode = new ArrayList<BSTNode<K,V>>();

    /**
     * BST kuralı için Tree yi inOrder traverse etmem gerek.
     * inorder methodu.
     * İnternetten yardım aldım.
     * http://www.java2blog.com/2014/07/binary-tree-inorder-traversal-in-java.html
     * @param troot
     */
    public void inOrderIter(BSTNode troot) {
        if(troot == null)
            return;

        Stack s = new Stack();
        BSTNode currentNode=troot;

        while(!s.empty() || currentNode!=null){

            if(currentNode!=null)
            {
                s.push(currentNode);
                currentNode=currentNode.left;
            }
            else
            {
                BSTNode n = (BSTNode) s.pop();
                Map.Entry<K,V> mpentry = new BSTNode<K,V>((K)n.getKey(),(V)n.getValue());
                mpArrayNode.add(n);
                mpArray.add(mpentry);//****ARRAY mpEntry dolumu.
                currentNode=n.right;
                //System.out.println("ascending--"+mpentry.getKey());
                //System.out.println("ascending--"+n.getKey());
            }
        }

    }

    /**
     * Inner class for Node struct.
     * @param <K>
     * @param <V>
     */
    private class BSTNode<K,V> implements Map.Entry<K,V>, Comparable<K>{
        private K key;
        private V value;
        private BSTNode left, right;

        public BSTNode(K key, V value) {
            this.value=value;
            this.key=key;
        }
        public BSTNode(){
            this(null,null);
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value=value;
            return value;
        }
        public K setKey(K key){
            this.key=key;
            return key;
        }
        @Override
        public int compareTo(K o) {
            Object obj = o;
            Object objO = this.key;
            if(obj.toString().compareTo(objO.toString())>=1){
                return 1;
            }
            else if(obj.toString().compareTo(objO.toString())<=-1){
                return -1;
            }
            return 0;
        }
    }

    /**
     * toString Methodu.
     * @return
     */
    public String toString(){
        inOrderIter(root);
        String str = "\n";
        int i=0;
        while(i<mpArray.size()){
            str+=mpArray.get(i).getKey()+" "+mpArray.get(i).getValue()+"\n";
            ++i;
        }
        return str;
    }
}