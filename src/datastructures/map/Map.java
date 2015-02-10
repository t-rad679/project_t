package datastructures.map;

import datastructures.list.List;

/**
 * An abstract representation of a map, also known as a dictionary.  It is essentially
 * a set of key-value pairs.
 * @author Trevor Radcliffe
 * @version 1.0
 */
public interface Map<K, V> {

    /**
     * @return An array of the keys to this map
     */
    public List<K> getKeys();

    /**
     * @return An array of the values in this map
     */
    public List<V> getValues();

    /**
     * @return A list of entries stored in this map
     */
    public List<Entry<K, V>> getEntries();

    /**
     * @param key The key associated with the desired value
     * @return The value in this map at key
     */
    public V get(K key);

    /**
     * Puts a value in this map of the given value at the given key
     * @param key The given key
     * @param value The given value
     */
    public void put(K key, V value);

    /**
     * @return The number of entries in this map
     */
    public int size();


}
