package br.com.projetoclica.controle;

import br.com.projetoclica.model.AgendamentoModel;
import br.com.projetoclica.model.BairroModel;
import br.com.projetoclica.model.PacienteModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jovino
 */
public class AgendaControl {

    private static PacienteControl pacienteControl = new PacienteControl();
    ConexaoBD conexao = new ConexaoBD();
    AgendamentoModel agendamento;
    ArrayList<BairroModel> lista = new ArrayList<>();

    public ArrayList preencherTabela(String paciente, Date data) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        ArrayList dados = new ArrayList();
        
        if (paciente.equals("") && data == null) {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\"");
            System.out.println(sql.toString());
        } else{
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\" ");
            sql.append("WHERE ");
            sql.append("\"dataAgendamento\" = '");
            sql.append(data.toString());
            sql.append("'");
            
//            sql.append("SELECT * FROM agendamentos ");
//            sql.append("inner join pacientes on ");
//            sql.append("\"dataAgendamento\" = '");
//            sql.append(data.toString());
//            sql.append("' inner join medicos on true");
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
                        conexao.rs.getString("nomeMedico")                        
                    });
                } while (conexao.rs.next());
           
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return dados;
    }

    public ArrayList buscarAgendamento(String buscar, Date data) {
        ArrayList<AgendamentoModel> dados = new ArrayList();
        MedicoControl medicoControl = new MedicoControl();
        PacienteControl pacienteControl = new PacienteControl();
        
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        if (buscar.equals("") && data == null) {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\"");
        } else {
            sql.append("SELECT * FROM agendamentos ");
            sql.append("inner join pacientes on ");
            sql.append("\"codPacienteAgendamento\" = \"codPaciente\" ");
            sql.append("inner join medicos on \"codMedicoAgendamento\" = \"codMedico\" ");
            sql.append("WHERE ");
            sql.append("\"dataAgendamento\" = '");
            sql.append(data.toString());
            sql.append("'");
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

       public void alterarSituacao(AgendamentoModel agendamentoModel) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE agendamentos SET \"situacaoAgendamento\" = '");
        sql.append(agendamentoModel.getSituacaoAgendamento());
        sql.append("' WHERE \"codAgendamento\" =");
        sql.append(agendamentoModel.getCodAgendamento());
        
        try{
            PreparedStatement stmt = conexao.con.prepareStatement(sql.toString());

            stmt.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
        System.out.println(sql.toString());
        conexao.desconecta();
    }




}
