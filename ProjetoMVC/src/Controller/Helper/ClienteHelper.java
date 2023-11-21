/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.DAO.ClienteDAO;
import Model.Dono;
import View.CadastroCliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuário
 */
public class ClienteHelper implements Serializable{
    private final CadastroCliente view;

    public ClienteHelper(CadastroCliente view) {
        this.view = view;
    }
    
    public Dono obterModelo() {
        String nome = view.getTf_nome().getText();
        String cpf = view.getTf_cpf().getText();
        String telefone = view.getTf_telefone().getText();
        String endereco = view.getTf_endereco().getText();

        // Verificar se algum campo obrigatório está vazio
        if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos obrigatórios.");
            return null;  // Retorna null se há campos não preenchidos
        }

        // Verificar se o CPF já existe na lista de clientes
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Dono> clientes = clienteDAO.obterClientes();

        for (Dono cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                JOptionPane.showMessageDialog(null, "Cliente com CPF " + cpf + " já cadastrado.");
                return null;  // Retorna null se o CPF já existe
            }
        }

        // Criar e retornar um objeto Cliente com os dados fornecidos
        return new Dono(nome, cpf, telefone, endereco);
    }


    public void setarModelo(Dono modelo) {
        String nome = modelo.getNome();
        String cpf = modelo.getCpf();  // Corrigcpfo para obter o ID do modelo
        String telefone = modelo.getTelefone();  // Corrigcpfo para obter o telefone do modelo
        String endereco = String.valueOf(modelo.getEndereco());  // Corrigcpfo para obter o endereco como String
        
        
        view.getTf_nome().setText(nome);
        view.getTf_cpf().setText(cpf);
        view.getTf_telefone().setText(telefone);
        view.getTf_endereco().setText(endereco);
        
    }
    
    public void limparTela() {
        view.getTf_nome().setText("");
        view.getTf_cpf().setText("");
        view.getTf_telefone().setText("");
        view.getTf_endereco().setText("");
        
    }

    public void preencherTabela(ArrayList<Dono> clientesCarregados) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableCliente().getModel();

        // Limpar as linhas existentes na tabela
        tableModel.setNumRows(0);

        // Inverter a ordem dos produtos
        Collections.reverse(clientesCarregados);

        // Percorrer a lista preenchendo o table Model
        for (Dono cliente : clientesCarregados) {
            tableModel.addRow(new Object[]{
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getCpf(),
                cliente.getEndereco(),
            });
        }
    }
    
    public void excluirCliente(){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTableCliente().getModel();
        int selectedRow = view.getTableCliente().getSelectedRow();

        if (selectedRow != -1) {
            // Obtém o ID do Cliente na coluna 1 (ou ajuste conforme necessário)
            String clienteId = (String) tableModel.getValueAt(selectedRow, 2);

            // Remove o produto do modelo da tabela
            tableModel.removeRow(selectedRow);
            // Atualiza a exibição da tabela
            tableModel.fireTableDataChanged();
            // Remova o produto do armazenamento persistente, se necessário
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.removerCliente(clienteId);
        } else {
            // Exiba uma mensagem informando que nenhum cliente foi selecionado
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }
}
