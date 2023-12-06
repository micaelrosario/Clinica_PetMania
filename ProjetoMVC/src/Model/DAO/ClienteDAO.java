/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Dono;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

<<<<<<< HEAD
public class ClienteDAO {
    
    public void create(Dono d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente(nome, telefone, cpf, endereco)VALUES(?, ?, ?, ?)");
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getTelefone());
            stmt.setString(3, d.getCpf());
            stmt.setString(4, d.getEndereco());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Salvar Cliente" +ex); 
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Dono> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Dono> clientes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Dono cliente = new Dono();
                
                cliente.setNome(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEndereco(rs.getString("endereco"));
                clientes.add(cliente);
=======
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
>>>>>>> 572612a388795f3ab9bb249013ee05d32b16f2f3
            }
        }catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
<<<<<<< HEAD
        
        
        return clientes; 
=======

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
>>>>>>> 572612a388795f3ab9bb249013ee05d32b16f2f3
    }
}
