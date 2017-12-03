/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.model;

import java.util.Date;

/**
 *
 * @author Jovino
 */
public class AgendaModel {
    private int codAgendamento;
    private PacienteModel codPacienteAgendamento;
    private String turno;
    private MedicoModel codMedicoAgendamento;
    private Date dataAgendamento;
    private String motivoAgendamento;

    public int getCodAgendamento() {
        return codAgendamento;
    }

    public void setCodAgendamento(int codAgendamento) {
        this.codAgendamento = codAgendamento;
    }

    public PacienteModel getCodPacienteAgendamento() {
        return codPacienteAgendamento;
    }

    public void setCodPacienteAgendamento(PacienteModel codPacienteAgendamento) {
        this.codPacienteAgendamento = codPacienteAgendamento;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public MedicoModel getCodMedicoAgendamento() {
        return codMedicoAgendamento;
    }

    public void setCodMedicoAgendamento(MedicoModel codMedicoAgendamento) {
        this.codMedicoAgendamento = codMedicoAgendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getMotivoAgendamento() {
        return motivoAgendamento;
    }

    public void setMotivoAgendamento(String motivoAgendamento) {
        this.motivoAgendamento = motivoAgendamento;
    }
    
    
}
