package pp.designv2;

import javax.swing.JOptionPane;
import pp.negocio.Sistema;

/**
 *
 * @author
 * Fantastic4
 */
import pp.negocio.*;
public class Piloto {      
    
    public static void main(String[] args) throws ListaUtilizadores.UtilizadorDuplicadoException {
        Sistema sistema = new Sistema();
        //Condominus dados = new Condominus();
        try {                                                
            //Inicializa o sistema
            sistema.inicializar();            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, 
                    String.format("Ocorreu um erro ao inicializar o sistema: %s.\nO programa será encerrado.",
                        ex.getMessage()), 
                    "Erro fatal", JOptionPane.ERROR_MESSAGE);
            sistema.terminar();
        }
        
        //Uma vez que a JanelaLogin é modal, este método irá bloquear até que a janela seja fechada.
        //A janela só fecha quando os dados de login são válidos.                
        JanelaLogin login = new JanelaLogin(sistema);               
        login.setVisible(true);
    
        JanelaPrincipal principal = new JanelaPrincipal(sistema);
        principal.setVisible(true);        
        
    }          
    
}
