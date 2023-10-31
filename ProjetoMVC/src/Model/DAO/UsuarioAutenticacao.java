
package Model.DAO;

import Model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAutenticacao {
    private List<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(String nome, String senha) {
        Usuario novoUsuario = new Usuario(nome, senha);
        usuarios.add(novoUsuario);

        // Serializar a lista de usuários em um arquivo
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarios.txt"))) {
            out.writeObject(usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean autenticarUsuario(String nome, String senha) {
    // Verificar se o usuário e a senha coincidem
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                return true;
            }
        }
        return false;
    }
}
