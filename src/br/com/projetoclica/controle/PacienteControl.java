package br.com.projetoclica.controle;

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
public class PacienteControl {

    PacienteModel paciente = new PacienteModel();
    ConexaoBD conexao = new ConexaoBD();
    BairroModel bairro = new BairroModel();
    BairroControl bairroControle = new BairroControl();
    ArrayList<BairroModel> lista = new ArrayList<>();

    public void salvar(PacienteModel paciente) {
        conexao.conexao();

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO pacientes ");
        sql.append("(\"nomePaciente\", ");
        sql.append("\"nascimentoPaciente\", ");
        sql.append("\"rgPaciente\", ");
        sql.append("\"telefonePaciente\", ");
        sql.append("\"ruaPaciente\", ");
        sql.append("\"cepPaciente\", ");
        sql.append("\"complementoPaciente\", ");
        sql.append("\"estadoPaciente\", ");
        sql.append("\"codBairroPaciente\")");
        sql.append("VALUES (");
        sql.append("\'");
        sql.append(paciente.getNomePaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getNascimentoPaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getRgPaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getTelefonePaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getRuaPaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getCepPaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getComplementoPaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getEstadoPaciente());
        sql.append("\', ");
        sql.append("\'");
        sql.append(paciente.getCodBairroPaciente().getCodBairro());
        sql.append("\') ");

        try {
            PreparedStatement pst = conexao.con.prepareStatement(sql.toString());
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados");
        }
        conexao.desconecta();
    }

    public void alterar(PacienteModel paciente) {
        conexao.conexao();

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE pacientes SET ");
        sql.append("\"nomePaciente\" = '");
        sql.append(paciente.getNomePaciente());
        sql.append("', \"nascimentoPaciente\" ='");
        sql.append(paciente.getNascimentoPaciente());
        sql.append("', \"rgPaciente\" ='");
        sql.append(paciente.getRgPaciente());
        sql.append("', \"cidadePaciente\" ='");
        sql.append(paciente.getCidade());
        sql.append("', \"telefonePaciente\" ='");
        sql.append(paciente.getTelefonePaciente());
        sql.append("', \"ruaPaciente\" ='");
        sql.append(paciente.getRuaPaciente());
        sql.append("', \"cepPaciente\" ='");
        sql.append(paciente.getCepPaciente());
        sql.append("', \"complementoPaciente\" ='");
        sql.append(paciente.getComplementoPaciente());
        sql.append("', \"estadoPaciente\" ='");
        sql.append(paciente.getEstadoPaciente());
        sql.append("', \"codBairroPaciente\" =");
        sql.append(paciente.getCodBairroPaciente().getCodBairro());
        sql.append(" WHERE \"codPaciente\"  ='");
        sql.append(paciente.getCodPaciente());
        sql.append("\'");

        System.out.println(sql.toString());
        try {
            PreparedStatement pst = conexao.con.prepareStatement(sql.toString());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados");
        }
        conexao.desconecta();
    }

