package datastructures.list.linkedlist;

import datastructures.graph.Node;

/**
 * A single node of a linked list
 * @author Trevor Radcliffe
 * @version 1.0
 */
public class LLNode<T> implements Node{
    private T value;
    private LLNode<T> next;
    private LLNode<T> prev;

    /**
     * Default constructor.
     */
    public LLNode(){
        this.value = null;
        this.next  = this;
        this.prev  = this;
    }
    /**
     * Constructor with only a value argument.  Next and prev must be set independently.
     * @param value The value of the new node
     */
    public LLNode(T value){
        this.value = value;
        this.next  = this;
        this.prev  = this;
    }

    /**
     * Constructor with a 'next' argument.
     * @param value The value of the new node
     * @param next The next node in the list from this node
     */
    public LLNode(T value, LLNode<T> next){
        this.value = value;
        this.next = next;
        this.prev = this;
    }

    public LLNode(T value, LLNode<T> next, LLNode<T> prev){
        this.value = value;
        this.next  = next;
        this.prev  = prev;

    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public Node[] getNeighbors() {
        Node[] neighbors = new Node[2];
        neighbors[0] = next;
        neighbors[1] = prev;
        return neighbors;
    }

    /**
     * @return The next node of this node
     */
    public LLNode<T> next(){
        return next;
    }

    /**
     * @return The previous node of this node
     */
    public LLNode<T> prev(){
        return prev;
    }

    /**
     * Sets the next node for this node
     * @param next The new next node
     */
    public void setNext(LLNode<T> next){
        this.next = next;
    }

    /**
     * Sets the previous node for this node.
     * @param prev The previous node
     */
    public void setPrev(LLNode<T> prev){
        this.prev = prev;
    }

    @Override
    public boolean equals(Node node){
        if(node != null){
            return (node.getValue().equals(value));
        }
        return false;
    }
}
