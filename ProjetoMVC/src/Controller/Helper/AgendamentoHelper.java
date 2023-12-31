/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Dono;
import View.View_Agendamento;
import Model.GeradorDeId;
import Model.Pet;
import Model.Procedimento;
import Model.Produto;
import Model.Agendamento;
import Model.DAO.ClienteDAO;
import Model.DAO.ProcedimentoDAO;
import Model.DAO.PetDAO;
import Model.DAO.ProdutoDAO;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Usuário
 */
public class AgendamentoHelper  {
    
    private final View_Agendamento view;
    

    public AgendamentoHelper(View_Agendamento view) {
        this.view = view;
    }
    
    
    public Agendamento obterModelo() {
        GeradorDeId gerarId = new GeradorDeId();
        int id = gerarId.gerarNovoId();
        Dono dono = (Dono) view.getCb_cliente().getSelectedItem();
        Pet pet = (Pet) view.getCb_pet().getSelectedItem();
        Produto prod = (Produto) view.getCb_produto().getSelectedItem();
        Procedimento proced = (Procedimento) view.getCb_procedimento().getSelectedItem();
        String data = view.getTf_data().getText();

        if (dono == null || pet == null || data.isEmpty() || prod == null || proced == null) {
            return null;  // Retorna null se há campos não preenchidos
        }

        return new Agendamento( id, dono, pet,  data,  prod,  proced);
    }

    public void preencherDonos() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_cliente().getModel();

        ClienteDAO clienteDAO = new ClienteDAO();
        List<Dono> donos = clienteDAO.read();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Dono dono : donos) {
            comboBoxModel.addElement(dono);
        }
    }
    
    
    
    public void listaPet() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_pet().getModel();
        
        DefaultComboBoxModel cbDono = (DefaultComboBoxModel) view.getCb_cliente().getModel();
        Dono dono = (Dono) cbDono.getSelectedItem();
        PetDAO petDAO = new PetDAO();
        List<Pet> pets = petDAO.read();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Pet pet : pets) {
            if(pet.getIdDono().equals(dono.getNome())){
                comboBoxModel.addElement(pet);
            }
            
        }
    }
    
    /*public List<Pet> obterPetDono(Dono donoSelecionado) {
        PetDAO petDAO = new PetDAO();
        List<Pet> pets = petDAO.read();

        for (Pet pet : pets) {
            if(pet.getIdDono().equals(donoSelecionado.getNome())){
                pets.add(pet);
            }
        }
        return pets;
    }*/
    public void preencherPet(){
        listaPet();
    }
    
    public String preencherData(){
        String data = view.getTf_data().getText();
        return data;
    }
    
    public void preencherProduto() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_produto().getModel();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.read();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Produto produto : produtos) {
            comboBoxModel.addElement(produto);
        }
    }
    
    public void preencherProcedimento() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_procedimento().getModel();

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        List<Procedimento> procedimentos = procedimentoDAO.read();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Procedimento procedimento : procedimentos) {
            comboBoxModel.addElement(procedimento);
        }
    }
}
