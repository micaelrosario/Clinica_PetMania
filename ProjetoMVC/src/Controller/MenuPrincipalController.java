/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Agendamento;
import View.CarrinhoCompra;
import View.HistoricoCliente;
import View.MenuLateral;
import View.MenuPrincipal;
import View.SubMenuCadastro;


public class MenuPrincipalController {
    private final MenuPrincipal view;

    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
    }
    
    //Navegar para o Cadastro
    public void navegarParaCadastro(){
        SubMenuCadastro cadastro = new SubMenuCadastro();
        cadastro.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    
    //Navegar para o Carrinho de Compras
    public void navegarParaCarrinho(){
        CarrinhoCompra carrinho = new CarrinhoCompra();
        carrinho.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Agendamento
    public void navegarParaAgendamento(){
        Agendamento agendamento = new Agendamento();
        agendamento.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Histórico de Clientes
    public void navegarParaHistorico(){
        HistoricoCliente historico = new HistoricoCliente();
        historico.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    //Navegar para o Histórico de Clientes
    public void navegarParaMenuLateral(){
        MenuLateral menuLateral = new MenuLateral();
        menuLateral.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
}
