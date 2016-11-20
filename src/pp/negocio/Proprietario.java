package pp.negocio;

import java.util.ArrayList;

/** Classe que cria objectos do tipo Proprietario
 *
 * @author Fantastic4
 */
public class Proprietario {
     
    // variaveis de instância para a classe propriatário
    
    private String nome;
    private int nif;
    private int telefone;
    private String morada;
    private String mail;
    //private ArrayList<Proprietario> listaclientes;
  /**
     * metodo construtor por defeito 
     */
    public Proprietario () { 
   // listaclientes = new ArrayList<>();
    }
    
    //construtor com parametros

    /**
     * metodo construtor que recebe os parametros:
     * @param nome do tipo String
     * @param nif do tipo int
     * @param telefone do tipo int
     * @param morada do tipo String
     * @param mail do tipo String
     */
    
    public Proprietario (String nome, int nif, int telefone, String morada, String mail){ 
        this.nome = nome;
        this.nif = nif;
        this.telefone = telefone;
        this.morada = morada;
        this.mail = mail;
        //listaclientes = new ArrayList<>();
    }
    
    /**
     * metodo que retorna o nome do proprietario
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * metodo para alterar o nome do proprietario
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * metodo que retorna o Nif do proprietario
     * @return nif
     */
    public int getNif() {
        return nif;
    }

    /**
     * metodo para alterar o nif do propreitario 
     * @param nif 
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * metodo que retorna o numero de telefone do proprietario
     * @return telefone
     */
    public int getTelefone() {
        return telefone;
    }

    /**
     * metodo para aletar o numero de telefone do proprietario
     * @param telefone
     */
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    /**
     *  metodo que retorna a morada do proprietario
     * @return morada
     */
    public String getMorada() {
        return morada;
    }

    /**
     * metoedo para alterar a morada do proprietario
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * metodo que retorna o mail do proprietario
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     * metodo para alterar o mail do proprietario
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    
   /* 
    public ArrayList<Proprietario> getListaclientes() {
        return listaclientes;
    }

    public void setListaclientes(ArrayList<Proprietario> listacondominios) {
        this.listaclientes = listacondominios;
        
    }
    
    // adicionar cliente
    public void addCliente(Proprietario ref){
        
        if(listaclientes.contains(ref)){
            System.out.println("O cliente já foi anteriormente adicionado");
            } else {
                listaclientes.add(ref);
            }
    }
*/
  
    @Override
    public String toString(){
        return "\n" + "Nome: " + nome + "\n" + "NIF: " + nif + "\n" + "Contacto: " + telefone + "\n" + "Morada: " + morada + "\n" + "E-MAIL: " + mail; 
    }









}


