/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.visao;

import br.com.projetoclica.controle.AgendaControl;
import br.com.projetoclica.controle.ConexaoBD;
import br.com.projetoclica.controle.AgendamentoControl;
import br.com.projetoclica.controle.MedicoControl;
import br.com.projetoclica.controle.PacienteControl;
import br.com.projetoclica.model.AgendamentoModel;
import br.com.projetoclica.model.MedicoModel;
import br.com.projetoclica.model.PacienteModel;
import br.com.projetoclica.model.TabelaModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Jovino
 */
public class FormAgenda extends javax.swing.JFrame {
    private AgendamentoModel agendamentoModel = new AgendamentoModel();
    private ArrayList dados = new ArrayList();
    private  ArrayList<AgendamentoModel> listaAgendamentos = new ArrayList<>();
    private ArrayList<PacienteModel> listaPacientes = new ArrayList<>();
    private final AgendaControl agendaControl = new AgendaControl();
    private String dataPesquisada = "";
    /**
     * Creates new form TelaFormMedico
     */
    public FormAgenda() {
        initComponents();
        preencherTabela("", null);
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAgenda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButtonAtender = new javax.swing.JButton();
        jTextFieldMotivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButtonCancelado = new javax.swing.JButton();
        jButtonFinalizado = new javax.swing.JButton();
        jLabelCadastroMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableAgenda);

        jLabel1.setText("Data:");

        jButtonAtender.setText("Atender");
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });

        jLabel2.setText("Motivo:");

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonCancelado.setText("Cancelado");
        jButtonCancelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCanceladoActionPerformed(evt);
            }
        });

        jButtonFinalizado.setText("Finalizado");
        jButtonFinalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonFinalizado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldMotivo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtender)
                    .addComponent(jButtonCancelado)
                    .addComponent(jButtonFinalizado))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jLabelCadastroMedico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCadastroMedico.setText("AGENDA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jLabelCadastroMedico)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCadastroMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        setSize(new java.awt.Dimension(633, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMouseClicked
        agendamentoModel = listaAgendamentos.get(jTableAgenda.getSelectedRow());
        jTextFieldMotivo.setText("");
        jTextFieldMotivo.setText(agendamentoModel.getMotivoAgendamento());
        System.out.println(agendamentoModel.getMotivoAgendamento());
    }//GEN-LAST:event_jTableAgendaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(jDateChooser1.getDate()!= null && !dataPesquisada.equals(jDateChooser1.getDate().toString())){
            System.out.println("Entrando");
            preencherTabela("", new java.sql.Date(jDateChooser1.getDate().getTime()));           
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
        agendamentoModel = listaAgendamentos.get(jTableAgenda.getSelectedRow());
        agendamentoModel.setSituacaoAgendamento(jButtonAtender.getText());
        agendaControl.alterarSituacao(agendamentoModel);
        if(jDateChooser1.getDate()!= null && !dataPesquisada.equals(jDateChooser1.getDate().toString())){
            System.out.println("Entrando");
            preencherTabela("", new java.sql.Date(jDateChooser1.getDate().getTime()));           
        }else{
             preencherTabela("", null);
        }
    }//GEN-LAST:event_jButtonAtenderActionPerformed

    private void jButtonCanceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCanceladoActionPerformed
        agendamentoModel = listaAgendamentos.get(jTableAgenda.getSelectedRow());
        agendamentoModel.setSituacaoAgendamento(jButtonCancelado.getText());
        agendaControl.alterarSituacao(agendamentoModel);
        if(jDateChooser1.getDate()!= null && !dataPesquisada.equals(jDateChooser1.getDate().toString())){
            System.out.println("Entrando");
            preencherTabela("", new java.sql.Date(jDateChooser1.getDate().getTime()));           
        }else{
             preencherTabela("", null);
        }
    }//GEN-LAST:event_jButtonCanceladoActionPerformed

    private void jButtonFinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizadoActionPerformed
        agendamentoModel = listaAgendamentos.get(jTableAgenda.getSelectedRow());
        agendamentoModel.setSituacaoAgendamento(jButtonFinalizado.getText());
        agendaControl.alterarSituacao(agendamentoModel);
        if(jDateChooser1.getDate()!= null && !dataPesquisada.equals(jDateChooser1.getDate().toString())){
            System.out.println("Entrando");
            preencherTabela("", new java.sql.Date(jDateChooser1.getDate().getTime()));           
        }else{
             preencherTabela("", null);
        }
    }//GEN-LAST:event_jButtonFinalizadoActionPerformed

    public void preencherTabela(String paciente, Date data){
        dados = agendaControl.preencherTabela(paciente, data);
        
        if(dados != null){listaAgendamentos = agendaControl.buscarAgendamento(paciente, data);}
        String[] colunas = new String[]{
            "Nome", "RG", "Telefone", "Situação", "Turno", "Médico"
        };
        TabelaModel modeloTabela = new TabelaModel(dados, colunas);
        jTableAgenda.setModel(modeloTabela);
        jTableAgenda.getColumnModel().getColumn(0).setPreferredWidth(0);
        jTableAgenda.getColumnModel().getColumn(0).setResizable(true);
        jTableAgenda.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTableAgenda.getColumnModel().getColumn(1).setResizable(true);
        jTableAgenda.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTableAgenda.getColumnModel().getColumn(2).setResizable(true);
        jTableAgenda.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableAgenda.getColumnModel().getColumn(3).setResizable(true);
        jTableAgenda.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableAgenda.getColumnModel().getColumn(4).setResizable(true);

        jTableAgenda.getTableHeader().setReorderingAllowed(true);
        
//        jTableAgenda.setAutoResizeMode(jTableAgenda.AUTO_RESIZE_ALL_COLUMNS);
        jTableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JButton jButtonCancelado;
    private javax.swing.JButton jButtonFinalizado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCadastroMedico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAgenda;
    private javax.swing.JTextField jTextFieldMotivo;
    // End of variables declaration//GEN-END:variables


}
