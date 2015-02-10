package datastructures.list;

/**
 * Abstract representation of an ordered list data structure.  Also functions as a basic stack, for most
 * practical purposes.
 * @author Trevor Radcliffe
 * @version 1.0
 */
public interface List<T> {

    /**
     * Insert a value to the list at index idx
     * @param value The value to insert into the list
     * @param idx The index in the list that value will be at after the insertion.  (Note that the value previously at index idx will be at idx+1 after the insertion)
     * @throws java.lang.IllegalArgumentException If the value is for some reason unacceptable to this list
     * @throws java.lang.IndexOutOfBoundsException If the index is out of the bounds of the list
     */
    public void put(T value, int idx) throws IllegalArgumentException, IndexOutOfBoundsException;

    /**
     * Add a value to the end of the list
     * @param value The value to append to the list
     * @throws java.lang.IllegalArgumentException If the value is for some reason unacceptable to this list
     */
    public void put(T value) throws IllegalArgumentException;

    /**
     * Gets a value from the list at the given index.
     * @param idx The index in the list
     * @return The value if the index is within the bounds of the list, throws an exception otherwise.
     * @throws java.lang.IndexOutOfBoundsException If the index is out of the bounds of this list
     */
    public T get(int idx) throws IndexOutOfBoundsException;

    /**
     * Gets the first element of the list
     * @return The value of the last element added to the list, if there is one.  null otherwise
     */
    public T get();

    /**
     * Removes the value in the list at the given index, and returns this value.
     * @param idx The given index
     * @return The value in the list at the index, if it is within the bounds of the list.  Throws an exception otherwise
     * @throws java.lang.IndexOutOfBoundsException If the index is outside the bounds of this list
     */
    public T remove(int idx) throws IndexOutOfBoundsException;

    /**
     * Removes the first element of the list, and returns it.
     * @return The value at the first element of the list if there is one, null otherwise.
     */
    public T remove();

    /**
     * Finds and returns the index of a given value in this list
     * @param value The given value
     * @return The index of the given value in this list, if it exists,  -1 otherwise.
     * @throws java.lang.IllegalArgumentException If the value is for some reason unacceptable to this list, or if it is not present.
     */
    public int indexOf(T value) throws IllegalArgumentException;

    /**
     * @return The number of elements in this list
     */
    public int size();
}
