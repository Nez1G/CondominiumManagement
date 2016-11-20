/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.designv2;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import pp.negocio.*;

/**
 *
 * @author Utilizador
 */
public class ListarCondominios extends javax.swing.JFrame {
    
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    protected Condominio select;
    /**
     * Creates new form ListarCondominios
     */
    public ListarCondominios(Sistema sistema) {
        initComponents();
        setSize(836, 511);
        this.sistema = sistema;
        this.modeloTabela = criarModeloTabela();
        tabelaCondo.setModel(modeloTabela);
        this.setResizable(false);
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nº", "Modalidade", "Despesas", "Andares", "Morada", "Código Postal", "Dias para pagar"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return sistema.listaCondos().size();
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
                        return sistema.listaCondos().get(rowIndex).getnCondominio();
                    case 1:
                        return sistema.listaCondos().get(rowIndex).getModalidade().getTipo();
                    case 2:
                        return sistema.listaCondos().get(rowIndex).getDespesas();
                    case 3:
                        return sistema.listaCondos().get(rowIndex).getNumAndares();
                    case 4:
                        return sistema.listaCondos().get(rowIndex).getMorada();
                    case 5:
                        return sistema.listaCondos().get(rowIndex).getCodPostal();
                    case 6:
                        return sistema.listaCondos().get(rowIndex).getDiaPagamento();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
    } 
    
    public void fechar(){
        dispose();
    }
    
    private void adicionar() {
        JanelaAdicionarCondominio janela = new JanelaAdicionarCondominio(sistema, null, this);   
        janela.setVisible(true);
    }
    
    private void remover(){
        int rowIndex = tabelaCondo.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Nenhum condominio selecionado!"); return;}
        int nCondo = (int) modeloTabela.getValueAt(rowIndex, 0);
        sistema.getListacondominios().remove(String.valueOf(nCondo));
        modeloTabela.fireTableDataChanged();
        }
    
    private void fracoes(){
    
        int rowIndex = tabelaCondo.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Nenhum condominio selecionado"); return;}
        this.select =  sistema.getListacondominios().get(String.valueOf(tabelaCondo.getValueAt(rowIndex, 0)));
        //this.agenda = select.getAgenda();
        //JOptionPane.showMessageDialog(this, agenda.getListaLimpeza().size());
        ListarFracoes window;
        window = new ListarFracoes(sistema, select);
        window.setVisible(true);
        
    }
    
    private void editar() {
        int rowIndex = tabelaCondo.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1)  { JOptionPane.showMessageDialog(this, "Nenhum condominio selecionado!"); return;}
        
        int num = (int) modeloTabela.getValueAt(rowIndex, 0);
        
        Condominio condo = sistema.getListacondominios().get(String.valueOf(num));
        JanelaAdicionarCondominio janela = new JanelaAdicionarCondominio(sistema, condo, this);
        janela.setVisible(true);
        
    }
     
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listaCondo = new javax.swing.JScrollPane();
        tabelaCondo = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        alterarBtn = new javax.swing.JButton();
        removeBtn = new javax.swing.JButton();
        fracoesList = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        tabelaCondo.setModel(new javax.swing.table.DefaultTableModel(
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
        listaCondo.setViewportView(tabelaCondo);

        getContentPane().add(listaCondo);
        listaCondo.setBounds(60, 46, 716, 100);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/add.png"))); // NOI18N
        addBtn.setText("Adicionar");
        addBtn.setBorder(null);
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        getContentPane().add(addBtn);
        addBtn.setBounds(60, 253, 125, 43);

        alterarBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/editar.png"))); // NOI18N
        alterarBtn.setText("Editar");
        alterarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarBtnActionPerformed(evt);
            }
        });
        getContentPane().add(alterarBtn);
        alterarBtn.setBounds(258, 253, 123, 43);

        removeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/delete.png"))); // NOI18N
        removeBtn.setText("Remover");
        removeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(removeBtn);
        removeBtn.setBounds(454, 253, 122, 43);

        fracoesList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/information.png"))); // NOI18N
        fracoesList.setText("Detalhes");
        fracoesList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fracoesListActionPerformed(evt);
            }
        });
        getContentPane().add(fracoesList);
        fracoesList.setBounds(649, 253, 127, 43);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/cancel.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(650, 410, 125, 43);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/nossa empresa.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-20, -100, 870, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        adicionar();        // TODO add your handling code here:
    }//GEN-LAST:event_addBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void fracoesListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fracoesListActionPerformed
        fracoes();        // TODO add your handling code here:
    }//GEN-LAST:event_fracoesListActionPerformed

    private void alterarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarBtnActionPerformed
        editar();
        
    }//GEN-LAST:event_alterarBtnActionPerformed

    private void removeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeBtnActionPerformed
        remover();
    }//GEN-LAST:event_removeBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton alterarBtn;
    private javax.swing.JButton fracoesList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane listaCondo;
    private javax.swing.JButton removeBtn;
    private javax.swing.JTable tabelaCondo;
    // End of variables declaration//GEN-END:variables
}
