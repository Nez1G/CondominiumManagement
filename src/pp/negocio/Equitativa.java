
package pp.negocio;

import java.util.*;

/**
 * Classe com objectos do tipo equitativo que contem herança da classe Modalidade
 * @author Fantastic4
 */
public class Equitativa extends Modalidade {
    
    Scanner in = new Scanner(System.in);                                                                                                   
    
    /**
     *construtor por defeito 
     */
    public Equitativa(){                 // NOTA = em funçao da permilagem e do nº de andar em que se localiza a fração
    super("Equitativa");
   }

    /**
     * metodo que calcula o valor da quota de condomínio em função do valor da permilagem da sua fração e do número de andar em que se localiza a fração
     * @param cond 
     */
    public void calcularEquitativa(Condominio cond){
       
        int nAndares = cond.getNumAndares();
        double despesaCond = cond.getDespesas();
        double despesaAndar = 0;
        double valor = 0;
        int percentagem = 0;
        double num = 0;
               
        for(int x = 1; x <= nAndares; x++){
            
                if(percentagem > 100){
                    System.out.println("Já excedeu o limite percentual para o seu condomínio! Tente de novo.");
                    break;
                }
            
                System.out.println("Introduza um valor entre 0 e 100 para definir a parte que o andar "
                + x + " terá que pagar:");
                num = in.nextInt();
                percentagem += num;
                
                if(num > 100 || num < 0){
                    System.out.println("Número inválido! Tente de novo.");
                    break;
                } else {
                    num = (num / 100);
                }
                
                despesaAndar = (num * despesaCond);
                valor = (despesaAndar / cond.getNumFracoesAndar(x));
            
            for(int y = 0; y < cond.getFracoes().size(); y++){
                
                if(cond.getFracoes().get(y).getNumAndar() == x){
                    cond.getFracoes().get(y).setValor(valor);
                }
        }
        
     }
   }
    
    
   
}
