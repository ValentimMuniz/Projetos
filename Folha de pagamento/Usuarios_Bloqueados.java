package folha_de_pagamento;

import java.sql.*;
import static javax.swing.JOptionPane.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Usuarios_Bloqueados extends javax.swing.JFrame {
    conexao_banco var = new conexao_banco();
    public Usuarios_Bloqueados() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDesbloq = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_bloqueados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuários Bloqueados");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnDesbloq.setText("Desbloquear");
        btnDesbloq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloqActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        Tabela_bloqueados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Tabela_bloqueados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Login", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela_bloqueados.setColumnSelectionAllowed(true);
        Tabela_bloqueados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Tabela_bloqueados);
        Tabela_bloqueados.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (Tabela_bloqueados.getColumnModel().getColumnCount() > 0) {
            Tabela_bloqueados.getColumnModel().getColumn(0).setResizable(false);
            Tabela_bloqueados.getColumnModel().getColumn(1).setResizable(false);
            Tabela_bloqueados.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Usuários Bloqueados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnDesbloq)
                        .addGap(18, 18, 18)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesbloq)
                    .addComponent(btnSair))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(428, 306));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public static boolean isEmpty(JTable jTable){
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }
    
    private void btnDesbloqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloqActionPerformed
        if(isEmpty(Tabela_bloqueados)){
            showMessageDialog(this, "Não tem usuários bloqueados!","Sem usuários bloqueados", 2);
            return; //Não tem nada selecionado
        }
        
        int selecionada = Tabela_bloqueados.getSelectedRow();
        if (selecionada == -1){
            showMessageDialog(this,"Selecione o usuários que você deseja desbloquear!", "Selecione o usuário", 1);
            return; //Não tem nada selecionado
        }
        
        var.conecta();
        DefaultTableModel Bloq = (DefaultTableModel) Tabela_bloqueados.getModel();     
        String id_usu = Tabela_bloqueados.getValueAt(selecionada, 0).toString();

        try{
            int Linhas = var.stmt.executeUpdate("update Tabela_Usuarios set Status='0',cont_bloq ='0' where UserID = " + id_usu + " ");

            if (Linhas!=0){
                showMessageDialog(this,"Usuario = " + id_usu + " foi desbloqueado", "Usuario desbloqueado", 1);
                Bloq.removeRow(selecionada);
            }
            var.stmt.close();
            var.con.close();
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnDesbloqActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
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
    }//GEN-LAST:event_btnSairActionPerformed
    
    public void carrega_bloqueados(){    
        var.conecta();
        Tabela_bloqueados.setAutoCreateRowSorter(true);
        DefaultTableModel Usuarios = (DefaultTableModel) Tabela_bloqueados.getModel();
        try{   
            var.RS = var.stmt.executeQuery("select * from Tabela_Usuarios where Status = '1'");
            boolean existe = false;
            while(var.RS.next()){
                existe = true;
                Usuarios.addRow(new Object[]{var.RS.getString("UserID"), 
                var.RS.getString("Nome"),
                var.RS.getString("Status") + " - bloqueado"});   
            }
            if(!existe){
                showMessageDialog(this, "Não tem usuários bloqueados!","Sem usuários bloqueados", 2);
            }   
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        } 
    }
     
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carrega_bloqueados();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = showConfirmDialog(null, "Deseja realmente sair ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair){
            case YES_OPTION:
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes
                break;
            case CANCEL_OPTION:
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel
                break;
            default:
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//no
                break;
        }
    }//GEN-LAST:event_formWindowClosing

    
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
            java.util.logging.Logger.getLogger(Usuarios_Bloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usuarios_Bloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usuarios_Bloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usuarios_Bloqueados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usuarios_Bloqueados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela_bloqueados;
    private javax.swing.JButton btnDesbloq;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
