
package Model;


public class Pet extends Animal{
    //Atributos do Pet
    private int id_Dono;

    public Pet(int id_Dono) {
        this.id_Dono = id_Dono;
    }

    public Pet(String nome, String especie, int idade, int id_Dono) {
        super(nome, especie, idade);
        this.id_Dono = id_Dono;
    }
    
    // MÉTODO ESPECÍFICO
    public String ExibirDados(){
        return "===== DADOS DO PET ====="+
                        "\nNome: "+this.nome+
                        "\nEspecie: "+this.especie+
                        "\nIdade: "+this.idade+
                        "\nDono: "+this.id_Dono;
    }
}
