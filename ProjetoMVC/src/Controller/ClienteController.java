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
public class ClienteController implements Serializable {
    private final CadastroCliente view;
    private final ClienteHelper helper;

    public ClienteController(CadastroCliente view) {
        this.view = view;
        this.helper = new ClienteHelper(view);
    }
    
    public void cadastrarCliente(){
        Dono cliente = helper.obterModelo();
        
        if(cliente != null){
            ClienteDAO produtoDAO = new ClienteDAO();
            produtoDAO.cadastrarCliente(cliente);
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
            atualizaTabela();
        }else {
            //JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente: Campos não preenchidos.");
        }
    }
    
    public void excluirCliente(){
        helper.excluirCliente();
    }
    
    
    public void atualizaTabela() {
        // Buscar Lista com cliente do banco de dados
        ClienteDAO clienteDAO = new ClienteDAO();
        //ArrayList<Produto> produtos = produtoDAO.carregarProdutos();
        ArrayList<Dono> clientes = clienteDAO.obterClientes();
        //Condição 
        if (clientes != null) {
            helper.preencherTabela(clientes);
        } else {
            // Lidar com o caso em que a leitura falhou (pode ser um arquivo ausente, erro de formato, etc.)
            JOptionPane.showMessageDialog(null, "Erro ao carregar clientes do arquivo.");
        }
        
    }
    
    public void voltarSubMenuCadastro(){
        // Ação após clicar no Botão Voltar
        SubMenuCadastro novoFrame = new SubMenuCadastro();
        novoFrame.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
}
