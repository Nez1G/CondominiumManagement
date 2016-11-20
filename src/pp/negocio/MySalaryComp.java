/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.util.*;

/**Classe que cria objectos do tipo MySalaryComp
 * 
 * @author Fantastic4
 */
class MySalaryComp implements Comparator<Condominio>{
 /*
    @Override
    public int compare(Condominio e1, Condominio e2) {
        if(e1.getMontanteRecibos() < e2.getMontanteRecibos()){
            return 1;
        } else {
            return -1;
        }
    }
*/    
    
    @Override
    public int compare(Condominio e1, Condominio e2) {
        if(e1.getTotalFacturado() < e2.getTotalFacturado()){
            return 1;
        } else {
            return -1;
        }
    }
    
    
    
    
}
