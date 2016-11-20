/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;
/**Classe que cria objecto do tipo Orcamento
 * 
 * @author Fantastic4
 */
public class Orcamento {
    
    private Modalidade tipoModalidade;
    private int numPropriedades;
    private Fracao tipo;
    private int despesaAgua;
    private int depesaLuz;
    private int despesaGas;
    private int despesaConservacao;
    private int estimativaDespesa;

// construtor sem parametros 
    public Orcamento() { }
// construtor com parametros
    public Orcamento(Modalidade tipoModalidade, int numPropriedades, Fracao tipo, int estimativaDespesa) {
        this.tipoModalidade = tipoModalidade;
        this.numPropriedades = numPropriedades;
        this.tipo = tipo;
        this.estimativaDespesa = estimativaDespesa;
    }

// Modificadores e Seletores 

    public Modalidade getTipoModalidade() {
        return tipoModalidade;
    }

    public void setTipoModalidade(Modalidade tipoModalidade) {
        this.tipoModalidade = tipoModalidade;
    }

    public int getNumPropriedades() {
        return numPropriedades;
    }

    public void setNumPropriedades(int numPropriedades) {
        this.numPropriedades = numPropriedades;
    }

    public Fracao getTipo() {
        return tipo;
    }

    public void setTipo(Fracao tipo) {
        this.tipo = tipo;
    }

    public int getEstimativaDespesa() {
        return estimativaDespesa;
    }

    public void setEstimativaDespesa(int estimativaDespesa) {
        this.estimativaDespesa = estimativaDespesa;
    }

    public int getDespesaAgua() {
        return despesaAgua;
    }

    public void setDespesaAgua(int despesaAgua) {
        this.despesaAgua = despesaAgua;
    }

    public int getDepesaLuz() {
        return depesaLuz;
    }

    public void setDepesaLuz(int depesaLuz) {
        this.depesaLuz = depesaLuz;
    }

    public int getDespesaGas() {
        return despesaGas;
    }

    public void setDespesaGas(int despesaGas) {
        this.despesaGas = despesaGas;
    }

    public int getDespesaConservacao() {
        return despesaConservacao;
    }

    public void setDespesaConservacao(int despesaConservacao) {
        this.despesaConservacao = despesaConservacao;
    }
    
    
    
    



}
