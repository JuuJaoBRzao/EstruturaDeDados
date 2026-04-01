
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

        ArrayList<Clima> lista = new ArrayList<>();

		try {
		 File arquivo = new File("base.csv");
         Scanner leitor = new Scanner(arquivo);

         while (leitor.hasNextLine()) {
             String linha = leitor.nextLine();
             String[] dadosLinha = linha.split(",");
			 
             if (dadosLinha.length < 4) {
            	 System.out.println("Erro na linha: " + linha);
            	 continue;
             }

             Clima c = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

             if (!lista.contains(c)) {
            	 lista.add(c);
             }
         } 

         leitor.close();
      
         Clima maisQuente = null; 
         Clima maisFrio = null; 
         
         int maiorPrecipitacao = -1;
         int menorPrecipitacao = Integer.MAX_VALUE;

         for (Clima c : lista) {
             int precipitacao = Integer.parseInt(c.precipitacao);

             if (c.temperatura.equals("Quente")) {
                 if (precipitacao > maiorPrecipitacao) {
                     maiorPrecipitacao = precipitacao;
                     maisQuente = c;
                 }
             }

             if (c.temperatura.equals("Frio")) {
                 if (precipitacao < menorPrecipitacao) {
                     menorPrecipitacao = precipitacao;
                     maisFrio = c;
                 }
             }
         }

         System.out.println("Mês mais quente:");
         if (maisQuente != null) { 
             System.out.println(maisQuente);
         }

         System.out.println("\nMês mais frio:");
         if (maisFrio != null) { 
             System.out.println(maisFrio);
         }

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		}
	}
}
