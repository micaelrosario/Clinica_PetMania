/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.DAO.ProcedimentoDAO;
import Model.Procedimento;
import View.CadastroServiço;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class ProcedimentoHelper {
    private final CadastroServiço view;

    public ProcedimentoHelper(CadastroServiço view) {
        this.view = view;
    }
    
    public Procedimento obterModelo() {
        String nome = view.getTf_nome().getText();
        String idStr = view.getTf_id().getText();
        String funcionario = view.getTf_funcionario().getText();
        String valorStr = view.getTf_valor().getText();
        int id = Integer.parseInt(idStr);

        // Verificar se algum campo obrigatório está vazio
        if (nome.isEmpty() || id == 0 || funcionario.isEmpty() || valorStr.isEmpty()) {
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
        ProcedimentoDAO procedimentoDAO = new ProcedimentoDAO();
        List<Procedimento> procedimentos = procedimentoDAO.read();
        

        for (Procedimento procedimento : procedimentos) {
            if (procedimento.getId()!= 0 && procedimento.getId() == id) {
                JOptionPane.showMessageDialog(null, "Serviço com ID: "+procedimento.getId()+" já cadastrado.");
                return null;  // Retorna null se o CPF já existe
            }
        }
        
        
        
        // Criar e retornar um objeto Procedimento com os dados fornecidos
        return new Procedimento(nome, id, funcionario, valor);
    }

    public void setarModelo(Procedimento modelo) {
        String nome = modelo.getNome();
        int idInt = modelo.getId();  // Corrigido para obter o ID do modelo
        String fornecedor = modelo.getFuncionario();  // Corrigido para obter o fornecedor do modelo
        String valor = String.valueOf(modelo.getValor());  // Corrigido para obter o valor como String
        String id = String.valueOf(idInt);
        
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

    public void preencherTabela() {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableProcedimento().getModel();

        // Limpar as linhas existentes na tabela
        tableModel.setNumRows(0);
        
        ProcedimentoDAO procedimentoDAO= new ProcedimentoDAO();

        // Percorrer a lista preenchendo o table Model
        for (Procedimento procedimento : procedimentoDAO.read()) {
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
        Procedimento procedimento = new Procedimento();
        if (selectedRow != -1) {
            // Obtém o ID do produto na coluna 1 (ou ajuste conforme necessário)
            procedimento.setId((int) tableModel.getValueAt(selectedRow, 1));

            // Remove o produto do modelo da tabela
            tableModel.removeRow(selectedRow);

            // Atualiza a exibição da tabela
            tableModel.fireTableDataChanged();

            // Remova o produto do armazenamento persistente, se necessário
            ProcedimentoDAO procedDAO = new ProcedimentoDAO();
            procedDAO.delete(procedimento);
            // Exemplo: ProdutoDAO.removerProduto(productId);
        } else {
            // Exiba uma mensagem informando que nenhum produto foi selecionado
            JOptionPane.showMessageDialog(null, "Selecione um serviço para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
