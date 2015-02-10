package datastructures.map.hashmap;

import datastructures.list.ArrayList;
import datastructures.list.List;
import datastructures.map.Entry;
import datastructures.map.Map;

/**
 * Created by t_rad on 2/10/15.
 */
public abstract class HashMap<K, V> implements Map<K, V> {
    protected int size = 0;
    protected HashEntry<K, V>[] table;
    protected HashFunction<K> hashFunction;

    protected abstract  void addToBucket(K key, V value, int hash);

    private int hash(K key){
        return hashFunction.hash(key);
    }

    @Override
    public List<K> getKeys(){
        ArrayList<K> keys = new ArrayList<>(size());

        List<Entry<K, V>> entries = getEntries();
        for(int i=0; i<entries.size(); i++){
            keys.put(entries.get(i).getKey());
        }
        return keys;
        //O(n)
    }

    @Override
    public List<V> getValues() {
        ArrayList<V> values = new ArrayList<>(size());
        List<Entry<K, V>> entries = getEntries();
        for(int i=0; i<entries.size(); i++){
            values.put(entries.get(i).getValue());
        }
        return values;
        //O(n)
    }

    @Override
    public List<Entry<K, V>> getEntries() {
        ArrayList<HashEntry<K, V>> ret = new ArrayList<>(size);
        int entryIdx = 0;
        for (int i = 0; i < size; i++) {
            HashEntry<K, V> current = null;
            while(current==null){
                current = table[entryIdx];
                entryIdx++;
            }
            ret.put(current);
        }
        return ret;
        //O(n)
    }

    @Override
    public V get(K key) {
        int hash = hash(key);
        HashEntry<K, V> entry = table[hash].find(key);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        int hash = hash(key);
        addToBucket(key, value, hash);
    }

    @Override
    public int size() {
        return size;
    }
}
