/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;
import java.util.*;
/**
 *
 * @author Utilizador
 */
public class ComparadorTeste {
    
    
    
    
    public static void main(String[] args){
        Exata e1 = new Exata();
        Equitativa e2 = new Equitativa();
        Permilagem e3 = new Permilagem();
        Condominio c1 = new Condominio(1, e2, 53.5, 3, "Rua 25 de Abril N187", "4710-000", 10);
        Condominio c2 = new Condominio(2, e3, 500, 4, "Rua do Pinheiro N45", "4715-000", 21);
        Condominio c3 = new Condominio(3, e1, 250.5, 3, "Rua da Caranga N21", "4720-000", 10);
        Condominio c4 = new Condominio(4, e1, 250.5, 3, "Rua 1", "4725-000", 10);
        Condominio c5 = new Condominio(5, e1, 250.5, 3, "Rua 2", "4730-000", 10);
        Condominio c6 = new Condominio(6, e1, 250.5, 3, "Rua 3", "4735-000", 10);
        Condominio c7 = new Condominio(7, e1, 250.5, 3, "Rua 21", "4740-000", 10);
        
        c1.setTotalFacturado(500);
        c2.setTotalFacturado(250);
        c3.setTotalFacturado(1000);
        c4.setTotalFacturado(2000);
        c5.setTotalFacturado(1500);
        c6.setTotalFacturado(1200);
        c7.setTotalFacturado(0.0);
        
        
        
        
        
        
        List<Condominio> list = new ArrayList<Condominio>();
        ArrayList<Condominio> listfive = new ArrayList<>();
        
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        
        
        Collections.sort(list, new MySalaryComp());
        System.out.println("Sorted list entries: ");
        for(Condominio e:list){
            if(listfive.size() < 5) {
                listfive.add(e);
            }   
        }        
        for(int i = 0; i < listfive.size(); i++){
                    System.out.println(listfive.get(i).toString());
        }
    }
}
