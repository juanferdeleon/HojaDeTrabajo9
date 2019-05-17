import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Hoja de Trabajo 9
 * @author Juanfer De Leon
 *
 */
public class HojaDeTrabajo9 {

    public static void main(String[] args) throws IOException {

        boolean whantsToContinue = true;

        //Ingreso de path del archivo
        System.out.print("\nIngrese path del archivo: ");
        Scanner input = new Scanner(System.in);
        String path = input.next();

        //path = "D:\\Users\\Juanfer De Leon\\Desktop\\Estructura de Datos\\Projects\\HojaDeTrabajo9\\guategrafo.txt";

        //Crea el grafo
        IGrafo<String, Double> grafo = leerGrafo(path);

        while (whantsToContinue){

        }

    }

    public static IGrafo<String, Double> leerGrafo (String path) throws IOException {

        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        IGrafo<String, Double> grafo = new GrafoMatrizDirigida<>(10);

        while ((line = bufferedReader.readLine()) != null) {

            String[] info = line.split(" ");

            grafo.add(info[0]); //Vertice1
            grafo.add(info[1]); //Vertice2
            grafo.addEdge(info[0], info[1], Double.parseDouble(info[2])); //Arco entre Vertice1 y Vertice2

        }

        return grafo;

    }

}
