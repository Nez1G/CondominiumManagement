
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.util.*;
import java.time.*;

/**
 *
 * @author Fantastic4
 */
public class Condominus{
    private ArrayList<Condominio> listacondominios;
    private ArrayList<Proprietario> listaProp;

    /**
     *
     * @return
     */
    public ArrayList<Condominio> getListacondominios() {
        return listacondominios;
    }

    /**
     *
     * @param listacondominios
     */
    public void setListacondominios(ArrayList<Condominio> listacondominios) {
        this.listacondominios = listacondominios;
    }
    
    /**
     *
     */
    public Condominus(){
        listacondominios = new ArrayList<>();
        listaProp = new ArrayList<>();
    }
    
    /*adiciona um condominio a arraylist e em caso de esse condominio ja pertencer a
    essa arraylist o utilizador é notificado*/

    /**
     *
     * @param ref
     */

    public void addCondominio(Condominio ref){
        
        if(listacondominios.contains(ref)){
            //System.out.println("O condomínio já foi anteriormente adicionado");
            return;
            } else {
                listacondominios.add(ref);
            }
    }
    
    /**
     *
     * @param ref
     */
    public void delCondominio(Condominio ref){
        
        listacondominios.remove(ref);
        }
        
    @Override
    public String toString(){
        String print = "";
        for(int i = 0; i < listacondominios.size(); i++){
          print += "\n" +  listacondominios.get(i).toString();
           
        }
        return print;
    }

    /**
     *
     * @return
     */
    public ArrayList<Proprietario> getListaProp() {
        return listaProp;
    }

    /**
     *
     * @param listaProp
     */
    public void setListaProp(ArrayList<Proprietario> listaProp) {
        this.listaProp = listaProp;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Condominio> orderbyFact(){
        TreeMap<String, Condominio> topfive = new TreeMap<>();
        Comparator<Condominio> byFacturacao = (e1, e2) -> Double.compare(e1.getMontanteRecibos(),
                e2.getMontanteRecibos());
        listacondominios
                        .stream()
                        .sorted(byFacturacao)
                        .forEach(e -> topfive.put(String.valueOf(e.getMontanteRecibos()), e));
        return new ArrayList<>(topfive.descendingMap().values());
    }

    /**
     *
     * @return
     */
    public String statCod(){
        String codpostal = "";
        ArrayList<String> listacod;
        listacod = new ArrayList<>();
        for(int i = 0; i < listacondominios.size(); i++ ){
            listacod.add(listacondominios.get(i).getCodPostal());
        }
        
        Map<String, Integer> contaStrings = new HashMap<>();
        for(String str: listacod){
            Integer conta = contaStrings.get(str);
            if(conta == null) conta = new Integer(0);
                conta++;
                contaStrings.put(str,conta);
        }
        Map.Entry<String,Integer> maisUsada = null;
        for(Map.Entry<String, Integer> e: contaStrings.entrySet()){
            if(maisUsada == null || maisUsada.getValue()<e.getValue())
            maisUsada = e;
        }


        if(maisUsada != null)
        codpostal = maisUsada.getKey();
        
        return codpostal;
    }
    
    /**
     *
     * @param dataInicio
     * @param dataFim
     * @return
     */
    public double statFacturado(LocalDate dataInicio, LocalDate dataFim){
        double montanteapurado = 0;
        for(int i = 0; i < listacondominios.size(); i++){
              ArrayList<Fracao> condo = listacondominios.get(i).getFracoes();
            for(int a = 0; a < condo.size(); a++){
                ArrayList<Recibo> recibos = condo.get(a).listaRecibos();
                for(int e = 0; e < recibos.size(); e++){
                    LocalDate data = recibos.get(e).getDataemissao();
                    if(data.isAfter(dataInicio) && data.isBefore(dataFim )){
                        montanteapurado += recibos.get(e).getMontante();
                    }
                }
            }
        }
        return montanteapurado;
    }
    
    /**
     *
     */
    public void emitirFacturacaoMensal(){
        for(int i = 0; i < listacondominios.size(); i++){
            ArrayList<Fracao> condo = listacondominios.get(i).getFracoes();
            for(int a = 0; a < condo.size(); a++){
                condo.get(a).emitirFactura();
                
            }
        }
    }
    
  
   /* 
   public static Comparator<Condominio> CompararFacturacao 
                          = new Comparator<Condominio>() {

            @Override
	    public int compare(Condominio condo1, Condominio condo2) {
	    	
                int fact1;
                    fact1 = (int) condo1.getMontanteRecibos();
                int fact2;
                    fact2 = (int) condo2.getMontanteRecibos();
	      
	      //ascending order
	      //return fact1.compareTo(fact2);
	      
	      //descending order
	      return fact2.compareTo(fact1);
	    }

	};
   */

    /**
     *
     */

    
    public void sortir(){
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        for(int i = 0; i < listacondominios.size(); i++){
           Integer valor = (int)listacondominios.get(i).getMontanteRecibos(); 
           
    }
    
}
   
}

