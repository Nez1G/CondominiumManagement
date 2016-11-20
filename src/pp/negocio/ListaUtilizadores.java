package pp.negocio;

import java.util.TreeMap;
/**
 * Classe que cria objectos do tipo ListaUtilizador
 * @author Fantastic4
 */
public class ListaUtilizadores {
  
    private TreeMap<String, Utilizador> lista;

    /**
     * Classe que lança uma exepção do tipo UtilizadorNaoExistenteException que é lançada caso um utilizador não exista 
     */
    public class UtilizadorNaoExistenteException extends Exception {
        public UtilizadorNaoExistenteException() { }
        public UtilizadorNaoExistenteException(String message) {
            super(message);
        }        
    }
    
    /**
     *Classe que lança uma exepção do tipo UtilizadorDuplicadoException que é lançada caso um objecto do tipo utilizador seja repetido 
     */
    public class UtilizadorDuplicadoException extends Exception {
        public UtilizadorDuplicadoException() { }
        public UtilizadorDuplicadoException(String message) {
            super(message);
        }        
    }
    
    /**
     * metodo cronstrutor por defeito da class ListaUtilizadores que inicializa com um TreeMap
     */
    public ListaUtilizadores() {
        lista = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);        
    }
    
    /**
     * metodo para adicionar um utilizdor a um TreeMap
     * @param utilizador
     * @throws UtilizadorDuplicadoException
     */
    public void adicionar(Utilizador utilizador) throws UtilizadorDuplicadoException {
        if (utilizador == null) {
            throw new NullPointerException("O parâmetro 'utilizador' não pode ser um valor nulo");
        }        
        
        if (!lista.containsKey(utilizador.getUsername())) {
            lista.put(utilizador.getUsername(), utilizador);
        }else{
            throw new UtilizadorDuplicadoException(String.format("O utilizador '%s' já existe na coleção", utilizador.getUsername()));
        }
        
    }        
    
    /**
     * metodo para verificar a existencia do utilizador e retorna um booleano 
     * @param username
     * @return
     */
    public boolean existe(String username) {
        return lista.containsKey(username);
    }
    
    /**
     * metodo que lança uma exepção do tipo UtilizadorNaoExistenteException caso o utilizador ja exista 
     * @param username
     * @return
     * @throws UtilizadorNaoExistenteException
     */
    public Utilizador getUtilizador(String username) throws UtilizadorNaoExistenteException {
        if (lista.containsKey(username)){
            return lista.get(username);
        }else{
            throw new UtilizadorNaoExistenteException("O utilizador '%s' já existe na lista");
        }
    }          
    
}
