/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.designv2;

import javax.swing.JOptionPane;
import pp.negocio.*;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

/**
 *
 * @author André
 */
public class JanelaAdicionarCondominio extends javax.swing.JFrame {
    private Sistema sistema;
    private Condominio condo;
    private ListarCondominios jc;
    private Proprietario prop;
    private ListarClientes listar;
    
    
    public JanelaAdicionarCondominio(Sistema sistema, Condominio condo, ListarCondominios jc) {
        initComponents();
        this.sistema = sistema;
        this.jc = jc;
        this.condo = condo;
        
        if (registoNovo()) {    
            //Altera o titulo da janela
            //Como construimos sempre uma nova janela, as caixas de texto já estão limpas
            setTitle("Criação de novo Condomínio");
            nCondField.requestFocus();  
        }else{
            //No caso de um registo existente
            //Altera o titulo da janela
            setTitle("Alteração de dados do Condomínio");
            //Preenche as caixas de texto com os dados do utilizador
            nCondField.setEditable(false);
            nCondField.setEditable(false);
            //nCondField.setText(String.valueOf(condo.getnCondominio()));
            moradaField.setText(condo.getMorada());
            proprietarioField.setText(String.valueOf(condo.getResp().getNif()));
            andaresField.setText(String.valueOf(condo.getNumAndares()));
            despesasField.setText(String.valueOf(condo.getDespesas()));
            codPostalField.setText(condo.getCodPostal());
            diaPagamentoField.setText(String.valueOf(condo.getDiaPagamento()));
        }
        
        this.setResizable(false);
        setSize(460, 400);
        
    }


    private void fechar() {
        dispose();
    }
    
    private boolean registoNovo() {
        //Se utililizador == null consideramos que é um novo registo
        return condo == null;
    }
    
