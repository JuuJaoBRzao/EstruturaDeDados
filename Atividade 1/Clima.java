//Declaração da classe e das váriaveis
public class Clima {
	String ano;
    String mes;
    String temperatura;
    String precipitacao;

	//Atribuindo valores para as váriaveis, construtor
    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    //colocamos toString para exibir um objeto completo da classe 
    @Override
    public String toString() {
        return "Clima [ano = " + this.ano + ", mes = " + this.mes + ", temperatura = " + this.temperatura + ", precipitacao = " + this.precipitacao+ "]";         
    }
    
    //colocamos o método equals para definir os atributos identificadores
	//os climas vão ser iguais se eles tiverem o mesmo ano e mês
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //verifica se os objetos são iguais, vai retornar true se for o caso
        if (obj == null || !(obj instanceof Clima)) return false; //verifica se o objeto é nulo ou se não é da classe clima, vai retornar false se for o caso

        Clima c = (Clima) obj; //declara um objeto do tipo clima para comparar os atributos

        return this.ano.equals(c.ano) && this.mes.equals(c.mes); //verifica se o ano e o mes são iguais
    }
}
