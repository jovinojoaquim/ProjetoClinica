package br.com.projetoclica.model;

/**
 *
 * @author Jovino
 */
public class UsuarioModel {
    private Integer codUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private String tipoUsuario;
    private String pesquisa;

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPesquisa() {
        return pesquisa;
    }
    
    public void setPesquisa(String pesquisa){
        this.pesquisa = pesquisa;
    }
    
}
