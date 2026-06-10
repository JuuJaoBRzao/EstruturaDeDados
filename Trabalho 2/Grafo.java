import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Grafo {
    int[][] matrizADJ;
    int qtdVertices;
    ArrayList<String> vertices;

    public Grafo(ArrayList<String> vertices) {
        this.vertices = new ArrayList<>(vertices);
        this.qtdVertices = vertices.size();
        this.matrizADJ = new int[qtdVertices][qtdVertices];
    }

    static void descobrirVertices(String arquivo, ArrayList<String> vertices) {
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(arquivo, StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                String origem  = partes[0].trim();
                String destino = partes[1].trim();
                if (!vertices.contains(origem))  vertices.add(origem);
                if (!vertices.contains(destino)) vertices.add(destino);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        java.util.Collections.sort(vertices);
    }

    static void montarGrafo(String arquivo, Grafo g) {
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(arquivo, StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                String[] partes = linha.split(",");
                int origem  = g.pegarIndice(partes[0].trim());
                int destino = g.pegarIndice(partes[1].trim());
                int custo   = Integer.parseInt(partes[2].trim());
                g.inserirAresta(origem, destino, custo);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    void inserirAresta(int origem, int destino, int custo) {
        if (matrizADJ[origem][destino] == 0) {
            matrizADJ[origem][destino] = custo;
        }
    }

    int pegarIndice(String vertice) {
        return vertices.indexOf(vertice);
    }

    void mostrarMatriz() {
         System.out.printf("%18s", "");
        for (String v : vertices) System.out.printf("%18s", v);
        System.out.println();
        for (int i = 0; i < qtdVertices; i++) {
            System.out.printf("%18s", vertices.get(i));
            for (int j = 0; j < qtdVertices; j++) {
                System.out.printf("%18d", matrizADJ[i][j]);
            }
            System.out.println();
        }
    }

    void mostrarGrafo() {
        for (int i = 0; i < qtdVertices; i++) {
            System.out.print(vertices.get(i) + ": ");
            for (int j = 0; j < qtdVertices; j++) {
                if (matrizADJ[i][j] != 0) {
                    System.out.print(vertices.get(j) + "(" + matrizADJ[i][j] + ")  ");
                }
            }
            System.out.println();
        }
    }
}
