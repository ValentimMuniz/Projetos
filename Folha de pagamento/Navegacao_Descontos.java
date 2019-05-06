package folha_de_pagamento;
import java.awt.event.KeyEvent;
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Navegacao_Descontos extends javax.swing.JFrame {

    conexao_banco var_lista = new conexao_banco();
    public Navegacao_Descontos() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_desc = new javax.swing.JTextField();
        btnPrimeiro = new javax.swing.JButton();
        txt_quantidade = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_valor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Navegação de descontos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnProximo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnProximo.setText(">");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Setor");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Valor");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel8.setText("Navegação de descontos");

        txt_codigo.setEditable(false);
        txt_codigo.setToolTipText("Código");
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigoKeyPressed(evt);
            }
        });

        txt_desc.setEditable(false);
        txt_desc.setToolTipText("Descrição");

        btnPrimeiro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnPrimeiro.setText("|<<");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        txt_quantidade.setEditable(false);
        txt_quantidade.setToolTipText("Setor");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Código");

        txt_valor.setEditable(false);
        txt_valor.setToolTipText("Valor");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Descrição");

        btnAnterior.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        btnUltimo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnUltimo.setText(">>|");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2)
                        .addGap(10, 10, 10)
                        .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrimeiro)
                        .addGap(6, 6, 6)
                        .addComponent(btnAnterior)
                        .addGap(6, 6, 6)
                        .addComponent(btnProximo)
                        .addGap(10, 10, 10)
                        .addComponent(btnUltimo)
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrimeiro)
                    .addComponent(btnAnterior)
                    .addComponent(btnProximo)
                    .addComponent(btnUltimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int sair = showConfirmDialog(null, "Deseja realmente desta tela ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair){
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

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        proximo();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void txt_codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_LEFT){
            anterior();
        }
        if(evt.getKeyCode() == KeyEvent.VK_RIGHT){
            proximo();
        }
        if(evt.getKeyCode() == KeyEvent.VK_PERIOD){
            ultimo();
        }
        if(evt.getKeyCode() == KeyEvent.VK_COMMA){
            primeiro();
        }
    }//GEN-LAST:event_txt_codigoKeyPressed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        primeiro();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        ultimo();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        var_lista.conecta_lista();  
        try{             
            var_lista.RS= var_lista.stmt.executeQuery("Select * From Tabela_Descontos");
            //var_lista.RS= var_lista.stmt.executeQuery("Select Top 1 *, newid() as aleatorio From tb_alunos Order By aleatorio"); //**** Se quiser pegar um aleatorio
            var_lista.RS.first();
            txt_codigo.setText(var_lista.RS.getString("Codigo_desc"));
            txt_desc.setText(var_lista.RS.getString("Descricao")); 
            txt_quantidade.setText(var_lista.RS.getString("Quantidade"));
            txt_valor.setText("R$ " + var_lista.RS.getString("Valor"));    
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
        }
        txt_codigo.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = showConfirmDialog(null, "Deseja realmente sair desta tela ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair){
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

   public void primeiro(){
        try{  
            if(var_lista.RS.isFirst()){
                showMessageDialog(this,"Este já é o primeiro registro!", "Primeiro", 1);
                return;
            }
            var_lista.RS= var_lista.stmt.executeQuery("Select * From Tabela_Descontos");
            //var_lista.RS= var_lista.stmt.executeQuery("Select Top 1 *, newid() as aleatorio From tb_alunos Order By aleatorio"); //**** Se quiser pegar um aleatorio
            var_lista.RS.first();
            txt_codigo.setText(var_lista.RS.getString("Codigo_desc"));
            txt_desc.setText(var_lista.RS.getString("Descricao")); 
            txt_quantidade.setText(var_lista.RS.getString("Quantidade"));
            txt_valor.setText("R$ " + var_lista.RS.getString("Valor"));   
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros", "Não existem registros", 1);
        }
        txt_codigo.requestFocus();
    }
    
    public void ultimo(){
        try{   
            if(var_lista.RS.isLast()){
                showMessageDialog(this,"Este já é o último registro!", "Último", 1);
                return;
            }
            var_lista.RS= var_lista.stmt.executeQuery("Select * From Tabela_Descontos");
            //var_lista.RS= var_lista.stmt.executeQuery("Select Top 1 *, newid() as aleatorio From tb_alunos Order By aleatorio"); //**** Se quiser pegar um aleatorio
            var_lista.RS.last();
            txt_codigo.setText(var_lista.RS.getString("Codigo_desc"));
            txt_desc.setText(var_lista.RS.getString("Descricao")); 
            txt_quantidade.setText(var_lista.RS.getString("Quantidade"));
            txt_valor.setText("R$ " + var_lista.RS.getString("Valor"));  
        }
        catch(SQLException e){
           showMessageDialog(this,"Não existem registros", "Não existem registros", 1);
        }
        txt_codigo.requestFocus();
    }
    
    public void anterior(){
        try{            
            var_lista.RS.previous();
            txt_codigo.setText(var_lista.RS.getString("Codigo_desc"));
            txt_desc.setText(var_lista.RS.getString("Descricao")); 
            txt_quantidade.setText(var_lista.RS.getString("Quantidade"));
            txt_valor.setText("R$ " + var_lista.RS.getString("Valor"));
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros anteriores!", "Ultimo anterior", 1);
        }
        txt_codigo.requestFocus();
    }
    
    public void proximo(){
        try{   
            var_lista.RS.next();
            txt_codigo.setText(var_lista.RS.getString("Codigo_desc"));
            txt_desc.setText(var_lista.RS.getString("Descricao")); 
            txt_quantidade.setText(var_lista.RS.getString("Quantidade"));
            txt_valor.setText("R$ " + var_lista.RS.getString("Valor"));      
        }
        catch(SQLException e){
           showMessageDialog(this,"Não existem registros posteriores!", "Ultimo posterior", 1);
        }
        txt_codigo.requestFocus();
    }
    
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
            java.util.logging.Logger.getLogger(Navegacao_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navegacao_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navegacao_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navegacao_Descontos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Navegacao_Descontos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_quantidade;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
