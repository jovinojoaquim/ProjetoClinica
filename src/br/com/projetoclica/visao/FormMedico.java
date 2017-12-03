/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.visao;

import br.com.projetoclica.controle.ConexaoBD;
import br.com.projetoclica.controle.MedicoControl;
import br.com.projetoclica.model.MedicoModel;
import br.com.projetoclica.model.TabelaModel;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Jovino
 */
public class FormMedico extends javax.swing.JFrame {
    MedicoModel medico = new MedicoModel();
    MedicoControl medicoControl = new MedicoControl();
    int flag = 0;
    ConexaoBD conexao = new ConexaoBD();
    ArrayList dados = new ArrayList();
    /**
     * Creates new form TelaFormMedico
     */
    public FormMedico() {
        initComponents();
        preencherTabela("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCRM = new javax.swing.JLabel();
        jLabelEspecialista = new javax.swing.JLabel();
        jFormattedTextFieldCRM = new javax.swing.JFormattedTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxEspecialista = new javax.swing.JComboBox<>();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePEsquisaMedico = new javax.swing.JTable();
        jLabelPesquisarMedico = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jLabelCadastroMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelNome.setText("Nome:");

        jLabelCRM.setText("CRM:");

        jLabelEspecialista.setText("Especialista:");

        jComboBoxEspecialista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cirurgias", "Coração", "Veias" }));

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTablePEsquisaMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePEsquisaMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePEsquisaMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePEsquisaMedico);

        jLabelPesquisarMedico.setText("Pesquisar:");

        jTextFieldPesquisar.setToolTipText("Digite o nome ou CRM");
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNome))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCRM)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addComponent(jLabelEspecialista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabelPesquisarMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jLabelEspecialista)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEspecialista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar)
                    .addComponent(jLabelCRM)
                    .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluir)
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPesquisarMedico)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCadastroMedico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCadastroMedico.setText("CADASTRO DE MÉDICO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabelCadastroMedico))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelCadastroMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );

        setSize(new java.awt.Dimension(633, 496));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed

        if(!(jTextFieldNome.getText().isEmpty() || jFormattedTextFieldCRM.getText().isEmpty()))   {     
            medico.setNome(jTextFieldNome.getText());
            medico.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));
            medico.setEspecialidade(jComboBoxEspecialista.getSelectedItem().toString());

            if(flag ==0){
                medicoControl.salvar(medico);
            }else{

                medicoControl.alterar(medico);
                flag = 0;
                jButtonEditar.setEnabled(true);
                preencherTabela("");
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        jTextFieldNome.setText("");
        jFormattedTextFieldCRM.setText("");
        jComboBoxEspecialista.setSelectedIndex(0);
        medico=null;
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jTextFieldPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyReleased
        preencherTabela(jTextFieldPesquisar.getText());
        
    }//GEN-LAST:event_jTextFieldPesquisarKeyReleased

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag = 1;
        jTextFieldNome.setEnabled(true);
        jFormattedTextFieldCRM.setEnabled(true);
        jComboBoxEspecialista.setEnabled(true);
        jButtonEditar.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja Realmente excluir este médico?");
        medicoControl.excluir(medico);
        if(resposta== JOptionPane.YES_OPTION){
            medicoControl.excluir(medico);
            preencherTabela("");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTablePEsquisaMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePEsquisaMedicoMouseClicked
        jButtonEditar.setEnabled(true);
        
        String codigoMedico = ""+jTablePEsquisaMedico.getValueAt(jTablePEsquisaMedico.getSelectedRow(), 0);
        medico = medicoControl.buscaMedicoPorCodigo(codigoMedico);
        System.out.println(medico.getNome());
        jTextFieldNome.setText(medico.getNome());
        jFormattedTextFieldCRM.setText(String.valueOf(medico.getCrm()));
        jComboBoxEspecialista.setSelectedItem(medico.getEspecialidade());
        
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldCRM.setEnabled(false);
        jComboBoxEspecialista.setEnabled(false);
        flag =1;
    }//GEN-LAST:event_jTablePEsquisaMedicoMouseClicked

    public void preencherTabela(String medico){
        dados = medicoControl.preencherTabela(medico);
        String[] colunas = new String[]{
            "","Nome", "Especialidade", "CRM"
        };
        TabelaModel modeloTabela = new TabelaModel(dados, colunas);
        jTablePEsquisaMedico.setModel(modeloTabela);
        jTablePEsquisaMedico.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTablePEsquisaMedico.getColumnModel().getColumn(0).setResizable(true);
        jTablePEsquisaMedico.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTablePEsquisaMedico.getColumnModel().getColumn(1).setResizable(true);
        jTablePEsquisaMedico.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTablePEsquisaMedico.getColumnModel().getColumn(2).setResizable(true);
        jTablePEsquisaMedico.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTablePEsquisaMedico.getColumnModel().getColumn(3).setResizable(true);
        jTablePEsquisaMedico.getTableHeader().setReorderingAllowed(true);
        jTablePEsquisaMedico.setAutoResizeMode(jTablePEsquisaMedico.AUTO_RESIZE_ALL_COLUMNS);
        jTablePEsquisaMedico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }
    
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
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxEspecialista;
    private javax.swing.JFormattedTextField jFormattedTextFieldCRM;
    private javax.swing.JLabel jLabelCRM;
    private javax.swing.JLabel jLabelCadastroMedico;
    private javax.swing.JLabel jLabelEspecialista;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPesquisarMedico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTablePEsquisaMedico;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}