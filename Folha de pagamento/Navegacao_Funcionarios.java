package folha_de_pagamento;

import java.awt.event.KeyEvent;
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Navegacao_Funcionarios extends javax.swing.JFrame {

    conexao_banco var_lista = new conexao_banco();
    public Navegacao_Funcionarios() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrimeiro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAnterior = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnUltimo = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_chapa = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_setor = new javax.swing.JTextField();
        txt_salario = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nvegação de funcionários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnPrimeiro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnPrimeiro.setText("|<<");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Chapa");

        btnAnterior.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Setor");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nome");

        btnUltimo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnUltimo.setText(">>|");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });

        btnProximo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnProximo.setText(">");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Salário");

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel8.setText("Navegação de funcionários");

        txt_chapa.setEditable(false);
        txt_chapa.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_chapa.setToolTipText("Chapa");
        txt_chapa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_chapaKeyPressed(evt);
            }
        });

        txt_nome.setEditable(false);
        txt_nome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_nome.setToolTipText("Nome");

        txt_setor.setEditable(false);
        txt_setor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_setor.setToolTipText("Setor");

        txt_salario.setEditable(false);
        txt_salario.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txt_salario.setToolTipText("Salário");

        btnSair.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnPrimeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUltimo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_setor)
                            .addComponent(txt_chapa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nome)
                            .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_chapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_setor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrimeiro)
                    .addComponent(btnAnterior)
                    .addComponent(btnProximo)
                    .addComponent(btnUltimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(419, 305));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
        primeiro();
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        ultimo();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        proximo();
    }//GEN-LAST:event_btnProximoActionPerformed

    private void txt_chapaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_chapaKeyPressed
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
    }//GEN-LAST:event_txt_chapaKeyPressed

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        var_lista.conecta_lista();
        try{             
            var_lista.RS= var_lista.stmt.executeQuery("Select * From Tabela_Funcionarios");
            //var_lista.RS= var_lista.stmt.executeQuery("Select Top 1 *, newid() as aleatorio From tb_alunos Order By aleatorio"); //**** Se quiser pegar um aleatorio
            var_lista.RS.first();
            txt_chapa.setText(var_lista.RS.getString("Chapa"));
            txt_nome.setText(var_lista.RS.getString("Nome")); 
            txt_setor.setText(var_lista.RS.getString("Setor"));
            txt_salario.setText("R$ " + var_lista.RS.getString("Salario"));    
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
        }
        txt_chapa.requestFocus();
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
            var_lista.RS= var_lista.stmt.executeQuery("Select * From Tabela_Funcionarios");
            //var_lista.RS= var_lista.stmt.executeQuery("Select Top 1 *, newid() as aleatorio From tb_alunos Order By aleatorio"); //**** Se quiser pegar um aleatorio
            var_lista.RS.first();
            txt_chapa.setText(var_lista.RS.getString("Chapa"));
            txt_nome.setText(var_lista.RS.getString("Nome")); 
            txt_setor.setText(var_lista.RS.getString("Setor"));
            txt_salario.setText("R$ " + var_lista.RS.getString("Salario"));     
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros", "Não existem registros", 1);
        }
        txt_chapa.requestFocus();
    }
    
    public void ultimo(){
        try{   
            if(var_lista.RS.isLast()){
                showMessageDialog(this,"Este já é o último registro!", "Último", 1);
                return;
            }
            var_lista.RS= var_lista.stmt.executeQuery("Select * From Tabela_Funcionarios");
            //var_lista.RS= var_lista.stmt.executeQuery("Select Top 1 *, newid() as aleatorio From tb_alunos Order By aleatorio"); //**** Se quiser pegar um aleatorio
            var_lista.RS.last();
            txt_chapa.setText(var_lista.RS.getString("Chapa"));
            txt_nome.setText(var_lista.RS.getString("Nome")); 
            txt_setor.setText(var_lista.RS.getString("Setor"));
            txt_salario.setText("R$ " + var_lista.RS.getString("Salario"));    
        }
        catch(SQLException e){
           showMessageDialog(this,"Não existem registros", "Não existem registros", 1);
        }
        txt_chapa.requestFocus();
    }
    
    public void anterior(){
        try{            
            var_lista.RS.previous();
            txt_chapa.setText(var_lista.RS.getString("Chapa"));
            txt_nome.setText(var_lista.RS.getString("Nome")); 
            txt_setor.setText(var_lista.RS.getString("Setor"));
            txt_salario.setText("R$ " + var_lista.RS.getString("Salario"));     
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros anteriores!", "Ultimo anterior", 1);
        }
        txt_chapa.requestFocus();
    }
    
    public void proximo(){
        try{   
            var_lista.RS.next();
            txt_chapa.setText(var_lista.RS.getString("Chapa"));
            txt_nome.setText(var_lista.RS.getString("Nome")); 
            txt_setor.setText(var_lista.RS.getString("Setor"));
            txt_salario.setText("R$ " + var_lista.RS.getString("Salario"));                
        }
        catch(SQLException e){
           showMessageDialog(this,"Não existem registros posteriores!", "Ultimo posterior", 1);
        }
        txt_chapa.requestFocus();
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
            java.util.logging.Logger.getLogger(Navegacao_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navegacao_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navegacao_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navegacao_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Navegacao_Funcionarios().setVisible(true);
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
    private javax.swing.JTextField txt_chapa;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_salario;
    private javax.swing.JTextField txt_setor;
    // End of variables declaration//GEN-END:variables
}
