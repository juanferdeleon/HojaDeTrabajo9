/**
 * @author Juanfer De Leon
 * @param <E>
 */
public class Vertex<E>
{
    private E label;
    private boolean visited;
    int row;

    /**
     * Constructor
     * @param label Vertice
     */
    public Vertex(E label, int row) {
        this.label = label;
        this.visited = false;
        this.row = row;
    }

    public int row() { return this.row;	}

}