package datastructures.list;

/**
 * Array based List implementation.
 * @author Trevor Radcliffe
 * @version 1.0
 */
public class ArrayList<T> implements List {
    final static int DEFAULT_INIT_SIZE = 100;
    T[] list;

    public ArrayList(int defSize){
        list = (T[]) new Object[defSize];
    }

    public ArrayList(){
        list = new Object[defSize];
    }
    @Override
    public void put(Object value, int idx) throws IllegalArgumentException, IndexOutOfBoundsException {

    }

    @Override
    public void put(Object value) throws IllegalArgumentException {

    }

    @Override
    public Object get(int idx) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object get() {
        return null;
    }

    @Override
    public Object remove(int idx) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object remove() {
        return null;
    }

    @Override
    public int indexOf(Object value) throws IllegalArgumentException {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}
