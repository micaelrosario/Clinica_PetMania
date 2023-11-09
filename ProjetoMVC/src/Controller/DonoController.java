/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.CadastroCliente;
import View.SubMenuCadastro;
import java.io.Serializable;

/**
 *
 * @author Usuário
 */
public class DonoController implements Serializable {
     private final CadastroCliente view;
     private DonoHelper helper;

    public DonoController(CadastroCliente view) {
        this.view = view;
        this.helper = new DonoHelper(helper);
    }
    
    public void cadastrarCliente(){
        //Pegar Pet da view
        Dono dono = helper.obterModelo();
        
        DonoDAO donoDao = new DonoDAO();
        donoDao.cadastrarCliente(dono);
    }
     
    public void voltarAoMenu(){
        SubMenuCadastro novoFrame = new SubMenuCadastro();
        novoFrame.setVisible(true);
    }
}
