/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.AgendamentoHelper;
import Model.Agendamento;
import Model.DAO.AgendamentoDAO;
import View.MenuPrincipal;
import View.View_Agendamento;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class AgendamentoController implements Serializable {
    private final View_Agendamento view;
    private AgendamentoHelper helper;
    
    public AgendamentoController(View_Agendamento view) {
        this.view = view;
        this.helper = new AgendamentoHelper(view);
    }
    
    
    public void agendar(){
        Agendamento agendamento = helper.obterModelo();
        System.out.println(agendamento);
        if(agendamento != null){
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
            agendamentoDAO.create(agendamento);
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Agendamento feito com Sucesso!","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
        }
    }
    
    
    public void atualizaDono(){
        // Buscar Clientes do Banco de Dados
        helper.preencherDonos();
    }
    public void atualizaPet(){
        helper.preencherPet();
    }
    public void atualizaData(){
        // Buscar Clientes do Banco de Dados
        helper.preencherData();
    }
    public void atualizaProduto(){
        // Buscar Clientes do Banco de Dados
        helper.preencherProduto();
    }
    public void atualizaProcedimento(){
        // Buscar Clientes do Banco de Dados
        helper.preencherProcedimento();
    }
    
    //Navegar para o Cadastro
    public void navegarParaMenuPrincipal(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
}
