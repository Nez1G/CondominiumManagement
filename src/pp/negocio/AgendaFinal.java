
package pp.negocio;
import java.util.*;
/**
 *Classe que cria objectos do tipo Agenda 
 * @author Fantastic4
 */
public class AgendaFinal {
    
    private ArrayList<EventoData2> listaLimpeza;
    private ArrayList<EventoData2> listaManutencao;
    private ArrayList<EventoData2> listaReuniao;
    private ArrayList<EventoData2> listaEventos;

    /**
     * metodo construtor por defeito
     */
    public AgendaFinal(){
        listaEventos = new ArrayList<>();
        listaReuniao = new ArrayList<>();
        listaManutencao = new ArrayList<>();
        listaLimpeza = new ArrayList<>();
    }
    

    /**
     *
     * @return
     */

    
    public ArrayList<EventoData2> getListaLimpeza() {
        return listaLimpeza;
    }

    /**
     *
     * @param listaLimpeza
     */
    public void setListaLimpeza(ArrayList<EventoData2> listaLimpeza) {
        this.listaLimpeza = listaLimpeza;
    }
    
    public void addEvento(EventoData2 evento){
        listaEventos.add(evento);
    }

    public ArrayList<EventoData2> listadeEventos() {
        return listaEventos;
    }

    public void setListaEventos(ArrayList<EventoData2> listaEventos) {
        this.listaEventos = listaEventos;
    }
    
    

    /**
     *
     * @return
     */
    public ArrayList<EventoData2> getListaManutencao() {
        return listaManutencao;
    }

    /**
     *
     * @param listaManutencao
     */
    public void setListaManutencao(ArrayList<EventoData2> listaManutencao) {
        this.listaManutencao = listaManutencao;
    }

    /**
     *
     * @return
     */
    public ArrayList<EventoData2> getListaReuniao() {
        return listaReuniao;
    }

    /**
     *
     * @param listaReuniao
     */
    public void setListaReuniao(ArrayList<EventoData2> listaReuniao) {
        this.listaReuniao = listaReuniao;
    }
    
    /**
     * metodo para adiciona ao ArrayList o tipo de evento 
     * @param evento
     */
    public void adicionarEvento(EventoData2 evento){
        if(evento.getTipo().equals("Limpeza")){
            listaLimpeza.add(evento);
        }
        if(evento.getTipo().equals("Reuniao")){
            listaReuniao.add(evento);
        }
        if(evento.getTipo().equals("Manutencao")){
            listaManutencao.add(evento);
        }
    }
    
    /**
     * metodo para remover do ArrayList um tipo de evento 
     * @param evento
     */
    public void removerEvento(EventoData2 evento){
        if(evento.getTipo().equals("Limpeza")){
            listaLimpeza.remove(evento);
        }
        if(evento.getTipo().equals("Reuniao")){
            listaReuniao.remove(evento);
        }
        if(evento.getTipo().equals("Manutencao")){
            listaManutencao.remove(evento);
        }
    }
    
    public void removerEvento(int index){
        listaEventos.remove(index);
    }
    
    /**
     *
     * @return
     */
    /*
    public ArrayList<EventoData2> listadeEventos(){
        ArrayList listaEventos = new ArrayList<>();
        if(!listaLimpeza.isEmpty()){
        for(int i = 0 ; i < listaLimpeza.size(); i++){
            listaEventos.add(listaLimpeza.get(i));
        }
        }
        if(!listaReuniao.isEmpty()){
        for(int a = 0 ; a < listaReuniao.size(); a++){
            listaEventos.add(listaReuniao.get(a));
        }
        }
        
        if(!listaManutencao.isEmpty()){
        for(int y = 0 ; y < listaManutencao.size(); y++){
            listaEventos.add(listaManutencao.get(y));
        }
        }
        
     return listaEventos;
    }
    */
    /*
     public static void main(String[] args){
        AgendaFinal a1 = new AgendaFinal();
        Limpeza e2 = new Limpeza();
        Reuniao r1 = new Reuniao();
        Manutencao w1 = new Manutencao();
        a1.adicionarEvento(e2);
        //a1.adicionarEvento(r1);
        //a1.adicionarEvento(w1);
        ArrayList<EventoData2> teste;
        //teste = new ArrayList<>();
        teste = a1.listadeEventos();
        //System.out.println(a1.listadeEventos().size());
        //System.out.println(teste.size());
        System.out.println("Manutencao: " + a1.getListaManutencao().size());
        System.out.println("Limpeza: " + a1.getListaLimpeza().size());
        System.out.println("Reuniao: " + a1.getListaReuniao().size());
        System.out.println("total: " + a1.listadeEventos().size());
    }
    */



}
