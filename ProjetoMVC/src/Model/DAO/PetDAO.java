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
        System.out.println(pet.getIdDono().getCpf());
        try {
            stmt = con.prepareStatement("INSERT INTO pet(nome, raca, idade, cliente_id) VALUES (?, ?, ?, ?)");
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getRaca());
            stmt.setInt(3, pet.getIdade());

            // Supondo que idDono seja a chave estrangeira
            stmt.setInt(4, Integer.parseInt(pet.getIdDono().getCpf()));  // Alteração aqui, use o método getId() ou o equivalente para obter o idDono

            stmt.executeUpdate();

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
            stmt = con.prepareStatement("DELETE FROM pet WHERE codBarras = ?");
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
                String idDono = rs.getString("idDono");
                Dono dono = donoDAO.obterDonoPorID(idDono);

                Pet pet = new Pet(
                    rs.getString("nome"),
                    rs.getString("raca"),
                    rs.getInt("idade"),
                    dono
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
}

    

