import java.util.ArrayList;
import java.util.TreeSet;

public class Arvore {
    public static void main(String[] args) {
        TreeSet<Integer> arvore = new TreeSet<>();
        ArrayList<Integer> lista = new ArrayList<>();
        int quantidade = 10000000;

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < quantidade; i++) {
            int numero = (int) (Math.random() * quantidade);
            arvore.add(numero);
        }

        long fim = System.currentTimeMillis();
        long tempoDecorrido = fim - inicio;
        System.out.println("Tempo de execução em arvore: " + tempoDecorrido + " ms");
 
        inicio = System.currentTimeMillis();
        for (int i = 0; i < quantidade; i++) {
            int numero = (int) (Math.random() * quantidade);
            lista.add(numero);
        }
        fim = System.currentTimeMillis();
        tempoDecorrido = fim - inicio;
        System.out.println("Tempo de execução lista: " + tempoDecorrido + " ms");
    }
}
