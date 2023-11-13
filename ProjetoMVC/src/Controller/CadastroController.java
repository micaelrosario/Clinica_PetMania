/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helper.CadastroHelper;
import Model.DAO.UsuarioAutenticacao;
import static Model.DAO.UsuarioAutenticacao.usuarios;
import Model.Usuario;
import View.Cadastro;
import View.Login;
import javax.swing.JOptionPane;

public class CadastroController {
    private  final Cadastro view;
    private CadastroHelper helper;
    
    public CadastroController(Cadastro view){
        this.view = view;
        this.helper = new CadastroHelper(view);
    }
    
    public void cadastrarNoSistema(){
        try {
            // Criar um usuário a partir do nome e senha em View Cadastro
            Usuario usuario = helper.obterModelo();

            if (usuario != null) {
                // Colocar esse usuário na lista de usuários
                UsuarioAutenticacao autenticacao = new UsuarioAutenticacao();
                autenticacao.cadastrarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
                navegarParaLogin();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Usuário: Campos não preenchidos.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Usuário: " + e.getMessage());
        }
        
        
    }
    // Redirecionar para o Login
    public void navegarParaLogin(){
        Login login = new Login();
        login.setVisible(true);
    }
}
