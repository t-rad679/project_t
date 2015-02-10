package datastructures.map.hashmap;

/**
 * Created by t_rad on 2/10/15.
 */
public interface HashFunction<K> {

    public int hash(K key);
}
