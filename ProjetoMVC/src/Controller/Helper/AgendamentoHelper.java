/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Dono;
import Model.GeradorDeId;
import Model.Pet;
import Model.Procedimento;
import Model.Produto;
import View.Agendamento;
import java.io.Serializable;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class AgendamentoHelper implements Serializable {
    
    private final Agendamento view;

    public AgendamentoHelper(Agendamento view) {
        this.view = view;
    }
    
    
    public Agendamento obterModelo() {
        GeradorDeId novoId = new GeradorDeId();
        int id = novoId.gerarNovoId();
        
        Dono donoSelecionado = (Dono) view.getCb_cliente().getSelectedItem();
        Pet petSelecionado = (Pet) view.getCb_pet().getSelectedItem();
        Produto produtoSelecionado = (Produto) view.getCb_produto().getSelectedItem();
        Procedimento procedimentoSelecionado = (Procedimento) view.getCb_procedimento().getSelectedItem();
        String data = view.getTf_data().getText();
        // Verificar se ambos os campos estão preenchidos
        if (donoSelecionado == null || petSelecionado == null || data.isEmpty() || produtoSelecionado == null || procedimentoSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return null;  // Retorna null se há campos não preenchidos
        }

        // Retorna um objeto Agendamento se os campos estiverem preenchidos
        Agendamento modelo = new Agendamento(id, donoSelecionado, petSelecionado, data, produtoSelecionado, procedimentoSelecionado);
        return modelo;
    }

    
    public void setarModelo(Agendamento modelo){
        /*String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getText_usuario().setText(nome);
        view.getText_senha().setText(senha);*/
    }
    
    public void  limparTela(){
        /*view.getText_usuario().setText("");
        view.getText_senha().setText("");*/ 
    }
}
