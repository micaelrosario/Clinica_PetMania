/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.ClienteController;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuário
 */
public class CadastroCliente extends javax.swing.JFrame {

    private final ClienteController controller;
    /**
     * Creates new form CadastroCliente
     */
    public CadastroCliente() {
        initComponents();
        
        controller = new ClienteController(this);
        
        // Adicione um listener para o evento de visibilidade da janela
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent evt) {
                controller.atualizaTabela();
            }
        });
        // Impedir reordenação de colunas
        tableCliente.getTableHeader().setReorderingAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tf_nome = new javax.swing.JTextField();
        tf_telefone = new javax.swing.JTextField();
        tf_cpf = new javax.swing.JTextField();
        tf_endereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCliente = new javax.swing.JTable();
        Fundo_CadastrarCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 280, 100, 40));

        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 100, 40));

        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 40, 50));

        tf_nome.setBorder(null);
        getContentPane().add(tf_nome, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 126, 220, 30));

        tf_telefone.setBorder(null);
        getContentPane().add(tf_telefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 126, 200, 30));

        tf_cpf.setBorder(null);
        getContentPane().add(tf_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 220, 30));

        tf_endereco.setBorder(null);
        tf_endereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_enderecoActionPerformed(evt);
            }
        });
        getContentPane().add(tf_endereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 200, 30));

        tableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "Cpf", "Endereço"
            }
        ));
        jScrollPane1.setViewportView(tableCliente);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 690, 150));

        Fundo_CadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/CadastroCliente.png"))); // NOI18N
        getContentPane().add(Fundo_CadastrarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 760, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_enderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_enderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_enderecoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.controller.voltarSubMenuCadastro();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.controller.cadastrarCliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.controller.excluirCliente();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fundo_CadastrarCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCliente;
    private javax.swing.JTextField tf_cpf;
    private javax.swing.JTextField tf_endereco;
    private javax.swing.JTextField tf_nome;
    private javax.swing.JTextField tf_telefone;
    // End of variables declaration//GEN-END:variables

    public JTextField getTf_cpf() {
        return tf_cpf;
    }

    public void setTf_cpf(JTextField tf_cpf) {
        this.tf_cpf = tf_cpf;
    }

    public JTextField getTf_endereco() {
        return tf_endereco;
    }

    public void setTf_endereco(JTextField tf_endereco) {
        this.tf_endereco = tf_endereco;
    }

    public JTextField getTf_nome() {
        return tf_nome;
    }

    public void setTf_nome(JTextField tf_nome) {
        this.tf_nome = tf_nome;
    }

    public JTextField getTf_telefone() {
        return tf_telefone;
    }

    public void setTf_telefone(JTextField tf_telefone) {
        this.tf_telefone = tf_telefone;
    }

    public JTable getTableCliente() {
        return tableCliente;
    }

    public void setTableCliente(JTable tableCliente) {
        this.tableCliente = tableCliente;
    }

    
    

    
}
