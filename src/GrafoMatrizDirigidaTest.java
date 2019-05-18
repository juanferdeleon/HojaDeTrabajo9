import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoMatrizDirigidaTest {

    @Test
    void add() {
        GrafoMatrizDirigida<String, String> grafo = new GrafoMatrizDirigida<String, String>(2);
        grafo.add("prueba");
        assertEquals(grafo.get("prueba"), "prueba");
    }

    @Test
    void addEdge() {
        GrafoMatrizDirigida<String, String> grafo = new GrafoMatrizDirigida<String, String>(2);
        grafo.add("prueba");
        grafo.add("prueba2");
        grafo.addEdge("prueba", "prueba2", "label");
        assertEquals(grafo.getEdge("prueba", "prueba2").here(), "prueba");
    }
}