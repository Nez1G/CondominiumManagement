/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;
import java.time.LocalDate;
/** Classe que retorna Objetos do tipo Manutenção
 *
 * @author Fantastic4
 */
public class Manutencao extends EventoData2 {
    private LocalDate dataref;

    /**
     * metodo construtor por defeito
     */
    public Manutencao(){
        super("Manutencao");
    }
    /*
    public Manutencao(int day, Month mes, int year){
        super("Manutencao");
        dataref.of();
    }
    */    

    /**
     * metodo para retorno da data da manutenção
     * @return 
     * 
     */
    
    public LocalDate getDataref() {
        return dataref;
    }

    /**
     * metodo para alterar a data da manutenção 
     * @param dataref
     */
    public void setDataref(LocalDate dataref) {
        this.dataref = dataref;
    }

    




}
