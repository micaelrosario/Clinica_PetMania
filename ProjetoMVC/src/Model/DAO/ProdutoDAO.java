/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.Produto;
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
public class ProdutoDAO implements Serializable {
    private static ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto dono) {
        produtos.add(dono);

        // Serializar a lista de usuários em um arquivo
        try{
            FileOutputStream outFile = new FileOutputStream("produtos_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(ProdutoDAO.produtos);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> carregarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();

        try {
            FileInputStream inFile = new FileInputStream("produtos_lista.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Produto> produtosCarregados = (ArrayList<Produto>) objectInputStream.readObject();
            objectInputStream.close();
            produtos.addAll(produtosCarregados);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return produtos;
    }


    public ArrayList<Produto> obterProdutos() {
        return produtos;
    }
}
