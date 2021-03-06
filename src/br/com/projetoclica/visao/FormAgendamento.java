/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.visao;

import br.com.projetoclica.controle.ConexaoBD;
import br.com.projetoclica.controle.AgendamentoControl;
import br.com.projetoclica.controle.MedicoControl;
import br.com.projetoclica.controle.PacienteControl;
import br.com.projetoclica.model.AgendamentoModel;
import br.com.projetoclica.model.MedicoModel;
import br.com.projetoclica.model.PacienteModel;
import br.com.projetoclica.model.TabelaModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Jovino
 */
public class FormAgendamento extends javax.swing.JFrame {
    private AgendamentoModel agendamentoModel = new AgendamentoModel();
    private AgendamentoControl agendamentoControl = new AgendamentoControl();
    private PacienteControl pacienteControl = new PacienteControl();
    private PacienteModel pacienteModel = new PacienteModel();
    private MedicoModel medicoModel = new MedicoModel();
    private MedicoControl medicoControl = new MedicoControl();
    private int flag = 0;
    private ConexaoBD conexao = new ConexaoBD();
    private ArrayList dados = new ArrayList();
    private ArrayList<AgendamentoModel> listaAgendamentos = new ArrayList<>();
    private ArrayList<PacienteModel> listaPacientes = new ArrayList<>();
    private ArrayList<MedicoModel> listaMedicos = new ArrayList<>();
    /**
     * Creates new form TelaFormMedico
     */
    public FormAgendamento() {
        initComponents();
        preencherTabela("");
        preencherListaMedicos();
        bloquearCampos();
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
        jLabelPaciente = new javax.swing.JLabel();
        jLabelMedico = new javax.swing.JLabel();
        jLabelData = new javax.swing.JLabel();
        jTextFieldPaciente = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePEsquisaAgendamento = new javax.swing.JTable();
        jLabelPesquisarMedico = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabelMotivo = new javax.swing.JLabel();
        jComboBoxMedicos = new javax.swing.JComboBox<>();
        jTextFieldMotivo = new javax.swing.JTextField();
        jButtonFinalizarAgendamento = new javax.swing.JButton();
        jButtonCancelarAgendamento = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabelCadastroMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelPaciente.setText("Paciente:");

        jLabelMedico.setText("Médico:");

        jLabelData.setText("Data:");

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno" }));

        jTablePEsquisaAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePEsquisaAgendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePEsquisaAgendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePEsquisaAgendamento);

        jLabelPesquisarMedico.setText("Pesquisar:");

