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
            System.out.println("Cliente cadastrado na tabela");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Salvar Cliente" +ex); 
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete(Dono d){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM cliente WHERE cpf = ?");
            stmt.setString(1, d.getCpf());
          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Cliente" +ex); 
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
            }
        }catch(SQLException ex){
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return clientes;
    }

    public Dono obterDonoPorID(String id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE id = ?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Dono dono = new Dono(
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("endereco")
                );
                return dono;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao obter Dono por ID: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return null; // Retorna null se não encontrar um dono com o ID especificado
    }
}


