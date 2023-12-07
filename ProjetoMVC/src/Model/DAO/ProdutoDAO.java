package Model.DAO;

import ConnectionFactory.ConnectionFactory;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProdutoDAO {
    
    public void create(Produto produto){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO produto(nome, codBarras, fornecedor, valor, validade) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getId());
            stmt.setString(3, produto.getFornecedor());
            stmt.setDouble(4, produto.getValor());
            stmt.setString(5, produto.getValidade());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar Produto: " + ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE codBarras = ?");
            stmt.setInt(1, p.getId());
          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir Produto" +ex); 
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    public List<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(
                    rs.getString("nome"),
                    rs.getInt("codBarras"),
                    rs.getString("fornecedor"),
                    rs.getDouble("valor"),
                    rs.getString("validade")
                );

                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar ler Produtos "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;   
    }
}
