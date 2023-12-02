
package Model;

import java.io.Serializable;


public class Produto implements Serializable {
    private String nome;
    private String id;
    private String fornecedor;
    private double valor;
    private String validade;
    

    //========== CONSTRUTOR ===========
    public Produto(String nome, String id, String fornecedor, double valor, String validade ) {
        this.nome = nome;
        this.id = id;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.validade = validade;
    }
    
    //========== MÉTODOS ESPECÍFICOS ============


    //========== GETTERS E SETTERS ============

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
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
    
    public String ToString(){
        return getNome();
}
}
