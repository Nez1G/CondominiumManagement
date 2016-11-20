/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.designv2;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import pp.negocio.*;

/**
 *
 * @author Utilizador
 */
public class JanelaFracao extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    private Fracao mostrarselect;
    /**
     * Creates new form JanelaFracao
     */
    public JanelaFracao(Sistema sistema, Fracao mostrarselect) {
        initComponents();
        setSize(1097, 513);
        this.sistema = sistema;
        this.mostrarselect = mostrarselect;
        this.modeloTabela = criarModeloTabela();
        docTable.setModel(modeloTabela);
        clienteField.setText(mostrarselect.getProprietario().getNome());
        nAndarField.setText(String.valueOf(mostrarselect.getNumAndar()));
        nPortaField.setText(mostrarselect.getNumPorta());
        areaField.setText(String.valueOf(mostrarselect.getArea()));
        mensalidadeField.setText(String.valueOf(mostrarselect.getValor()));
        clienteField.setEditable(false);
        nPortaField.setEditable(false);
        nAndarField.setEditable(false);
        areaField.setEditable(false);
        mensalidadeField.setEditable(false);
        this.setResizable(false);
    }
    
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nº Doc", "Nome",  "NIF", "Data de emissao", "Data Limite", "Data de Pagamento ","Montante", "Multa", "Nº de Vias"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return mostrarselect.listaRecibos().size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
            /*
                Este método é invocado quando se pretende "popular" cada uma das células da tabela
                Se a tabela tem 3 linhas e 2 colunas existem 6 células (3*2), logo o método será invocado 6 vezes
                    rowIndex representa a linha da célula (0 a rowCount -1)
                    columnIndex representa a coluna da célula (0 a ColumnCount -1)
            */
            
                switch (columnIndex) {
                    case 0: 
                        return mostrarselect.listaRecibos().get(rowIndex).getNdocumento();
                    case 1:
                        return mostrarselect.listaRecibos().get(rowIndex).getCliente().getNome();
                    case 2:
                        return mostrarselect.listaRecibos().get(rowIndex).getCliente().getNif();
                    case 3:
                        return mostrarselect.listaRecibos().get(rowIndex).getDataemissao();
                    case 4:
                        return mostrarselect.listaRecibos().get(rowIndex).getDatalimite();
                    case 5:
                        return mostrarselect.listaRecibos().get(rowIndex).getDatapagamento();
                    case 6:
                        return mostrarselect.listaRecibos().get(rowIndex).getMontante();
                    case 7:
                        return mostrarselect.listaRecibos().get(rowIndex).getMulta();
                    case 8:
                        return mostrarselect.listaRecibos().get(rowIndex).getNvia();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    public void fechar(){
        dispose();
    }
    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    }
    
    public void pagar(){
        String test1= JOptionPane.showInputDialog("Por favor insira o ano e mês que pretende pagar " +"\n" + "Formato ano-mês(Ex: 2016-5)");
        mostrarselect.efectuarPagamento(test1);
        atualizar();
    }
    public void emitirF(){
        sistema.getListaFacturas().add(mostrarselect.emitirFactura());
        atualizar();
    }
    
    public void reprint(){
        int rowIndex = docTable.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Selecione um Documento"); return;}
        Recibo ref =  mostrarselect.getListapagamentosfrac().get(String.valueOf(docTable.getValueAt(rowIndex, 0)));
        JOptionPane.showMessageDialog(this, "Foi impressa uma nova via!");
        ref.updateNVia();
        atualizar();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        clienteField = new javax.swing.JTextField();
        nPortaField = new javax.swing.JTextField();
        nAndarField = new javax.swing.JTextField();
        areaField = new javax.swing.JTextField();
        mensalidadeField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        docTable = new javax.swing.JTable();
        pagarBtn = new javax.swing.JButton();
        novaFactBtn = new javax.swing.JButton();
        reprintBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(size());
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proprietario");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 34, 67, 16);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nº de Porta");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 72, 66, 16);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nº de Andar");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(27, 108, 70, 16);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Area");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(63, 146, 27, 16);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mensalidade");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 180, 71, 16);
        getContentPane().add(clienteField);
        clienteField.setBounds(163, 31, 100, 22);
        getContentPane().add(nPortaField);
        nPortaField.setBounds(163, 69, 100, 22);
        getContentPane().add(nAndarField);
        nAndarField.setBounds(163, 105, 100, 22);
        getContentPane().add(areaField);
        areaField.setBounds(163, 143, 100, 22);
        getContentPane().add(mensalidadeField);
        mensalidadeField.setBounds(163, 181, 100, 22);

        docTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(docTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(429, 11, 641, 272);

        pagarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/money_euro.png"))); // NOI18N
        pagarBtn.setText("Efectuar Pagamento");
        pagarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pagarBtn);
        pagarBtn.setBounds(860, 410, 200, 35);

        novaFactBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/emitir fatura.png"))); // NOI18N
        novaFactBtn.setText("Emitir Factura");
        novaFactBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novaFactBtnActionPerformed(evt);
            }
        });
        getContentPane().add(novaFactBtn);
        novaFactBtn.setBounds(650, 410, 150, 35);

        reprintBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/printer.png"))); // NOI18N
        reprintBtn.setText("Reimprimir");
        reprintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reprintBtnActionPerformed(evt);
            }
        });
        getContentPane().add(reprintBtn);
        reprintBtn.setBounds(429, 410, 140, 35);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/nossa--empresa.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1100, 513);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void pagarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarBtnActionPerformed
        pagar();        // TODO add your handling code here:
    }//GEN-LAST:event_pagarBtnActionPerformed

    private void novaFactBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novaFactBtnActionPerformed
        emitirF();        // TODO add your handling code here:
    }//GEN-LAST:event_novaFactBtnActionPerformed

    private void reprintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reprintBtnActionPerformed
        reprint();// TODO add your handling code here:
    }//GEN-LAST:event_reprintBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaField;
    private javax.swing.JTextField clienteField;
    private javax.swing.JTable docTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mensalidadeField;
    private javax.swing.JTextField nAndarField;
    private javax.swing.JTextField nPortaField;
    private javax.swing.JButton novaFactBtn;
    private javax.swing.JButton pagarBtn;
    private javax.swing.JButton reprintBtn;
    // End of variables declaration//GEN-END:variables
}