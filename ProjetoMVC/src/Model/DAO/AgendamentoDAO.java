/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Agendamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgendamentoDAO {
    public void create(Agendamento agenda){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO agendamento(cliente, pet, data, produto, procedimento) VALUES (?, ?, ?, ?, ?)");
            stmt.setObject(1, agenda.getDono().getNome());
            stmt.setObject(2, agenda.getPet().getNome());
            stmt.setString(3, agenda.getHoraAtend());
            stmt.setString(4, agenda.getProduto().getNome());
            stmt.setString(4, agenda.getProcedimento().getNome());

            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Pet: " + ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    
    public void delete(Agendamento a){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM pet WHERE id = ?");
            stmt.setInt(1, a.getId());
          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Pet" +ex); 
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    // ... outros métodos da classe PetDAO

    public List<Agendamento> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Agendamento> agendamentos = new ArrayList<>();
        Agendamento a = new Agendamento();

        try {
            stmt = con.prepareStatement("SELECT * FROM pet");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Agendamento agendamento = new Agendamento(
                    rs.getInt("id"),
                    rs.getObject(cliente),
                    rs.getString("pet"),
                    rs.getInt("data"),
                    rs.getString("id_dono"),
                    rs.getString("id_dono")
                );

                agendamentos.add(agendamento);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao tentar ler Pets " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return pets;
    }
}

    

