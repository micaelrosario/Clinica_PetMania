
package Controller;

import View.Login;
import Controller.Helper.LoginHelper;
import Model.Usuario;


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
        
        
        //Pesquisar Usuário no Banco e Comparar se são os mesmo
        //Se for igual, redirecionar para o Menu
        //Se não, mostrar mensagem "Usuário ou senha Inválidos"
    }
    public void fizTarefa() {
        System.out.println("Busquei algo do banco de dados");
        this.view.exibeMensagem("Executei o fiz tarefa");
    }

    
    
    
}
