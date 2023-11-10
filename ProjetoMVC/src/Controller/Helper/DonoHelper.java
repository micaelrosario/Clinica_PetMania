
package Controller.Helper;

import Model.Dono;
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
        String cpf = view.getTf_cpf().getText();
        String endereco = view.getTf_endereco().getText();
        Dono modelo = new Dono(nome, cpf, telefone, endereco);
        return modelo;
    }
}
