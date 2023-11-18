/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Procedimento;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Usuário
 */
public class ProcedimentoDAO implements Serializable{
     private static ArrayList<Procedimento> procedimentos = new ArrayList<>();

    public void cadastrarProcedimento(Procedimento procedimento) {
        procedimentos.add(procedimento);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("procedimentos_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(ProcedimentoDAO.procedimentos);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarProcedimento() {
        try {
            FileInputStream inFile = new FileInputStream("procedimentos_lista.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Procedimento> procedimentosCarregados = (ArrayList<Procedimento>) objectInputStream.readObject();
            objectInputStream.close();
            procedimentos.clear(); // Limpe a lista estática existente
            procedimentos.addAll(procedimentosCarregados); // Adicione os procedimentos carregados à lista estática
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Procedimento> obterProcedimentos() {
        return procedimentos;
    }
    
    public void removerProcedimento(String procedimentoId) {
        // Encontrar o índice do procedimento pelo ID
        int indexToRemove = -1;
        for (int i = 0; i < procedimentos.size(); i++) {
            Procedimento procedimento = procedimentos.get(i);
            if (procedimento.getId().equals(procedimentoId)) {
                indexToRemove = i;
                break;
            }
        }

        // Se o produto foi encontrado, remova-o
        if (indexToRemove != -1) {
            procedimentos.remove(indexToRemove);

            // Atualize o arquivo serializado
            salvarProcedimentos();
        }
    }
    
    private void salvarProcedimentos() {
        try {
            FileOutputStream outFile = new FileOutputStream("produtos_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(ProcedimentoDAO.procedimentos);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
