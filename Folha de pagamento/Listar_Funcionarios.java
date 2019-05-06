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

public class Listar_Funcionarios extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();    
    FileWriter arq;
    PrintWriter gravarArq;
    int existe;
    int escolha = 0;
    String filename = File.separator+"tmp";
    
    public Listar_Funcionarios() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTXT = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_funcionarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Listar/Salvar funcionários");
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

        tb_funcionarios.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tb_funcionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chapa", "Nome", "Setor", "Salario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_funcionarios.setColumnSelectionAllowed(true);
        tb_funcionarios.getTableHeader().setReorderingAllowed(false);
        tb_funcionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_funcionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_funcionarios);
        tb_funcionarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tb_funcionarios.getColumnModel().getColumnCount() > 0) {
            tb_funcionarios.getColumnModel().getColumn(0).setResizable(false);
            tb_funcionarios.getColumnModel().getColumn(1).setResizable(false);
            tb_funcionarios.getColumnModel().getColumn(2).setResizable(false);
            tb_funcionarios.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel1.setText("Lista de funcionários");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTXT)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(540, 322));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public static boolean isEmpty(JTable jTable) {
        if (jTable != null && jTable.getModel() != null) {
            return jTable.getModel().getRowCount()<=0?true:false;
        }
        return false;
    }
    
    private void btnTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTXTActionPerformed
        if(isEmpty(tb_funcionarios)){
            showMessageDialog(this,"Não existem funcionários cadastrados no banco de dados!", "Sem funcionários cadastrados", 1);
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
        try{
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

            var.RS= var.stmt.executeQuery("Select * from Tabela_Funcionarios");
            while(var.RS.next()){          
                gravarArq.printf("#Chapa: "
                    + var.RS.getString("Chapa")
                    + "\n #Nome -> "
                    + var.RS.getString("Nome")
                    + "\n #Setor -> "
                    + var.RS.getString("Setor")
                    + "\n #Salário -> "
                    + var.RS.getString("Salario")
                    + "\r\n %n" ); }
            arq.close();

            if(escolha == 1){
                showMessageDialog(this, "Arquivo" + nome + ".txt foi substituído", "Arquivo substituído", 2);
            }else{
                showMessageDialog(this, "Arquivo " + nome + ".txt da Tabela: Tabela_Funcionarios foi gerado com sucesso!", "Arquivo gerado com sucesso", 1 );
            }
            escolha = 0;
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }catch (IOException ex){
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
        tb_funcionarios.setAutoCreateRowSorter(true);
        tb_funcionarios.requestFocus();
        DefaultTableModel Funcionarios = (DefaultTableModel) tb_funcionarios.getModel();
            
        try{   
            var.RS = var.stmt.executeQuery("SELECT TOP 10 * FROM Tabela_Funcionarios order by Nome");
            boolean existir = false;
            while(var.RS.next()){
                existir = true; 
                Funcionarios.addRow(new Object[]{
                    var.RS.getString("Chapa"), 
                    var.RS.getString("Nome"),  
                    var.RS.getString("Setor"),
                    "R$ " + var.RS.getString("Salario"),
                });   
            }
            if(!existir){
                showMessageDialog(this,"Não existem funcionários cadastrados no banco de dados!", "Sem funcionários", 1);
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

    private void tb_funcionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_funcionariosMouseClicked
        if (evt.getClickCount() == 2){
            int linha = tb_funcionarios.getSelectedRow();
            String chapafunc = tb_funcionarios.getValueAt(linha, 0).toString(); 
            String nomefunc = tb_funcionarios.getValueAt(linha, 1).toString();   
            String setorfunc = tb_funcionarios.getValueAt(linha, 2).toString();   
            String salariofunc = tb_funcionarios.getValueAt(linha, 3).toString();  
            showMessageDialog(this, "Funcionário -> " + nomefunc + ", Chapa -> " + chapafunc + ", Setor -> " + setorfunc + ", Salário -> " + salariofunc, "Informação", 1);
        }
    }//GEN-LAST:event_tb_funcionariosMouseClicked

    private void txtBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyReleased
        var.conecta();
        tb_funcionarios.setAutoCreateRowSorter(true);
        DefaultTableModel Funcionarios2 = (DefaultTableModel) tb_funcionarios.getModel();
        Funcionarios2.setRowCount(0); 
        String NomeBusca = null;
        NomeBusca = txtBusca.getText().trim().replaceAll("\\s+", " ");
        try{   
            //var.RS = var.stmt.executeQuery("SELECT * FROM Tabela_Funcionarios where Nome like '" + NomeBusca + "%' or Nome Like '%" + NomeBusca + "%' ");
            
            PreparedStatement stmt = var.con.prepareStatement("SELECT * FROM Tabela_Funcionarios where Nome like ? or Nome Like ?");
            stmt.setString(1, NomeBusca + "%");
            stmt.setString(2, "%" + NomeBusca + "%");
            var.RS = stmt.executeQuery();
            while(var.RS.next()){
               
                Funcionarios2.addRow(new Object[]{
                    var.RS.getString("Chapa"), 
                    var.RS.getString("Nome"),  
                    var.RS.getString("Setor"),
                    "R$ " + var.RS.getString("Salario"),
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
            java.util.logging.Logger.getLogger(Listar_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listar_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listar_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listar_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listar_Funcionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_funcionarios;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
