
package Controller;

import View.Login;
import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioAutenticacao;
import static Model.DAO.UsuarioAutenticacao.usuarios;
import Model.Usuario;
import View.MenuPrincipal;


public class LoginController {

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
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
        }else{
            view.exibeMensagem("Usuário ou senha inválidos!");
        }
        
        //Se for igual, redirecionar para o Menu
        //Se não, mostrar mensagem "Usuário ou senha Inválidos"
    }
    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }

    
    
    
}