    public ArrayList preencherTabela(String buscar) {
        ArrayList dados = new ArrayList();
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        if (buscar.equals("")) {
            sql.append("SELECT * FROM pacientes");
        } else {
            sql.append("SELECT * FROM pacientes ");
            sql.append("WHERE ");
            sql.append(" \"nomePaciente\" LIKE '%");
            sql.append(buscar);
            sql.append("%' OR ");
            sql.append("\"rgPaciente\" LIKE '%");
            sql.append(buscar);
            sql.append(("%'"));
        }

        conexao.executaSQL(sql.toString());

        try {
            conexao.rs.first();

            do {
                dados.add(new Object[]{
                    conexao.rs.getInt("codPaciente"),
                    conexao.rs.getString("nomePaciente"),
                    conexao.rs.getString("rgPaciente"),
                    conexao.rs.getString("telefonePaciente")
                });
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return dados;
    }

    public static void main(String args[]) {
        PacienteControl pc = new PacienteControl();
        PacienteModel pm = new PacienteModel();
        BairroModel bm = new BairroModel();

        bm.setCodBairro(1);
        bm.setNomeBairro("Santa Amélia");
        
        pm.setCodPaciente(2);
        pm.setNomePaciente("Nome");
        pm.setCepPaciente("312222");
        pm.setCidade("Cidade");
        pm.setComplementoPaciente("Complemento");
        pm.setEstadoPaciente("MG");
        pm.setNascimentoPaciente("07/31/1993");
        pm.setRgPaciente("321");
        pm.setRuaPaciente("Rua 1");
        pm.setTelefonePaciente("9999");
        pm.setCodBairroPaciente(bm);

//        pc.salvar(pm);
//        pc.excluir(pm);
//        pc.alterar(pm);

    }

    public ArrayList buscarPacientes(String buscar) {
        ArrayList<PacienteModel> dados = new ArrayList();
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        if (buscar.equals("")) {
            sql.append("SELECT * FROM pacientes");
        } else {
            sql.append("SELECT * FROM pacientes ");
            sql.append("WHERE ");
            sql.append(" \"nomePaciente\" LIKE '%");
            sql.append(buscar);
            sql.append("%' OR ");
            sql.append("\"rgPaciente\" LIKE '%");
            sql.append(buscar);
            sql.append(("%'"));
        }

        conexao.executaSQL(sql.toString());

        try {
            conexao.rs.first();

            do {
                paciente = new PacienteModel();
                
                bairro = bairroControle.buscarBairro(conexao.rs.getInt("codBairroPaciente"));

                paciente.setCodPaciente(conexao.rs.getInt("codPaciente"));
                paciente.setNomePaciente(conexao.rs.getString("nomePaciente"));
                paciente.setRgPaciente(conexao.rs.getString("rgPaciente"));
                paciente.setTelefonePaciente(conexao.rs.getString("telefonePaciente"));
                paciente.setNascimentoPaciente(conexao.rs.getString("nascimentoPaciente"));
                paciente.setRuaPaciente(conexao.rs.getString("ruaPaciente"));
                paciente.setCepPaciente(conexao.rs.getString("cepPaciente"));
                paciente.setComplementoPaciente(conexao.rs.getString("complementoPaciente"));
                paciente.setCidade(conexao.rs.getString("cidadePaciente"));
                paciente.setEstadoPaciente(conexao.rs.getString("estadoPaciente"));
                paciente.setCodBairroPaciente(bairro);
                dados.add(paciente);
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return dados;
    }

    public void excluir(PacienteModel pacienteModelo) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM pacientes WHERE \"codPaciente\" =");
        sql.append(pacienteModelo.getCodPaciente());
        
        try {
            PreparedStatement pst = conexao.con.prepareCall(sql.toString());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paciente Excluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir paciente");
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }    
        conexao.desconecta();
    }

    public PacienteModel buscarPacientesPorCodigo(String buscar) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        if (buscar.equals("")) {
            sql.append("SELECT * FROM pacientes");
        } else {
            sql.append("SELECT * FROM pacientes ");
            sql.append("WHERE ");
            sql.append(" \"codPaciente\" =");
            sql.append(buscar);
        }

        conexao.executaSQL(sql.toString());

        try {
            conexao.rs.first();

            do {
                paciente = new PacienteModel();
                
                bairro = bairroControle.buscarBairro(conexao.rs.getInt("codBairroPaciente"));

                paciente.setCodPaciente(conexao.rs.getInt("codPaciente"));
                paciente.setNomePaciente(conexao.rs.getString("nomePaciente"));
                paciente.setRgPaciente(conexao.rs.getString("rgPaciente"));
                paciente.setTelefonePaciente(conexao.rs.getString("telefonePaciente"));
                paciente.setNascimentoPaciente(conexao.rs.getString("nascimentoPaciente"));
                paciente.setRuaPaciente(conexao.rs.getString("ruaPaciente"));
                paciente.setCepPaciente(conexao.rs.getString("cepPaciente"));
                paciente.setComplementoPaciente(conexao.rs.getString("complementoPaciente"));
                paciente.setCidade(conexao.rs.getString("cidadePaciente"));
                paciente.setEstadoPaciente(conexao.rs.getString("estadoPaciente"));
                paciente.setCodBairroPaciente(bairro);
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(PacienteControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return paciente;
    }
}
