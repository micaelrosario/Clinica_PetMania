package Controller.Helper;

import Model.Produto;
import View.CadastroProduto;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoHelper {
    private final CadastroProduto view;

    public ProdutoHelper(CadastroProduto view) {
        this.view = view;
    }
    
    public Produto obterModelo() {
        String nome = view.getTf_nome().getText();
        String id = view.getTf_id().getText();
        String fornecedor = view.getTf_fornecedor().getText();
        String valorStr = view.getTf_valor().getText();
        String validade = view.getTf_validade().getText();

        // Verificar se algum campo obrigatório está vazio
        if (nome.isEmpty() || id.isEmpty() || fornecedor.isEmpty() || valorStr.isEmpty() || validade.isEmpty()) {
            // JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.");
            return null;  // Retorna null se há campos não preenchidos
        }
        
        // Converter o valor de string para double
        double valor;
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            // Tratar o caso em que o valor não pode ser convertido para double
            JOptionPane.showMessageDialog(null, "O valor deve ser um número válido.");
            return null;
        }
        
        // Criar e retornar um objeto Produto com os dados fornecidos
        return new Produto(nome, id, fornecedor, valor, validade);
    }

    public void setarModelo(Produto modelo) {
        String nome = modelo.getNome();
        String id = modelo.getId();  // Corrigido para obter o ID do modelo
        String fornecedor = modelo.getFornecedor();  // Corrigido para obter o fornecedor do modelo
        String valor = String.valueOf(modelo.getValor());  // Corrigido para obter o valor como String
        String validade = modelo.getValidade();
        
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

    public void preencherTabela(ArrayList<Produto> produtos) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProdutos().getModel();
        tableModel.setNumRows(0);
        
        //Percorrer a lista preenchendo o table Model
        for (Produto produto : produtos) {
            tableModel.addRow(new Object[]{
                produto.getNome(),
                produto.getId(),
                produto.getFornecedor(),
                produto.getValor(),
                produto.getValidade()
            });
        }
    }
}
