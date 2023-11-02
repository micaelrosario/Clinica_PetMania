
package Controller.Helper;

import Model.DAO.UsuarioAutenticacao;
import static Model.DAO.UsuarioAutenticacao.usuarios;
import Model.Usuario;
import View.Login;

public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getText_usuario().getText();
        String senha = view.getText_senha().getText();
        Usuario modelo = new Usuario(nome, senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getText_usuario().setText(nome);
        view.getText_senha().setText(senha);
    }
    
    public void  limparTela(){
        view.getText_usuario().setText("");
        view.getText_senha().setText("");
    }

   
}
