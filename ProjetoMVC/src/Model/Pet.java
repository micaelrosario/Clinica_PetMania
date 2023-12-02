
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
        return getNome();

    }

    public Dono getIdDono() {
        return dono;
    }

    public void setIdDono(Dono dono) {
        this.dono = dono;
    }

    
    
    
}
