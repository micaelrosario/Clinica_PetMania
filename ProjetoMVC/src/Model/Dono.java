
package Model;

import java.util.ArrayList;
import Model.Pet;
import java.io.Serializable;

public class Dono extends Pessoa implements Serializable{
    
    private ArrayList<Pet> listaPets;
    
    //================ MÉTODO CONSTRUTOR ====================
    public Dono() {
        listaPets = new ArrayList<>();
    }
    
    public Dono(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone, endereco);
        listaPets = new ArrayList<>();
    }
    
    // ==================== MÉTODOS DA LISTA DE PETS ===================
    // < ADICIONAR A LISTA >
    public void adicionarPet(Pet pet) {
        listaPets.add(pet);
    }
    // < REMOVER DA LISTA>
    public void removerPet(Pet pet){
        listaPets.remove(pet);
        pet.setIdDono(null);
    }
    // < LISTA DE PETS >
    public ArrayList<Pet> getListaPets(){
        return listaPets;
    }
   

    // ================= MÉTODOS ESPECÍFICOS    =========================
    
}
