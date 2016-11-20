/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.time.LocalDate;
import java.util.*;
/** Classe que cria Objetos do tipo Condominio
 *
 * @author Fantastic4
 */
public class Condominio {
    
    private HashMap<String, Fracao> fracoes;  
    private Modalidade modalidade;
    private double despesas;
    private int numAndares;
    private String morada;
    private String codPostal;
    private AgendaFinal agenda;
    private Proprietario resp;
    private double totalFacturado; // a cada pagamento, invocar um método para incrementar o total factura de cada condominio ???????????
    private int diaPagamento;
    private int nCondominio;
    
    /**
     * construtos por defeito 
     * onde inicializa o HashMap fracoes e 
     */
    public Condominio() {  
        agenda = new AgendaFinal();
        fracoes = new HashMap<>();
    }

    /**
     * metodo construtor com que recebe os parametros:
     * @param nCondominio tipo int
     * @param modalidade tipo Objeto
     * @param despesas tipo double
     * @param numAndares tipo int
     * @param morada tipo String
     * @param codPostal tipo String
     * @param diaPagamento tipo int
     */
    public Condominio(int nCondominio ,Modalidade modalidade, double despesas, int numAndares,String morada, String codPostal, int diaPagamento){
        AgendaFinal agenda = new AgendaFinal();
        this.nCondominio = nCondominio;
        fracoes = new HashMap<>();
        this.modalidade = modalidade;
        this.despesas = despesas;
        this.numAndares = numAndares;
        this.morada = morada;
        this.codPostal = codPostal;
        this.agenda = agenda;
        this.totalFacturado = 0;
        this.diaPagamento = diaPagamento;
        //listapagamentos = new ArrayList<>();
    }
    
    /**
     * Metodo para adicionar uma fracao ao HasMap que contem as fracoes
     * @param ref
     */
    public void addFracao(Fracao ref){
        
        if(fracoes.containsKey(String.valueOf(ref.getNumPorta()))){
            //System.out.println("A fração já foi anteriormente adicionada ao condomínio!");
            return;
        } else {
        fracoes.put(String.valueOf(ref.getNumPorta()), ref);
        }
    }
    
    public void delFracao(String refgetNumPorta){
        if(!fracoes.containsKey(refgetNumPorta)){
            return;
        }else{
            fracoes.remove(refgetNumPorta);
        }
    }

    /**
     * retorna um ArrayList de fracoes 
     * @return
     */
    public ArrayList<Fracao> getFracoes() {
        ArrayList<Fracao> listaFracoes = new ArrayList<>(fracoes.values());
        
        return listaFracoes; 
    }
    
    /**
     * retorna um HashMap com uma chave do tipo String e um valor que é um objecto do tipo fracao 
     * @return
     */
    public HashMap<String, Fracao> getListaFracoes(){
        return fracoes;
    }

    /**
     * retorna variavel do tipo inteiro - numero de condominio  
     * @return
     */
    public int getnCondominio() {
        return nCondominio;
    }

    /**
     * metodo para alterar o numero de condominio 
     * @param nCondominio
     */
    public void setnCondominio(int nCondominio) {
        this.nCondominio = nCondominio;
    }

    /**
     * retorna variavel do tipo  Proprietario - responsavel 
     * @return
     */
    public Proprietario getResp() {
        return resp;
    }

    /**
     * metodo para alterar o proprietario 
     * @param resp
     */
    public void setResp(Proprietario resp) {
        this.resp = resp;
    }

    /**
     * retorna variavel do tipo interio - dia de pagamento 
     * @return
     */
    public int getDiaPagamento() {
        return diaPagamento;
    }

    /**
     * metodo para alterar dia de pagamento 
     * @param diaPagamento
     */
    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

  

    /**
     * retorna uma variavel do tipo double - total facturado 
     * @return
     */
    public double getTotalFacturado() {
        return totalFacturado;
    }

    /**
     * metodo para alterar o total facturado 
     * @param totalFacturado
     */
    public void setTotalFacturado(double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }
    
