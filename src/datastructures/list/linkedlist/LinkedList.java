package datastructures.list.linkedlist;

import datastructures.list.List;

/**
 * Abstract Representation of the Linked List data structure.
 * @author Trevor Radcliffe
 * @version 1.0
 */
public abstract class LinkedList<T> implements List<T> {
    LLNode<T> head;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    /**
     * @return The node at the end of the list
     */
    public abstract LLNode<T> getTailNode();

    /**
     * @param node The node before the node to get
     * @return The node following the given node
     */
    protected abstract LLNode<T> getNodeAfter(LLNode<T> node);


    /**
     * @param node The node after the node to get
     * @return The node preceding the given node, null if it was not found
     */
    public abstract LLNode<T> getNodeBefore(LLNode<T> node);

    /**
     * Puts a node at the end of the linked list
     * @param value The value to insert
     */
    public abstract void putTail(T value);

    /**
     * Puts a node after a given node in a list
     *
     * @param value
     * @param node The node to insert
     * @throws java.lang.IllegalArgumentException If the given node is not in the list
     */
    public abstract void putAfter(T value, LLNode<T> node) throws IllegalArgumentException;

    /**
     * Puts a node before a given node in a list.
     * Will be faster in a doubly linked list than
     * a singly linked list.
     *
     * @param value
     * @param node The node to insert
     * @throws java.lang.IllegalArgumentException If the given node is not in the list
     */
    protected abstract void putBefore(T value, LLNode<T> node) throws IllegalArgumentException;

    /**
     * Removes a given node from the list, and returns its value.
     * @param node The given node
     * @return The value of the node, if it was found.
     */
    public abstract T removeNode(LLNode<T> node);

    /**
     * Removes the last element from the list and
     * returns its value
     * @return The value of the last element in the list
     */
    public abstract T removeTail();

    /**
     * Removes the node following the given node
     * @param node The given node
     * @return The value of the node removed
     * @throws java.lang.IllegalArgumentException If the given node is not in the list
     */
    protected abstract T removeAfter(LLNode<T> node) throws IllegalArgumentException;

    /**
     * Removes the node preceding the given node.
     * @param node The given node
     * @return The value of the node removed
     * @throws java.lang.IllegalArgumentException If the given node is not in the list
     */
    public abstract T removeBefore(LLNode<T> node) throws IllegalArgumentException;

    @Override
    public void put(T value, int idx) throws IllegalArgumentException, IndexOutOfBoundsException {
        LLNode<T> current = head;
        for(int i=0; i<idx; i++){  // Goes to idx-1
            current = current.next();
        }
        putAfter(value, current);
        //O(n)
    }

    @Override
    public void put(T value) throws IllegalArgumentException {
        put(value, 0);
        //O(1)
    }

    @Override
    public T get(int idx) throws IndexOutOfBoundsException {
        LLNode<T> current = head;
        for(int i=0; i<=idx; i++){  //Goes to idx
            current = current.next();
        }
        return current.getValue();
        //O(n)
    }

    @Override
    public T get() {
        return get(0);
        //O(1)
    }

    @Override
    public T remove(int idx) throws IndexOutOfBoundsException {
        LLNode<T> current = head;
        for(int i=0; i<idx; i++) {  //Goes to idx-1
            current = current.next();
        }
        T ret = removeAfter(current);
        return ret;
        //O(n)
    }

    @Override
    public T remove() {
        return remove(0);
        //O(1)
    }

    @Override
    public int indexOf(T value) throws IllegalArgumentException {
        LLNode<T> current = head;
        for(int i=0; i<size; i++){
            current = current.next();
            if(current.getValue().equals(value)){
                return i;
            }
        }
        return -1;
    }

}
