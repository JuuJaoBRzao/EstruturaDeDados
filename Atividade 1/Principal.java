import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Clima> lista = new ArrayList<>();

		//iniciando o tratamento de exceções
		try {
		//abre e le o arquivo com os dados, nesse caso é o "base.csv"
		 File arquivo = new File("base.csv");
         Scanner leitor = new Scanner(arquivo);

         //le linha por linha
         while (leitor.hasNextLine()) {
             String linha = leitor.nextLine();

             //separa os valores da linha usando vírgula
             String[] dadosLinha = linha.split(",");
			 
			//se não tem os 4 campos do clima, pula essa linha
             if (dadosLinha.length < 4) {
            	 System.out.println("Erro na linha: " + linha);
            	 continue;
             }

			 //declaração do objeto clima junto com os valores das variaveis declarados no construtor
             Clima c = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

			 //se não estiver na lista, adiciona na lista
             if (!lista.contains(c)) {
            	 lista.add(c);
             }
         } 

         leitor.close();

		//declarando as variaveis para medir o mes mais quente e o mes mais frio
         Clima maisQuente = null;
         Clima maisFrio = null;
         
         int maiorPrecipitacao = -1;
         int menorPrecipitacao = Integer.MAX_VALUE;

		//vai percorrer toda a lista até achar o mes mais quente e o mais frio
         for (Clima c : lista) {
             int precipitacao = Integer.parseInt(c.precipitacao);

			 //se a temperatura for "quente" e a precipitação for a maior dentre os valores que estão na lista, então achamos o mes mais quente
             if (c.temperatura.equals("Quente")) {
                 if (precipitacao > maiorPrecipitacao) {
                     maiorPrecipitacao = precipitacao;
                     maisQuente = c;
                 }
             }

			 //se a temperatura for "frio" e a precipitação for o menor valor dentre os que estão na lista, então temos o mes mais frio
             if (c.temperatura.equals("Frio")) {
                 if (precipitacao < menorPrecipitacao) {
                     menorPrecipitacao = precipitacao;
                     maisFrio = c;
                 }
             }
         }

         //mostrando o resultado
         System.out.println("Mês mais quente:");
         if (maisQuente != null) {
             System.out.println(maisQuente);
         }

         System.out.println("\nMês mais frio:");
         if (maisFrio != null) {
             System.out.println(maisFrio);
         }

		//se não achar o arquivo, mostra na tela
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
	}
}
