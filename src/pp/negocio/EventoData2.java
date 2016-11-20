/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.time.*;
import java.time.Month;
import java.util.Date;

/**
 * Classe com objectos do tipo EventoData2
 * @author Utilizador
 */
public class EventoData2 {
    private String tipo;
    private LocalDate data;
    private String notas;
    private String staff;
    
    /**
     * metodo construtor por defeito 
     */
    public EventoData2(){}
    
    /**
     * metodo construtor que recebe um parametro:
     * @param tipo do tipo String
     */
    public EventoData2(String tipo) {
        this.tipo = tipo;
    }
     
    /**
     * metodo construtor que recebe parametros:
     * @param tipo do tipo String
     * @param data do tipo LocalDate (TIPO OBJETO)
     */
    public EventoData2(String tipo, LocalDate data) {
        this.tipo = tipo;
        this.data = data;
    }
    
    /**
     * metodo construtor que recebe parametros
     * @param tipo do tipo String
     * @param data do tipo LocalDate (Tipo Objeto~)
     * @param notas do tipo String
     */
    public EventoData2(String tipo, LocalDate data, String notas) {
        this.tipo = tipo;
        this.data = data;
        this.notas = notas;
    }
    
    /**
     * metodo construtor que recebe parametros: 
     * @param tipo do tipo String
     * @param data do tipo LocalDate (Tipo Objeto)
     * @param notas do tipo String
     * @param staff do tipo String
     */
    public EventoData2(String tipo, LocalDate data, String notas, String staff) {
        this.tipo = tipo;
        this.data = data;
        this.notas = notas;
        this.staff = staff;
    }
    
    /**
     * metodo que retorna o tipo de evento
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo para alterar o tipo de evento
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * metodo que retorna a data do evento
     * @return
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * metodo para alterar a data do evento
     * @param data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * metodo que retorna a descrição de um evento 
     * @return
     */
    public String getNotas() {
        return notas;
    }

    /**
     * metodo para alterar a descrição de um evento
     * @param notas
     */
    public void setNotas(String notas) {
        this.notas = notas;
    }

    /**
     * metodo que retorna o Staff utilizado em cada evento
     * @return
     */
    public String getStaff() {
        return staff;
    }

    /**
     * metodo para alterar o Staff utilizado em cada evento
     * @param staff
     */
    public void setStaff(String staff) {
        this.staff = staff;
    }
    
    @Override
    public String toString(){
        return "\n" + "Evento: " + tipo + "\n" + "Data: " + data + "\n" + "Responsável: " + staff + "\n" + "Notas: " + notas;
    }
    
    /*
    public static void main(String[] args){
        EventoData2 a1 = new EventoData2("Limpeza", LocalDate.of(2014, Month.FEBRUARY, 25));
        //a1.setData(LocalDate.of(2004, Month.JANUARY, 17));
        LocalDate dt = LocalDate.of(2014, Month.FEBRUARY, 25);
        LocalDate teste = LocalDate.of(2014, 2, 25);
        LocalDate dr = LocalDate.now();
        EventoData2 a2 = new EventoData2("Limpeza", LocalDate.of(2014, 05, 25));
        EventoData2 f5 = new Limpeza();
        //f5.setData(LocalDate.of(2016, 06, 11));
        //System.out.println(dt);
        //System.out.println(dr);
        //System.out.println(a1);
        //System.out.println(a2);
        
        int iniAno = Integer.parseInt("2015");
        int iniMes = Integer.parseInt("5");
        int iniDia = Integer.parseInt("20");
        int fimAno = Integer.parseInt("2016");
        int fimMes = Integer.parseInt("9");
        int fimDia = Integer.parseInt("27");
        
        LocalDate dataInicio = LocalDate.of(iniAno, iniMes, iniDia);
        LocalDate dataFim = LocalDate.of(fimAno, fimMes, fimDia);
        
        
        Date data = new Date();
        Date ref = new Date();
        f5.setData(data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        System.out.println(dataInicio);
        System.out.println(dataFim);
        //System.out.println(f5);
    }
*/

}