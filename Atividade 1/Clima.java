public class Clima {
	String ano;
    String mes;
    String temperatura;
    String precipitacao;
    
    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    //reescrevemos toString para exibir um objeto completo da classe 
    @Override
    public String toString() {
        return "Clima [ano = " + this.ano + ", mes = " + this.mes + ", temperatura = " + this.temperatura + ", precipitacao = " + this.precipitacao+ "]";         
    }
    
    //reescreve o método equals para definir os atributos identificadores
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Clima)) return false;

        Clima c = (Clima) obj;

        return this.ano.equals(c.ano) && this.mes.equals(c.mes);
    }
}
