/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
/**
 * Classe que cria objectos do tipo Fracao 
 * @author André
 */
public class Fracao {
    
    private int area;
    private String numPorta;
    private Proprietario proprietario; 
    private int numAndar;
    private HashMap<String,Recibo> listapagamentosfrac;
    protected double valor;
    private double multa;
    
    /**
     * criação de um HashMap 
     */
    public Fracao() { 
        listapagamentosfrac = new HashMap<>();
        
    }

    /**
     *
     * @param area
     * @param numPorta
     * @param proprietario
     * @param numAndar
     */
    public Fracao(int area, String numPorta, Proprietario proprietario, int numAndar) {
        this.area = area;
        this.numPorta = numPorta;
        this.proprietario = proprietario;
        this.numAndar = numAndar;
        listapagamentosfrac = new HashMap<>();
    }

    /**
     *
     * @param area
     * @param numPorta
     * @param numAndar
     */
    public Fracao(int area, String numPorta, int numAndar) {
        this.area = area;
        this.numPorta = numPorta;
        this.numAndar = numAndar;
        listapagamentosfrac = new HashMap<>();
    }

    /**
     * retorna um HashMap com uma chave do tipo String e um valor que é um objecto do tipo recibo
     * @return
     */
    public HashMap<String, Recibo> getListapagamentosfrac() {
        return listapagamentosfrac;
    }

    /**
     * metodo para alterar a lista de pagamentos das fracoes 
     * @param listapagamentosfrac
     */
    public void setListapagamentosfrac(HashMap<String, Recibo> listapagamentosfrac) {
        this.listapagamentosfrac = listapagamentosfrac;
    }

    /**
     * retorna uma variavel do tipo inteiro -area 
     * @return
     */
    public int getArea() {
        return area;
    }

    /**
     * metodo para alterar a area 
     * @param area
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * retorna uma variavel do tipo String - numero da porta 
     * @return
     */
    public String getNumPorta() {
        return numPorta;
    }

    /**
     * metodo para alterar  o numero da porta 
     * @param numPorta
     */
    public void setNumPorta(String numPorta) {
        this.numPorta = numPorta;
    }

    /**
     * retorna uma variavel do tipo double - multa 
     * @return
     */
    public double getMulta() {
        return multa;
    }

    /**
     * metodo para alterar a multa 
     * @param multa
     */
    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    /**
     * retorna uma variavel do tipo double - valor 
     * @return
     */
    public double getValor() {
        return valor;
    }

    /**
     * metodo para alterar o valor 
     * @param valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * retorna uma variavel do tipo Proprietario - proprietario 
     * @return
     */
    public Proprietario getProprietario() {
        return proprietario;
    }

    /**
     * metodo para alterar o proprietario 
     * @param proprietario
     */
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    
    /**
     * retorna uma variavel do tipo inteiro - numero do andar 
     * @return
     */
    public int getNumAndar() {
        return numAndar;
    }

    /**
     * metodo para alterar o numero do andar 
     * @param numAndar
     */
    public void setNumAndar(int numAndar) {
        this.numAndar = numAndar;
    }
    
    /**
     * metodo para emitir uma factura de uma fracao 
     * @return
     */
    public Recibo emitirFactura(){
        Recibo ref = new Recibo();
        ref.setCliente(proprietario);
        ref.setMontante(valor);
        String dataemissao = String.valueOf(ref.getNdocumento()) ;
        listapagamentosfrac.put(dataemissao, ref);
        //listaFacturas.add(ref);
        //ref.updateNVia();
        //return "\n"+ "--Factura--" + "\n" + proprietario.toString() + "\n" + "Nº-Via: " + ref.getNvia() + "\n" + "Montante: " + valor ;
        return ref;
    }
    
    /**
     * metodo para efectuar o pagamento de um fracao dado o ano e o mes do recibo que se pretende pagar 
     * @param dataemissao
     */
    public void efectuarPagamento(String dataemissao){
        if(!listapagamentosfrac.get(dataemissao).getDataemissao().isBefore(listapagamentosfrac.get(dataemissao).getDatalimite())){
         listapagamentosfrac.get(dataemissao).setMulta(multa);
        listapagamentosfrac.get(dataemissao).setMontante( listapagamentosfrac.get(dataemissao).getMontante() + 
                multa);}
        else{listapagamentosfrac.get(dataemissao).setPago(true);
              listapagamentosfrac.get(dataemissao).setDatapagamento(LocalDate.now());}
         //return "\n"+ "--Recibo--" + "\n" + proprietario.toString() + listapagamentosfrac.get(dataemissao);
         
    }
    
    /**
     * metodo para calcular o montante facturado ate ao momento numa determinada fracao 
     * @return
     */
    public double getValRecibos(){
        double valrecibos = 0;
        for(int i = 0; i < listaRecibos().size(); i++){
            valrecibos += listaRecibos().get(i).getMontante();
        }
        return valrecibos;
    }
    
    /**
     * retorna uma lista que é constituida por um ArrayList de recibos 
     * @return
     */
    public ArrayList<Recibo> listaRecibos(){
        ArrayList<Recibo> listaRecibos = new ArrayList<>(listapagamentosfrac.values());
        
        return listaRecibos;  
    }
    
    
    @Override
    public String toString(){
        return "\n"+ "Proprietario: " + proprietario.toString() +  "\n" + "Numero de Porta: " + numPorta + "\n" + "Numero de Andar: " + numAndar;
    }   
}


