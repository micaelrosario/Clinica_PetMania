/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendamentoHelper;
import Model.DAO.AgendamentoDAO;
import View.Agendamento;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class AgendamentoController implements Serializable {
    private final Agendamento view;
    private AgendamentoHelper helper;

    public AgendamentoController(Agendamento view) {
        this.view = view;
    }
    
    public void agendar(){
        Agendamento agendamento = helper.obterModelo();
        if(agendamento != null){
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            agendamentoDAO.cadastrarAgendamento(agendamento);
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Agendamento feito com Sucesso!","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
        }
    }
    
    
}
