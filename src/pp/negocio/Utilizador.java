package pp.negocio;
/** Classe que cria objetos do tipo Utilizador 
 *
 * @author Fantastic4
 */
public class Utilizador {
    private String username;
    private String password;
    private String nome;

    /**
     * Contrutor por defeito
     */
    public Utilizador() { }    
    
    /**
     * metodo construtor que recebe parametros:
     * @param username do tipo String
     * @param password do tipo String
     * @param nome do tipo String
     */
    public Utilizador(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }    
    
    /** Metodo que retorna o Nome de utlizador 
     *
     * @return String - Nome do utlizador
     */
    public String getUsername() {
        return username;
    }

    /** Metodo para alterar o nome do utlizador
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /** Metodo para retorno da palavra passe
     *
     * @return String - palavra passe
     */
    public String getPassword() {
        return password;
    }

    /** Metodo para alterar a palavra passe
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** Metodo para o retorno do Nome
     *
     * @return String - nome
     */
    public String getNome() {
        return nome;
    }

    /** Metodo para alterar o nome 
     *
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }        
    
}
