/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Dono;
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
public class ClienteDAO implements Serializable {
    private static ArrayList<Dono> clientes = new ArrayList<>();

    public void cadastrarCliente(Dono produto) {
        clientes.add(produto);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("clientes_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(ClienteDAO.clientes);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void carregarClientes() {
        try {
            FileInputStream inFile = new FileInputStream("clientes_lista.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Dono> clientesCarregados = (ArrayList<Dono>) objectInputStream.readObject();
            objectInputStream.close();
            clientes.clear(); // Limpe a lista estática existente
            clientes.addAll(clientesCarregados); // Adicione os clientes carregados à lista estática
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Dono> obterClientes() {
        return clientes;
    }
    
    public void removerCliente(String productId) {
        // Encontrar o índice do produto pelo ID
        int indexToRemove = -1;
        for (int i = 0; i < clientes.size(); i++) {
            Dono cliente = clientes.get(i);
            if (cliente.getCpf().equals(productId)) {
                indexToRemove = i;
                break;
            }
        }

        // Se o produto foi encontrado, remova-o
        if (indexToRemove != -1) {
            clientes.remove(indexToRemove);

            // Atualize o arquivo serializado
            salvarCliente();
        }
    }
    
    private void salvarCliente() {
        try {
            FileOutputStream outFile = new FileOutputStream("clientes_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(ClienteDAO.clientes);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
