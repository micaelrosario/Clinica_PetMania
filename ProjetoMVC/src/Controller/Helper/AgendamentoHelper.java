/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import View.Agendamento;
import java.util.Date;

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
        //Dono dono = view.getText_usuario().getText();
        //Pet pet = view.getText_senha().getText();
        String data = view.getTf_data().getText();
        // Verificar se ambos os campos estão preenchidos
        /*if () {
            //JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return null;  // Retorna null se há campos não preenchidos
        }*/

        // Retorna um objeto Usuario se os campos estiverem preenchidos
        /*Agendamento modelo = new Agendamento(id, dono, pet, data,produto, procedimento);*/
        return null;
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
