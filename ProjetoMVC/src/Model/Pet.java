
package Model;

import java.io.Serializable;


public class Pet extends Animal implements Serializable{
    //Atributos do Pet
    private Dono dono;

    public Pet(Dono dono) {
        this.dono = dono;
    }

    public Pet(String nome, String raca, String idade, Dono dono) {
        super(nome, raca, idade);
        this.dono = dono;
    }
    
     @Override
    public String toString() {
<<<<<<< HEAD
        return "Nome: " + nome + ", Especie: " + raca + ", Idade: " + idade+", Dono: "+dono;
=======
        return "Nome: " + nome + ", Espécie: " + raca + ", Idade: " + idade+" Dono: "+dono;
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
    }

    public Dono getIdDono() {
        return dono;
    }

    public void setIdDono(Dono dono) {
        this.dono = dono;
    }

    
    
    
}
