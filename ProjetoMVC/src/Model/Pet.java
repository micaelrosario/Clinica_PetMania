
package Model;

import java.io.Serializable;


public class Pet extends Animal {
    //Atributos do Pet
    private String id_dono;

    public Pet(String dono) {
        this.id_dono = dono;
    }

    public Pet(String nome, String raca, int idade, String id_dono) {
        super(nome, raca, idade);
        this.id_dono = id_dono;
    }
    
     @Override
    public String toString() {
        return getNome();

    }

    public String getIdDono() {
        return id_dono;
    }

    public void setIdDono(String dono) {
        this.id_dono = dono;
    }
}
