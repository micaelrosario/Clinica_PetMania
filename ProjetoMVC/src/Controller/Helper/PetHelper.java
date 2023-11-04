/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Pet;
import View.AdicionarPet;
import java.io.Serializable;
        
public class PetHelper implements Serializable{
    private final AdicionarPet view;
    private int id_Dono;

    public PetHelper(AdicionarPet view) {
        this.view = view;
    }
    
    public Pet obterModelo(){
        String nome = view.getTf_nome().getText();
        String raca = view.getTf_raca().getText();
        String idade = view.getTf_idade().getText();
        Pet modelo = new Pet(nome, raca,idade,id_Dono);
        return modelo;
    }
    
    public void setarModelo(Pet modelo){
        String nome = modelo.getNome();
        String raca = modelo.getRaca();
        String idade = modelo.getIdade();
        
        view.getTf_nome().setText(nome);
        view.getTf_raca().setText(raca);
        view.getTf_idade().setText(idade);
    }
    
    public void  limparTela(){
        view.getTf_nome().setText("");
        view.getTf_raca().setText("");
        view.getTf_idade().setText("");
    }
}
