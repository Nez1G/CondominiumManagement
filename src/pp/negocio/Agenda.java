package pp.negocio;


import java.util.*;

/**
 * Classe que cria objectos do tipo agenda
 * @author Fantastic4
 */
public class Agenda {
    private String autor;
    private HashMap<String, ArrayList<EventoData2>> eventos;
    //private ArrayList<EventoData2> listaeventos;
    
    /**
     * metodo construtor por defeito 
     */
    public Agenda(){
        eventos = new HashMap<>();
        //listaeventos = new ArrayList<>();
    }

    /**
     *metodo construtor que recebe um parametro do tipo String chamado autor e inicialização de um HashMap 
     * @param autor
     */
    public Agenda(String autor) {
        this.autor = autor;
        eventos = new HashMap<>();
    }    

    /**
     *
     * @return
     */
    public String getAutor() {
        return autor;
    }

    /**
     *
     * @param autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     *
     * @param evento
     */
    public void addEvento(EventoData2 evento){
        if(eventos.containsKey(evento.getTipo())){
            eventos.get(evento.getTipo()).add(evento);
        }else{
            ArrayList<EventoData2> listaevento = new ArrayList<>();
            listaevento.add(evento);
            eventos.put(evento.getTipo(), listaevento);
        }
        
    }
    
    // para remover o exemplo selecionado ????????????????

    /**
     *
     * @param evento
     */
    public void deleteEvento(EventoData2 evento){
        eventos.remove(evento.getTipo(), evento);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<EventoData2> listadeEventos(){
        ArrayList<EventoData2> eventosManutencao;
        ArrayList<EventoData2> eventosReuniao;
        ArrayList<EventoData2> eventosLimpeza;
        ArrayList<EventoData2> conjuntoeventos;
        
        if(eventos.isEmpty()){
            conjuntoeventos = new ArrayList<>();
        }
        
        else{conjuntoeventos = new ArrayList<>();}
        /*
        else{
        conjuntoeventos = new ArrayList<>();
        eventosLimpeza = new ArrayList<>(eventos.get("Limpeza"));
        eventosReuniao = new ArrayList<>(eventos.get("Reuniao"));
        eventosManutencao = new ArrayList<>(eventos.get("Manutencao"));
        for(int i = 0 ; i < eventosLimpeza.size(); i++){
            conjuntoeventos.add(eventosLimpeza.get(i));
        }
        
        for(int a = 0 ; a < eventosReuniao.size(); a++){
            conjuntoeventos.add(eventosReuniao.get(a));
        }
        
        for(int y = 0 ; y < eventosManutencao.size(); y++){
            conjuntoeventos.add(eventosManutencao.get(y));
        }
        }
        */
        return conjuntoeventos;
    }
   
    /**
     *
     * @param tipoevento
     * @return
     */
    public ArrayList<EventoData2> getEventos(String tipoevento){
        return eventos.get(tipoevento);
    }
    // Retornar todos os eventos ?????????? VOID PORQUE DÁ ERRO ??????????

    /**
     *
     * @return
     */
    public String getAllEventos(){
       return eventos.toString();
    }
    
    /*
    public static void main(String[] args){
        Agenda a1 = new Agenda();
        Limpeza e2 = new Limpeza();
        a1.addEvento(e2);
        ArrayList<EventoData2> teste;
        //teste = new ArrayList<>();
        teste = a1.listadeEventos();
        //System.out.println(a1.listadeEventos().size());
        //System.out.println(teste.size());
        
        System.out.println(teste.size());
    }
    */
}
