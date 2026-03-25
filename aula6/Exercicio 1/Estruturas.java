import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Estruturas {
    public static void gerarProcesso(ArrayList<Processo> lista) {
        int id;
        String descricao;
        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();
        Processo tmp;
        

        while(true) {
            id = gerador.nextInt(500);
            System.out.println("Descricao do processo: ");
            descricao = teclado.nextLine().toUpperCase();
            if (descricao.equals("Sair")) {
                break;
            }
            tmp = new Processo(id, descricao);
            if (!lista.contains(tmp)) {
                lista.add(tmp);
            }
        }
    }

    public static void exibirProcessos(ArrayList<Processo> lista) {
        System.out.println("Quantidade de processos: "+lista.size());
       
        //indice de ordenacao = descricao
        lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao));
        for (Processo p : lista) {
            System.out.println(p);
        }
    }

    public static void localizarProcessos(ArrayList<Processo> lista) {
        String descricao;
        Scanner teclado = new Scanner (System.in);
        
        //rotina para pesquisar parte da descricao na lista de processos
        System.out.println("Digite palavra ou expressao que deseja localzar: ");
        descricao = teclado.nextLine().toUpperCase();

        for (Processo p : lista) {
            if (p.descricao.contains(descricao)) {
                System.out.println(p);
            }
        }
    }

    public static void localizarRemover(ArrayList<Processo> lista) {
            String descricao;
            Scanner teclado = new Scanner (System.in);
        
            //rotina para pesquisar parte da descricao na lista de processos
        System.out.println("Digite palavra ou expressao que deseja localzar: ");
        descricao = teclado.nextLine().toUpperCase();

        for (int i = 0; i < lista.size(); i++) {
            Processo p = lista.get(i);
            if(p.descricao.contains(descricao)) {
                System.out.println("Removendo processo: ");
                lista.remove(i);
                i--;
            }
        }
    }    

    public static void main(String[] args) {
        ArrayList<Processo> lista = new ArrayList<>();
        
        Estruturas.gerarProcesso(lista);
        Estruturas.exibirProcessos(lista);
        Estruturas.localizarProcessos(lista);
        Estruturas.localizarRemover(lista);
    }
}
