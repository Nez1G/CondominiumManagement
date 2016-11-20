/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.negocio;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Utilizador
 */
public class Teste {
    public static void main(String[] args) throws Sistema.ClienteDuplicadoException, Sistema.CondoDuplicadoException{
        
        // Criar a App Condominus;
        Condominus m1 = new Condominus();
        //Sistema k1 = new Sistema();

        //criar eventos
        EventoData2 a1 = new Limpeza();
        EventoData2 a2 = new Reuniao();
        EventoData2 a3 = new Reuniao();
        EventoData2 h1 = new Manutencao();
        // Criar agenda
        Agenda s1 = new Agenda("Fantastic4");
        Agenda s2 = new Agenda("Teste");
        //Adicionar os eventos a uma agenda;
        s1.addEvento(a3);
        s1.addEvento(a2);
        s1.addEvento(a1);
        s1.addEvento(h1);
        // Teste da agenda;
        //System.out.println(s1.getAllEventos());
        // Modificar eventos da agenda;
        a1.setData(LocalDate.of(2016, Month.MAY, 07));
        a2.setData(LocalDate.of(2016, Month.MAY, 10));
        a3.setData(LocalDate.of(25, Month.MAY, 25));
        // Testes sobre a agenda;
        //System.out.println(s1.getAllEventos());
        a1.setStaff("Equipa constituida por Inera, Oscar e Gelinho");
        //System.out.println(s1.getEventos("Limpeza"));
        //System.out.println(a1.getStaff());
        // Criar Modalidade
        Exata e1 = new Exata();
        Equitativa e2 = new Equitativa();
        Permilagem e3 = new Permilagem();
        //e2.setQuota(1200);
        // Criar condominio;
        Condominio c1 = new Condominio(1, e2, 53.5, 3, "Rua 25 de Abril N187", "4710-000", 10);
        Condominio c2 = new Condominio(2, e3, 500, 4, "Rua do Pinheiro N45", "4715-000", 21);
        Condominio c3 = new Condominio(3, e1, 250.5, 3, "Rua da Caranga N21", "4710-000", 10);
        //Fazer set à facturação;
        c1.setTotalFacturado(2500.5);
        c2.setTotalFacturado(3500.5);
        c3.setTotalFacturado(9898.9);
        // Criar proprietario
        Proprietario p1 = new Proprietario("Bruno Ferreira", 145095036, 253675042, "Rua 25 de Abril N187 8000-00", "bruno@teste.com");
        Proprietario p2 = new Proprietario("Pedro Palha", 251977285, 910944167, "Rua do Pinheiro N45 8000-00", "pedro@gmail.com");
        Proprietario p3 = new Proprietario("Fantastic4", 510024360, 91775599, "Rua dos Chãos N180 4710-193", "teste@gmail.com");
        // Colocar p1 como responsável do condominio;
        c1.setResponsavel(p1);
        c2.setResponsavel(p2);
        c3.setResponsavel(p3);

        // Testar a impressao dos elementos do Condominio
        //System.out.println(c1.toString());
        
        // Criar uma fracao com um proprietario associado;
        Fracao f1 = new Fracao(200, "2E", p1, 2);
        Fracao f2 = new Fracao(250, "1E", p2, 2);
        Fracao f3 = new Fracao(350, "1D", p2, 1);
        
        //f1.setValor(2015.36);
        //f1.emitirRecibo();
        
        
        
        
        Recibo n1 = new Recibo(); 
        //n1.setCliente(p3);
        Recibo n2 = new Recibo();  
        //n2.setCliente(p3);
        Recibo n3 = new Recibo();  
        //n3.setCliente(p3);
        Recibo n4 = new Recibo();  
        //n4.setCliente(p3);
        Recibo n5 = new Recibo();  
        //n5.setCliente(p3);
        Recibo n6 = new Recibo();  
        //n6.setCliente(p3);
        Recibo n7 = new Recibo();  
        //n7.setCliente(p3);
        
        f1.listaRecibos().add(n7);
        f1.listaRecibos().add(n6);
        f1.listaRecibos().add(n5);
        f2.listaRecibos().add(n4);
        f2.listaRecibos().add(n3);
        f2.listaRecibos().add(n2);
        f3.listaRecibos().add(n1);
        f3.listaRecibos().add(n7);
        f3.listaRecibos().add(n6);
        
        
        // Testar a impressao dos elementos da fracao;
        //System.out.println(f1.toString());
        // adicionar a Fracao ao Condominio;
        c1.addFracao(f1);
        c2.addFracao(f2);
        c3.addFracao(f3);
        
        
        f1.setValor(250.5);
        //f1.emitirFactura();
        
        f2.setValor(350.5);
        //f2.emitirFactura();
        
        f3.setValor(400.5);
        //f3.emitirFactura();
        
        // Adicionar o condominio à APP;
        m1.addCondominio(c1);
        m1.addCondominio(c2);
        m1.addCondominio(c3);        
        
        //m1.addCondominio(c1);
        // Testar Metodos sobre a APP;
        //System.out.println(m1.toString());
        //System.out.println("Resultado Area da Fracao: " + f2.getArea());
        //System.out.println("Resultado Area do Andar: " + c2.getAreaAndar(f2));
        //System.out.println("Resultado do Calculo: " + c2.getModalidade().calcularPermilagem(c2, f2));
        //Testes sobre os metodos do condominio;
        //c1.getUltimoEvento("Reuniao");
        
        //System.out.println(c1.getMontanteRecibos());
        //System.out.println(m1.orderbyFact());
        //Teste sobre o statCod();
        //System.out.println(m1.statCod());
        /*//Teste sobre os recibos;
        Recibo b1 = new Recibo();
        Recibo b2 = new Recibo();
        b2.setData(LocalDate.of(1995, 2, 8));
        System.out.println(b1.getData());
        System.out.println(b1.getData().isBefore(b2.getData()));
        */
        //System.out.println(f1.getValRecibos());
        //System.out.println(f3.emitirFactura());
        //System.out.println(f3.efectuarPagamento("2016-5"));
        //e3.calcularPermilagem(c2);
        //System.out.println(f1.getValor());
        //System.out.println(k1.listaFacturas());
        
        
        
        
        
        
    }
}
