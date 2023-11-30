/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Agendamento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
<<<<<<< HEAD
 * @author Usuário
=======
 * @author aluno
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
 */
public class AgendamentoDAO implements Serializable{
    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();
    
    public void cadastrarAgendamento(Agendamento agendamento) {
        AgendamentoDAO.agendamentos.add(agendamento);

        // Serializar apenas o novo agendamento em um arquivo
        try {
            FileOutputStream outFile = new FileOutputStream("agendamentos_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(agendamento);
            } catch (IOException e) {
            e.printStackTrace();
        }

        agendamentos.add(agendamento);

        
        

        System.out.println("Agendamento adicionado no arquivo");
    }
    
    
    public ArrayList<Agendamento> obterAgendamentos() {
        // Desserializa a lista de agendamentos do arquivo
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("agendamentos_lista.txt"))) {
            Object object = objectInputStream.readObject();
            if (object instanceof ArrayList) {
                agendamentos = (ArrayList<Agendamento>) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return agendamentos;
    }
}
    



