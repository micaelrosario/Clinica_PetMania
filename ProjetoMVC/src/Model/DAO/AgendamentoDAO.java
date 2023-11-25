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
 * @author aluno
 */
public class AgendamentoDAO implements Serializable{
    private static ArrayList<Agendamento> agendamentos = new ArrayList<>();
    
    public void cadastrarAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("pets_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(AgendamentoDAO.agendamentos);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void carregarAgendamentos() {
        try {
            FileInputStream inFile = new FileInputStream("pets_lista.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Agendamento> petsCarregados = (ArrayList<Agendamento>) objectInputStream.readObject();
            objectInputStream.close();
            agendamentos.clear();
            agendamentos.addAll(petsCarregados);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Agendamento> obterAgendamentos() {
        return agendamentos;
    }

    public void cadastrarAgendamento(View.Agendamento newAgendamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


