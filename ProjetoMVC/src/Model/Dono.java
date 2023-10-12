
package Model;

import java.util.ArrayList;
import Model.Pet;

public class Dono extends Pessoa{
    // ATRIBUTOS
    private int id_Dono;
    
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


    //GETTERS E SETTERS
    public int getId_Dono() {
        return id_Dono;
    }

    public void setId_Dono(int id_Dono) {
        this.id_Dono = id_Dono;
    }

    // ================= MÉTODOS ESPECÍFICOS    =========================
    // < CONSULTAR DADOS DO DONO >
    public String consultarDados() {
        return "===== DADOS DO DONO ====="+
                        "\nNome: "+this.getNome()+
                        "\nEspecie: "+this.getCpf()+
                        "\nIdade: "+this.getTelefone()+
                        "\nEndereço: "+this.getEndereco()+
                        "\nID do Dono: "+this.getId_Dono();
                        
    }
                    
    // Ver o histórico de pets do dono (você pode implementar essa função)
    public void verHistorico() {
        // Implemente aqui a visualização do histórico do dono
    }
}
