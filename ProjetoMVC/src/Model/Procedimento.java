
package Model;


public class Procedimento {
    private String nome;
    private double valor;


    //========== CONSTRUTOR ===========
    public Procedimento(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    //========== MÉTODOS ESPECÍFICOS ============
    // Método toString para exibir informações do procedimento
    public String exibirProcedimento() {
        return "Nome do Procedimento: " + this.getNome() + "\nValor do Procedimento: R$" + this.getValor();
    }

    //========== GETTERS E SETTERS ============
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
