package folha_de_pagamento;
import java.awt.event.KeyEvent;
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Controle_Vencimentos extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();
    public int Codigo = -1;
    public String SCodigo = null;
    
    public Controle_Vencimentos() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cod = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_desc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_quant = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        txt_valor = new javax.swing.JTextField();
        btnSair = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de vencimentos");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Descrição");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Quantidade");

        txt_cod.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_cod.setToolTipText("Digite o código");
        txt_cod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Valor");

        txt_desc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_desc.setToolTipText("Digite a descrição");
        txt_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setText("Controle de vencimentos");

        txt_quant.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_quant.setToolTipText("Digite a quantidade");
        txt_quant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_quantKeyTyped(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txt_valor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_valor.setToolTipText("Digite o valor");
        txt_valor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_valorKeyTyped(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnAlterar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_desc)
                                    .addComponent(txt_quant)
                                    .addComponent(txt_cod)
                                    .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_quant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCadastrar)
                            .addComponent(btnConsultar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAlterar)
                            .addComponent(btnExcluir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSair)
                        .addContainerGap())))
        );

        setSize(new java.awt.Dimension(529, 361));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        var.conecta();
        if(SCodigo == null){
            showMessageDialog(this,"Consulte o código de vencimento que deseja excluir primeiro!", "Consulte primeiro", 1);
            txt_cod.requestFocus();
            return;
        }
        try{
            int edit = var.stmt.executeUpdate("delete from Tabela_Vencimentos where Codigo_venc = "  + txt_cod.getText() + " ");
            if (edit!=0){
                showMessageDialog(this,"Código de vencimento =>  " + txt_cod.getText() + " excluido com sucesso!!", "Registo excluido", 1);
                limpar();
            }
            var.stmt.close();
            var.con.close();
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txt_codKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE){
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);         
            }else{
                showMessageDialog(this, "Digite somente números no campo 'Código'!","Somente números",1);
            }
            String SCod = txt_cod.getText();
            txt_cod.setText(SCod.trim());
            evt.consume();
        }
    }//GEN-LAST:event_txt_codKeyTyped

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txt_valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_valorKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE){
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);         
            }else{
                showMessageDialog(this, "Digite somente números no campo 'Quantidade'!","Somente números",1);
            }
            String SValor = txt_valor.getText();
            txt_valor.setText(SValor.trim());
            evt.consume();
        }

        /*Caso queira pegar somente os numeros de uma string
        String str= txt_salario.getText();
        String numberOnly= str.replaceAll("[^0-9]", "");

        System.out.print(numberOnly);*/
    }//GEN-LAST:event_txt_valorKeyTyped

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int sair = showConfirmDialog(null, "Deseja realmente sair desta tela?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
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

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        var.conecta();
        try{
            String CodCadastra = txt_cod.getText().trim().replaceAll("\\s+", " ");
            String DescCadastra = txt_desc.getText().trim().replaceAll("\\s+", " ");
            String ValorCadastra = txt_valor.getText().trim().replaceAll("\\s+", " ");
            String QuantCadastra = txt_quant.getText().trim().replaceAll("\\s+", " ");

            if(CodCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Código'", "Campo Vazio",2);
                txt_cod.requestFocus();
                return;
            }
            if(DescCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Descrição'", "Campo Vazio",2);
                txt_desc.requestFocus();
                return;
            }
            if(QuantCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Quantidade'", "Campo Vazio",2);
                txt_valor.requestFocus();
                return;
            }
            if(ValorCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Valor'", "Campo Vazio",2);
                txt_quant.requestFocus();
                return;
            }

            boolean consulta_func = false;
            var.RS= var.stmt.executeQuery("select * from Tabela_Vencimentos where Codigo_venc = " + CodCadastra + " ");
            while (var.RS.next()){
                consulta_func = true;
            }
            if(!consulta_func){
                PreparedStatement stmt = var.con.prepareStatement("insert into Tabela_Vencimentos (Codigo_venc,Descricao,Quantidade,Valor) values (?,?,?,?)");
                stmt.setString(1, CodCadastra);
                stmt.setString(2, DescCadastra);
                stmt.setString(3, QuantCadastra);
                stmt.setString(4, ValorCadastra);

                stmt.execute();
                stmt.close();
                var.con.close();
                showMessageDialog( this, "Código de vencimento => " + CodCadastra + " cadastrado com sucesso!!", "Cadastrado com sucesso", 1);
                limpar();
            }else{
                showMessageDialog(this,"Código de vencimento => " + CodCadastra + " já cadastrado!", "Código já cadastrado",2);
            }

            var.con.close();
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        var.conecta();
            try{
                while (Codigo == -1) {
                    SCodigo = showInputDialog(this, "Digite o código de vencimento que você deseja consultar", "Qual o código de vencimento?", 3);
                    Codigo = stringToInt(SCodigo);
                }
                
                if(SCodigo == null){
                    Codigo = -1;
                    return;
                }
                
                boolean consultaChapa = false;
                var.RS = var.stmt.executeQuery("select * from Tabela_Vencimentos where Codigo_venc = " + Codigo + " ");

                while(var.RS.next()){
                    consultaChapa = true;
                    txt_cod.setText(var.RS.getString("Codigo_venc"));
                    txt_desc.setText(var.RS.getString("Descricao"));
                    txt_quant.setText(var.RS.getString("Quantidade"));
                    txt_valor.setText(var.RS.getString("Valor"));
                    btnCadastrar.setEnabled(false);
                    Codigo = -1;
                }
                if(!consultaChapa){
                    showMessageDialog(this,"Código de vencimento => " + Codigo + " não existe!", "Código inválido", 1);
                    limpar();
                }
                var.stmt.close();
                var.con.close();
            }
            catch( SQLException e){
                showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
            }    
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        var.conecta();     
        
        if(SCodigo == null){
            showMessageDialog(this,"Consulte o código de vencimento que deseja alterar primeiro!", "Consulte primeiro", 1);
            return;
        }
        try{
            String CodAltera = txt_cod.getText().trim();
            String DescAltera = txt_desc.getText().trim();
            String QuantAltera = txt_quant.getText().trim();
            String ValorAltera = txt_valor.getText().trim();
            
            
            PreparedStatement stmt = var.con.prepareStatement("update Tabela_Vencimentos set Codigo_venc = ?, Descricao=?, Quantidade=?, Valor=? where Codigo_venc = " + CodAltera + " ");   
            stmt.setString(1, CodAltera);
            stmt.setString(2, DescAltera);
            stmt.setString(3, QuantAltera);
            stmt.setString(4, ValorAltera);

            stmt.execute();
            stmt.close();
            var.con.close();  
            
            showMessageDialog(this,"Código de vencimento => " + CodAltera + " alterado com sucesso!!", "Registo alterado", 1);
            limpar();           
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void txt_quantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE)
            {
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);         
            }else{
                showMessageDialog(this, "Digite somente números no campo 'Quantidade'!","Somente números",1);
            }
            String SQuant = txt_quant.getText();
            txt_quant.setText(SQuant.trim());
            evt.consume();
        }
    }//GEN-LAST:event_txt_quantKeyTyped

    private void txt_descKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descKeyTyped
        /* Setar o txt_desc(Decrição) pra 50 caracteres apenas*/
        String DescTyped = txt_desc.getText();
        if(DescTyped.length() >= 50){
            evt.consume();
        } 
    }//GEN-LAST:event_txt_descKeyTyped

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

     public void limpar(){
        txt_cod.requestFocus();
        Codigo = -1;
        SCodigo = null;
        txt_cod.setText("");
        txt_desc.setText("");
        txt_quant.setText("");
        txt_valor.setText("");
        btnCadastrar.setEnabled(true);
    }
    
    private static int stringToInt(String string) {
        try{
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            if(string == null || string.equals("")){
                showMessageDialog(null,"Digite uma código de vencimento válido! ", "Digite um código válido", 1);
            }else{
                showMessageDialog(null,"Digite somente números para consultar o código de vencimento! ", "Somente números", 1);
            }          
            return -1;
        }   
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
            java.util.logging.Logger.getLogger(Controle_Vencimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controle_Vencimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controle_Vencimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controle_Vencimentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controle_Vencimentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_cod;
    private javax.swing.JTextField txt_desc;
    private javax.swing.JTextField txt_quant;
    private javax.swing.JTextField txt_valor;
    // End of variables declaration//GEN-END:variables
}
