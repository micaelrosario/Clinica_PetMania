
package Model;

import java.util.ArrayList;
import Model.Pet;
import java.io.Serializable;

public class Dono extends Pessoa implements Serializable{
    
    ArrayList<Pet> ListaPets;
    
    //================ MÉTODO CONSTRUTOR ====================
    public Dono() {
        ListaPets = new ArrayList<>();
    }
    
    public Dono(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone, endereco);
        ListaPets = new ArrayList<>();
    }
    
    // ==================== MÉTODOS DA LISTA DE PETS ===================
    // < ADICIONAR A LISTA >
    public void adicionarPet(Pet pet) {
        ListaPets.add(pet);
    }
    // < REMOVER DA LISTA>
    public void removerPet(Pet pet){
        ListaPets.remove(pet);
    }
    // < LISTA DE PETS >
    public ArrayList<Pet> getListaPets(){
        return ListaPets;
    }
   

    // ================= MÉTODOS ESPECÍFICOS    =========================
}
