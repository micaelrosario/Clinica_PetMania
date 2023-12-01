/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;
<<<<<<< HEAD

=======
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
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
<<<<<<< HEAD
        AgendamentoDAO.agendamentos.add(agendamento);

        // Serializar apenas o novo agendamento em um arquivo
        try {
            FileOutputStream outFile = new FileOutputStream("agendamentos_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(agendamento);
=======
        agendamentos.add(agendamento);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("pets_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(AgendamentoDAO.agendamentos);
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
<<<<<<< HEAD

        System.out.println("Agendamento adicionado no arquivo");
    }

    
    public void carregarAgendamentos(){
        try {
            FileInputStream inFile = new FileInputStream("agendamentos_lista.txt");
=======
    }
    
    public void carregarAgendamentos() {
        try {
            FileInputStream inFile = new FileInputStream("pets_lista.txt");
>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Agendamento> petsCarregados = (ArrayList<Agendamento>) objectInputStream.readObject();
            objectInputStream.close();
            agendamentos.clear();
            agendamentos.addAll(petsCarregados);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
<<<<<<< HEAD
    public ArrayList<Agendamento> obterAgendamentos(){
        return agendamentos;
    }
    
    
}
=======
    public ArrayList<Agendamento> obterAgendamentos() {
        return agendamentos;
    }

    public void cadastrarAgendamento(View.Agendamento newAgendamento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}


>>>>>>> 64cf2ecc99e24c0e05695767622aca2570f94679
