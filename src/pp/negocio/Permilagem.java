package pp.negocio;
/**Classe que cria objctos do tipo permilagem que tem herança da classe Modalidade
 * 
 * @author Fantastic4
 */
public class Permilagem extends Modalidade {

    /**
     * metodo construtor por defeito 
     */
    public Permilagem(){                                        
        super("Permilagem"); 
    }

    /**
     * metodo que calcula o valor de quota de condomínio a pagar por cada condómino em função do valor da permilagem da sua fração
     * @param cond
     */
    public void calcularPermilagem(Condominio cond){
        
        double despesas = cond.getDespesas();
        double areaCond = 0;
        
        for(int i = 0; i < cond.getFracoes().size(); i++){
            
            areaCond += cond.getFracoes().get(i).getArea();
            
            }
        
        double fator = (despesas / areaCond);

        for(int i = 0; i < cond.getFracoes().size(); i++){
            
            int areaFracao = cond.getFracoes().get(i).getArea();
            double resultado = (areaFracao * fator);
            cond.getFracoes().get(i).setValor(resultado);
        }
        
    }

   
    @Override
    public String getTipo() {
        return super.getTipo(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
       