package br.com.projetoclica.controle;

import br.com.projetoclica.model.AgendamentoModel;
import br.com.projetoclica.model.BairroModel;
import br.com.projetoclica.model.PacienteModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jovino
 */
public class AgendamentoControl {

    private static PacienteControl pacienteControl = new PacienteControl();
    ConexaoBD conexao = new ConexaoBD();
    AgendamentoModel agendamento;
    ArrayList<BairroModel> lista = new ArrayList<>();

    public ArrayList preencherTabela(String paciente) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        ArrayList dados = new ArrayList();
        if (paciente.equals("")) {
            sql.append("SELECT * FROM agendamentos inner join pacientes on true inner join medicos on true");
            System.out.println(sql.toString());
        } else {

            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = ");
            sql.append("(SELECT \"codPaciente\" from pacientes ");
            sql.append("WHERE \"nomePaciente\" LIKE '%");
            sql.append(paciente);
            sql.append("%' or \"rgPaciente\" LIKE '%");
            sql.append(paciente);
            sql.append("%') ");
            sql.append("inner join medicos on true");
            System.out.println(sql.toString());
        }
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();

                do {
                    dados.add(new Object[]{
                        conexao.rs.getString("nomePaciente"),
                        conexao.rs.getString("MotivoAgendamento"),
                        conexao.rs.getString("rgPaciente"),
                        conexao.rs.getString("telefonePaciente"),
                        conexao.rs.getString("turnoAgendamento"),
                        conexao.rs.getString("nomeMedico")
                    });
                } while (conexao.rs.next());
           
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return dados;
    }

    public ArrayList buscarAgendamento(String buscar) {
        ArrayList<AgendamentoModel> dados = new ArrayList();
        MedicoControl medicoControl = new MedicoControl();
        PacienteControl pacienteControl = new PacienteControl();
        
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        if (buscar.equals("")) {
            sql.append("SELECT * FROM agendamentos inner join pacientes on true inner join medicos on true");
        } else {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = ");
            sql.append("(SELECT \"codPaciente\" from pacientes ");
            sql.append("WHERE \"nomePaciente\" LIKE '%");
            sql.append(buscar);
            sql.append("%' or \"rgPaciente\" LIKE '%");
            sql.append(buscar);
            sql.append("%') ");
            sql.append("inner join medicos on true");
        }

        conexao.executaSQL(sql.toString());

        try {
            conexao.rs.first();

            do {
                agendamento = new AgendamentoModel();
                agendamento.setCodAgendamento(conexao.rs.getInt("codAgendamento"));
                agendamento.setMotivoAgendamento(conexao.rs.getString("motivoAgendamento"));
                agendamento.setDataAgendamento(conexao.rs.getDate("dataAgendamento"));
                agendamento.setTurno(conexao.rs.getString("turnoAgendamento"));
                agendamento.setCodMedicoAgendamento(medicoControl.buscaMedicoPorCodigo(conexao.rs.getString("codMedicoAgendamento")));
                agendamento.setCodPacienteAgendamento(pacienteControl.buscarPacientesPorCodigo(conexao.rs.getString("codPacienteAgendamento")));
                
                dados.add(agendamento);
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return dados;
    }

    public static void main(String args[]) {
        ArrayList<PacienteModel> listaDePacientes = new ArrayList<>();
        listaDePacientes = pacienteControl.buscarPacientes("a");
        AgendamentoControl ac = new AgendamentoControl();
//        ac.preencherTabela(listaDePacientes);
        ac.preencherTabela("a");
    }


    public void salvar(AgendamentoModel agendamento) {
        conexao.conexao();
        
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO agendamentos(");
        sql.append("\"codPacienteAgendamento\",");
        sql.append("\"turnoPaciente\",");
        sql.append("\"codMedicoAgendamento\",");
        sql.append("\"dataAgendamento\",");
        sql.append("\"motivoAgendamento\") VALUES (");
        sql.append(agendamento.getCodPacienteAgendamento().getCodPaciente());
        sql.append(", '");
        sql.append(agendamento.getTurno());
        sql.append("', ");
        sql.append(agendamento.getCodMedicoAgendamento().getCodigo());
        sql.append(", '");
        sql.append(new java.sql.Date(agendamento.getDataAgendamento().getTime()));
        sql.append("', '");
        sql.append(agendamento.getMotivoAgendamento());
        sql.append("')");
        System.out.println(sql.toString());
        try {
            PreparedStatement stmt = conexao.con.prepareStatement(sql.toString());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        conexao.desconecta();
    }





}
