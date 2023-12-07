package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Procedimento;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProcedimentoDAO {
    
    public void create(Procedimento p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO procedimento(nome, id, funcionario, valor) VALUES (?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getId());
            stmt.setString(3, p.getFuncionario());
            stmt.setDouble(4, p.getValor());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Procedimento: " + ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Procedimento p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM procedimento WHERE id = ?");
            stmt.setInt(1, p.getId());
          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir um Procedimento" +ex); 
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Procedimento> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Procedimento> procedimentos = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM procedimento");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Procedimento procedimento = new Procedimento(
                    rs.getString("nome"),
                    rs.getInt("id"),
                    rs.getString("funcionario"),
                    rs.getDouble("valor")
                );

                procedimentos.add(procedimento);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar ler Procedimentos "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return procedimentos;   
    }
}
