/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.AdicionarPet;
import Controller.Helper.PetHelper;
import Model.DAO.PetDados;
import Model.Pet;
import View.SubMenuCadastro;
import java.io.Serializable;

/**
 *
 * @author Usuário
 */
public class PetController implements Serializable{
    
    private final AdicionarPet view;
    private PetHelper helper;

    public PetController(AdicionarPet view) {
        this.view = view;
        this.helper = new PetHelper(view);
    }
    
    public void cadastrarPet(){
        //Pegar Pet da view
        Pet pet = helper.obterModelo();
        
        PetDados petDados = new PetDados();
        petDados.cadastrarPet(pet);
    }
    public void voltarAoMenu(){
        SubMenuCadastro novoFrame = new SubMenuCadastro();
        novoFrame.setVisible(true);
    }
}
