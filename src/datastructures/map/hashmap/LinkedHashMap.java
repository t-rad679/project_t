package datastructures.map.hashmap;

import datastructures.list.ArrayList;
import datastructures.list.List;
import datastructures.map.Entry;
import datastructures.map.Map;

/**
 * Created by t_rad on 2/8/15.
 */
public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> {
    private final static int DEFAULT_INIT_SIZE = 128;

    public LinkedHashMap(int initialSize){
        table = new LinkedHashEntry[initialSize];
        for(int i=0; i < table.length; i++){
            table[i] = new LinkedHashEntry<>();
        }
    }

    public LinkedHashMap(){
        this(DEFAULT_INIT_SIZE);
    }

    @Override
    protected void addToBucket(K key, V value, int hash){
        LinkedHashEntry<K, V> bucket = (LinkedHashEntry<K, V>)table[hash];
        LinkedHashEntry<K, V> newEntry = new LinkedHashEntry<>(key, value, bucket);
        table[hash] = newEntry;
    }

}
