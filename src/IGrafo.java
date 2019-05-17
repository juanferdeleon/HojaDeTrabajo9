/**
 * @author Juanfer De Leon
 * @param <V>
 * @param <E>
 */
public interface IGrafo <V,E> {

    /**
     * Se agrega un vertice al grafo
     * @param label Etiqueta para el vertice
     */
    public void add(V label);

    /**
     *
     * Agrega arco entre vertices
     *
     * @param vtx1  Etiqueta del vertice 1
     * @param vtx2  Etiqueta del vertice 2
     * @param label Arco entre vertice 1 y vertice 2
     * @return Devuelve verdadero si el Arco fue agregado exitosamente
     */
    public boolean addEdge(V vtx1, V vtx2, E label);

    /**
     * @param label
     * @return Deuelve etiqueta del vertice
     */
    public V get(V label);

    /**
     * Devuelve arco entre vertices
     *
     * @param label1 vertice 1
     * @param label2 vertice 2
     * @return Arco entre vertice 1 y vertice 2
     */
    public Edge<V, E> getEdge(V label1, V label2);

}