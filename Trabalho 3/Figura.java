public class Figura implements Comparable<Figura> {

    private String nomeSelecao;
    private int numeroFigura;
    private String descricao;
    private int quantidade;
    private boolean rara;

    public Figura(String nomeSelecao, int numeroFigura, String descricao, int quantidade, boolean rara) {
        this.nomeSelecao = nomeSelecao;
        this.numeroFigura = numeroFigura;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    public String getNomeSelecao() {
        return nomeSelecao;
    }

    public void setNomeSelecao(String nomeSelecao) {
        this.nomeSelecao = nomeSelecao;
    }

    public int getNumeroFigura() {
        return numeroFigura;
    }

    public void setNumeroFigura(int numeroFigura) {
        this.numeroFigura = numeroFigura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isRara() {
        return rara;
    }

    public void setRara(boolean rara) {
        this.rara = rara;
    }

    
    @Override
    public int compareTo(Figura outra) {
        int cmpSelecao = this.nomeSelecao.compareToIgnoreCase(outra.nomeSelecao);
        if (cmpSelecao != 0) {
            return cmpSelecao;
        }
        return Integer.compare(this.numeroFigura, outra.numeroFigura);
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Figura)) return false;
        Figura outra = (Figura) obj;
        return this.numeroFigura == outra.numeroFigura
                && this.nomeSelecao.equalsIgnoreCase(outra.nomeSelecao);
    }

    @Override
    public int hashCode() {
        return 31 * nomeSelecao.toLowerCase().hashCode() + numeroFigura;
    }

    public String toCSV() {
        return nomeSelecao + "," + numeroFigura + "," + descricao + "," + quantidade + "," + rara;
    }

    public static Figura fromCSV(String linha) {
        String[] partes = linha.split(",");
        String nomeSelecao = partes[0].trim();
        int numeroFigura = Integer.parseInt(partes[1].trim());
        String descricao = partes[2].trim();
        int quantidade = Integer.parseInt(partes[3].trim());
        boolean rara = Boolean.parseBoolean(partes[4].trim());
        return new Figura(nomeSelecao, numeroFigura, descricao, quantidade, rara);
    }

    @Override
    public String toString() {
        return String.format("[%s] #%d - %s | Qtd: %d | Rara: %s",
                nomeSelecao, numeroFigura, descricao, quantidade, rara ? "Sim" : "Nao");
    }
}
