/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.ProcedimentoHelper;
import Model.DAO.ProcedimentoDAO;
import Model.Procedimento;
import View.CadastroServiço;
import View.SubMenuCadastro;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class ProcedimentoController implements Serializable{
    private final CadastroServiço view;
    private final ProcedimentoHelper helper;

    public ProcedimentoController(CadastroServiço view) {
        this.view = view;
        this.helper = new ProcedimentoHelper(view);
    }
    
    public void cadastrarProcedimento(){
        Procedimento procedimento = helper.obterModelo();
        
        if(procedimento != null){
            ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
            procedimentoDAO.cadastrarProcedimento(procedimento);
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Procedimento Cadastrado com Sucesso","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
            atualizaTabela();
        }else {
            //JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Procedimento: Campos não preenchidos.");
        }
    }
    
    public void excluirProcedimento(){
        helper.excluirProcedimento();
    }
    
    
    public void atualizaTabela() {
        // Buscar Lista com produtos do banco de dados
        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        //ArrayList<Produto> produtos = produtoDAO.carregarProdutos();
        ArrayList<Procedimento> procedimentos = procedimentoDAO.obterProcedimentos();
        //Condição 
        if (procedimentos != null) {
            helper.preencherTabela(procedimentos);
        } else {
            // Lidar com o caso em que a leitura falhou (pode ser um arquivo ausente, erro de formato, etc.)
            JOptionPane.showMessageDialog(null, "Erro ao carregar procedimentos do arquivo.");
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
