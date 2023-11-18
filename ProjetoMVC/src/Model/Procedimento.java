
package Model;

import java.io.Serializable;


public class Procedimento implements Serializable{
    private String nome;
    private String id;
    private String funcionario;
    private double valor;


    //========== CONSTRUTOR ===========
    public Procedimento(String nome, String id, String funcionario, double valor) {
        this.nome = nome;
        this.id = id;
        this.funcionario = funcionario;
        this.valor = valor;
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

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}
