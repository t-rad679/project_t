package datastructures.list.linkedlist;

/**
 * A Linked List that only keeps track of the next nodes (ignore the prev nodes).
 * This implementation uses a dummy node as the "head", and the first real node of the
 * list is going to be the "next" of the head.
 * @author Trevor Radcliffe
 * @version 1.0
 */
public class SinglyLinkedList<T> extends LinkedList<T> {

    public SinglyLinkedList() {
        head = new LLNode<>();
    }

    @Override
    public LLNode<T> getTailNode() {
        LLNode<T> current = head;
        for(int i=0; i<=size; i++){
            current = current.next();
        }
        return current;
    }

    @Override
    protected LLNode<T> getNodeAfter(LLNode<T> node) {
        return node.next();
    }

    @Override
    public LLNode<T> getNodeBefore(LLNode<T> node) {
        LLNode<T> current = head;
        for(int i=0; i<size; i++){
            current = current.next();
            if(current.next().equals(node)){
                return current;
            }
        }
        return null;
    }

    @Override
    public void putTail(T value) {
        put(value, size-1);
        //O(n)
    }

    @Override
    public void putAfter(T value, LLNode<T> node) throws IllegalArgumentException {
        LLNode<T> newNode = new LLNode<T>(value, node.next());
        node.setNext(newNode);
        //O(1)
    }

    @Override
    protected void putBefore(T value, LLNode<T> node) throws IllegalArgumentException {
        LLNode<T> preceding = getNodeBefore(node);
        LLNode<T> newNode = new LLNode<>(value, node);
        preceding.setNext(newNode);
        //O(n)
    }

    @Override
    public T removeTail() {
        return remove(size-1);
        //O(n)
    }

    @Override
    protected T removeAfter(LLNode<T> node) throws IllegalArgumentException {
        LLNode<T> following = node.next();
        node.setNext(following.next());
        return following.getValue();
    }

    @Override
    public T removeNode(LLNode<T> node){
        LLNode<T> preceding = getNodeBefore(node);
        preceding.setNext(node.next());
        return node.getValue();
    }

    @Override
    public T removeBefore(LLNode<T> node) throws IllegalArgumentException {
        LLNode<T> current = head;
        for(int i=0; i<size-1; i++){ //Iterate one less to ensure both next calls happen as expected
            current = current.next();

            if(current.next().next().equals(node)){
                return removeAfter(current);
            }
        }
        if(node.equals(current.next())){
            return removeAfter(current);
        }
        return null;
    }
}
