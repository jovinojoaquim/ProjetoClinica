/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import br.com.projetoclica.model.MedicoModel;
import br.com.projetoclica.model.TabelaModel;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Jovino
 */
public class MedicoControl {

    ConexaoBD conexao = new ConexaoBD();
    MedicoModel medico = new MedicoModel();

    public void salvar(MedicoModel medico) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO medicos(\"nomeMedico\", \"especialidadeMedico\", \"crmMedico\") ");
        sql.append("VALUES (");
        sql.append("?, ?, ?");
        sql.append(")");
        JOptionPane.showMessageDialog(null, sql.toString());
        try {
            PreparedStatement pst = conexao.con.prepareStatement(sql.toString());
            pst.setString(1, medico.getNome());
            pst.setString(2, medico.getEspecialidade());
            pst.setInt(3, medico.getCrm());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Médico inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n " + ex.getMessage() + " \n" + ex.getSQLState());
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.desconecta();
    }

    public void alterar(MedicoModel medico) {
        conexao.conexao();

        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE medicos ");
        sql.append("SET \"nomeMedico\" = '");
        sql.append(medico.getNome());
        sql.append("', \"especialidadeMedico\" ='");
        sql.append(medico.getEspecialidade());
        sql.append("', \"crmMedico\" = '");
        sql.append(medico.getCrm());
        sql.append("' WHERE \"codMedico\" =");
        sql.append(medico.getCodigo());
        System.out.println(sql.toString());
        JOptionPane.showMessageDialog(null, sql.toString());
        try {
            PreparedStatement stmt = conexao.con.prepareStatement(sql.toString());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao alterar dados");
        }
        conexao.desconecta();
    }

    public void excluir(MedicoModel medico) {
        conexao.conexao();

        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM medicos ");
        sql.append("WHERE \"codMedico\" =");
        sql.append(medico.getCodigo());

        try {
            PreparedStatement stmt = conexao.con.prepareCall(sql.toString());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Medico Excluído com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir médico! \n" + ex.getMessage());
        }
        conexao.desconecta();
    }

    public ArrayList preencherTabela(String nomeMedico) {
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{
            "Nome", "Especialidade", "CRM"
        };
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM medicos ");
        sql.append("WHERE");
        sql.append("\"nomeMedico\" LIKE '%");
        sql.append(nomeMedico);
        sql.append("%'");
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();
            do {
                dados.add(new Object[]{
                    conexao.rs.getInt("codMedico"),
                    conexao.rs.getString("nomeMedico"),
                    conexao.rs.getString("especialidadeMedico"),
                    conexao.rs.getInt("crmMedico")
                });
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher o arraylist \n" + ex.getMessage());

        }
        conexao.desconecta();
        return dados;
    }

    public MedicoModel buscaMedicoPorCodigo(String codigo) {
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM medicos ");
        sql.append("WHERE");
        sql.append("\"codMedico\" =");
        sql.append(codigo);
        sql.append(";");
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();
            medico.setCodigo(conexao.rs.getInt("codMedico"));
            medico.setNome(conexao.rs.getString("nomeMedico"));
            medico.setEspecialidade(conexao.rs.getString("especialidadeMedico"));
            medico.setCrm(conexao.rs.getInt("crmMedico"));
        } catch (SQLException ex) {
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nenhum médico foi encontrado");
        }
        return medico;
    }

    public ArrayList<MedicoModel> buscarMedicos(String buscar) {
        ArrayList<MedicoModel> listaMedico = new ArrayList<>();

        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        if (buscar.equals("")) {
            sql.append("SELECT * FROM medicos ");
        }
        conexao.executaSQL(sql.toString());

        try {
            conexao.rs.first();

            do {
                medico = new MedicoModel();
                medico.setCodigo(conexao.rs.getInt("codMedico"));
                medico.setNome(conexao.rs.getString("nomeMedico"));
                medico.setEspecialidade(conexao.rs.getString("especialidadeMedico"));
                medico.setCrm(conexao.rs.getInt("crmMedico"));
                listaMedico.add(medico);
            } while (conexao.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao.desconecta();
        return listaMedico;
    }
}
