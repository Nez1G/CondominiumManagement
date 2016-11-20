package pp.negocio;

import java.util.*;
/** Classe para criar Objetos do tipo Modalidade, onde serão contidos 
 * valores e metedos para o mesmo
 *
 * @author Fantastic4
 */
public class Modalidade {
    // variaveis de instancia 
    private String tipo;
    Scanner in = new Scanner(System.in);  
    
    /**
     * Construtor por defeito
     */
    public Modalidade(){ }
    
    /** 
     *
     * @param tipo
     */
    public Modalidade(String tipo){
        this.tipo = tipo;
    }

//Modificadores e Seletores

    /** Metodo para o retorno do tipo de Modalidade
     *
     * @return String - tipo de modalidade
     */
    public String getTipo() {
        return tipo;
    }

    /** Metodo para alterar o tipo de modalidade
     *
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     *
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
    
    /**
     *
     * @param cond
     * @return
     */
    public double calcularExata(Condominio cond){
        
        double despesa = cond.getDespesas();
        int numFracoes = cond.getFracoes().size();
        return (despesa / numFracoes);
    }
    
    /**
     *
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
