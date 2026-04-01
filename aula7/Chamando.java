import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Chamando {
    public static void main(String[] args) {
        Queue<Integer> filaNormal = new LinkedList<>();
        Queue<Integer> filaPrioritaria = new LinkedList<>();
        
        int contarNormal = 1;
        int contarPrioritaria = 500;
        int totalAtendimentos = 0;
        Scanner teclado = new Scanner(System.in);
        String opcao = "";
        String qualFila;

        do {
            System.out.println("M E N U");
            System.out.println("1 - Ficha Normal");
            System.out.println("2 - Ficha Prioritaria");
            System.out.println("3 - Chamar ficha");
            System.out.println("4 - Mostrar fichas");
            System.out.println("5 - Sair");
            System.out.println("Opcao: ");
            opcao = teclado.nextLine();

            switch(opcao) {
                case "1":
                    System.out.println("Gerando ficha normal..." +contarNormal);
                    filaNormal.offer(contarNormal);
                    contarNormal++;
                    break;
                case "2":
                    System.out.println("Gerando ficha prioritaria..." +contarPrioritaria);
                    filaPrioritaria.offer(contarPrioritaria);
                    contarPrioritaria++;
                    break;
                case "3":
                    int fichaAtendida = -1;
                    if (totalAtendimentos % 3 == 0) { //a cada 3 chamadas normal, chama 1 prioritaria
                        qualFila = "PRIORITARIA";
                    } else { //chamar normal
                        qualFila = "NORMAL";
                    }
                    if (qualFila.equals("PRIORITARIA") && !filaPrioritaria.isEmpty()) {
                        fichaAtendida = (int)filaPrioritaria.poll();
                        totalAtendimentos++;
                    } else if (qualFila.equals ("Normal") && !filaNormal.isEmpty()) {
                        fichaAtendida = (int)filaNormal.poll();
                        totalAtendimentos++;
                    }  else if (qualFila.equals ("Normal") && filaNormal.isEmpty() && !filaPrioritaria.isEmpty()) {
                        qualFila = "PRIORITARIA";
                        fichaAtendida = (int)filaNormal.poll();
                        totalAtendimentos++;
                        //DEVERIA SER NORMAL, MAS ESTA VAZIA... ENTAO TENTA A PRIORITARIA
                    } else if (qualFila.equals("PRIORITARIA") && filaPrioritaria.isEmpty() && !filaNormal.isEmpty()) {
                        fichaAtendida = (int)filaNormal.poll();
                        totalAtendimentos++;
                        qualFila = "NORMAl";
                    }
                    if (fichaAtendida != -1) {
                        System.out.println("Chamando ficha..." + qualFila + ": " +fichaAtendida);
                    } else {
                        System.out.println("Ninguem para ser atendido!!!");
                    }
                    break;
                case "4":
                    System.out.println("Mostrando fichas faltantes...");
                    int totalNormalFaltantes = filaNormal.size();
                    int totalPrioritariaFaltantes = filaNormal.size();

                    System.out.println("Fila normal: " +filaNormal);
                    System.out.println("Total de fichas... " +totalNormalFaltantes);

                    System.out.println("Fila prioritaria: " +filaPrioritaria);
                    System.out.println("Total de fichas..." +totalPrioritariaFaltantes);

                    break;
                case "5":
                    System.out.println("Sistema encerrando...");
                    break;
                default:
                    System.out.println("Opcao invalida......");
                    break;
            }

        } while (!opcao.equals("5"));
    }
}