        jTextFieldPesquisar.setToolTipText("Digite o nome ou CRM");
        jTextFieldPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisarKeyReleased(evt);
            }
        });

        jLabel1.setText("Turno:");

        jLabelMotivo.setText("Motivo:");

        jComboBoxMedicos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonFinalizarAgendamento.setText("Finalizar Agendamento");
        jButtonFinalizarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarAgendamentoActionPerformed(evt);
            }
        });

        jButtonCancelarAgendamento.setText("Cancelar Agendamento");
        jButtonCancelarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarAgendamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFinalizarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarAgendamento)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPaciente)
                            .addComponent(jLabelMotivo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMedico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldMotivo)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelPesquisarMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPesquisarMedico)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelData)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPaciente)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelMedico)
                        .addComponent(jComboBoxMedicos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMotivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFinalizarAgendamento)
                    .addComponent(jButtonCancelarAgendamento))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabelCadastroMedico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCadastroMedico.setText("AGENDAMENTO");

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
                .addGap(110, 110, 110))
        );

        setSize(new java.awt.Dimension(633, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarAgendamentoActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButtonCancelarAgendamentoActionPerformed

    private void limparCampos() {
        pacienteModel = null;
        medicoModel = null;
        jTextFieldPaciente.setText("");
        jTextFieldMotivo.setText("");
        jComboBoxMedicos.setSelectedIndex(0);
        jComboBoxTurno.setSelectedIndex(0);
        jDateChooser1.setDate(null);
    }

    private void jButtonFinalizarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarAgendamentoActionPerformed
        if(jTextFieldPaciente.getText().equals("") ||
            jTextFieldMotivo.getText().equals("") ||
            jDateChooser1.getDate()==(null) ||
            jComboBoxMedicos.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }else{
            medicoModel = listaMedicos.get(jComboBoxMedicos.getSelectedIndex()-1);

            agendamentoModel.setCodPacienteAgendamento(pacienteModel);
            agendamentoModel.setCodMedicoAgendamento(medicoModel);
            agendamentoModel.setDataAgendamento(jDateChooser1.getDate());
            agendamentoModel.setMotivoAgendamento(jTextFieldMotivo.getText());
            agendamentoModel.setTurno(jComboBoxTurno.getSelectedItem().toString());

            agendamentoControl.salvar(agendamentoModel);
            limparCampos();
            jButtonCancelarAgendamentoActionPerformed(evt);
        }
    }//GEN-LAST:event_jButtonFinalizarAgendamentoActionPerformed

    private void jTextFieldPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarKeyReleased
        preencherTabela(jTextFieldPesquisar.getText());
    }//GEN-LAST:event_jTextFieldPesquisarKeyReleased

    private void jTablePEsquisaAgendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePEsquisaAgendamentoMouseClicked
        liberarCampos();
        pacienteModel = listaPacientes.get(jTablePEsquisaAgendamento.getSelectedRow());
        jTextFieldPaciente.setText(pacienteModel.getNomePaciente());

    }//GEN-LAST:event_jTablePEsquisaAgendamentoMouseClicked

    public void preencherTabela(String paciente){
        dados = pacienteControl.preencherTabela(paciente);
        listaPacientes = pacienteControl.buscarPacientes(paciente);
        String[] colunas = new String[]{
            "", "Nome", "RG", "Telefone"
        };
        TabelaModel modeloTabela = new TabelaModel(dados, colunas);
        jTablePEsquisaAgendamento.setModel(modeloTabela);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(0).setResizable(true);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(1).setResizable(true);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(2).setResizable(true);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTablePEsquisaAgendamento.getColumnModel().getColumn(3).setResizable(true);

        jTablePEsquisaAgendamento.getTableHeader().setReorderingAllowed(true);
        
        jTablePEsquisaAgendamento.setAutoResizeMode(jTablePEsquisaAgendamento.AUTO_RESIZE_ALL_COLUMNS);
        jTablePEsquisaAgendamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
                new FormAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarAgendamento;
    private javax.swing.JButton jButtonFinalizarAgendamento;
    private javax.swing.JComboBox<String> jComboBoxMedicos;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCadastroMedico;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelMotivo;
    private javax.swing.JLabel jLabelPaciente;
    private javax.swing.JLabel jLabelPesquisarMedico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePEsquisaAgendamento;
    private javax.swing.JTextField jTextFieldMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables

    private void preencherListaMedicos() {
        listaMedicos = medicoControl.buscarMedicos("");
        System.out.println(listaMedicos.size());
        jComboBoxMedicos.removeAllItems();
        jComboBoxMedicos.addItem(" - ");
        for(MedicoModel medico : listaMedicos){
            jComboBoxMedicos.addItem(medico.getNome());
        }
    }

    private void bloquearCampos() {
        jTextFieldPaciente.setEditable(false);
        jTextFieldPaciente.setEnabled(false);
        jTextFieldMotivo.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jComboBoxMedicos.setEnabled(false);
        jComboBoxTurno.setEnabled(false);
    }
    
    private void liberarCampos(){
        jTextFieldPaciente.setEditable(false);
        jTextFieldPaciente.setEnabled(true);
        jTextFieldMotivo.setEnabled(true);
        jDateChooser1.setEnabled(true);
        jComboBoxMedicos.setEnabled(true);
        jComboBoxTurno.setEnabled(true);
    }
}
