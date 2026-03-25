import java.util.ArrayList;
import java.util.Iterator;

public class Lista {
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList();

        lista.add(45);
        lista.add(2);
        lista.add(42);
        lista.add(23);

        //Percursos em lista

        //Percorrer via indice
        System.out.println("Percorrendo  via indice...");
        for(int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }

        //Percorrer via objeto
        System.out.println("Percorrendo via objeto...");
        for (int p : lista) {
            System.out.println(p);
        }

        //Percorrer por um iterador
        System.out.println("Percorrendo por um iterador");
        Iterator<Integer> it = lista.iterator();
        while (it.hasNext()) {
            int num = it.next();
            System.out.println(num);
        }
    }
}
