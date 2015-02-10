package datastructures.map.hashmap;


import datastructures.map.Entry;

/**
 * Created by t_rad on 2/9/15.
 */
public  abstract class HashEntry<K, V> implements Entry<K, V> {
    K key;
    V value;

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public abstract HashEntry<K, V> find(K key);

}
