import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
 
public class Principal {
    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<String[]> arestas = new ArrayList<>();
 
        // Ler arquivo CSV e extrair vértices e arestas
        try (BufferedReader leitor = new BufferedReader(
                new FileReader("mapa.csv", StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                String origem  = partes[0].trim();
                String destino = partes[1].trim();
                arestas.add(new String[]{origem, destino});
                if (!vertices.contains(origem))  vertices.add(origem);
                if (!vertices.contains(destino)) vertices.add(destino);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }
 
        Collections.sort(vertices);
 
        Grafo gAssimetrico = new Grafo(vertices);
 
        for (String[] aresta : arestas) {
            gAssimetrico.inserirAresta(
                gAssimetrico.pegarIndice(aresta[0]),
                gAssimetrico.pegarIndice(aresta[1])
            );
        }
 
        gAssimetrico.mostrarMatriz();
        System.out.println();
        gAssimetrico.mostrarGrafo();
    }
}
