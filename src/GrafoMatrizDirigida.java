import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Extraido de http://www.cs.williams.edu/~jeannie/cs136/javadoc/structure5/structure5/GraphMatrixDirected.html#GraphMatrixDirected
 * Editado por: Juanfer De Leon
 * @param <V>
 * @param <E>
 */
public class GrafoMatrizDirigida<V,E extends Comparable<E>> implements IGrafo<V,E>{

    protected int size; // Tamañp del grafo
    protected Object data[][]; // matriz
    protected Map<V,Vertex<V>> dict; // vertices
    protected List<Integer> freeList; // indices disponibles en la matriz
    private boolean negativeCycle;
    Number[][] distances;

    /**
     * Constructor
     * @param size tamaño del grafo
     */
    protected GrafoMatrizDirigida(int size) {
        this.size = size;
        this.data = new Object[size][size];
        this.distances = new Number[size][size];
        this.dict = new HashMap<>(size);
        this.freeList = new ArrayList<>();
        for (int row = size-1; row >= 0; row--) { freeList.add(row); }
        for(int i = 0; i < distances.length; i++) {
            for(int j = 0; j < distances.length; j++) {
                distances[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    /**
     * Agrega un vertice
     * @param label
     */
    @Override
    public void add(V label) {
        //Si ya existe el vertice no realiza nada
        if (dict.containsKey(label)) return;
        // verificar que aun existan indices disponibles para el vertice
        int row = freeList.remove(0);
        // Agrega vertice al diccionario
        dict.put(label, new Vertex<V>(label, row));
    }

    /**
     * Agrega un arco
     * @param vtx1  Etiqueta del vertice 1
     * @param vtx2  Etiqueta del vertice 2
     * @param label Arco entre vertice 1 y vertice 2
     * @return
     */
    @Override
    public boolean addEdge(V vtx1, V vtx2, E label) {
        Vertex<V> vertice1 = dict.get(vtx1);
        Vertex<V> vertice2 = dict.get(vtx2);
        // Verifica que los vertices esten en el mapa
        if(vertice1 == null || vertice2 == null) {
            return false;
        }else {
            data[vertice1.row()][vertice2.row()] = new Edge<V, E>(vtx1, vtx2, label, true);
            return true;
        }
    }

    /**
     * Obtener el valor de la ruta mas corta entre vertice 1 y vertice 2
     * @param label1 vertice1
     * @param label2 vertice2
     * @return Devuelve la dstancia mas corta
     */
    public String getRutaMasCorta(V label1, V label2) {
        Vertex<V> vtx1 = dict.get(label1);
        Vertex<V> vtx2 = dict.get(label2);
        if (vtx1 == null || vtx2 == null) return "No hay conexion!";
        return "\nLa ruta mas corta es de: " + this.distances[vtx1.row()][vtx2.row()] + ".";
    }

    /**
     * Encuentra el centro del grafo
     * @param label
     * @return
     */
    public V getCentroGrafo(V label){

        int[] columnMaxIndex = new int[distances.length];
        for(int i = 0; i < distances.length; i++) {
            Number currentMax = distances[i][0];
            int currentMaxIndex = 0;
            for(int j = 0; j < distances.length; j++) {
                Number temp = distances[i][j];
                if(temp.doubleValue() > currentMax.doubleValue()) {
                    currentMax = temp;
                    currentMaxIndex = j;
                }
            }
            columnMaxIndex[i] = currentMaxIndex;
        }

        int currentMinIndex = 0;
        Number currentMin = columnMaxIndex[0];
        for(int x = 0; x < columnMaxIndex.length; x++) {
            Number temp = columnMaxIndex[x];
            if(temp.doubleValue() < currentMin.doubleValue()) {
                currentMin = temp;
                currentMinIndex = x;
            }
        }

        Edge<V, E> centro = (Edge<V, E>) data[columnMaxIndex[currentMinIndex]][currentMinIndex];
        try {
            return (centro.here() == null) ? label : centro.here();
        } catch(Exception e) {
            return label;
        }

    }

}
