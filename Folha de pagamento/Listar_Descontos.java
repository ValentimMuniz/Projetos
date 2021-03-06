package folha_de_pagamento;

import java.awt.event.KeyEvent;
import static javax.swing.JOptionPane.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Listar_Descontos extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();    
    FileWriter arq;
    PrintWriter gravarArq;
    int existe;
    int escolha = 0;
    String filename = File.separator+"tmp";
    
    public Listar_Descontos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTXT = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_descontos = new javax.swing.JTable();
        txtBusca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar/Salvar descontos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Lista de descontos");

        btnTXT.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnTXT.setText("Salvar em arquivo texto");
        btnTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTXTActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        tb_descontos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tb_descontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_descontos.setColumnSelectionAllowed(true);
        tb_descontos.getTableHeader().setReorderingAllowed(false);
        tb_descontos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_descontosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_descontos);
        tb_descontos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Buscar por código");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(btnTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTXT)
                    .addComponent(btnSair))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(508, 307));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public static boolean isEmpty(JTable jTable){
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }
    
    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTXTActionPerformed
        if(isEmpty(tb_descontos)){
            showMessageDialog(this,"Não existem descontos cadastrados no banco de dados!", "Sem descontos cadastrados", 1);
            return; //Não tem nada selecionado
        }
        
        var.conecta();
        JFileChooser fc = new JFileChooser(new File(filename));
        fc.setFileFilter(new FileNameExtensionFilter("Arquivo de Texto", "txt"));
        fc.setAcceptAllFileFilterUsed(false);
        // Mostra a dialog de save file
        fc.showSaveDialog(null);
        File selFile = fc.getSelectedFile();
        String nome = fc.getName(selFile);

        if(selFile == null){
            return;
        }
        try
        {
            File idea = new File(selFile + ".txt");
            if (idea.exists()){
                existe = showConfirmDialog(null, "Arquivo " + nome + ".txt já existe, deseja substituílo?",  "Deseja substituir?", YES_NO_CANCEL_OPTION);
                switch (existe){
                    case YES_OPTION:
                    idea.delete();
                    arq = new FileWriter(selFile + ".txt");
                    gravarArq = new PrintWriter(arq);
                    escolha = 1;
                    break;
                    case CANCEL_OPTION:
                    escolha = 0;
                    return;
                    default:
                    escolha = 0;
                    return;
                }
            }else{
                arq = new FileWriter(selFile + ".txt");
                gravarArq = new PrintWriter(arq);
            }

            var.RS= var.stmt.executeQuery("Select * from Tabela_Descontos");
            while(var.RS.next()){
                gravarArq.printf("#Código: "
                    + var.RS.getString("Codigo_desc")
                    + "\n #Descricao -> "
                    + var.RS.getString("Descricao")
                    + "\n #Quantidade -> "
                    + var.RS.getString("Quantidade")
                    + "\n #Valor -> "
                    + var.RS.getString("Valor")
                    + "\r\n %n" ); }
            arq.close();

            if(escolha == 1){
                showMessageDialog(this, "Arquivo" + nome + ".txt foi substituído", "Arquivo substituído", 2);
            }else{
                showMessageDialog(this, "Arquivo " + nome + ".txt da Tabela: Tabela_Descontos foi gerado com sucesso!", "Arquivo gerado com sucesso", 1 );
            }
            escolha = 0;
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
        catch (IOException ex){
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTXTActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int sair = showConfirmDialog(null, "Deseja realmente sair desta tela ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch(sair){
            case YES_OPTION:
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes
            this.dispose();
            break;
            case CANCEL_OPTION:
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel
            break;
            default:
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//no
            break;
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        var.conecta();
        tb_descontos.setAutoCreateRowSorter(true);
        DefaultTableModel Descontos = (DefaultTableModel) tb_descontos.getModel();
        tb_descontos.requestFocus();
        try{   
            var.RS = var.stmt.executeQuery("SELECT TOP 10 * FROM Tabela_Descontos order by Codigo_desc");
            boolean existir = false;
            while(var.RS.next()){
                existir = true; 
                Descontos.addRow(new Object[]{
                    var.RS.getString("Codigo_desc"), 
                    var.RS.getString("Descricao"),  
                    var.RS.getString("Quantidade"),
                    "R$ " + var.RS.getString("Valor"),
                });   
            }
            if(!existir){
                showMessageDialog(this,"Não existem descontos cadastrados no banco de dados!", "Sem descontos cadastrados", 1);       
            }   
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        } 
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = showConfirmDialog(null, "Deseja realmente sair desta tela ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch(sair){
            case YES_OPTION:
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes
                this.dispose();
                break; 
            case CANCEL_OPTION:
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel               
                break;
            default:
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//no
                break;
        }
    }//GEN-LAST:event_formWindowClosing

    private void tb_descontosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_descontosMouseClicked
        if (evt.getClickCount() == 2){
            int linha = tb_descontos.getSelectedRow();
            String cod = tb_descontos.getValueAt(linha, 0).toString(); 
            String desc = tb_descontos.getValueAt(linha, 1).toString();
            String quant = tb_descontos.getValueAt(linha, 2).toString();
            String valor = tb_descontos.getValueAt(linha, 3).toString();
            showMessageDialog(this, "Código desconto -> " + cod + ", Descrição -> " + desc + ", Quantidade -> " + quant + ", Valor -> " + valor, "Informação", 1);
        }
    }//GEN-LAST:event_tb_descontosMouseClicked

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        var.conecta();
        tb_descontos.setAutoCreateRowSorter(true);
        DefaultTableModel Descontos2 = (DefaultTableModel) tb_descontos.getModel();
        Descontos2.setRowCount(0);
        String CodigoBusca = null;
        CodigoBusca = txtBusca.getText().trim().replaceAll("\\s+", " ");
        try{
            //var.RS = var.stmt.executeQuery("SELECT * FROM Tabela_Descontos where Codigo_desc like '" + CodigoBusca + "%' or Codigo_desc Like '%" + CodigoBusca + "%' ");
            PreparedStatement stmt = var.con.prepareStatement("SELECT * FROM Tabela_Descontos where Codigo_desc like ? or Codigo_desc Like ?");
            stmt.setString(1, CodigoBusca + "%");
            stmt.setString(2, "%" + CodigoBusca + "%");
            var.RS = stmt.executeQuery();
            while(var.RS.next()){

                Descontos2.addRow(new Object[]{
                    var.RS.getString("Codigo_desc"), 
                    var.RS.getString("Descricao"),  
                    var.RS.getString("Quantidade"),
                    "R$ " + var.RS.getString("Valor"),
                });   
            }

        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_txtBuscaKeyReleased

    private void txtBuscaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE){
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);     
            }else{
                showMessageDialog(this, "Digite somente números para Buscar o código de desconto!","Somente números",1);
            }
            String SChapa = txtBusca.getText();
            txtBusca.setText(SChapa.trim());            
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscaKeyTyped

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Listar_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar_Descontos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_descontos;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
