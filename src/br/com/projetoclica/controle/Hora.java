package br.com.projetoclica.controle;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jovino
 */
public class Hora {
    private String hora;
    SimpleDateFormat horaFormatada = new SimpleDateFormat("HH:mm");
    
    public void lerHora(){
        Date horaAtual = new Date();
        hora = horaFormatada.format(horaAtual);
    }

    public String getHora() {
        return hora;
    }
    
    
}
