package Model;

public abstract class Animal {
     //ATRIBUTOS 
    String nome;
    String raca;
    String idade;

    //MÉTODO CONSTRUTOR DA CLASSE
    public Animal(){

    }

    public Animal(String nome, String raca, String idade) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }

    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
