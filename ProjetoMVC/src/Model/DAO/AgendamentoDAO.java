/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Agendamento;
import Model.Dono;
import Model.Pet;
import Model.Procedimento;
import Model.Produto;
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
            stmt.setString(5, agenda.getProcedimento().getNome());

            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer agendamento: " + ex); 
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

        try {
            stmt = con.prepareStatement("SELECT * FROM agendamento"); // Correção na tabela para "agendamento"
            rs = stmt.executeQuery();

            while (rs.next()) {
                Agendamento agendamento = new Agendamento();

                // Aqui assumo que você tenha um método setId() em Agendamento, ajuste conforme necessário
                agendamento.setId(rs.getInt("id"));

                // Assumindo que "dono", "pet", "produto" e "procedimento" são IDs
                String donoId = rs.getString("dono");
                String petId = rs.getString("pet");
                String produtoId = rs.getString("produto");
                String procedimentoId = rs.getString("procedimento");

                // Aqui você deve obter os objetos Dono, Pet, Produto e Procedimento pelos seus IDs
                // Implemente o método getById() ou ajuste conforme sua lógica
                ClienteDAO c = new ClienteDAO();
                Dono dono = c.obterDonoPorID(donoId);
                PetDAO p = new PetDAO();
                Pet pet = p.obterPetPorID(petId);
                ProdutoDAO produt = new ProdutoDAO();
                Produto produto = produt.obterProdutoPorID(produtoId);
                ProcedimentoDAO proced = new ProcedimentoDAO();
                Procedimento procedimento = proced.obterProcedimentoPorID(procedimentoId);

                agendamento.setDono(dono);
                agendamento.setPet(pet);
                agendamento.setHoraAtend(rs.getString("data"));
                agendamento.setProduto(produto);
                agendamento.setProcedimento(procedimento);

                agendamentos.add(agendamento);
            }

        } catch (SQLException ex) {
            System.out.println("Erro ao tentar ler Agendamentos " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return agendamentos;
    }

}

    

