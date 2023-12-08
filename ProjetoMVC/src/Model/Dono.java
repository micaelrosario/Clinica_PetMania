
package Model;

import java.util.ArrayList;

public class Dono extends Pessoa{
    
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
    /* < ADICIONAR A LISTA >
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
    }*/
   

    // ================= MÉTODOS ESPECÍFICOS    =========================
    @Override
    public String toString(){
        return getNome();
    }
    
}
