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


/**
 *
 * @author Usuário
 */
public class AgendamentoHelper {
    
    private final Agendamento view;

    public AgendamentoHelper(Agendamento view) {
        this.view = view;
        
    }
    
    
    public Agendamento obterModelo() {
        GeradorDeId gerarId  = new GeradorDeId();
        int id = gerarId.gerarNovoId();
        Dono dono = (Dono) view.getCb_cliente().getSelectedItem();
        Pet pet = (Pet) view.getCb_pet().getSelectedItem();
        Produto prod = (Produto) view.getCb_produto().getSelectedItem();
        Procedimento proced = (Procedimento) view.getCb_procedimento().getSelectedItem();
        String data = view.getTf_data().getText();

        // Verificar se ambos os campos estão preenchidos
        if (dono == null || pet == null || data.isEmpty() || prod == null || proced == null) {
            //JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return null;  // Retorna null se há campos não preenchidos
        }
        // Retorna um objeto Agendamento se os campos estiverem preenchidos
        Agendamento modelo = new Agendamento(id, dono, pet, data, prod, proced);
        return modelo;
    }

}
