
package Model;


public class Produto {
    private String nome;
    private int codigo;
    private double valor;
    private String validade;
    private int qtdEstoque;

    //========== CONSTRUTOR ===========
    public Produto(String nome, int codigo, double valor, String validade, int qtdEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.valor = valor;
        this.validade = validade;
        this.qtdEstoque = qtdEstoque;
    }
    
    //========== MÉTODOS ESPECÍFICOS ============

    //Método para exibir informações do produto
    public void exibirProduto() {
        System.out.println("Nome do Produto: " + this.getNome());
        System.out.println("Código do Produto: " + this.getCodigo());
        System.out.println("Preço do Produto: R$" +this.getValor());
        System.out.println("Validade do Produto: R$" +this.getValidade());
        System.out.println("Quantidade em Estoque: " +this.getQtdEstoque() );
    }

    //========== GETTERS E SETTERS ============
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
}
