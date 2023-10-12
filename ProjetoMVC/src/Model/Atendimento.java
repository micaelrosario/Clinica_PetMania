/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime; // Importe a classe LocalDateTime para representar a hora do atendimento.
import Model.Dono;
import Model.Pet;

public class Atendimento {
    private Dono dono; // 
    private Pet pet; // 
    private LocalDateTime horaAtendimento; 

    // Construtor
    public Atendimento(Dono dono, Pet pet, LocalDateTime horaAtendimento) {
        this.dono = dono;
        this.pet = pet;
        this.horaAtendimento = horaAtendimento;
    }

    // Métodos Getters e Setters

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

    public LocalDateTime getHoraAtendimento() {
        return horaAtendimento;
    }

    public void setHoraAtendimento(LocalDateTime horaAtendimento) {
        this.horaAtendimento = horaAtendimento;
    }

}
