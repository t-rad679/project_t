package datastructures.map.hashmap;

/**
 * Created by t_rad on 2/9/15.
 */
public class LinkedHashEntry<K, V> extends HashEntry<K, V>{
    private LinkedHashEntry<K, V> next;

    public LinkedHashEntry(){
        next = this;
        key = null;
        value = null;
    }

    public LinkedHashEntry(K key, V value, LinkedHashEntry<K, V> next){
        this.next = next;
        this.key = key;
        this.value = value;
    }

    @Override
    public HashEntry<K, V> find(K key) {
        if(next == null){
            return next;
        }
        if(this.key.equals(key)){
            return this;
        }

    }

    public void setNext(LinkedHashEntry<K, V> entry){
        this.next = entry;
    }

}
