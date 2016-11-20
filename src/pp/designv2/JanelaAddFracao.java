/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.designv2;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pp.negocio.*;
/**
 *
 * @author Utilizador
 */
public class JanelaAddFracao extends javax.swing.JFrame {
    private Sistema sistema;
    private Fracao fracao;
    private ListarFracoes lf;
    private Condominio condo;
    private Manual manual = new Manual();
    /**
     * Creates new form JanelaAddFracao
     */
    public JanelaAddFracao(Sistema sistema, Fracao fracao, ListarFracoes lf, Condominio condo) {
        initComponents();
        setSize(310, 380);
        this.sistema = sistema;
        this.fracao = fracao;
        this.lf = lf;
        this.condo = condo;
        
        
        if (condo.getModalidade().getTipo().equals("Manual")){
            valorLabel.setVisible(true);
            valorField.setVisible(true);
        } else {
            valorLabel.setVisible(false);
            valorField.setVisible(false);
        }
        
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Criação de nova fracao");
            nportaField.requestFocus();                      
        }else{
            //No caso de um registo existente
            //Altera o titulo da janela
            setTitle("Alteração de dados da fração");
            //Preenche as caixas de texto com os dados do utilizador
            
            nportaField.setEditable(false);
            nportaField.setEnabled(false);
            nandarField.setEditable(false);
            nandarField.setEnabled(false);
            nportaField.setText(fracao.getNumPorta());
            nandarField.setText(String.valueOf(fracao.getNumAndar()));
            areaField.setText(String.valueOf(fracao.getArea()));
            nifField.setText(String.valueOf(fracao.getProprietario().getNif()));
            if(valorField.isVisible() && valorLabel.isVisible()){
                valorField.setText(String.valueOf(fracao.getValor()));
            }
            this.setResizable(false);
        }
        
        
    }
    
     private boolean registoNovo() {
        //Se utililizador == null consideramos que é um novo registo
        return fracao == null;
    }   
    
    private void fechar() {
        dispose();
    }
    
    private void calcMensalidade(){
        if(condo.getModalidade().getTipo().equals("Permilagem")){
            condo.getModalidade().calcularPermilagem(condo);
            //JOptionPane.showMessageDialog(this, fracao.getValor());
        }
        
        if(condo.getModalidade().getTipo().equals("Exata")){
            condo.getModalidade().calcularExata(condo);
            JOptionPane.showMessageDialog(this, fracao.getValor());
        }
        
        if(condo.getModalidade().getTipo().equals("Equitativa")){
            condo.getModalidade().calcularEquitativa(condo);
           // JOptionPane.showMessageDialog(this, fracao.getValor());
        }
    }
    
    private void criarFracao() throws Sistema.ClienteNaoExistenteException{
        
        if (registoNovo() && nportaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o nº de porta!");            
            nportaField.requestFocus();
            return;
        }
        
        if (registoNovo() && nifField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o NIF do Responsável!");            
            nifField.requestFocus();
            return;
        }
        
        if (registoNovo() && nandarField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o nº de andar!");            
            nandarField.requestFocus();
            return;
        } 
             
        if (registoNovo() && areaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a area da fração!");            
            areaField.requestFocus();
            return;
        } 
        
        
        if(registoNovo() && condo.getListaFracoes().containsKey(nportaField.getText())){
           
            JOptionPane.showMessageDialog(this, "O número de porta de fração desejado já está em uso");
            return;
           
        }
        
        if(!sistema.getListaProp().containsKey(nifField.getText())){
            JOptionPane.showMessageDialog(this, "O proprietário introduzido não existe");
            return;
        }
        
        
    
        if(registoNovo()){ 
            nportaField.setEditable(true);
            Fracao xpto = new Fracao();
            if(condo.getModalidade().getTipo().equals("Manual")){
               xpto.setValor(Double.parseDouble(valorField.getText())); 
            }
            xpto.setNumPorta(nportaField.getText());
            xpto.setNumAndar(Integer.parseInt(nandarField.getText()));
            xpto.setArea(Integer.parseInt(areaField.getText()));
            calcMensalidade();
            try {
                xpto.setProprietario(sistema.getCliente(nifField.getText()));
            } catch (Sistema.ClienteNaoExistenteException ex) {
                Logger.getLogger(JanelaAddFracao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            sistema.getListacondominios().get(String.valueOf(condo.getnCondominio())).addFracao(xpto); 
        } else {
           //fracao.setNumAndar(Integer.parseInt(nandarField.getText()));
           //fracao.setNumPorta(nportaField.getText());
           fracao.setArea(Integer.parseInt(areaField.getText()));
           fracao.setProprietario(sistema.getCliente(nifField.getText()));
        
           
        if (lf != null) lf.atualizar();  
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nportaField = new javax.swing.JTextField();
        nandarField = new javax.swing.JTextField();
        areaField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nifField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        valorLabel = new javax.swing.JLabel();
        valorField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nº da Porta");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(29, 32, 120, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nº de Andar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(26, 78, 100, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Area");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(26, 130, 90, 16);
        getContentPane().add(nportaField);
        nportaField.setBounds(185, 29, 80, 22);
        getContentPane().add(nandarField);
        nandarField.setBounds(185, 78, 80, 22);
        getContentPane().add(areaField);
        areaField.setBounds(185, 127, 80, 22);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NIF do Cliente");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(26, 179, 130, 16);
        getContentPane().add(nifField);
        nifField.setBounds(185, 176, 80, 22);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/add.png"))); // NOI18N
        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 280, 110, 31);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(140, 280, 120, 31);

        valorLabel.setForeground(new java.awt.Color(255, 255, 255));
        valorLabel.setText("Valor da Prestação");
        getContentPane().add(valorLabel);
        valorLabel.setBounds(26, 228, 120, 16);
        getContentPane().add(valorField);
        valorField.setBounds(185, 225, 80, 22);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/nossa_emrpesa.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-120, 0, 430, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            criarFracao();        // TODO add your handling code here:
        } catch (Sistema.ClienteNaoExistenteException ex) {
            Logger.getLogger(JanelaAddFracao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fechar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nandarField;
    private javax.swing.JTextField nifField;
    private javax.swing.JTextField nportaField;
    private javax.swing.JTextField valorField;
    private javax.swing.JLabel valorLabel;
    // End of variables declaration//GEN-END:variables
}
