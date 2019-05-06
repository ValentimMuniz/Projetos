package folha_de_pagamento;
import static javax.swing.JOptionPane.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Listar_Usuarios extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();
    
    FileWriter arq;
    PrintWriter gravarArq;
    int existe;
    int escolha = 0;
    String filename = File.separator+"tmp";
    public Listar_Usuarios(){
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTXT = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_usuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar/Salvar usuários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        tb_usuarios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tb_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "Nome", "Status", "É um admin?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_usuarios.setColumnSelectionAllowed(true);
        tb_usuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tb_usuarios);
        tb_usuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tb_usuarios.getColumnModel().getColumnCount() > 0) {
            tb_usuarios.getColumnModel().getColumn(0).setResizable(false);
            tb_usuarios.getColumnModel().getColumn(1).setResizable(false);
            tb_usuarios.getColumnModel().getColumn(2).setResizable(false);
            tb_usuarios.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Lista de usuários");

        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscaKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Buscar por nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 361, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTXT)
                    .addComponent(btnSair))
                .addGap(41, 41, 41))
        );

        setSize(new java.awt.Dimension(901, 354));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public static boolean isEmpty(JTable jTable){
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }
    
    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTXTActionPerformed
        if(isEmpty(tb_usuarios)){
            showMessageDialog(this,"Não existem usuários cadastrados no banco de dados!", "Sem usuários cadastrados", 1);
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
        String status;
        String ehadmin;
        String LinhaStatus;
        String LinhaAdmin;
        
        
        if(selFile == null){
            return;
        }
       
        try{
            
            File idea = new File(selFile + ".txt");
            if (idea.exists()){
                existe = showConfirmDialog(null, "Arquivo " + nome + ".txt já existe, deseja substituílo?",  "Deseja substituir?", YES_NO_CANCEL_OPTION);
                switch (existe) {
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

            var.RS= var.stmt.executeQuery("Select * from Tabela_Usuarios");

            while(var.RS.next()){
                status = var.RS.getString("Status");
                ehadmin = var.RS.getString("Perfil");
                if(status.equals("1")){
                    LinhaStatus = "Usuário está bloqueado";
                }else{
                    LinhaStatus = "Usuário não está bloqueado";
                }
                if(ehadmin.equals("1")){
                    LinhaAdmin = "Usuário é um administrador";
                }else{
                    LinhaAdmin = "Usuário não é um administrador";
                }
                gravarArq.printf("#UserID: "
                    + var.RS.getString("UserID")
                    + "\n #Nome -> "
                    + var.RS.getString("Nome")
                    + "\n #Status -> "
                    + LinhaStatus
                    + "\n #Perfil -> "
                    + LinhaAdmin      
                    + "\r\n %n" ); }

            arq.close();

            if(escolha == 1){
                showMessageDialog(this, "Arquivo" + nome + ".txt foi substituído", "Arquivo substituído", 2);
            }else{
                showMessageDialog(this, "Arquivo " + nome + ".txt da Tabela: Tabela_Usuarios foi gerado com sucesso!", "Arquivo gerado com sucesso", 1 );
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
        var.conecta();
        tb_usuarios.setAutoCreateRowSorter(true);
        tb_usuarios.requestFocus();
        DefaultTableModel Usuarios = (DefaultTableModel) tb_usuarios.getModel();
        String status;
        String ehadmin;
        String RowStatus;
        String RowAdmin;

        try{   
            var.RS = var.stmt.executeQuery("SELECT TOP 10 * FROM Tabela_Usuarios order by Nome");
            boolean existir = false;
            while(var.RS.next())
            {
                existir = true;
                status = var.RS.getString("Status");
                ehadmin = var.RS.getString("Perfil");
                
                if(status.equals("1")){
                    RowStatus = "Usuário está bloqueado";
                }else{
                    RowStatus = "Usuário não está bloqueado";
                }
                if(ehadmin.equals("1")){
                    RowAdmin = "Usuário é um administrador";
                  }
                  else{
                    RowAdmin = "Usuário não é um administrador";
                }
                Usuarios.addRow(new Object[]{
                    var.RS.getString("UserID"), 
                    var.RS.getString("Nome"),  
                    RowStatus,
                    RowAdmin,
                });   
            }
            if(!existir){
                showMessageDialog(this,"Não existem usuários cadastrados no banco de dados!", "Sem usuários cadastrados", 1);
            }   
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        } 
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

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        var.conecta();
        tb_usuarios.setAutoCreateRowSorter(true);
        DefaultTableModel Usuarios2 = (DefaultTableModel) tb_usuarios.getModel();
        Usuarios2.setRowCount(0);
        String statusbusca;
        String ehadminbusca; 
        String RowStatusbusca;
        String RowAdminbusca;
        String NomeBusca = null;
        NomeBusca = txtBusca.getText().trim().replaceAll("\\s+", " ");
        
        
        try{
            //var.RS = var.stmt.executeQuery("SELECT * FROM Tabela_Usuarios where Nome like '" + NomeBusca + "%' or Nome Like '%" + NomeBusca + "%' ");           
            PreparedStatement stmt = var.con.prepareStatement("SELECT * FROM Tabela_Usuarios where Nome like ? or Nome Like ?");
            stmt.setString(1, NomeBusca + "%");
            stmt.setString(2, "%" + NomeBusca + "%");
            var.RS = stmt.executeQuery();
            while(var.RS.next()){

                statusbusca = var.RS.getString("Status");
                ehadminbusca = var.RS.getString("Perfil");
                
                if(statusbusca.equals("1")){
                    RowStatusbusca = "Usuário está bloqueado";
                }else{
                    RowStatusbusca = "Usuário não está bloqueado";
                }
                if(ehadminbusca.equals("1")){
                    RowAdminbusca = "Usuário é um administrador";
                  }
                  else{
                    RowAdminbusca = "Usuário não é um administrador";
                }
                Usuarios2.addRow(new Object[]{
                    var.RS.getString("UserID"), 
                    var.RS.getString("Nome"),  
                    RowStatusbusca,
                    RowAdminbusca,
                });   
            }

        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_txtBuscaKeyReleased

  
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
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_usuarios;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
