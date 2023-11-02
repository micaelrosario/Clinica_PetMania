
package Model.DAO;

import Model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioAutenticacao {
    // ARRAYLIST DE USUÁRIOS PARA LOGAR NO SISTEMA
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("usuarios_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(UsuarioAutenticacao.usuarios);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Boolean autenticarUsuario(Usuario usuario) {
    // Verificar se o usuário e a senha 
        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        for (Usuario user : usuarios)
            if (user.getNome().equals(nome) && user.getSenha().equals(senha)) {
                return true;
            }
        return false;
        }
        
    }

