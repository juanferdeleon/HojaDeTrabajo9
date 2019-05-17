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

    public E label() { return this.label; }

    /**
     * Visita vertice
     * @return Devuelve verdadero si ha sido visitado
     */
    public boolean visit() {
        boolean state = this.visited;
        this.visited = true;
        return state;
    }

    /**
     * Devuelve verdadero si el vertice ha sido visitado, falso si no
     * @return
     */
    public boolean isVisited() { return visited; }

    public int row() { return this.row;	}

}