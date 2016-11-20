package pp.negocio;
/** Classe para criar Objetos do tipo Administrador que contém herança da classe Utilizador
 * 
 * @author Fantastic4
 */
    public class Administrador extends Utilizador {

    /**
     * Construtor por defeito
     */
    public Administrador() {
    }

    /**
     *
     * @param username
     * @param password
     * @param nome
     */
    public Administrador(String username, String password, String nome) {
        super(username, password, nome);
    }    
    
    
}

