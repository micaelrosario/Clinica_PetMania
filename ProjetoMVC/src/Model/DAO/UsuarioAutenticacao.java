
package Model.DAO;

import Model.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioAutenticacao implements Serializable{
    // ARRAYLIST DE USUÁRIOS PARA LOGAR NO SISTEMA
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    
    // Método para carregar a lista de usuários a partir de um arquivo
    public void carregarUsuarios() {
     try {
         FileInputStream inFile = new FileInputStream("usuarios_lista.txt");
         ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
         ArrayList<Usuario> usuariosCarregados = (ArrayList<Usuario>) objectInputStream.readObject();
         objectInputStream.close();
         usuarios.clear(); // Limpa a lista atual de usuários
         usuarios.addAll(usuariosCarregados); // Adiciona os usuários carregados ao ArrayList
     } catch (IOException | ClassNotFoundException e) {
         // Lidar com exceções, por exemplo, se o arquivo não existir
         e.printStackTrace();
     }
 }
    
    
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
            JOptionPane.showMessageDialog(null, "Erro ao criar arquivo");
        }
    }
    public Boolean autenticarUsuario(Usuario usuario) {
    // Verificar se o usuário e a senha 
        String nome = usuario.getNome();
        String senha = usuario.getSenha();
        for (Usuario user : usuarios)
            if (user != null && user.getNome().equals(nome) && user.getSenha().equals(senha)) {
                return true;
            }
        return false;
    }
        
    }

