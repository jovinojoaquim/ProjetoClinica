package br.com.projetoclica.controle;

import br.com.projetoclica.model.BairroModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jovino
 */
public class BairroControl {
    ConexaoBD conexao = new ConexaoBD();
    BairroModel bairro;
    ArrayList<BairroModel> lista = new ArrayList<>();
    

    public ArrayList buscaBairro(){
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM bairros ");
        
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();
            do{          
                bairro = new BairroModel();
                bairro.setCodBairro(conexao.rs.getInt("codBairro"));
                bairro.setNomeBairro(conexao.rs.getString("nomeBairro"));
                lista.add(bairro);
            }while(conexao.rs.next());
           
        } catch (SQLException ex) {
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nenhum bairro foi encontrado");
        }
        conexao.desconecta();
        return lista;
    }
    
    public BairroModel buscarBairro(int codigo){
        conexao.conexao();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM bairros WHERE \"codBairro\" =");
        sql.append(codigo);
        
        conexao.executaSQL(sql.toString());
        try {
            conexao.rs.first();
            do{          
                bairro = new BairroModel();
                bairro.setCodBairro(conexao.rs.getInt("codBairro"));
                bairro.setNomeBairro(conexao.rs.getString("nomeBairro"));
                lista.add(bairro);
            }while(conexao.rs.next());
           
        } catch (SQLException ex) {
            Logger.getLogger(MedicoControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nenhum bairro foi encontrado");
        }
        conexao.desconecta();
        return bairro;
    }
}
