
package Controller.Helper;

import View.CadastroCliente;
import java.io.Serializable;


public class DonoHelper implements Serializable {
    private final CadastroCliente view;

    public DonoHelper(CadastroCliente view) {
        this.view = view;
    }
    
    public Dono obterModelo(){
        String nome = view.getTf_nome().getText();
        String telefone = view.getTf_telefone().getText();
        String email = view.getTf_email().getText();
        String endereco = view.getTf_endereco().getText();
        Pet modelo = new Dono(nome, raca,idade,id_Dono);
        return modelo;
    }
}
