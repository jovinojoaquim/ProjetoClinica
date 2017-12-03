/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.model;

/**
 *
 * @author Jovino
 */
public class PacienteModel {

    private int codPaciente;
    private String nomePaciente;
    private String nascimentoPaciente;
    private String rgPaciente;
    private String telefonePaciente;
    private String ruaPaciente;
    private String cepPaciente;
    private String complementoPaciente;
    private String estadoPaciente;
    private BairroModel codBairroPaciente;
    private String pesquisar;
    private String cidade;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodPaciente() {
        return codPaciente;
    }

    public void setCodPaciente(int codPaciente) {
        this.codPaciente = codPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNascimentoPaciente() {
        return nascimentoPaciente;
    }

    public void setNascimentoPaciente(String nascimentoPaciente) {
        this.nascimentoPaciente = nascimentoPaciente;
    }

    public String getRgPaciente() {
        return rgPaciente;
    }

    public void setRgPaciente(String rgPaciente) {
        this.rgPaciente = rgPaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getRuaPaciente() {
        return ruaPaciente;
    }

    public void setRuaPaciente(String ruaPaciente) {
        this.ruaPaciente = ruaPaciente;
    }

    public String getCepPaciente() {
        return cepPaciente;
    }

    public void setCepPaciente(String cepPaciente) {
        this.cepPaciente = cepPaciente;
    }

    public String getComplementoPaciente() {
        return complementoPaciente;
    }

    public void setComplementoPaciente(String complementoPaciente) {
        this.complementoPaciente = complementoPaciente;
    }

    public String getEstadoPaciente() {
        return estadoPaciente;
    }

    public void setEstadoPaciente(String estadoPaciente) {
        this.estadoPaciente = estadoPaciente;
    }

    public BairroModel getCodBairroPaciente() {
        return codBairroPaciente;
    }

    public void setCodBairroPaciente(BairroModel codBairroPaciente) {
        this.codBairroPaciente = codBairroPaciente;
    }

    public String getPesquisar() {
        return pesquisar;
    }

    public void setPesquisar(String pesquisar) {
        this.pesquisar = pesquisar;
    }

}
