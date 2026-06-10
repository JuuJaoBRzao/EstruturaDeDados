import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> listaVertices = new ArrayList<>();
        String arquivoMapa = "mapa.csv";

        Grafo.descobrirVertices(arquivoMapa, listaVertices);
        Grafo g = new Grafo(listaVertices);

        Grafo.montarGrafo(arquivoMapa, g);

        System.out.println("=== Matriz de Adjacência ===");
        g.mostrarMatriz();

        System.out.println("\n=== Lista de Adjacência ===");
        g.mostrarGrafo();
    }
}
