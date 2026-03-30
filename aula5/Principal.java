import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Clima> lista = new ArrayList<>();
        
        //simulando que estamos lendo linha a linha do arquivo
        //primeira linha
        String linha = " 2020, Janeiro, Quente, muita";
        String dadosLinha[] = linha.split(",");
        Clima objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);

        if (!lista.contains(objClima)) {
            lista.add(objClima);
        }

        //segunda linha
        linha = " 2020, Janeiro, Frio, pouca";
        dadosLinha  = linha.split(",");
        objClima = new Clima(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3]);
        
        if (!lista.contains(objClima)) {
            lista.add(objClima);
        }

        for (Clima c : lista) {
            System.out.println(c);
        }

        Clima maisQuente = null;
        Clima maisFrio = null;

        for (Clima c : lista) {
            if (maisQuente == null || c.temperatura.trim().equals("Quente")) {
            maisQuente = c;
            }

            if (maisFrio == null || c.temperatura.trim().equals("Frio")) {
            maisFrio = c;
            }
        }
        System.out.println("\nMais quente: " + maisQuente);
        System.out.println("Mais frio: " + maisFrio);
    }
}
