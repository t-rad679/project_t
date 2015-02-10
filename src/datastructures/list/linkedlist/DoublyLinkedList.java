package datastructures.list.linkedlist;


/**
 * A Doubly Linked List implementation with a head and a tail.
 * @author Trevor Radcliffe
 * @version 1.0
 */
public class DoublyLinkedList<T> extends LinkedList<T> {
    LLNode<T> tail;

    public DoublyLinkedList(){
        head = new LLNode<>();
        tail = new LLNode<>();
    }

    @Override
    public LLNode<T> getTailNode() {
        LLNode<T> tail = head.next().prev();
        if(tail.next().equals(head)){
            return null;
        }
        return tail;
    }

    @Override
    public LLNode<T> getNodeAfter(LLNode<T> node) {
        if(node != null && !node.next().equals(node)){
            return node.next();
        }
        return null;
    }

    @Override
    public T getValueAfter(LLNode<T> node) {
        return getNodeAfter(node).getValue();
    }

    @Override
    public LLNode<T> getNodeBefore(LLNode<T> node) {
        if(node != null && !node.prev().equals(node)){
            return node.prev();
        }
        return null;
    }

    @Override
    public T getValueBefore(LLNode<T> node) {
        return getNodeBefore(node).getValue();
    }

    @Override
    public void putTail(T value) {
        LLNode<T> newNode = new LLNode<>(value);
        newNode.setNext(newNode);
        newNode.setPrev(tail.prev());
        tail.setPrev(newNode);
    }

    @Override
    public void putAfter(T value, LLNode<T> node) throws IllegalArgumentException {
        LLNode<T> newNode = new LLNode<>(value, node.next(), node);
        node.next().setPrev(newNode);
        node.setNext(newNode);
    }

    @Override
    public void putBefore(T value, LLNode<T> node) throws IllegalArgumentException {
        LLNode<T> newNode = new LLNode<>(value, node, node.prev());
        node.prev().setNext(newNode);
        node.setPrev(newNode);
    }

    @Override
    public T removeNode(LLNode<T> node) {
        LLNode<T> current = head;
        for(int i=0; i<size; i++){
            current = current.next();
            if(current.next().equals(node)){
                return removeAfter(current);
            }
        }
        return null;
    }

    @Override
    public T removeTail() {
        LLNode<T> last = tail.prev();
        if(last.equals(tail)){
            return null;
        }
        tail.setPrev(last.prev());
        last.prev().setNext(tail);
        return last.getValue();
    }

    @Override
    public T removeAfter(LLNode<T> node) throws IllegalArgumentException {
        if(tail.prev().equals(node)){
            return removeTail();
        }
        LLNode<T> next = node.next();
        next.setPrev(node);
        node.setNext(next.next());
        return next.getValue();
    }

    @Override
    public T removeBefore(LLNode<T> node) throws IllegalArgumentException {
        if(head.next().equals(node)){
            return remove();
        }
        LLNode<T> prev = node.prev();
        prev.prev().setNext(node);
        node.setPrev(prev.prev());
        return prev.getValue();
    }
}
