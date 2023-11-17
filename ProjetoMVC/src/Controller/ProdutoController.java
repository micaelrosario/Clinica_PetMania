/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.ProdutoHelper;
import Model.DAO.ProdutoDAO;
import Model.Produto;
import View.CadastroProduto;
import java.io.Serializable;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class ProdutoController implements Serializable{
    private final CadastroProduto view;
    private final ProdutoHelper helper;

    public ProdutoController(CadastroProduto view) {
        this.view = view;
        this.helper = new ProdutoHelper(view);
    }
    
    public void cadastrarProduto(){
        Produto produto = helper.obterModelo();
        
        if(produto != null){
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.cadastrarProduto(produto);
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
            atualizaTabela();
        }else {
            //JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Produto: Campos não preenchidos.");
        }
    }
    
    public void excluirProduto(){
        helper.excluirProduto();
    }
    
    
    public void atualizaTabela() {
        // Buscar Lista com produtos do banco de dados
        ProdutoDAO produtoDAO = new ProdutoDAO();
        //ArrayList<Produto> produtos = produtoDAO.carregarProdutos();
        ArrayList<Produto> produtos = produtoDAO.obterProdutos();
        //Condição 
        if (produtos != null) {
            // Exibir esta lista na View
            System.out.println("TABELA PREENCHIDA");
            helper.preencherTabela(produtos);
        } else {
            // Lidar com o caso em que a leitura falhou (pode ser um arquivo ausente, erro de formato, etc.)
            JOptionPane.showMessageDialog(null, "Erro ao carregar produtos do arquivo.");
        }
        
    }

}
