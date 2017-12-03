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
public class ConsultaModel {
    private int codConsulta;
    private int codAgendamentoConsulta;
    private String diagnosticoConsulta;
    private String receitaConsulta;

    public int getCodConsulta() {
        return codConsulta;
    }

    public void setCodConsulta(int codConsulta) {
        this.codConsulta = codConsulta;
    }

    public int getCodAgendamentoConsulta() {
        return codAgendamentoConsulta;
    }

    public void setCodAgendamentoConsulta(int codAgendamentoConsulta) {
        this.codAgendamentoConsulta = codAgendamentoConsulta;
    }

    public String getDiagnosticoConsulta() {
        return diagnosticoConsulta;
    }

    public void setDiagnosticoConsulta(String diagnosticoConsulta) {
        this.diagnosticoConsulta = diagnosticoConsulta;
    }

    public String getReceitaConsulta() {
        return receitaConsulta;
    }

    public void setReceitaConsulta(String receitaConsulta) {
        this.receitaConsulta = receitaConsulta;
    }
    
    
}
