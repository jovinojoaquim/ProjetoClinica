package br.com.projetoclica.controle;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jovino
 */
public class ConexaoBD {
    public Statement stmt;
    public ResultSet rs;
    private static final String driver = "org.postgreesql.driver";
    private static final String host = "jdbc:postgresql://localhost:5432/projetoclinica";
    private static final String usuario = "postgres";
    private static final String senha = "root";
    public static Connection con;
    
    public static Connection conexao(){
        try {
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(host, usuario, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    public void desconecta(){
        try {
            con.close();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao fechar conexao");
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void executaSQL(String sql){
        try {
            stmt = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao executar sql");
        }
    }
}
