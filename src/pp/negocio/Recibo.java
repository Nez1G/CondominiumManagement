/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.time.*;

/** Classe que cria objectos do tipo Recibo
 *
 * @author Fantastic4
 */
public class Recibo {
    private double multa;
    private double montante;
    private LocalDate dataemissao;
    private LocalDate datapagamento;
    private LocalDate datalimite;
    private Proprietario cliente;
    private int nif;
    private int nvia;
    private static int nextInvoiceNumber = 1;
    private int ndocumento;
    private boolean pago;
    private int diasparapagar;

    /**
     * metodo construtos por defeito que inicializa as variaveis diasparapagar,
     * nvia, dataemissao, datalimite, pago, multa, ndocumento
     * 
     */
    public Recibo(){
        this.diasparapagar = 25;
        this.nvia = 1;
        this.dataemissao = LocalDate.now();
        this.datalimite = LocalDate.now().plusDays(diasparapagar);
        this.pago = false;
        this.multa = 0;
        ndocumento= nextInvoiceNumber;
        nextInvoiceNumber++;
    }
    
    /**
     * metodo contrutor que recebe parametros e inicializa as variaveis diasparapagar,
     * nvia, dataemissao, datalimite, pago, multa, ndocumento 
     * @param cliente tipo Objeto
     */
    public Recibo(Proprietario cliente){
        this.diasparapagar = 25;
        this.cliente = cliente;
        this.nvia = 1;
        this.dataemissao = LocalDate.now();
        this.datalimite = LocalDate.now().plusDays(diasparapagar);
        this.pago = false;
        this.multa = 0;
        ndocumento = nextInvoiceNumber;
        nextInvoiceNumber++;
    }

    /**
     * metodo que retorna o montante da multa a pagar
     * @return multa
     */
    public double getMulta() {
        return multa;
    }
    
    /**
     * metodo para alterar o montante da multa a pagar
     * @param multa
     */
    public void setMulta(double multa) {
        this.multa = multa;
    }

    /**
     * metodo que retorna o numero do decomento
     * @return int - ndocumento
     */
    public int getNdocumento() {
        return ndocumento;
    }

    /**
     * metodo para alterar o numero do documento
     * @param ndocumento
     */
    
    
    /**
     * metodo que retorna a data limite de pagamento
     * @return datalimite
     */
    public LocalDate getDatalimite() {
        return datalimite;
    }

    /**
     * metodo para alterar o dia da data limite de pagamento
     * @param datalimite
     */
    public void setDatalimite(LocalDate datalimite) {
        this.datalimite = datalimite;
    }

    /**
     * metodo que retorna o numero de dias que tem para o pagamento (da multa)
     * @return diasparapagar
     */
    public int getDiasparapagar() {
        return diasparapagar;
    }

    /**
     * metodo para alterar o numero de dias que tem para o pagamento (da multa)
     * @param diasparapagar
     */
    public void setDiasparapagar(int diasparapagar) {
        this.diasparapagar = diasparapagar;
    }
    
    /**
     * metodo para atualizar o numero da via 
     */
    public void updateNVia(){
        nvia++;
    }

    /**
     * metodo que retorna um booleno, onde verifica se o recibo já foi pago ou não
     * @return
     */
    public boolean isPago() {
        return pago;
    }

    /**
     * metodo que altera o estado do recibo
     * @param pago
     */
    public void setPago(boolean pago) {
        this.pago = pago;
        this.datapagamento = LocalDate.now();
    }
    
    /**
     * metodo que retorna o montante a pagar
     * @return montante
     */
    public double getMontante() {
        return montante;
    }

    /**
     * metodo para alterar o valor do montate
     * @param montante
     */
    public void setMontante(double montante) {
        this.montante = montante;
    }

    /**
     * metodo que retorna a data de emissão do recibo
     * @return
     */
    public LocalDate getDataemissao() {
        return dataemissao;
    }

    /**
     * metodo para alterar a data de emissão do recibo
     * @param dataemissao
     */
    public void setDataemissao(LocalDate dataemissao) {
        this.dataemissao = dataemissao;
    }

    /**
     * metodo que retorna o cliente para o qual o recibo dever ser emitido
     * @return
     */
    public Proprietario getCliente() {
        return cliente;
    }

    /**
     * metodo para alterar o cliente para qual o recibo deve ser emitido 
     * @param cliente
     */
    public void setCliente(Proprietario cliente) {
        this.cliente = cliente;
    }

    /**
     * metodo que retorna o nif do cliente para o qual o recibo foi emitido 
     * @return nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * metodo para alterar o nif do cliente para qual o recibo foi emitido
     * @param nif
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * metodo que retorna o numero da via em que foi emitido o recibo
     * @return nvia
     */
    public int getNvia() {
        return nvia;
    }

    /**
     * metodo para alterar o numero da via em que foi emitido o recibo
     * @param nvia
     */
    public void setNvia(int nvia) {
        this.nvia = nvia;
    }

    /**
     * metodo que retorna o dia de pagamento do recibo 
     * @return
     */
    public LocalDate getDatapagamento() {
        return datapagamento;
    }

    /**
     * metodo para alterar o dia de pagamento do recibo
     * @param datapagamento
     */
    public void setDatapagamento(LocalDate datapagamento) {
        this.datapagamento = datapagamento;
    }
    
    public String toString(){
        return "\n" + "Nº de Documento: " + ndocumento + "\n" + "Data de emissão: " + dataemissao  + "\n" + "Total: " + montante;
    }

}
