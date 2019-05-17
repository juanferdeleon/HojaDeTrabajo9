/**
 * @author Juanfer De Leon
 * @param <V>
 * @param <E>
 */
public class Edge<V,E> {

    private V vtx1;
    private V vtx2;
    private E label;
    private boolean directed;
    private boolean visited;

    /**
     * Constructor
     * @param vtx1
     * @param vtx2
     * @param label
     * @param directed
     */
    public Edge(V vtx1, V vtx2, E label, boolean directed) {
        this.vtx1 = vtx1;
        this.vtx2 = vtx2;
        this.label = label;
        this.directed = directed;
        this.visited = false;
    }

    public V here() {
        return this.vtx1;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean visit() {
        boolean state = this.visited;
        this.visited = true;
        return state;
    }

    public E label() {
        return label;
    }

}