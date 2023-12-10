/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.EsqueceuSenha;
import View.Login;
/**
 *
 * @author Usuário
 */
public class EsqueceuSenhaController {
    
    private final EsqueceuSenha view;

    public EsqueceuSenhaController(EsqueceuSenha view) {
        this.view = view;
    }
    
    public void navegarParaLogin(){
        Login novoFrame = new Login();
        novoFrame.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    
}
