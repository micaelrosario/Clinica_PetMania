/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.ClienteHelper;
import Model.DAO.ClienteDAO;
import Model.Dono;
import View.CadastroCliente;
import View.SubMenuCadastro;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class ClienteController  {
    private final CadastroCliente view;
    private final ClienteHelper helper;

    public ClienteController(CadastroCliente view) {
        this.view = view;
        this.helper = new ClienteHelper(view);
    }
    
    public void cadastrarCliente(){
        Dono cliente = helper.obterModelo();
        System.out.println(cliente+" Criado no Controller");
        if(cliente != null){
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.create(cliente);
            
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
            helper.limparTela();
            atualizaTabela();
        }else {
            //JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.");
        }
    }
    
    public void excluirCliente(){
        helper.excluirCliente();
        helper.limparTela();
        atualizaTabela();
    }
    
    
    public void atualizaTabela() {
        helper.preencherTabela();
    }
    
    public void voltarSubMenuCadastro(){
        // Ação após clicar no Botão Voltar
        SubMenuCadastro novoFrame = new SubMenuCadastro();
        novoFrame.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    
    
}
