
package Model;

import java.io.Serializable;


public class Pet extends Animal {
    //Atributos do Pet
    private Dono dono;

    public Pet(Dono dono) {
        this.dono = dono;
    }

    public Pet(String nome, String raca, int idade, Dono dono) {
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
