import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;

public class GerenciadorCSV {

    public static void salvarFigura(String caminhoArquivo, Figura figura) {
        try (FileWriter fw = new FileWriter(caminhoArquivo, StandardCharsets.UTF_8, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(figura.toCSV());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar figura: " + e.getMessage());
        }
    }

    public static TreeSet<Figura> carregarFiguras(String caminhoArquivo) {
        TreeSet<Figura> arvore = new TreeSet<>();
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            System.out.println("Arquivo nao encontrado: '" + caminhoArquivo + "' (exists=" + arquivo.exists() + ", absolutePath=" + arquivo.getAbsolutePath() + ")");
            return arvore;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo, StandardCharsets.UTF_8))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty()) {
                    try {
                        Figura figura = Figura.fromCSV(linha);
                        arvore.add(figura);
                    } catch (Exception e) {
                        System.out.println("Linha ignorada (formato invalido): " + linha);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
        return arvore;
    }
}
