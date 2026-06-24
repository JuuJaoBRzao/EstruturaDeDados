import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    private static final String ARQUIVO_REPETIDAS_PESSOAIS = "figuras_repetidas_pessoais.csv";
    private static final String ARQUIVO_DESEJADAS_PESSOAIS = "figuras_desejadas_pessoais.csv";


    private static TreeSet<Figura> lista_repetidas_pessoais = new TreeSet<>();
    private static TreeSet<Figura> lista_desejadas_pessoais = new TreeSet<>();

    private static Scanner scanner = new Scanner(new InputStreamReader(System.in, StandardCharsets.UTF_8));

    public static void main(String[] args) {
        carregarArquivosPessoais();

        int opcao = -1;
        while (opcao != 7) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Tente novamente.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrarFigura(lista_repetidas_pessoais, ARQUIVO_REPETIDAS_PESSOAIS, "Repetida");
                    break;
                case 2:
                    listarFiguras(lista_repetidas_pessoais, "Figuras Repetidas Pessoais");
                    break;
                case 3:
                    cadastrarFigura(lista_desejadas_pessoais, ARQUIVO_DESEJADAS_PESSOAIS, "Desejada");
                    break;
                case 4:
                    listarFiguras(lista_desejadas_pessoais, "Figuras Desejadas Pessoais");
                    break;
                case 5:
                    carregarEProcessarOutro("repetidas", lista_desejadas_pessoais);
                    break;
                case 6:
                    carregarEProcessarOutro("desejadas", lista_repetidas_pessoais);
                    break;
                case 7:
                    System.out.println("Encerrando o programa. Ate mais!");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n====== GERENCIADOR DE FIGURINHAS - COPA 2026 ======");
        System.out.println("1 - Cadastrar figuras repetidas pessoais");
        System.out.println("2 - Listar figuras repetidas pessoais");
        System.out.println("3 - Cadastrar figuras desejadas pessoais");
        System.out.println("4 - Listar figuras desejadas pessoais");
        System.out.println("5 - Carregar figuras repetidas OUTRO (match com desejadas pessoais)");
        System.out.println("6 - Carregar figuras desejadas OUTRO (match com repetidas pessoais)");
        System.out.println("7 - Sair");
        System.out.print("Opcao: ");
    }

    private static void carregarArquivosPessoais() {
        lista_repetidas_pessoais = GerenciadorCSV.carregarFiguras(ARQUIVO_REPETIDAS_PESSOAIS);
        lista_desejadas_pessoais = GerenciadorCSV.carregarFiguras(ARQUIVO_DESEJADAS_PESSOAIS);
        System.out.println("Dados pessoais carregados: "
                + lista_repetidas_pessoais.size() + " repetidas, "
                + lista_desejadas_pessoais.size() + " desejadas.");
    }

    private static Figura lerFigura() {
        System.out.print("Nome da selecao: ");
        String nomeSelecao = scanner.nextLine().trim();

        System.out.print("Numero da figurinha: ");
        int numeroFigura = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Descricao (jogador, brasao ou bandeira): ");
        String descricao = scanner.nextLine().trim();

        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("E rara? (true/false): ");
        boolean rara = Boolean.parseBoolean(scanner.nextLine().trim());

        return new Figura(nomeSelecao, numeroFigura, descricao, quantidade, rara);
    }

    private static void cadastrarFigura(TreeSet<Figura> lista, String arquivo, String tipo) {
        System.out.println("\n--- Cadastrar Figura " + tipo + " ---");
        try {
            Figura figura = lerFigura();
            // TreeSet ignora duplicatas (equals/compareTo) automaticamente
            boolean adicionada = lista.add(figura);
            if (adicionada) {
                GerenciadorCSV.salvarFigura(arquivo, figura);
                System.out.println("Figura " + tipo.toLowerCase() + " cadastrada com sucesso!");
            } else {
                System.out.println("Essa figurinha ja esta na lista (mesma selecao e numero). Nao foi adicionada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Valor invalido informado. Cadastro cancelado.");
        }
    }


    private static void listarFiguras(TreeSet<Figura> lista, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma figura cadastrada.");
            return;
        }

        
        TreeMap<String, TreeSet<Figura>> porSelecao = agruparPorSelecao(lista);

        int contador = 1;
        for (Map.Entry<String, TreeSet<Figura>> entrada : porSelecao.entrySet()) {
            System.out.println("\n  >> Selecao: " + entrada.getKey());
            for (Figura figura : entrada.getValue()) {
                System.out.println("     " + contador + ". " + figura);
                contador++;
            }
        }
        System.out.println("\nTotal: " + lista.size() + " figurinha(s).");
    }

   
    private static TreeMap<String, TreeSet<Figura>> agruparPorSelecao(TreeSet<Figura> lista) {
        TreeMap<String, TreeSet<Figura>> mapa = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (Figura figura : lista) {
            String selecao = figura.getNomeSelecao();
            if (!mapa.containsKey(selecao)) {
                mapa.put(selecao, new TreeSet<>());
            }
            mapa.get(selecao).add(figura);
        }
        return mapa;
    }

    private static void carregarEProcessarOutro(String tipo, TreeSet<Figura> listaParaMatch) {
        String labelOutro = tipo.equals("repetidas") ? "Repetidas" : "Desejadas";
        String labelMatch = tipo.equals("repetidas") ? "desejadas suas" : "repetidas suas";

        System.out.println("\n--- Carregar Figuras " + labelOutro + " do OUTRO ---");
        System.out.print("Caminho do arquivo CSV do outro: ");
        String caminho = scanner.nextLine().trim();

        
        if (caminho.length() >= 2) {
            char first = caminho.charAt(0);
            char last = caminho.charAt(caminho.length() - 1);
            boolean firstQuote = first == '"' || first == '\'' || first == '\u201C' || first == '\u2018';
            boolean lastQuote = last == '"' || last == '\'' || last == '\u201D' || last == '\u2019';
            if (firstQuote && lastQuote) {
                caminho = caminho.substring(1, caminho.length() - 1).trim();
            }
        }

        File arquivoOutro = new File(caminho);
        if (arquivoOutro.isDirectory()) {
            String arquivoPadrao = tipo.equals("repetidas") ? "figuras_repetidas_outro.csv" : "figuras_desejadas_outro.csv";
            File arquivoCSV = new File(arquivoOutro, arquivoPadrao);
            System.out.println("Diretorio informado; usando arquivo padrao: " + arquivoCSV.getAbsolutePath());
            caminho = arquivoCSV.getAbsolutePath();
        }

        TreeSet<Figura> figurasOutro = GerenciadorCSV.carregarFiguras(caminho);

        if (figurasOutro.isEmpty()) {
            System.out.println("Nenhuma figura encontrada no arquivo informado.");
            return;
        }

        System.out.println("\nFiguras " + labelOutro.toLowerCase() + " do outro:");
        listarFiguras(figurasOutro, "Figuras " + labelOutro + " do Outro");

        
        TreeSet<Figura> matches = new TreeSet<>(figurasOutro);
        matches.retainAll(listaParaMatch);

        System.out.println("\n=== MATCHES (" + labelOutro.toLowerCase() + " do outro x " + labelMatch + "): "
                + matches.size() + " ===");
        if (matches.isEmpty()) {
            System.out.println("Nenhum match encontrado.");
        } else {
            listarFiguras(matches, "Matches encontrados");
        }
    }
}
