/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.DAO.ClienteDAO;
import Model.Dono;
import Model.Pet;
import View.AdicionarPet;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
        
public class PetHelper implements Serializable{
    private final AdicionarPet view;
    

    public PetHelper(AdicionarPet view) {
        this.view = view;
    }
    
    public Pet obterModelo(){
        String nome = view.getTf_nome().getText();
        String raca = view.getTf_raca().getText();
        String idade = view.getTf_idade().getText();
        //Dono dono = 
        Pet modelo = new Pet(nome, raca,idade);
        return modelo;
    }
    
    public void setarModelo(Pet modelo){
        String nome = modelo.getNome();
        String raca = modelo.getRaca();
        String idade = modelo.getIdade();
        
        view.getTf_nome().setText(nome);
        view.getTf_raca().setText(raca);
        view.getTf_idade().setText(idade);
    }
    
    public void  limparTela(){
        view.getTf_nome().setText("");
        view.getTf_raca().setText("");
        view.getTf_idade().setText("");
    }

    public void preencherDonos(ArrayList<Dono> clientes) {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_Dono().getModel();
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.carregarCliente(); // Certifique-se de carregar os clientes antes de obter a lista

        ArrayList<Dono> donos = clienteDAO.carregarCliente();
        
        for (Dono dono : clientes){
            comboBoxModel.addElement(dono); 
        }
    }
}
