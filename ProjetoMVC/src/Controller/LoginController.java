
package Controller;

import View.Login;
import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioAutenticacao;
import static Model.DAO.UsuarioAutenticacao.usuarios;
import Model.Usuario;
import View.MenuPrincipal;
import View.EsqueceuSenha;
import java.io.Serializable;
import javax.swing.JOptionPane;


public class LoginController implements Serializable{

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
      
            //Pegar Usuário da view
            Usuario usuario = helper.obterModelo();
            
            //Pesquisar Usuário no Banco e Comparar 
            UsuarioAutenticacao usuarioBanco = new UsuarioAutenticacao();
            Boolean usuarioAutenticado = usuarioBanco.autenticarUsuario(usuario);


            // Verifique se as credenciais do usuário correspondem a algum usuário no ArrayList
            if(usuarioAutenticado){
                // Usuário autenticado com sucesso
                JOptionPane.showMessageDialog(null, "Login bem-sucedido! Bem-vindo, " + usuario.getNome() + "!");
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
            }
                
            
        /* catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado. Verifique suas credenciais e tente novamente.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
        }*/
        //Se for igual, redirecionar para o Menu
        //Se não, mostrar mensagem "Usuário ou senha Inválidos"
    }
    public void carregarUsuarios() {
        UsuarioAutenticacao usuarioBanco = new UsuarioAutenticacao();
        usuarioBanco.carregarUsuarios();
    }

    public void esqueciSenha() {
        EsqueceuSenha senha = new EsqueceuSenha();
        senha.setVisible(true);
    }
    
}
