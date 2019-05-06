package folha_de_pagamento;
import java.awt.event.KeyEvent;
import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Controle_Funcionarios extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();
    public int Chapa = -1;
    public String NomeFunc = null;
    
    public Controle_Funcionarios() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_chapa = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_setor = new javax.swing.JTextField();
        txt_salario = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de funcionários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        txt_chapa.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_chapa.setToolTipText("Chapa");
        txt_chapa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_chapaKeyTyped(evt);
            }
        });

        txt_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nome.setToolTipText("Nome");
        txt_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nomeKeyTyped(evt);
            }
        });

        txt_setor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_setor.setToolTipText("Setor");
        txt_setor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_setorKeyTyped(evt);
            }
        });

        txt_salario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_salario.setToolTipText("Salário");
        txt_salario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_salarioKeyTyped(evt);
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

        btnExcluir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Chapa");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Setor");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Salário");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel5.setText("Controle de funcionários");

        btnLimpar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

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
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(9, 9, 9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nome)
                                    .addComponent(txt_setor)
                                    .addComponent(txt_chapa)
                                    .addComponent(txt_salario, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 93, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_chapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

        setSize(new java.awt.Dimension(512, 373));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        var.conecta();      
        Object[] Opcoes = {"Chapa", "Nome"};
	int consultar = showOptionDialog(null,"Você deseja consultar por qual método ?","Consulta de funcionário",0, 3,null,Opcoes,Opcoes[0]);
        if(consultar == 0){
            try{
                while (Chapa == -1){
                    NomeFunc = showInputDialog(this, "Digite a chapa do funcionário que você deseja consultar", "Qual a chapa do funcionário?", 3);
                    Chapa = stringToInt(NomeFunc);
                }

                if(NomeFunc == null){
                    Chapa = -1;
                    return;         
                }
                boolean consultaChapa = false;
                var.RS = var.stmt.executeQuery("select * from Tabela_Funcionarios where Chapa = " + Chapa + "");
                
                while(var.RS.next()){
                    consultaChapa = true;
                    txt_chapa.setText(var.RS.getString("Chapa"));
                    txt_nome.setText(var.RS.getString("Nome"));
                    txt_setor.setText(var.RS.getString("Setor"));
                    txt_salario.setText(var.RS.getString("Salario"));   
                    btnCadastrar.setEnabled(false);
                    Chapa = -1;                   
                }
                if(!consultaChapa){
                    showMessageDialog(this,"Chapa => " + Chapa + " não existe!", "UserID inválida", 1);
                    limpar();
                }
                var.stmt.close();
                var.con.close();
            }  
            catch( SQLException e){
                showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
            }
        }
        else{           
            try{
                String func2 = null;
                do{
                    NomeFunc = showInputDialog(this, "Digite o nome de funcionário que você deseja consultar", "Qual nome do funcionário?", 3);
                    if(NomeFunc == null){
                        showMessageDialog(this,"Funcionário Inválido!", "Funcionário Inválido", 1);    
                        return;
                    }
                    if(NomeFunc.matches("^[a-zA-Z ]*$")){
                        func2 = NomeFunc;   
                    }else{
                        showMessageDialog(this,"Digite o nome sem caracteres especiais (exceto '@' e '.')", "Funcionário inválido", 1);
                    }
                }   while (!NomeFunc.matches("^[a-zA-Z ]*$"));
                
                if(NomeFunc == null){
                    showMessageDialog(this,"Funcionário Inválido!", "Funcionário Inválido", 1);    
                    return;
                }
                
                boolean consultaNome = false;
                var.RS = var.stmt.executeQuery("select * from Tabela_Funcionarios where Nome = '" + func2 +"'");
                while(var.RS.next()){
                    consultaNome = true;
                    txt_chapa.setText(var.RS.getString("Chapa").trim());
                    txt_nome.setText(var.RS.getString("Nome").trim());
                    txt_setor.setText(var.RS.getString("Setor").trim());
                    txt_salario.setText(var.RS.getString("Salario").trim());
                    btnCadastrar.setEnabled(false);
                    Chapa = -1;                    
                }
                if(!consultaNome){
                    showMessageDialog(this,"Funcionário => " + NomeFunc + " não existe!", "Funcionário inválido", 1);
                    limpar();
                }
                var.stmt.close();
                var.con.close();
                
            }
            catch( SQLException e){
                showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
            }
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        var.conecta();   
        try{
            String ChapaCadastra = txt_chapa.getText().trim().replaceAll("\\s+", " ");
            String NomeCadastra = txt_nome.getText().trim().replaceAll("\\s+", " ");
            String SalarioCadastra = txt_salario.getText().trim().replaceAll("\\s+", " ");
            String SetorCadastra = txt_setor.getText().trim().replaceAll("\\s+", " ");

            if(ChapaCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Chapa'", "Campo Vazio",2);
                txt_chapa.requestFocus();
                return;
            }
            if(NomeCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Nome'", "Campo Vazio",2);
                txt_nome.requestFocus();
                return;
            }
            if(SetorCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Setor'", "Campo Vazio",2);
                txt_setor.requestFocus();
                return;
            }
            if(SalarioCadastra.equals("")){
                showMessageDialog(this,"Preencha o campo 'Salário'", "Campo Vazio",2);
                txt_salario.requestFocus();
                return;
            }                      
            if(!NomeCadastra.matches("^[a-zA-Z ]*$")){
                showMessageDialog(this, "Digite o nome do funcionário sem caracteres especiais ou números", "Login inválido", 0);
                txt_nome.setText("");
                txt_nome.requestFocus();
                return;
            }
           

            boolean consulta_func = false;
            var.RS= var.stmt.executeQuery("select * from Tabela_Funcionarios where Chapa=" + ChapaCadastra + "");
            while (var.RS.next()){
                consulta_func = true;
            }
            if(!consulta_func){
                PreparedStatement stmt = var.con.prepareStatement("insert into Tabela_Funcionarios (Chapa,Nome,Setor,Salario) values (?,?,?,?)");   
                stmt.setString(1, ChapaCadastra);
                stmt.setString(2, NomeCadastra);
                stmt.setString(3, SetorCadastra);
                stmt.setString(4, SalarioCadastra);
               
                stmt.execute();
                stmt.close();
                var.con.close();                        
                showMessageDialog( this, "Funcionário => " + NomeCadastra + " cadastrado com sucesso!!", "Cadastrado com sucesso", 1);
                limpar();
            }else{
                showMessageDialog(this,"Chapa => " + ChapaCadastra + " já cadastrada!", "Chapa já cadastrada",2);
            }

            var.con.close();
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        var.conecta();          
        if(NomeFunc == null){
            showMessageDialog(this,"Consulte o funcionário que deseja alterar primeiro!", "Consulte primeiro", 1);
            return;
        }
        try{
            String NomeAltera = txt_nome.getText().trim();
            String ChapaAltera = txt_chapa.getText().trim();
            String SetorAltera = txt_setor.getText().trim();
            String SalarioAltera = txt_salario.getText().trim();
            
            
            PreparedStatement stmt = var.con.prepareStatement("update Tabela_Funcionarios set Chapa = ?, Nome=?, Setor=?, Salario=? where Chapa =" + ChapaAltera + "");   
            stmt.setString(1, ChapaAltera);
            stmt.setString(2, NomeAltera);
            stmt.setString(3, SetorAltera);
            stmt.setString(4, SalarioAltera);

            stmt.execute();
            stmt.close();
            var.con.close();  
            
            showMessageDialog(this,"Funcionário => " + NomeAltera + " alterado com sucesso!!", "Registo alterado", 1);
            limpar();
            
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        var.conecta();
        if(NomeFunc == null){
            showMessageDialog(this,"Consulte o funcionário que deseja excluir primeiro!", "Consulte primeiro", 1);
            txt_chapa.requestFocus();
            return;
        }
        try{
            int edit = var.stmt.executeUpdate("delete from Tabela_Funcionarios where Chapa = " + txt_chapa.getText() + "");
            if (edit!=0){
                showMessageDialog(this,"Funcionário =>  " + txt_nome.getText() + " excluido com sucesso!!", "Registo excluido", 1);
                limpar();
            }
            var.stmt.close();
            var.con.close();
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = showConfirmDialog(null, "Deseja realmente sair desta tela ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
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

    private void txt_chapaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_chapaKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE){
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);     
            }else{
                showMessageDialog(this, "Digite somente números no campo 'Chapa'!","Somente números",1);
            }
            String SChapa = txt_chapa.getText();
            txt_chapa.setText(SChapa.trim());            
            evt.consume();
        }
    }//GEN-LAST:event_txt_chapaKeyTyped

    private void txt_salarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_salarioKeyTyped
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"") && evt.getKeyChar() != KeyEvent.VK_BACK_SPACE && evt.getKeyChar() != KeyEvent.VK_ENTER && evt.getKeyChar() != KeyEvent.VK_DELETE ){
            if(evt.getKeyChar() == KeyEvent.VK_SPACE){
                showMessageDialog(this, "Digite somente números (Sem espaço)!","Somente números",0);        
            }else{
                showMessageDialog(this, "Digite somente números no campo 'Salario'!","Somente números",1);
            }
            String SSalario = txt_salario.getText();
            txt_salario.setText(SSalario.trim());             
            evt.consume();
        }
        
        /*Caso queira pegar somente os numeros de uma string
        String str= txt_salario.getText();
        String numberOnly= str.replaceAll("[^0-9]", "");
        
        System.out.print(numberOnly);*/
    }//GEN-LAST:event_txt_salarioKeyTyped

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txt_chapa.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void txt_nomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomeKeyTyped
        /* Setar o txt_nome(Nome) pra 50 caracteres apenas*/
        String NomeTyped = txt_nome.getText();
        if(NomeTyped.length() >= 50){
            evt.consume();
        } 
    }//GEN-LAST:event_txt_nomeKeyTyped

    private void txt_setorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_setorKeyTyped
        /* Setar o txt_setor(Setor) pra 50 caracteres apenas*/
        String SetorTyped = txt_setor.getText();
        if(SetorTyped.length() >= 50){
            evt.consume();
        } 
    }//GEN-LAST:event_txt_setorKeyTyped

    public void limpar(){
        txt_chapa.requestFocus();
        Chapa = -1;
        NomeFunc = null;
        txt_chapa.setText("");
        txt_nome.setText("");
        txt_setor.setText("");
        txt_salario.setText("");
        btnCadastrar.setEnabled(true);
    }
    
    private static int stringToInt(String string) {
        try{
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e){
            if(string == null || string.equals("")){
                showMessageDialog(null,"Digite uma chapa válida! ", "Digite uma chapa válida", 1);
            }else{
                showMessageDialog(null,"Digite somente números para consultar a chapa! ", "Somente números", 1);
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
            java.util.logging.Logger.getLogger(Controle_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controle_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controle_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controle_Funcionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controle_Funcionarios().setVisible(true);
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
    private javax.swing.JTextField txt_chapa;
    private javax.swing.JTextField txt_nome;
    private javax.swing.JTextField txt_salario;
    private javax.swing.JTextField txt_setor;
    // End of variables declaration//GEN-END:variables
}
