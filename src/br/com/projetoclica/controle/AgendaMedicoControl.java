package br.com.projetoclica.controle;

import br.com.projetoclica.model.AgendamentoModel;
import br.com.projetoclica.model.MedicoModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovino
 */
public class AgendaMedicoControl {
    AgendamentoModel agendamento = new AgendamentoModel();
    MedicoControl medicoControl = new MedicoControl();
    PacienteControl pacienteControl = new PacienteControl();
    ConexaoBD conexao = new ConexaoBD();

    public ArrayList preencherTabela(String medico, MedicoModel medicoModel) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        ArrayList dados = new ArrayList();

        if (medico.equals("") && medicoModel == null) {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\"");
            System.out.println(sql.toString());
        } else {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\" ");
            sql.append("WHERE ");
            sql.append("\"codMedicoAgendamento\" = '");
            sql.append(medicoModel.getCodigo());
            sql.append("' AND \"situacaoAgendamento\"='");
            sql.append("Atender");
            sql.append("'");

            System.out.println(sql.toString());
        }
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();

            do {
                dados.add(new Object[]{
                    conexao.rs.getString("nomePaciente"),
                    conexao.rs.getString("rgPaciente"),
                    conexao.rs.getString("telefonePaciente"),
                    conexao.rs.getString("situacaoAgendamento"),
                    conexao.rs.getString("turnoAgendamento"),
                    conexao.rs.getString("motivoAgendamento")
                });
            } while (conexao.rs.next());

        } catch (SQLException ex) {
//            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return dados;
    }

    public ArrayList<AgendamentoModel> buscarAgendamento(String medico, MedicoModel medicoModel) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        ArrayList dados = new ArrayList();
        if (medico.equals("") && medicoModel == null) {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\"");
            System.out.println(sql.toString());
        } else {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\" ");
            sql.append("WHERE ");
            sql.append("\"codMedicoAgendamento\" = '");
            sql.append(medicoModel.getCodigo());
            sql.append("' AND \"situacaoAgendamento\"='");
            sql.append("Atender");
            sql.append("'");

            System.out.println(sql.toString());
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

}
