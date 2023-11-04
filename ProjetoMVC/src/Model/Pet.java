
package Model;


public class Pet extends Animal{
    //Atributos do Pet
    private int id_Dono;

    public Pet(int id_Dono) {
        this.id_Dono = id_Dono;
    }

    public Pet(String nome, String raca, String idade, int id_Dono) {
        super(nome, raca, idade);
        this.id_Dono = id_Dono;
    }
    
     @Override
    public String toString() {
        return "Nome: " + nome + ", Espécie: " + raca + ", Idade: " + idade;
    }
}
