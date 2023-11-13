/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.AdicionarPet;
import View.CadastroCliente;
import View.CadastroProduto;
import View.CadastroServiço;
import View.MenuPrincipal;
import View.SubMenuCadastro;

public class MenuCadastroController {
    private final SubMenuCadastro view;

    public MenuCadastroController(SubMenuCadastro view) {
        this.view = view;
    }
    
    //Navegar para o Cadastro
    public void navegarParaPet(){
        AdicionarPet pet = new AdicionarPet();
        pet.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Cadastro
    public void navegarParaCliente(){
        CadastroCliente cliente = new CadastroCliente();
        cliente.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Cadastro
    public void navegarParaServico(){
        CadastroServiço servico = new CadastroServiço();
        servico.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Cadastro
    public void navegarParaProduto(){
        CadastroProduto produto = new CadastroProduto();
        produto.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Cadastro
    public void navegarParaMenuPrincipal(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
}
