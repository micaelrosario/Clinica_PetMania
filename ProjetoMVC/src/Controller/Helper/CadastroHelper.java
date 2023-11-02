/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Usuario;
import View.Cadastro;
import View.Login;

public class CadastroHelper {
    
    private final Cadastro view;
    

    public CadastroHelper(Cadastro view) {
        this.view = view;
    }
    
    public Usuario obterModelo(){
        String nome = view.getTf_nome().getText();
        String senha = view.getTf_senha().getText();
        Usuario modelo = new Usuario(nome, senha);
        return modelo;
    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTf_nome().setText(nome);
        view.getTf_senha().setText(senha);
    }
    
    public void  limparTela(){
        view.getTf_nome().setText("");
        view.getTf_senha().setText("");
    }
}
