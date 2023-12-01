/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento implements Serializable{
    private int id;
    private Dono dono; // 
    private Pet pet; // 
    private String horaAtend; 
    private Produto produto;
    private Procedimento procedimento;

    // Construtor
    public Agendamento(int id, Dono dono, Pet pet, String horaAtend, Produto produto, Procedimento procedimento) {
        this.id = id;
        this.dono = dono;
        this.pet = pet;
        this.horaAtend = horaAtend;
        this.produto = produto;
        this.procedimento = procedimento;
    }
    

    // Métodos Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        return horaAtend;
    }

    public void setHoraAtendimento(String horaAtend) {
        this.horaAtend = horaAtend;
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
