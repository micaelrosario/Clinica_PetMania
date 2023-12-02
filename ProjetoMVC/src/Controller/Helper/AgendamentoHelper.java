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
import Model.DAO.PetDados;
import Model.DAO.ProdutoDAO;
import java.util.ArrayList;
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
        clienteDAO.carregarCliente(); // Certifique-se de carregar os clientes antes de obter a lista

        ArrayList<Dono> donos = clienteDAO.obterClientes();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Dono dono : donos) {
            System.out.println(dono);
            comboBoxModel.addElement(dono);
        }
    }
    
    public void preencherPet() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_pet().getModel();

        // Obtém o Dono selecionado no JComboBox
        Dono donoSelecionado = (Dono) view.getCb_cliente().getSelectedItem();

        if (donoSelecionado != null) {
            // Aqui você deve ter algum método em PetDados que retorna os pets de um dono específico
            PetDados petDAO = new PetDados();
            ArrayList<Pet> pets = petDAO.obterPetsDoDono(donoSelecionado);

            // Limpar o combobox antes de adicionar os novos elementos
            comboBoxModel.removeAllElements();

            for (Pet pet : pets) {
                System.out.println(pet);
                comboBoxModel.addElement(pet);
            }
        }
    }

    
    public String preencherData(){
        String data = view.getTf_data().getText();
        System.out.println(data.toString());
        return data;
    }
    
    public void preencherProduto() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_produto().getModel();

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.carregarProdutos();// Certifique-se de carregar os clientes antes de obter a lista

        ArrayList<Produto> produtos = produtoDAO.obterProdutos();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Produto produto : produtos) {
            System.out.println(produto);
            comboBoxModel.addElement(produto);
        }
    }
    
    public void preencherProcedimento() {
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getCb_procedimento().getModel();

        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        procedimentoDAO.carregarProcedimento(); // Certifique-se de carregar os clientes antes de obter a lista

        ArrayList<Procedimento> procedimentos = procedimentoDAO.obterProcedimentos();

        // Limpar o combobox antes de adicionar os novos elementos
        comboBoxModel.removeAllElements();

        for (Procedimento procedimento : procedimentos) {
            System.out.println(procedimento);
            comboBoxModel.addElement(procedimento);
        }
    }
}
