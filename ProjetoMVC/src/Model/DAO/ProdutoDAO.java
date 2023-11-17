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

    public void carregarProdutos() {
        try {
            FileInputStream inFile = new FileInputStream("produtos_lista.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inFile);
            ArrayList<Produto> produtosCarregados = (ArrayList<Produto>) objectInputStream.readObject();
            objectInputStream.close();
            produtos.clear(); // Limpe a lista estática existente
            produtos.addAll(produtosCarregados); // Adicione os produtos carregados à lista estática
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Produto> obterProdutos() {
        return produtos;
    }
    
    public void removerProduto(String productId) {
        // Encontrar o índice do produto pelo ID
        int indexToRemove = -1;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId().equals(productId)) {
                indexToRemove = i;
                break;
            }
        }

        // Se o produto foi encontrado, remova-o
        if (indexToRemove != -1) {
            produtos.remove(indexToRemove);

            // Atualize o arquivo serializado
            salvarProdutos();
        }
    }
    
    private void salvarProdutos() {
        try {
            FileOutputStream outFile = new FileOutputStream("produtos_lista.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFile);
            objectOutputStream.writeObject(ProdutoDAO.produtos);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
