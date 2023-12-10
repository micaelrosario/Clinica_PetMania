
package Controller;

import View.Login;
import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioAutenticacao;
import static Model.DAO.UsuarioAutenticacao.usuarios;
import Model.Usuario;
import View.Cadastro;
import View.MenuPrincipal;
import View.Login;
import View.EsqueceuSenha;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class LoginController implements Serializable{

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema() {
        /*try {*/
            // Pegar Usuário da view
            Usuario usuario = helper.obterModelo();
            if(usuario != null){
                // Pesquisar Usuário no Banco e Comparar 
                UsuarioAutenticacao usuarioBanco = new UsuarioAutenticacao();
                Boolean usuarioAutenticado = usuarioBanco.autenticarUsuario(usuario);
                // Verifique se as credenciais do usuário correspondem a algum usuário no ArrayList
                if (usuarioAutenticado) {
                    // Usuário autenticado com sucesso
                    // Carregue um ícone personalizado (substitua "caminho/para/seu/icone.png" pelo caminho real do seu ícone)
                    ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
                    ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
                    JOptionPane.showMessageDialog(
                            null, 
                            "Login bem-sucedido! Bem-vindo, ao PetMania", 
                            "Sucesso", 
                            JOptionPane.PLAIN_MESSAGE, resizedIcon);
                    carregarMenuPrincipal();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos. Verifique suas credenciais e tente novamente.");
                }
            }else{
                 // Tratar o caso em que obterModelo retornou null
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
            }
    }

    public void carregarUsuarios() {
        UsuarioAutenticacao usuarioBanco = new UsuarioAutenticacao();
        usuarioBanco.carregarUsuarios();
    }

    public void esqueciSenha() {
        EsqueceuSenha senha = new EsqueceuSenha();
        senha.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
    
    public void navegarParaCadastro() {
         // Ação após clicar no Botão Voltar
        Cadastro novoFrame = new Cadastro();
        novoFrame.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    }
   
    public void carregarMenuPrincipal(){
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        // Feche a janela de login
        this.view.dispose();
    };
    }

