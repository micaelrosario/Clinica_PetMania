/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.AdicionarPet;
import Controller.Helper.PetHelper;
import Model.DAO.PetDados;
import Model.Pet;
import View.SubMenuCadastro;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */
public class PetController implements Serializable{
    
    private final AdicionarPet view;
    private PetHelper helper;

    public PetController(AdicionarPet view) {
        this.view = view;
        this.helper = new PetHelper(view);
    }
    
    public void cadastrarPet(){
        //Pegar Pet da view
        Pet pet = helper.obterModelo();
        if (pet != null) {
            PetDados petDados = new PetDados();
            petDados.cadastrarPet(pet);
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Pet Cadastrado com Sucesso!","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
        }
        
    }
    
    public void atualizaDono(){
        // Buscar Clientes do Banco de Dados
        helper.preencherDonos();
    }
    
    public void voltarSubMenuCadastro(){
        // Ação após clicar no Botão Voltar
        SubMenuCadastro novoFrame = new SubMenuCadastro();
        novoFrame.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
}
