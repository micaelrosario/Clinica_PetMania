/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Dono;
import Model.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PetDAO {
    public void create(Pet pet){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pet(nome, raca, idade, dono) VALUES (?, ?, ?, ?)");
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getRaca());
            stmt.setInt(3, pet.getIdade());
            stmt.setString(4, pet.getIdDono());

            stmt.executeUpdate();
            System.out.println("Pet cadastrado na tabela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Pet: " + ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public void delete(Pet p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM pet WHERE nome = ?");
            stmt.setString(1, p.getNome());
          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Pet" +ex); 
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    // ... outros métodos da classe PetDAO

    public List<Pet> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pet> pets = new ArrayList<>();
        ClienteDAO donoDAO = new ClienteDAO();

        try {
            stmt = con.prepareStatement("SELECT * FROM pet");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String idDono = rs.getString("dono");
                Dono dono = donoDAO.obterDonoPorID(idDono);

                Pet pet = new Pet(
                    rs.getString("nome"),
                    rs.getString("raca"),
                    rs.getInt("idade"),
                    rs.getString("dono")
                );

                pets.add(pet);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao tentar ler Pets " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pets;
    }
    
    public Pet obterPetPorID(String id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM pet WHERE id = ?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Pet pet = new Pet(
                    rs.getString("nome"),
                    rs.getString("raca"),
                    rs.getInt("idade"),
                    rs.getString("dono")
                );
                return pet;
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao obter Dono por ID: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return null; // Retorna null se não encontrar um dono com o ID especificado
    }
}

    

