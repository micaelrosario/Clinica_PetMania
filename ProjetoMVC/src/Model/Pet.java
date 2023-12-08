
package Model;

import java.io.Serializable;


public class Pet extends Animal {
    //Atributos do Pet
    private int dono;

    public Pet(int dono) {
        this.dono = dono;
    }

    public Pet(String nome, String raca, int idade, int id_dono) {
        super(nome, raca, idade);
        this.dono = dono;
    }
    
     @Override
    public String toString() {
        return getNome();

    }

    public int getIdDono() {
        return dono;
    }

    public void setIdDono(int dono) {
        this.dono = dono;
    }
}
