package datastructures.graph;

/**
 * An abstract representation of a Node for all kinds of graphs (trees, linked lists, directed/undirected,
 * weighted/unweighted, etc)
 * @author Trevor Radcliffe
 * @version 1.0
 */
public interface Node<T> {

    /**
     * @return The value stored in this node, if there is one.  Null otherwise.
     */
    public T getValue();

    /**
     * @return An array of neighboring nodes to this node.
     */
    public Node<T>[] getNeighbors();

    public boolean equals(Node<T> node);

    public int hashCode();
}
