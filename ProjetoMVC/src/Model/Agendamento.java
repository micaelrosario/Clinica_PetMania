/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime; // Importe a classe LocalDateTime para representar a hora do atendimento.
import Model.Dono;
import Model.Pet;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agendamento {
    private int id;
    private Dono dono; // 
    private Pet pet; // 
    private Date horaAtendimento; 
    private Produto produto;
    private Procedimento procedimento;

    // Construtor
    public Agendamento(int id, Dono dono, Pet pet, String horaAtendimento, Produto produto, Procedimento procedimento) {
        this.id = id;
        this.dono = dono;
        this.pet = pet;
        try {
            this.horaAtendimento = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(horaAtendimento);
        } catch (ParseException ex) {
            // Se houver um erro ao analisar a data, imprima a exceção e defina a data como null
            ex.printStackTrace();
            this.horaAtendimento = null; // Ou defina para um valor padrão, dependendo da lógica do seu aplicativo
        }
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

    public Date getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(Date horaAtendimento) {
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
