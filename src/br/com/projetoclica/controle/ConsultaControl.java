package br.com.projetoclica.controle;

import br.com.projetoclica.model.ConsultaModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jovino
 */
public class ConsultaControl {
    ConexaoBD conexao = new ConexaoBD();
    
    public void salvar(ConsultaModel consultaModel){
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO consultas(\"codAgendamentoConsulta\", \"diagnosticoConsulta\", \"receitaConsulta\") ");
        sql.append("VALUES (");
        sql.append(consultaModel.getCodAgendamentoConsulta());
        sql.append(", '");
        sql.append(consultaModel.getDiagnosticoConsulta());
        sql.append("', '");
        sql.append(consultaModel.getReceitaConsulta());
        sql.append("')");
        
        try {
            PreparedStatement stmt = conexao.con.prepareStatement(sql.toString());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaControl.class.getName()).log(Level.SEVERE, null, ex);
        }      
        conexao.desconecta();
    }
}