    private Modalidade selecModalidade(){
        Modalidade mod = null;
        
        if(permilagemButton.isSelected()){
            mod = new Permilagem();
        } 
        
        if(equitativaButton.isSelected()){
             mod = new Equitativa();
      
        } 
        
        if(exataButton.isSelected()){
          
              mod = new Exata();
        } 
        
        if(manualButton.isSelected()){
             mod = new Manual();
        }
        return mod;
    }
    

    
    private void criarCondominio() {
        
        if(registoNovo() && modalidadesGroup.getSelection() == null){
            JOptionPane.showMessageDialog(this, "Introduza a modalidade por favor!"); 
            return;
        }
        
        if ( registoNovo() && proprietarioField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o dia de pagamento por favor!");            
            diaPagamentoField.requestFocus();
            return;
        } 
        
        if(registoNovo() && nCondField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Introduza o número do condominio por favor!");            
            nCondField.requestFocus();
            return;
        }
        
        if (registoNovo() && despesasField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a despesa por favor!");            
            despesasField.requestFocus();
            return;
        } 
        
        if (registoNovo() && andaresField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o número de andares por favor!");            
            andaresField.requestFocus();
            return;
        } 
        
        if (registoNovo() && moradaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a morada por favor!");            
            moradaField.requestFocus();
            return;
        }
        
         if (registoNovo() && codPostalField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o código postal por favor!");            
            codPostalField.requestFocus();
            return;
        }        
        
        if (registoNovo() && diaPagamentoField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o dia de pagamento por favor!");            
            diaPagamentoField.requestFocus();
            return;
        } 
        
        if( registoNovo() &&sistema.getListacondominios().containsKey(nCondField.getText())){
            
            JOptionPane.showMessageDialog(this, "O número de condomínio desejado já está em uso");
            return;
        }
        
        if(!sistema.getListaProp().containsKey(proprietarioField.getText()) && registoNovo() ){
        
               JOptionPane.showMessageDialog(this, "Introduza um proprietário válido");
                return;
            }
        
        if(registoNovo() && !sistema.getListaProp().containsKey(proprietarioField.getText())){
            
            JOptionPane.showMessageDialog(this, "Introduza um proprietário válido");
                return;
        }
        
        if(registoNovo()){
            nCondField.setEditable(true);
            Condominio ref = new Condominio();
            
            ref.setnCondominio(Integer.parseInt(nCondField.getText()));
            
            try {
            
                    ref.setResponsavel(sistema.getCliente(proprietarioField.getText()));
            
                } catch (Sistema.ClienteNaoExistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                
            }
           
            ref.setModalidade(selecModalidade());
            ref.setDespesas(Double.parseDouble(despesasField.getText()));
            ref.setNumAndares(Integer.parseInt(andaresField.getText()));
            ref.setMorada(moradaField.getText());
            ref.setCodPostal(codPostalField.getText());
            ref.setDiaPagamento(Integer.parseInt(diaPagamentoField.getText()));
       
        try {
            sistema.addCondo(ref);
            }catch (Sistema.CondoDuplicadoException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                return;
            }  
       
        }
        else{
           nCondField.setEditable(false);
           nCondField.setEnabled(false);
           condo.setMorada(moradaField.getText());
           condo.setModalidade(selecModalidade());
           condo.setDespesas(Double.parseDouble(despesasField.getText()));
           condo.setNumAndares(Integer.parseInt(andaresField.getText()));
           condo.setCodPostal(codPostalField.getText());
           condo.setDiaPagamento(Integer.parseInt(diaPagamentoField.getText()));
           try {
            
                    condo.setResponsavel(sistema.getCliente(proprietarioField.getText()));
            
                } catch (Sistema.ClienteNaoExistenteException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
                
            }
           
        }
        
        if (jc != null) jc.atualizar();  
        JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
        fechar();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modalidadesGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        permilagemButton = new javax.swing.JRadioButton();
        equitativaButton = new javax.swing.JRadioButton();
        exataButton = new javax.swing.JRadioButton();
        manualButton = new javax.swing.JRadioButton();
        despesasField = new javax.swing.JTextField();
        andaresField = new javax.swing.JTextField();
        moradaField = new javax.swing.JTextField();
        diaPagamentoField = new javax.swing.JTextField();
        codPostalField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nCondField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        proprietarioField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Condominio");
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modalidade");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(23, 85, 100, 14);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código Postal");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(23, 241, 100, 14);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Despesas");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(23, 121, 90, 14);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Andares");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(23, 160, 90, 14);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dia Pagamento");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(23, 279, 100, 14);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(343, 187, 4, 0);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Morada");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(23, 205, 90, 14);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/accept.png"))); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(52, 314, 120, 37);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/cancel.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(263, 314, 103, 37);

        modalidadesGroup.add(permilagemButton);
        permilagemButton.setText("Permilagem");
        permilagemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permilagemButtonActionPerformed(evt);
            }
        });
        getContentPane().add(permilagemButton);
        permilagemButton.setBounds(123, 81, 90, 23);

        modalidadesGroup.add(equitativaButton);
        equitativaButton.setText("Equitativa");
        getContentPane().add(equitativaButton);
        equitativaButton.setBounds(210, 80, 80, 23);

        modalidadesGroup.add(exataButton);
        exataButton.setText("Exata");
        getContentPane().add(exataButton);
        exataButton.setBounds(290, 80, 70, 23);

        modalidadesGroup.add(manualButton);
        manualButton.setText("Manual");
        getContentPane().add(manualButton);
        manualButton.setBounds(360, 80, 80, 23);

        despesasField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                despesasFieldActionPerformed(evt);
            }
        });
        getContentPane().add(despesasField);
        despesasField.setBounds(123, 118, 100, 20);
        getContentPane().add(andaresField);
        andaresField.setBounds(123, 159, 100, 20);
        getContentPane().add(moradaField);
        moradaField.setBounds(123, 205, 100, 20);
        getContentPane().add(diaPagamentoField);
        diaPagamentoField.setBounds(122, 276, 100, 20);
        getContentPane().add(codPostalField);
        codPostalField.setBounds(122, 238, 100, 20);

        jLabel8.setText("Nº Condominio");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(23, 14, 100, 14);
        getContentPane().add(nCondField);
        nCondField.setBounds(123, 11, 100, 20);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NIF Responsável");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(23, 52, 100, 14);
        getContentPane().add(proprietarioField);
        proprietarioField.setBounds(123, 49, 100, 20);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/nossa_emrpesa.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 490, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fechar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void permilagemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permilagemButtonActionPerformed

        
    }//GEN-LAST:event_permilagemButtonActionPerformed

    private void despesasFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despesasFieldActionPerformed

    }//GEN-LAST:event_despesasFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        criarCondominio();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField andaresField;
    private javax.swing.JTextField codPostalField;
    private javax.swing.JTextField despesasField;
    private javax.swing.JTextField diaPagamentoField;
    private javax.swing.JRadioButton equitativaButton;
    private javax.swing.JRadioButton exataButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton manualButton;
    private javax.swing.ButtonGroup modalidadesGroup;
    private javax.swing.JTextField moradaField;
    private javax.swing.JTextField nCondField;
    private javax.swing.JRadioButton permilagemButton;
    private javax.swing.JTextField proprietarioField;
    // End of variables declaration//GEN-END:variables
}
