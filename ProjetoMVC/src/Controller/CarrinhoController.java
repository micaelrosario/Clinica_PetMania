/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.CarrinhoCompra;
import View.MenuPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CarrinhoController {
    private final CarrinhoCompra view;

    public CarrinhoController(CarrinhoCompra view) {
        this.view = view;
    }
    
    public void fazerPedido(){
        ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        JOptionPane.showMessageDialog(null, "Pedido feito com sucesso","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
    }
    
    public void voltarMenuPrincipal(){
        // Ação após clicar no Botão Voltar
        MenuPrincipal novoFrame = new MenuPrincipal();
        novoFrame.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    
}
