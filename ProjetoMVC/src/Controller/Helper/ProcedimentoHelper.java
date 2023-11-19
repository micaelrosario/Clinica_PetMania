/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.DAO.ProcedimentoDAO;
import Model.Procedimento;
import View.CadastroServiço;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class ProcedimentoHelper implements Serializable{
    private final CadastroServiço view;

    public ProcedimentoHelper(CadastroServiço view) {
        this.view = view;
    }
    
    public Procedimento obterModelo() {
        String nome = view.getTf_nome().getText();
        String id = view.getTf_id().getText();
        String funcionario = view.getTf_funcionario().getText();
        String valorStr = view.getTf_valor().getText();
        

        // Verificar se algum campo obrigatório está vazio
        if (nome.isEmpty() || id.isEmpty() || funcionario.isEmpty() || valorStr.isEmpty()) {
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
        
        // Criar e retornar um objeto Procedimento com os dados fornecidos
        return new Procedimento(nome, id, funcionario, valor);
    }

    public void setarModelo(Procedimento modelo) {
        String nome = modelo.getNome();
        String id = modelo.getId();  // Corrigido para obter o ID do modelo
        String fornecedor = modelo.getFuncionario();  // Corrigido para obter o fornecedor do modelo
        String valor = String.valueOf(modelo.getValor());  // Corrigido para obter o valor como String
        
        
        view.getTf_nome().setText(nome);
        view.getTf_id().setText(id);
        view.getTf_funcionario().setText(fornecedor);
        view.getTf_valor().setText(valor);
        
    }
    
    public void limparTela() {
        view.getTf_nome().setText("");
        view.getTf_id().setText("");
        view.getTf_funcionario().setText("");
        view.getTf_valor().setText("");
        
    }

    public void preencherTabela(ArrayList<Procedimento> procedimentosCarregados) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProcedimento().getModel();

        // Limpar as linhas existentes na tabela
        tableModel.setNumRows(0);

        // Inverter a ordem dos produtos
        Collections.reverse(procedimentosCarregados);

        // Percorrer a lista preenchendo o table Model
        for (Procedimento procedimento : procedimentosCarregados) {
            tableModel.addRow(new Object[]{
                procedimento.getNome(),
                procedimento.getId(),
                procedimento.getFuncionario(),
                procedimento.getValor(),
            });
        }
    }
    
    public void excluirProcedimento(){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProcedimento().getModel();
        int selectedRow = view.getTableProcedimento().getSelectedRow();

        if (selectedRow != -1) {
            // Obtém o ID do produto na coluna 1 (ou ajuste conforme necessário)
            String procedimentoId = (String) tableModel.getValueAt(selectedRow, 1);

            // Remove o produto do modelo da tabela
            tableModel.removeRow(selectedRow);

            // Atualiza a exibição da tabela
            tableModel.fireTableDataChanged();

            // Remova o produto do armazenamento persistente, se necessário
            ProcedimentoDAO produtoDAO = new ProcedimentoDAO();
            produtoDAO.removerProcedimento(procedimentoId);
            // Exemplo: ProdutoDAO.removerProduto(productId);
        } else {
            // Exiba uma mensagem informando que nenhum produto foi selecionado
            JOptionPane.showMessageDialog(null, "Selecione um procedimento para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
