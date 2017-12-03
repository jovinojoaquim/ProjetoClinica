package br.com.projetoclica.controle;

import br.com.projetoclica.model.UsuarioModel;
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
public class UsuarioControl {
    ConexaoBD conexao = new ConexaoBD();
    UsuarioModel usuario = new UsuarioModel();
    
    public void salvar(UsuarioModel usuario){
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO usuarios(\"loginUsuario\", \"nomeUsuario\", \"senhaUsuario\", \"tipoUsuario\") ");
        sql.append("VALUES (");
        sql.append("?, ?, ?, ?");
        sql.append(")");
        JOptionPane.showMessageDialog(null, sql.toString());
        try {
            PreparedStatement pst = conexao.con.prepareStatement(sql.toString());
            pst.setString(1, usuario.getLoginUsuario());
            pst.setString(2, usuario.getNomeUsuario());
            pst.setString(3, usuario.getSenhaUsuario());
            pst.setString(4, usuario.getTipoUsuario());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!\n "+ex.getMessage()+" \n"+ ex.getSQLState());
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.desconecta();
    }

    public UsuarioModel buscaUsuario(UsuarioModel usuario){
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuarios ");
        sql.append("WHERE" );
        sql.append("\"nomeUsuario\" LIKE '%");
        sql.append(usuario.getPesquisa());
        sql.append("%'");
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();
            usuario.setCodUsuario(conexao.rs.getInt("codUsuario"));
            usuario.setNomeUsuario(conexao.rs.getString("nomeUsuario"));
            usuario.setTipoUsuario(conexao.rs.getString("tipoUsuario"));
            usuario.setSenhaUsuario(conexao.rs.getString("senhaUsuario"));
            usuario.setLoginUsuario(conexao.rs.getString("loginUsuario"));
        } catch (SQLException ex) {
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nenhum usuário foi encontrado");
        }
        return usuario;
    }

    public void alterar(UsuarioModel usuario) {
        conexao.conexao();
        
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE usuarios ");
        sql.append("SET \"nomeUsuario\" = '");
        sql.append(usuario.getNomeUsuario());
        sql.append("', \"loginUsuario\" ='");
        sql.append(usuario.getLoginUsuario());
        sql.append("', \"tipoUsuario\" = '");
        sql.append(usuario.getTipoUsuario());
        sql.append("', \"senhaUsuario\" = '");
        sql.append(usuario.getSenhaUsuario());
        sql.append("' WHERE \"codUsuario\" =");
        sql.append(usuario.getCodUsuario()); 
        System.out.println(sql.toString());
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
    
    public void excluir(UsuarioModel usuario){
        conexao.conexao();
        
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM usuarios ");
        sql.append("WHERE \"codUsuario\" =");
        sql.append(usuario.getCodUsuario());
       
        try{
            PreparedStatement stmt = conexao.con.prepareCall(sql.toString());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario Excluído com sucesso");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir médico! \n"+ex.getMessage());
        }
        conexao.desconecta();
    }
    
    public ArrayList preencherTabela(String nomeUsuario){
        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{
            "Nome", "Usuário", "Tipo"
        };
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM usuarios ");
        sql.append("WHERE" );
        sql.append("\"nomeUsuario\" LIKE '%");
        sql.append(nomeUsuario);
        sql.append("%'");
        conexao.executaSQL(sql.toString());
        try{
            conexao.rs.first();
            do{
                dados.add(new Object[]{
                    conexao.rs.getInt("codUsuario"),
                    conexao.rs.getString("nomeUsuario"),
                    conexao.rs.getString("loginUsuario"),
                    conexao.rs.getString("tipoUsuario")
                });
            }while(conexao.rs.next());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao preencher o arraylist \n"+ex.getMessage());

        }      
        conexao.desconecta();
        return dados;
    }
    
        public UsuarioModel buscaUsuarioPorCodigo(String codigo){
            conexao.conexao();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM usuarios ");
            sql.append("WHERE" );
            sql.append("\"codUsuario\" =");
            sql.append(codigo);
            sql.append(";");
            conexao.executaSQL(sql.toString());
            try {
                conexao.rs.first();
                usuario.setCodUsuario(conexao.rs.getInt("codUsuario"));
                usuario.setNomeUsuario(conexao.rs.getString("nomeUsuario"));
                usuario.setLoginUsuario(conexao.rs.getString("loginUsuario"));
                usuario.setSenhaUsuario(conexao.rs.getString("senhaUsuario"));
                usuario.setTipoUsuario(conexao.rs.getString("tipoUsuario"));
            } catch (SQLException ex) {
                Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Nenhum usuário foi encontrado");
            }
            return usuario;
        }
}