    /**
     * metodo para alterar o responsavel 
     * @param responsavel
     */
    public void setResponsavel(Proprietario responsavel) {
        this.resp = responsavel;
    }

    /**
     * retorna variavel do tipo String - morada 
     * @return
     */
    public String getMorada() {
        return morada;
    }

    /**
     * metodo para alterar a morada 
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    /**
     * retorna uma variavel do tipo Modalidade - modalidade
     * @return
     */
    public Modalidade getModalidade() {
        return modalidade;
    }

    /**
     * metodo para alterar o tipo de modalidade 
     * @param modalidade
     */
    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    /**
     * retorna uma variavel do tipo double - despesa 
     * @return
     */
    public double getDespesas() {
        return despesas;
    }

    /**
     * metodo para alterar a despesa 
     * @param despesas
     */
    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    /**
     * retorna uma variavel do tipo inteiro - numero do andar 
     * @return
     */
    public int getNumAndares() {
        return numAndares;
    }

    /**
     * metodo para alterar o numero do andar 
     * @param numAndares
     */
    public void setNumAndares(int numAndares) {
        this.numAndares = numAndares;
    }

    /**
     * retorna variavel do tipo String - codigo postal 
     * @return
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * metodo para alterar o codigo postal 
     * @param codPostal
     */
    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }
    
    /**
     * metodo que me retorna a area correspondente a fracao 
     * @param ref
     * @return
     */
    public int getAreaFracao(Fracao ref){
        return ref.getArea();
    }
    
    /**
     * retorna o tamanho da fracao 
     * @return
     */
    public int getNumFracoes(){
        return fracoes.size();
    }

    /**
     *  retorna a agenda actual 
     * @return
     */
    public AgendaFinal getAgenda() {
        return agenda;
    }

    /**
     * metodo que vai buscar uma agenda ja existente para ser "actual" 
     * @param agenda
     */
    public void setAgenda(AgendaFinal agenda) {
        this.agenda = agenda;
    }
    
    /**
     * metodo que retorna a soma das fracoes dos andares todos  
     * @return
     */
    public int getAreaTotal(){
        int area = 0;
        ArrayList<Fracao> fracoeslista = new ArrayList<>(fracoes.values());
       for(int i = 0; i < fracoeslista.size(); i++){
                    area += fracoeslista.get(i).getArea();
            }
       
       return area;
    }
    
    /**
     * metodo que retorna a soma das fracoes por andar  
     * @param nAndar
     * @return
     */
    public int getAreaAndar(Fracao nAndar){
        int area = 0;
        int andarFracao = nAndar.getNumAndar();
        ArrayList<Fracao> fracoeslista = new ArrayList<>(fracoes.values());
        for(int i = 0; i < fracoeslista.size(); i++){
            if(fracoeslista.get(i).getNumAndar() == andarFracao){
                area += fracoeslista.get(i).getArea();
            }
        }
        
        return area;
    }
    
    /**
     * acrescenta um valor a facturação total de um condominio 
     * @param montante
     */
    public void updateFacturado(double montante){
        this.totalFacturado += montante;
    }
    
    /**
     * metodo que retorna o numero de fracoes por andar 
     * @param nAndar
     * @return
     */
    public int getNumFracoesAndar(int nAndar){
        int numFracoes = 0;
        ArrayList<Fracao> fracoeslista = new ArrayList<>(fracoes.values());
        for(int i = 0; i < fracoeslista.size(); i++){
            if(fracoeslista.get(i).getNumAndar() == nAndar){
                numFracoes += 1;
            }
        }
        
        return numFracoes;
    }

    /**
     * metodo que retorna o montante de recibos do condominio 
     * @return
     */
    public double getMontanteRecibos(){
        double montanteap = 0;
        for(int i = 0; i < getFracoes().size(); i++){
            Fracao fracao = getFracoes().get(i);
            montanteap += fracao.getValRecibos();
        }
        return montanteap;
    }
    
    
    
    
    
    @Override
    public String toString(){
        return "\n"+ "Responsavel: " + resp.toString() + "\n" + "Morada: " + codPostal + "\n" + "Modalidade: " + modalidade.getTipo() ;
    }
}
    
    

