package pp.designv2;

import javax.swing.JOptionPane;
import pp.negocio.Sistema;

/**
 *
 * @author
 * Bruno Ferreira (bruno@dsi.uminho.pt)
 */
public class JanelaAlteracaoDadosUtilizador extends javax.swing.JDialog {
    private Sistema sistema;

    public JanelaAlteracaoDadosUtilizador(Sistema sistema) {
        initComponents();
        setSize(389, 205);
        
        //Indica que a janela deve ser modal ou seja,
        //bloqueia a execução do programa até que a janela seja fechada
        this.setModal(true);           
        
        //Não permite o redimensionamento da janela
        this.setResizable(false);                        
        
        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        this.sistema = sistema;            
        
        //Preenche as caixas de texto com os dados do utilizador ligado
        txtUtilizador.setText(sistema.getUtilizadorLigado().getUsername());
        txtNome.setText(sistema.getUtilizadorLigado().getNome());            
        
        txtPassword.requestFocus();
        this.setResizable(false);
    }    
    
    private void alterar() {
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o seu nome!");            
            txtNome.requestFocus();
            return;
        }
        
        if (txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a nova password!");
            txtPassword.requestFocus();
            return;
        }       
        
        if (txtConfirmacao.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a password de confirmação!");
            txtConfirmacao.requestFocus();
            return;
        }  
        
        String password = new String(txtPassword.getPassword());
        
        if (!password.equals(new String(txtConfirmacao.getPassword()))){
            JOptionPane.showMessageDialog(this, "A password de confirmação não corresponde à password introduzida!");
            txtConfirmacao.requestFocus();
            return;
        }        
        
        sistema.getUtilizadorLigado().setNome(txtNome.getText());        
        sistema.getUtilizadorLigado().setPassword(password);             
        JOptionPane.showMessageDialog(this, "Alteração efectuada com sucesso.");                
        fechar();
        
    }
    
    private void fechar() {
        dispose();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUtilizador = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtConfirmacao = new javax.swing.JPasswordField();
        btnAlterar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração de dados de utilizador");
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(18, 14, 80, 14);
        getContentPane().add(txtUtilizador);
        txtUtilizador.setBounds(100, 11, 243, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(18, 42, 80, 14);
        getContentPane().add(txtNome);
        txtNome.setBounds(100, 39, 243, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(18, 73, 80, 14);
        getContentPane().add(txtPassword);
        txtPassword.setBounds(100, 70, 243, 20);
        getContentPane().add(txtConfirmacao);
        txtConfirmacao.setBounds(100, 99, 243, 20);

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/editar.png"))); // NOI18N
        btnAlterar.setLabel("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(100, 137, 121, 32);

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/cancel.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        getContentPane().add(btnFechar);
        btnFechar.setBounds(231, 137, 112, 32);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Confirmação:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(18, 102, 80, 14);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/nossa-empresa12.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-6, 4, 410, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        fechar();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnAlterarActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField txtConfirmacao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUtilizador;
    // End of variables declaration//GEN-END:variables
}
