/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime; // Importe a classe LocalDateTime para representar a hora do atendimento.
import Model.Dono;
import Model.Pet;
import java.io.Serializable;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento implements Serializable{
    private GeradorDeId id;
    private Dono dono; // 
    private Pet pet; // 
    private String horaAtendimento; 
    private Produto produto;
    private Procedimento procedimento;

    // Construtor
    public Agendamento(GeradorDeId id, Dono dono, Pet pet, String horaAtendimento, Produto produto, Procedimento procedimento) {
        this.id = id;
        this.dono = dono;
        this.pet = pet;
        this.horaAtendimento = horaAtendimento;
        this.produto = produto;
        this.procedimento = procedimento;
    }
    

    // Métodos Getters e Setters

    public GeradorDeId getId() {
        return id;
    }

    public void setId(GeradorDeId id) {
        this.id = id;
    }
    
    
    
    public Dono getDono() {
        return dono;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(String horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    

}
