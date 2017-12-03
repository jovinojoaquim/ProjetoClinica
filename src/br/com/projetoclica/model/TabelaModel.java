/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoclica.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Jovino
 */
public class TabelaModel extends AbstractTableModel{
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    public TabelaModel(ArrayList linhas, String[] colunas){
        setLinhas(linhas);
        setColunas(colunas);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] linha = (Object[]) getLinhas().get(rowIndex);
        return linha[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    
    
    
}
