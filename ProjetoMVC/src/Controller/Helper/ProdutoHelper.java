package Controller.Helper;

import Model.DAO.ProcedimentoDAO;
import Model.Produto;
import View.CadastroProduto;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.DAO.ProdutoDAO;
import Model.Procedimento;
import java.util.List;
import javax.swing.ImageIcon;

public class ProdutoHelper implements Serializable{
    private final CadastroProduto view;

    public ProdutoHelper(CadastroProduto view) {
        this.view = view;
    }
    
    public Produto obterModelo() {
        String nome = view.getTf_nome().getText();
        String idStr = view.getTf_id().getText();
        String fornecedor = view.getTf_fornecedor().getText();
        String valorStr = view.getTf_valor().getText();
        String validade = view.getTf_validade().getText();
        int id = Integer.parseInt(idStr);

        // Verificar se algum campo obrigatório está vazio
        if (nome.isEmpty() || id == 0 || fornecedor.isEmpty() || valorStr.isEmpty() || validade.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.");
            return null;  // Retorna null se há campos não preenchidos
        }
        
        // Converter o valor de string para double
        double valor;
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            // Tratar o caso em que o valor não pode ser convertido para double
            JOptionPane.showMessageDialog(null, "O campo VALOR deve ser um número válido. ex: 10.00");
            return null;
        }
        
        // Verificar se o CPF já existe na lista de clientes
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.read();
        

        for (Produto produto : produtos) {
            if (produto.getId()!= 0 && produto.getId() == id) {
                JOptionPane.showMessageDialog(null, "Produto com ID: "+produto.getId()+" já cadastrado.");
                return null;  // Retorna null se o CPF já existe
            }
        }
        
        
        // Criar e retornar um objeto Produto com os dados fornecidos
        return new Produto(nome, id, fornecedor, valor, validade);
    }

    public void setarModelo(Produto modelo) {
        String nome = modelo.getNome();
        int idInt = modelo.getId();  // Corrigido para obter o ID do modelo
        String fornecedor = modelo.getFornecedor();  // Corrigido para obter o fornecedor do modelo
        String valor = String.valueOf(modelo.getValor());  // Corrigido para obter o valor como String
        String validade = modelo.getValidade();
        String id = String.valueOf(idInt);
        
        view.getTf_nome().setText(nome);
        view.getTf_id().setText(id);
        view.getTf_fornecedor().setText(fornecedor);
        view.getTf_valor().setText(valor);
        view.getTf_validade().setText(validade);
    }
    
    public void limparTela() {
        view.getTf_nome().setText("");
        view.getTf_id().setText("");
        view.getTf_fornecedor().setText("");
        view.getTf_valor().setText("");
        view.getTf_validade().setText("");
    }

    public void preencherTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProdutos().getModel();

        // Limpar as linhas existentes na tabela
        tableModel.setNumRows(0);

        ProdutoDAO produto = new ProdutoDAO();

        // Percorrer a lista preenchendo o table Model
        for (Produto p : produto.read()) {
            // Verificar se o nome não é vazio e o valor é diferente de zero
            if (!p.getNome().isEmpty() && p.getValor() != 0.0) {
                tableModel.addRow(new Object[]{
                    p.getNome(),
                    p.getId(),
                    p.getFornecedor(),
                    p.getValor(),
                    p.getValidade(),
                });
            }
        }
    }

    
    public void excluirProduto(){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProdutos().getModel();
        int selectedRow = view.getTableProdutos().getSelectedRow();
        Produto produto = new Produto();
        
        if (selectedRow != -1) {
            // Obtém o ID do produto na coluna 1 (ou ajuste conforme necessário)
            produto.setId((int) tableModel.getValueAt(selectedRow, 1));

            // Remove o produto do modelo da tabela
            tableModel.removeRow(selectedRow);

            // Atualiza a exibição da tabela
            tableModel.fireTableDataChanged();

            // Remova o produto do armazenamento persistente, se necessário
            ProdutoDAO produtoDAO = new ProdutoDAO();
            produtoDAO.delete(produto);
            
            ImageIcon icon = new ImageIcon("C:\\Users\\Usuário\\OneDrive\\Documentos\\MeusProjetos-Github\\Clinica_PetMania\\ProjetoMVC\\src\\Imagens/sucess.png");
            ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
            JOptionPane.showMessageDialog(null, "Produto "+produto.getNome()+" Excluído com Sucesso","Info",JOptionPane.PLAIN_MESSAGE, resizedIcon);
        } else {
            // Exiba uma mensagem informando que nenhum produto foi selecionado
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }

    }
}




