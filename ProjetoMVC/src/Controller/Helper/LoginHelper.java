
package Controller.Helper;

import Model.DAO.UsuarioAutenticacao;
import static Model.DAO.UsuarioAutenticacao.usuarios;
import Model.Usuario;
import View.Login;
import java.io.Serializable;
import javax.swing.JOptionPane;

public class LoginHelper implements Serializable{
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Usuario obterModelo() {
        String nome = view.getText_usuario().getText().trim();
        String senha = view.getText_senha().getText().trim();

        // Verificar se ambos os campos estão preenchidos
        if (nome.isEmpty() || senha.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            return null;  // Retorna null se há campos não preenchidos
        }

        // Retorna um objeto Usuario se os campos estiverem preenchidos
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
