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
    void add(V label);

    /**
     *
     * Agrega arco entre vertices
     *
     * @param vtx1  Etiqueta del vertice 1
     * @param vtx2  Etiqueta del vertice 2
     * @param label Arco entre vertice 1 y vertice 2
     * @return Devuelve verdadero si el Arco fue agregado exitosamente
     */
    boolean addEdge(V vtx1, V vtx2, E label);

    /**
     * Obtener el valor de la ruta mas corta entre vertice 1 y vertice 2
     * @param label1 vertice1
     * @param label2 vertice2
     * @return Devuelve la dstancia mas corta
     */
    String getRutaMasCorta(V label1, V label2);

    /**
     * Encuentra el centro del grafo
     * @param label
     * @return
     */
    V getCentroGrafo(V label);

}