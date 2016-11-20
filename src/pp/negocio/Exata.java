package pp.negocio;
/** Classe com objectos do tipo exacta que tem herança da classe Modalidade
 *
 * @author Fantastic4
 */
public class Exata extends Modalidade {

    /**
     * metodo construtor por defeito 
     */
    public Exata(){
        super("Exata");        // NOTA = EXATA É IGUAL PARA TODOS OS CONDOMINOS
    }
    
    /**
     * metodo que calcula o valor da quota de condomínio que é igual para todos os condóminos do condomínio 
     * @param cond
     * @return
     */
    public double calcularExata(Condominio cond){
        
        double despesa = cond.getDespesas();
        int numFracoes = cond.getFracoes().size();
        return (despesa / numFracoes);
    }
    
}
