package pp.negocio;
/** Classe com objctos do tipo manual que tem herança da classe Modalidade
 *
 * @author Fantastic4
 */
public class Manual extends Modalidade {
    private double preco;
    
    /**
     * construtor por defeito 
     */
    public Manual(){
        super("Manual");
    }
    
    /**
     * metodo construtor que recebe um parametro do tipo double chamado montante 
     * @param montante
     */
    public Manual(double montante){                       //NOTA = montante atribuido por parte do diretor
        super("Manual");
        this.preco = montante;
    }

    /**
     * metodo para atribuir/modificar o valor da variavel valor na class fracao 
     * @param ref
     */
    public void atribuirValorManual(Fracao ref){
       ref.setValor(preco);
    }

    /**
     * metodo para retorno do preco 
     * @return preco do tipo double
     */
    public double getPreco() {
        return preco;
    }

    /**
     * metodo para alterar o preco
     * @param preco
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
  
    
}
