/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.designv2;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import pp.negocio.*;
import java.util.*;

/**
 *
 * @author Utilizador
 */
public class ListarFracoes extends javax.swing.JFrame {
    private Sistema sistema;
    private AbstractTableModel modeloTabela;
    private AbstractTableModel modeloTable;
    private Condominio selecionado;
    private Modalidade modalidade;
    private AgendaFinal agenda;
    private Fracao mostrarselect;
    private ArrayList<EventoData2> eventosselect;

    
    /**
     * Creates new form ListarFracoes
     */
    public ListarFracoes(Sistema sistema, Condominio selecionado) {
        initComponents();
        setSize(1034, 729);
        this.sistema = sistema;
        this.selecionado = selecionado;
        this.modalidade = selecionado.getModalidade();
        this.modeloTabela = criarModeloTabela();
        fracTable.setModel(modeloTabela);
        this.modeloTable = criarModelo();
        eventosTabela.setModel(modeloTable);
        //JOptionPane.showMessageDialog(this, selecionado.getDespesas());
        this.setResizable(false);
        
        }
    public ListarFracoes(){
        initComponents();
        this.setResizable(false);
        
    }
    
    private AbstractTableModel criarModeloTabela() {   
        String[] nomeColunas = {"Nº de Porta", "Proprietario", "Nº de andar", "Prestação", "Area"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return selecionado.getFracoes().size();
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
                        return selecionado.getFracoes().get(rowIndex).getNumPorta();
                    case 1:
                        return selecionado.getFracoes().get(rowIndex).getProprietario().getNome();
                    case 2:
                        return selecionado.getFracoes().get(rowIndex).getNumAndar();
                    case 3:
                        return selecionado.getFracoes().get(rowIndex).getValor();
                    case 4:
                        return selecionado.getFracoes().get(rowIndex).getArea();
                    default:
                        return "";
                }                              
            }            
        };
    }
   
    private AbstractTableModel criarModelo() {   
        String[] nomeColunas = {"Tipo de Evento", "Data", "Equipa", "Notas"};
        
        return new AbstractTableModel() {     
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
           
            @Override
            public int getRowCount() {
                //Retorna o número de linhas que a tabela deverá ter
                return selecionado.getAgenda().listadeEventos().size();
            }

            @Override
            public int getColumnCount() {
                //Retorna o número de colunas que a tabela deverá ter
                return nomeColunas.length;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
           
            
                switch (columnIndex) {
                    case 0: 
                        return selecionado.getAgenda().listadeEventos().get(rowIndex).getTipo();
                    case 1:
                        return selecionado.getAgenda().listadeEventos().get(rowIndex).getData();
                    case 2:
                        return selecionado.getAgenda().listadeEventos().get(rowIndex).getStaff();
                    case 3:
                        return selecionado.getAgenda().listadeEventos().get(rowIndex).getNotas();
                    default:
                        return "";
                }                              
            }            
        };
    }
    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
        modeloTabela.fireTableDataChanged();
        modeloTable.fireTableDataChanged();
    }
    
    
    public void fechar(){
        dispose();
    }
    
    private void addFracao() {
        JanelaAddFracao janela = new JanelaAddFracao(sistema, null, this, selecionado );   
        janela.setVisible(true);
    }
    
    private void detalhesFracao(){
        int rowIndex = fracTable.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Selecione uma fração"); return;}
        this.mostrarselect =  selecionado.getListaFracoes().get(String.valueOf(fracTable.getValueAt(rowIndex, 0)));
        JanelaFracao teste = new JanelaFracao(sistema, mostrarselect);
        teste.setVisible(true);
    }
    
    private void removerFracao(){
        int rowIndex = fracTable.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Nenhuma fração selecionada!"); return;}
        String nPorta =  String.valueOf(modeloTabela.getValueAt(rowIndex, 0));
        //selecionado.getListaFracoes().remove(String.valueOf(nPorta));
        //sistema.getListacondominios().get(String.valueOf(selecionado.getnCondominio())).getListaFracoes().remove(String.valueOf(nPorta));
        selecionado.delFracao(nPorta);
        modeloTabela.fireTableDataChanged();
    }
    
    private void editarFracao() {
        int rowIndex = fracTable.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Nenhuma fração selecionada!"); return;}
        String nPorta =  String.valueOf(modeloTabela.getValueAt(rowIndex, 0));
        
        //this.mostrarselect =  selecionado.getListaFracoes().get(String.valueOf(fracTable.getValueAt(rowIndex, 0)));
       
        Fracao fracao = selecionado.getListaFracoes().get(nPorta);
        JanelaAddFracao janela = new JanelaAddFracao(sistema, fracao, this, selecionado);
        janela.setVisible(true);
        
    }
    
    private void addEvento(){
        JanelaAdicionarEvento ref = new JanelaAdicionarEvento(sistema, selecionado, null, this, null);
        ref.setVisible(true);
    }
    
    public void removerEvento(){
        int rowIndex = eventosTabela.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Nenhum evento selecionado"); return;}
        //int ref =  Integer.parseInt(modeloTabela.getValueAt(rowIndex, 0));
        selecionado.getAgenda().removerEvento(rowIndex);
        sistema.getListaEventos().remove((rowIndex));
        modeloTable.fireTableDataChanged();
        
    }
    
    
    public void editarEvento(){
        int rowIndex = eventosTabela.getSelectedRow();
        if (rowIndex == -1) { JOptionPane.showMessageDialog(this, "Nenhum evento selecionado"); return;}
        //int ref =  Integer.parseInt(modeloTabela.getValueAt(rowIndex, 0));
        EventoData2 edit = sistema.getListaEventos().get(rowIndex);
        JanelaAdicionarEvento ref = new JanelaAdicionarEvento(sistema, selecionado, edit, this, null);
        ref.setVisible(true);
        
    }
    
    private int getNumFracoesAndar(int andar){
        int numFracoes = 0;
        
        for(int i = 0; i < fracTable.getRowCount(); i++){
            if(selecionado.getListaFracoes().get(i).getNumAndar() == andar){
                numFracoes += 1;
            }
        }
        
        return numFracoes;
    }
    
    private void atualizarPrestacao(){
        int area = 0;
        double despesas = selecionado.getDespesas();
        double fator = 0;
        int areaFracao = 0;
        double total = 0;
        int manual = 0;
        String fracao = "";
        double percentagem;
        double percentagemTotal = 0;
        double despesasAndar;
        int numFracoesAndar;
        
        if(selecionado.getModalidade().getTipo().equals("Permilagem")){
         
            for(int i = 0; i < fracTable.getRowCount(); i++ ){
            area += (int) modeloTabela.getValueAt(i, 4);
        }
       
            fator = (despesas / area);
        
            for(int i = 0; i < fracTable.getRowCount(); i++ ){
            areaFracao = (int) modeloTabela.getValueAt(i, 4);
            total = (int) (areaFracao * fator);
            selecionado.getFracoes().get(i).setValor(total);
            modeloTabela.fireTableDataChanged();
            }
        }
        
        if(selecionado.getModalidade().getTipo().equals("Equitativa")){
         
            for(int x = 1; x <= selecionado.getNumAndares(); x++){
                percentagem = Double.parseDouble(JOptionPane.showInputDialog("Introduza a percentagem que deseja atribuir ao " + (x) + "º andar no formato (0 a 1)" ));
                despesasAndar = (percentagem * despesas);
                numFracoesAndar = selecionado.getNumFracoesAndar(x);
                total = (despesasAndar / numFracoesAndar);
                
                percentagemTotal += percentagem;
               
                if(percentagem < 0 || percentagem > 1){
                    JOptionPane.showMessageDialog(this, "A percentagem introduzida não é válida");
                    return;
                }
           
                for(int y = 0; y < selecionado.getFracoes().size(); y++){
                    if(selecionado.getFracoes().get(y).getNumAndar()== (x)){
                       selecionado.getFracoes().get(y).setValor(total);
                    }
                }
            }
            
                            
            
                
                if(percentagemTotal != 1){
                    JOptionPane.showMessageDialog(this, "A soma percentual não é válida");
                    return;
                }
           
            modeloTabela.fireTableDataChanged();
            
        }
        
        if(selecionado.getModalidade().getTipo().equals("Exata")){
            total = Integer.parseInt(JOptionPane.showInputDialog("Introduza o valor da prestação"));
            
            for(int i = 0; i < fracTable.getRowCount(); i++ ){
            selecionado.getFracoes().get(i).setValor(total);
            modeloTabela.fireTableDataChanged();
            }
        }
        
        if(selecionado.getModalidade().getTipo().equals("Manual")){
            fracao = (JOptionPane.showInputDialog("Introduza o número da fração à qual deseja alterar a prestação"));
            selecionado.getListaFracoes().get(fracao);
            manual = Integer.parseInt(JOptionPane.showInputDialog("Introduza o valor que deseja aplicar à fração"));
            selecionado.getListaFracoes().get(fracao).setValor(manual);
            modeloTabela.fireTableDataChanged();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        fracTable = new javax.swing.JTable();
        addFracao = new javax.swing.JButton();
        delFracao = new javax.swing.JButton();
        changeFracao = new javax.swing.JButton();
        detailBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        eventsTable = new javax.swing.JScrollPane();
        eventosTabela = new javax.swing.JTable();
        addEvento = new javax.swing.JButton();
        delEvento = new javax.swing.JButton();
        editEvento = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        fracTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(fracTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(29, 15, 480, 229);

        addFracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/add.png"))); // NOI18N
        addFracao.setText("Adicionar Fração");
        addFracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFracaoActionPerformed(evt);
            }
        });
        getContentPane().add(addFracao);
        addFracao.setBounds(10, 480, 150, 36);

        delFracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/delete.png"))); // NOI18N
        delFracao.setText("Remover Fração");
        delFracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delFracaoActionPerformed(evt);
            }
        });
        getContentPane().add(delFracao);
        delFracao.setBounds(170, 480, 160, 36);

        changeFracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/editar.png"))); // NOI18N
        changeFracao.setText("Alterar Fração");
        changeFracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeFracaoActionPerformed(evt);
            }
        });
        getContentPane().add(changeFracao);
        changeFracao.setBounds(340, 480, 140, 36);

        detailBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/information.png"))); // NOI18N
        detailBtn.setText("Detalhes da Fração");
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });
        getContentPane().add(detailBtn);
        detailBtn.setBounds(50, 540, 180, 36);

        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/cancel.png"))); // NOI18N
        exitBtn.setText("Sair");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(exitBtn);
        exitBtn.setBounds(450, 590, 133, 46);

        eventosTabela.setModel(new javax.swing.table.DefaultTableModel(
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
        eventsTable.setViewportView(eventosTabela);

        getContentPane().add(eventsTable);
        eventsTable.setBounds(538, 15, 468, 229);

        addEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/add.png"))); // NOI18N
        addEvento.setText("Adicionar Evento");
        addEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventoActionPerformed(evt);
            }
        });
        getContentPane().add(addEvento);
        addEvento.setBounds(720, 480, 160, 36);

        delEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/delete.png"))); // NOI18N
        delEvento.setText("Remover Evento");
        delEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delEventoActionPerformed(evt);
            }
        });
        getContentPane().add(delEvento);
        delEvento.setBounds(560, 480, 150, 36);

        editEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/editar.png"))); // NOI18N
        editEvento.setText("Editar Evento");
        editEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEventoActionPerformed(evt);
            }
        });
        getContentPane().add(editEvento);
        editEvento.setBounds(890, 480, 130, 36);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/arrow_refresh.png"))); // NOI18N
        jButton1.setText("Atualizar Prestações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 540, 178, 34);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pp/designbonus/imagem fundo v10.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, -80, 1070, 890);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFracaoActionPerformed
        addFracao();        // TODO add your handling code here:
    }//GEN-LAST:event_addFracaoActionPerformed

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        detalhesFracao();        // TODO add your handling code here:
    }//GEN-LAST:event_detailBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        fechar();        // TODO add your handling code here:
    }//GEN-LAST:event_exitBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        fechar();        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void delFracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delFracaoActionPerformed
        removerFracao();
    }//GEN-LAST:event_delFracaoActionPerformed

    private void addEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventoActionPerformed
        addEvento(); // TODO add your handling code here:
    }//GEN-LAST:event_addEventoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        atualizarPrestacao();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void changeFracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeFracaoActionPerformed
        editarFracao();
    }//GEN-LAST:event_changeFracaoActionPerformed

    private void delEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delEventoActionPerformed
        removerEvento();                // TODO add your handling code here:
    }//GEN-LAST:event_delEventoActionPerformed

    private void editEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEventoActionPerformed
        editarEvento();        // TODO add your handling code here:
    }//GEN-LAST:event_editEventoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEvento;
    private javax.swing.JButton addFracao;
    private javax.swing.JButton changeFracao;
    private javax.swing.JButton delEvento;
    private javax.swing.JButton delFracao;
    private javax.swing.JButton detailBtn;
    private javax.swing.JButton editEvento;
    private javax.swing.JTable eventosTabela;
    private javax.swing.JScrollPane eventsTable;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTable fracTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
