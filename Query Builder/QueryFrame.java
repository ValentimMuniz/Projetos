package querybuilder;

import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;


public class QueryFrame extends javax.swing.JFrame {

    conexao_banco db = new conexao_banco();
    public QueryFrame() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        grupo_simnao = new javax.swing.ButtonGroup();
        btn_ok = new javax.swing.JButton();
        cmb_tabelas = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_query = new javax.swing.JTable();
        btn_limpar = new javax.swing.JButton();
        txt_comando = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_limit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmb_order = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        rd_sim = new javax.swing.JRadioButton();
        rd_nao = new javax.swing.JRadioButton();
        cmb_asc_desc = new javax.swing.JComboBox();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Query Builder");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btn_ok.setText("Executar");
        btn_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_okActionPerformed(evt);
            }
        });

        String sql = "SELECT table_name FROM information_schema.tables";
        this.db.conecta();
        this.grupo_simnao.add(rd_sim);
        this.grupo_simnao.add(rd_nao);
        this.cmb_asc_desc.setVisible(false);
        this.rd_sim.setMnemonic(1);
        this.rd_nao.setMnemonic(0);
        this.rd_nao.setSelected(true);
        DefaultComboBoxModel Tabelas = (DefaultComboBoxModel) this.cmb_tabelas.getModel();
        DefaultComboBoxModel Ordena = (DefaultComboBoxModel) this.cmb_order.getModel();
        try{
            this.db.RS= this.db.stmt.executeQuery(sql);
            ResultSetMetaData rsmd = this.db.RS.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (this.db.RS.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = this.db.RS.getString(i);
                    Tabelas.addElement(columnValue);
                }
            }
            if(this.rd_sim.isSelected()){
                this.db.RS = this.db.stmt.executeQuery("SELECT COLUMN_NAME FROM Base_FPagamento.INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + this.cmb_tabelas.getSelectedItem().toString() + "'");
                while (this.db.RS.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        String columnValue = this.db.RS.getString(i);
                        Ordena.addElement(columnValue);
                    }
                }
            }else if(this.rd_nao.isSelected()){
                this.cmb_order.removeAllItems();
                this.cmb_asc_desc.removeAllItems();
                this.cmb_asc_desc.setVisible(false);
                this.cmb_order.addItem("--------------------------");
            }

            this.db.RS.close();
            this.db.stmt.close();
            this.db.con.close();
        }
        catch(SQLException e){
            showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
        }
        cmb_tabelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tabelasActionPerformed(evt);
            }
        });

        tb_query.setAutoCreateRowSorter(true);
        tb_query.setAutoscrolls(false);
        tb_query.setEnabled(false);
        jScrollPane1.setViewportView(tb_query);

        btn_limpar.setText("Limpar");
        btn_limpar.setActionCommand("");
        btn_limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limparActionPerformed(evt);
            }
        });

        jLabel2.setText("Tabelas");

        jLabel3.setText("Digite seu comando SQL (SELECT)");

        txt_limit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_limitKeyTyped(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LIMIT");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ORDENAR ?");

        rd_sim.setText("Sim");
        rd_sim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_simMouseClicked(evt);
            }
        });

        rd_nao.setText("Não");
        rd_nao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rd_naoMouseClicked(evt);
            }
        });
        rd_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_naoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_comando, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmb_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_limit)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmb_order, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmb_asc_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rd_sim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rd_nao))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_limpar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(rd_sim)
                    .addComponent(rd_nao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_comando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_tabelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_limit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_asc_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ok)
                    .addComponent(btn_limpar))
                .addContainerGap(436, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(860, 705));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_okActionPerformed
        //DefaultTableModel Resultado = (DefaultTableModel) tb_query.getModel();
        DefaultComboBoxModel Tabelas = (DefaultComboBoxModel) cmb_tabelas.getModel();
        String sqlformat = null;
        db.conecta();
        String tabela = Tabelas.getSelectedItem().toString();
        String comando = txt_comando.getText().replaceAll("\\s+", " ");
        String limite = txt_limit.getText();    
        PreparedStatement stmt = null;
        if(comando.equals("")){
            showMessageDialog(this,"Digite sua query", "Campo Vazio",2);
            txt_comando.requestFocus();
            return;
        }/*
        if(!comando.matches("^[a-zA-Z0-9@*._]*$")){
                showMessageDialog(this, "Existem caracteres especiais ", "Query inválida", 0);
                //txt_comando.setText("");
                txt_comando.requestFocus();
                return;
        }*/
        //verificar se eh select
        if(Pattern.compile("SELECT .*").matcher(comando).find() || Pattern.compile("select .*").matcher(comando).find() || Pattern.compile("SELECT.*").matcher(comando).find() || Pattern.compile("select.*").matcher(comando).find())
        {     
            try{   
                String result = "";  
                stmt = db.con.prepareStatement("SELECT COLUMN_NAME FROM Base_FPagamento.INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + Tabelas.getSelectedItem().toString() + "'"); //PEGAR OS NOMES DAS COLUNAS         
                db.RS = stmt.executeQuery();
                ResultSetMetaData rsmd = db.RS.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                String [] ColumnName = new String[columnsNumber];
                while (db.RS.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        ColumnName[i -1] = db.RS.getString(i); //SALVAR NOME DAS COLUNAS NUMA STRING
                    }
                    
                    //IF PARA VER SE HÁ LIMITE
                    if(txt_limit.getText() == null || txt_limit.getText().equals("")){
                      sqlformat = comando + " " + tabela;
                      }else{
                          //System.out.println("Entrou if limit");
                          if(Pattern.compile("\\*").matcher(comando).find()){
                              for (int i = 1; i <= columnsNumber; i++) {
                                  result += ColumnName[i -1];
                                  result = result + ",";
                              }
                                sqlformat = comando;
                                sqlformat = sqlformat.replace("*", " TOP " + Integer.parseInt(limite) + " " + result.substring(0, result.length() -1) + " ");                          
                                sqlformat = sqlformat  + " " + tabela;
                          }else{
                                sqlformat = comando + " " + tabela;
                               }              
                          }      
                    }
               
                }catch(SQLException e){
                    JOptionPane.showMessageDialog(this, "Erro de sintaxe na query! Erro: " + e, "Erro ao executar a query", JOptionPane.ERROR_MESSAGE);
                }
            try{     
                if(rd_sim.isSelected()){
                    stmt = db.con.prepareStatement(sqlformat + " order by " + cmb_order.getSelectedItem().toString() + " " + cmb_asc_desc.getSelectedItem().toString());         
                }else if(rd_nao.isSelected()){
                    stmt = db.con.prepareStatement(sqlformat);       
                }
                                
                db.RS = stmt.executeQuery();                   
                tb_query.setModel(DbUtils.resultSetToTableModel(db.RS)); // COLOCAR VALORES DE LINHAS X COLUNAS NA TABELA       
                db.RS.close();
                db.stmt.close();
                db.con.close(); 
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this, "Erro de sintaxe na query! Erro: " + e, "Erro ao executar a query", JOptionPane.ERROR_MESSAGE);
            }
        }else{
           showMessageDialog(this, "Erro de sintaxe, use somente o comando Select!","Somente select",1);
        }            
    }//GEN-LAST:event_btn_okActionPerformed
    
 
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         txt_comando.requestFocus();
    }//GEN-LAST:event_formWindowOpened
  
   
    private void btn_limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limparActionPerformed
        DefaultTableModel Tabela = (DefaultTableModel) tb_query.getModel(); 
        Tabela.setColumnCount(0);
        txt_comando.setText("");
        txt_limit.setText("");
        grupo_simnao.clearSelection();
        rd_sim.setSelected(false);
        rd_nao.setSelected(true);
        cmb_order.removeAllItems();
        cmb_order.addItem("--------------------------");
        cmb_asc_desc.removeAllItems();
        cmb_asc_desc.setVisible(false);     
        txt_comando.requestFocus();
        int rowCount = Tabela.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            Tabela.removeRow(i);
        }
        
    }//GEN-LAST:event_btn_limparActionPerformed

    private void cmb_tabelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tabelasActionPerformed
        if(rd_sim.isSelected()){
            db.conecta();
            DefaultComboBoxModel Ordena = (DefaultComboBoxModel) cmb_order.getModel();  
            Ordena.removeAllElements();
            cmb_asc_desc.removeAllItems();
            cmb_asc_desc.addItem("ASC");
            cmb_asc_desc.addItem("DESC");
            cmb_asc_desc.setVisible(true);
            try{                   
                db.RS = db.stmt.executeQuery("SELECT COLUMN_NAME FROM Base_FPagamento.INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + cmb_tabelas.getSelectedItem().toString() + "'");
                ResultSetMetaData rsmd = db.RS.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (db.RS.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        String columnValue = db.RS.getString(i);     
                        Ordena.addElement(columnValue);
                    }    
                }
                db.RS.close();
                db.stmt.close();
                db.con.close(); 
            }
            catch(SQLException e){
                showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
            }
        }else if(rd_nao.isSelected()){
            cmb_order.removeAllItems();
            cmb_asc_desc.removeAllItems();
            cmb_asc_desc.setVisible(false);
            cmb_order.addItem("--------------------------");          
        }  
    }//GEN-LAST:event_cmb_tabelasActionPerformed

    private void txt_limitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_limitKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE){
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);         
            }else{
                showMessageDialog(this, "Digite somente números no campo 'Código'!","Somente números",1);
            }
            String Slimit = txt_limit.getText();
            txt_limit.setText(Slimit.trim());
            evt.consume();
        }
    }//GEN-LAST:event_txt_limitKeyTyped

    private void rd_naoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_naoMouseClicked
        cmb_order.removeAllItems();
        cmb_asc_desc.removeAllItems();
        cmb_asc_desc.setVisible(false);
        cmb_order.addItem("--------------------------");        
    }//GEN-LAST:event_rd_naoMouseClicked

    private void rd_simMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rd_simMouseClicked
        if(rd_sim.isSelected()){
            db.conecta();
            DefaultComboBoxModel Ordena = (DefaultComboBoxModel) cmb_order.getModel();  
            Ordena.removeAllElements();
            cmb_asc_desc.removeAllItems();
            cmb_asc_desc.addItem("ASC");
            cmb_asc_desc.addItem("DESC");
            cmb_asc_desc.setVisible(true);
            try{                   
                db.RS = db.stmt.executeQuery("SELECT COLUMN_NAME FROM Base_FPagamento.INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = '" + cmb_tabelas.getSelectedItem().toString() + "'");
                ResultSetMetaData rsmd = db.RS.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (db.RS.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        String columnValue = db.RS.getString(i);     
                        Ordena.addElement(columnValue);
                    }    
                }
                db.RS.close();
                db.stmt.close();
                db.con.close(); 
            }
            catch(SQLException e){
                showMessageDialog(this,"Não existem registros!", "Não existem registros", 1);
            }
        }else if(rd_nao.isSelected()){
            cmb_order.removeAllItems();
            cmb_asc_desc.removeAllItems();
            cmb_asc_desc.setVisible(false);
            cmb_order.addItem("--------------------------");          
        }  
    }//GEN-LAST:event_rd_simMouseClicked

    private void rd_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_naoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_naoActionPerformed

    
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
            java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QueryFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QueryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_limpar;
    private javax.swing.JButton btn_ok;
    private javax.swing.JComboBox cmb_asc_desc;
    private javax.swing.JComboBox cmb_order;
    private javax.swing.JComboBox cmb_tabelas;
    private javax.swing.ButtonGroup grupo_simnao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd_nao;
    private javax.swing.JRadioButton rd_sim;
    private javax.swing.JTable tb_query;
    private javax.swing.JTextField txt_comando;
    private javax.swing.JTextField txt_limit;
    // End of variables declaration//GEN-END:variables
}
