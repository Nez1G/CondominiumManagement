/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

/** Classe que cria Objetos do tipo CodigoPostal
 *
 * @author Fantastic4
 */
// IDEIA PARA IMPLEMENTAR NO FUNCIONAMENTO DO CODIGO POSTAL PARA COMPARAR APENAS
// OS PRIMEIROS 4 DIGITOS NA ZONA EM QUE HÁ MAIS CONDOMINIOS 

public class CodigoPostal {
    private int codpart1;
    private int codpart2;
    private String codpostal;
    
    /**
     * metodo construtor por defeito 
     */
    public CodigoPostal(){}
    
    /**
     * metodo contrutor com parametros do tipo inteiro chamados codpart1 e codpart2
     * @param codpart1 tipo int
     * @param codpart2 tipo int
     */
    public CodigoPostal(int codpart1, int codpart2){
        this.codpart1 = codpart1;
        this.codpart2 = codpart2;
        this.codpostal = codpart1+"-"+codpart2;
    }
    
    @Override
    public String toString(){
        return "\n" + codpostal;
    }
    /*
    public static void main(String[] args){
        
        CodigoPostal a1 = new CodigoPostal(4710, 575);
        
        System.out.println(a1.toString());
    }
    */
    
}
