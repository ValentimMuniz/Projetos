package folha_de_pagamento;
import java.awt.Color;
import java.sql.*;
import java.util.Random;
import static javax.swing.JOptionPane.*;

public class Controle_Usuarios extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();
    RotinasGlobais rt = new RotinasGlobais();
    public int eh_admin;
    public int UserIDConsulta = -1;
    public String Usuario = null;
    public int user_id;
    public Controle_Usuarios() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_adm = new javax.swing.ButtonGroup();
        botao_sim = new javax.swing.JRadioButton();
        botao_nao = new javax.swing.JRadioButton();
        txt_perg = new javax.swing.JTextField();
        txt_resp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        btnExlcuir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        progresso_senha = new javax.swing.JProgressBar();
        txt_senha = new javax.swing.JPasswordField();
        txt_repete = new javax.swing.JPasswordField();
        chk_show = new javax.swing.JCheckBox();
        btnSair = new javax.swing.JButton();
        txt_fullname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de usuários");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        botao_sim.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        botao_sim.setMnemonic('1');
        botao_sim.setText("Sim");

        botao_nao.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        botao_nao.setMnemonic('0');
        botao_nao.setText("Não");

        txt_perg.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_perg.setToolTipText("Digite a pergunta secreta");
        txt_perg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pergKeyTyped(evt);
            }
        });

        txt_resp.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_resp.setToolTipText("Digite a resposta secreta");
        txt_resp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_respKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Login");
        jLabel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Senha");
        jLabel2.setToolTipText("");

        btnCadastrar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Repita sua senha");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("Pergunta secreta");

        txt_login.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_login.setToolTipText("Digite o login");
        txt_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loginKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_loginKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("Resposta secreta");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Usuário é um admin?");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel7.setText("Controle de usuários");

        btnAlterar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExlcuir.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnExlcuir.setText("Excluir");
        btnExlcuir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExlcuirActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        progresso_senha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        progresso_senha.setForeground(new java.awt.Color(0, 0, 0));
        progresso_senha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        progresso_senha.setFocusable(false);
        progresso_senha.setOpaque(true);

        txt_senha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_senha.setToolTipText("Digite a senha");
        txt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_senhaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_senhaKeyTyped(evt);
            }
        });

        txt_repete.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_repete.setToolTipText("Repita a senha");
        txt_repete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_repeteKeyTyped(evt);
            }
        });

        chk_show.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        chk_show.setText("Mostrar senha");
        chk_show.setToolTipText("Mostrar senha");
        chk_show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_showMouseClicked(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txt_fullname.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txt_fullname.setToolTipText("Digite a pergunta secreta");
        txt_fullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fullnameKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("Nome Completo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCadastrar, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnExlcuir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSair))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_repete, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_login, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addComponent(txt_senha, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chk_show)
                                .addComponent(progresso_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel7)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(botao_sim)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botao_nao))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel4)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_perg)
                                .addComponent(txt_resp, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(txt_fullname)))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(progresso_senha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_repete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chk_show))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_perg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txt_resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_sim)
                    .addComponent(botao_nao)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExlcuir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpar)
                    .addComponent(btnSair))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(481, 421));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        var.conecta();
        try{
            String FullName = txt_fullname.getText().trim().replaceAll("\\s+", " ");
            String Login = txt_login.getText().trim().replaceAll("\\s+", " ");
            char[] Senha = txt_senha.getPassword();
            String strSenha = new String(Senha).trim().replaceAll("\\s+", " ");
            char[] Repete = txt_repete.getPassword();
            String strRepete = new String(Repete).trim().replaceAll("\\s+", " ");           
            String Perg = txt_perg.getText().trim().replaceAll("\\s+", " ");
            String Resp = txt_resp.getText().trim().replaceAll("\\s+", " ");   
            Random random = new Random();
            int ID = random.nextInt(10000001);  
               
            if(Login.equals("")){
                showMessageDialog(this,"Preencha o campo 'Login'", "Campo Vazio",2);
                txt_login.requestFocus();
                return;
            }
            if(strSenha.equals("")){
                showMessageDialog(this,"Preencha o campo 'Senha'", "Campo Vazio",2);
                txt_senha.requestFocus();
                return;
            }
            if(strRepete.equals("")){
                showMessageDialog(this,"Preencha o campo 'Repete Senha'", "Campo Vazio",2);
                txt_repete.requestFocus();
                return;
            }
            if(FullName.equals("")){
                showMessageDialog(this,"Preencha o campo 'Nome completo'", "Campo Vazio",2);
                txt_login.requestFocus();
                return;
            }
            if(Perg.equals("")){
                showMessageDialog(this,"Preencha o campo 'Pergunta Secreta'", "Campo Vazio",2);
                txt_perg.requestFocus();
                return;
            }
            if(Resp.equals("")){
                showMessageDialog(this,"Preencha o campo 'Resposta Secreta'", "Campo Vazio",2);
                txt_resp.requestFocus();
                return;
            }
            if(botao_sim.isSelected() || botao_nao.isSelected()){
                eh_admin = grupo_adm.getSelection().getMnemonic();
            }else{
                showMessageDialog(this,"Selecione a opção se é admin", "SELECIONE",2);
                return;
            }
            if(!strSenha.equals(strRepete)){
                showMessageDialog(this,"Senhas não conferem!", "Senhas diferentes",2);
                txt_senha.requestFocus();
                return;
            }
            if(Login.length() < 3){
                showMessageDialog(this,"Login muito curto, digite pelo menos 3 letras para um login válido", "Login curto",2);
                txt_login.requestFocus();
                return;
            }
            if (rt.checkPasswordStrength(strSenha) < 75){
                showMessageDialog(this,"Senha não é forte o suficiente, misture entre letras maiúsculas,minúsculas, números e caracteres especiais!", "Senha fraca/mediana",2);
                txt_senha.requestFocus();
                return;
            }
            if(!Login.matches("^[a-zA-Z0-9@. ]*$")){
                showMessageDialog(this, "Digite seu login sem caracteres especiais (exceto '@' e '.')", "Login inválido", 0);
                txt_login.setText("");
                txt_login.requestFocus();
                return;
            }
                         
            boolean consulta_usu = false;
            var.RS= var.stmt.executeQuery("select * from Tabela_Usuarios where Login = '" + Login + "'");
            while (var.RS.next()){
                consulta_usu = true;
            }
            if(!consulta_usu){   
                
                PreparedStatement stmt = var.con.prepareStatement("insert into Tabela_Usuarios (UserID,Login,Nome,Senha,perg_secreta,resp_secreta,Status,Perfil,cont_bloq) values (?,?,?,?,?,?,?,?,?)");
                stmt.setString(1, String.valueOf(ID));
                stmt.setString(2, Login);
                stmt.setString(3, FullName);
                stmt.setString(4, strSenha);
                stmt.setString(5, Perg);
                stmt.setString(6, Resp);
                stmt.setString(7, "0");
                stmt.setString(8, String.valueOf(eh_admin));
                stmt.setString(9, "0");
                stmt.execute();
                stmt.close();
                
                var.con.close();                
                showMessageDialog( this, "Usuário => " + Login + " cadastrado com sucesso!!", "Cadastrado com sucesso", 1);
                txt_login.requestFocus();
                limpar();
            }else{
                showMessageDialog(this,"Usuário => " + Login + " já cadastrado!", "Usuário ja cadastrado",2);
            }

            var.con.close();
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }

    }//GEN-LAST:event_btnCadastrarActionPerformed
    
    
    
    
    private void limpar(){
        UserIDConsulta = -1;
        Usuario = null;
        grupo_adm.clearSelection();
        txt_login.setText("");
        txt_senha.setText("");
        txt_repete.setText("");
        txt_resp.setText("");
        txt_perg.setText("");
        txt_fullname.setText("");
        txt_senha.setEchoChar('*');
        txt_repete.setEchoChar('*');
        chk_show.setSelected(false);
        txt_login.requestFocus();  
        progresso_senha.setStringPainted(true);    
        progresso_senha.setForeground(Color.lightGray); 
        progresso_senha.setBackground(Color.lightGray);
        progresso_senha.setString("");
        progresso_senha.setValue(0);
        btnCadastrar.setEnabled(true);
    }
    
    private void txt_loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loginKeyReleased
        /*
        txt_login.setText(txt_login.getText().replaceAll("[^A-Z | ^a-z | ^0-9@.]", ""));      
        String Login = txt_login.getText();
        
        if(!Login.matches("^[a-zA-Z0-9@.]*$"))
        {
            showMessageDialog(this, "Digite seu login sem caracteres especiais (exceto '@' e '.')", "Login inválido", 0);
            txt_login.requestFocus();
        }*/
       
    }//GEN-LAST:event_txt_loginKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        txt_login.requestFocus();
        grupo_adm.add(botao_sim);
        grupo_adm.add(botao_nao);        
        botao_sim.setMnemonic(1);
        botao_nao.setMnemonic(0);
        progresso_senha.setForeground(Color.lightGray);
        progresso_senha.setBackground(Color.lightGray);
        txt_senha.setTransferHandler(null);
        txt_senha.setDropTarget(null);
        txt_repete.setTransferHandler(null);
        txt_repete.setDropTarget(null);
    }//GEN-LAST:event_formWindowOpened

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

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
       var.conecta();
       String is_admin;
       try{
            while (UserIDConsulta == -1){
                Usuario = showInputDialog(this, "Digite o ID de usuário que você deseja consultar!", "Qual Id do usuário?", 3);
                UserIDConsulta = stringToInt(Usuario);
            }

            if(Usuario == null){
                UserIDConsulta = -1;
                return;         
            }
            boolean consultaID = false;
            var.RS = var.stmt.executeQuery("select * from Tabela_Usuarios where UserID = " + UserIDConsulta + " ");

            while(var.RS.next()){
                consultaID = true;
                user_id = Integer.parseInt(var.RS.getString("UserID").trim());
                is_admin = var.RS.getString("Perfil").trim();
                txt_login.setText(var.RS.getString("Login").trim());
                txt_fullname.setText(var.RS.getString("Nome").trim());
                txt_senha.setText(var.RS.getString("Senha").trim());
                txt_repete.setText(var.RS.getString("Senha").trim());
                txt_perg.setText(var.RS.getString("perg_secreta").trim());
                txt_resp.setText(var.RS.getString("resp_secreta").trim());
                if(is_admin.equals("1")){
                    botao_sim.setSelected(true);
                    botao_nao.setSelected(false);
                }else{
                    botao_sim.setSelected(false);
                    botao_nao.setSelected(true);
                }
                UserIDConsulta = -1;
                btnCadastrar.setEnabled(false);
            }
            if(!consultaID){
                showMessageDialog(this,"Id de usuário => " + UserIDConsulta + " não existe!", "UserID inválida", 1);
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
        char[] Senha = txt_senha.getPassword();
        String strSenha = new String(Senha);
        char[] Repete = txt_senha.getPassword();
        String strRepete = new String(Repete);       
        
        if(Usuario == null){
            showMessageDialog(this,"Consulte o usuário que deseja alterar primeiro!", "Consulte primeiro", 1);
            return;
        }
        if(!strSenha.equals(strRepete)){
            showMessageDialog(this,"Senhas não conferem!", "Senhas diferentes",2);
            txt_senha.requestFocus();
            return;
        }
        if(botao_sim.isSelected() || botao_nao.isSelected()){
            eh_admin = grupo_adm.getSelection().getMnemonic();
        }else{
            showMessageDialog(this,"Selecione a opção se é admin!", "SELECIONE",2);
            return;
        }
        if (rt.checkPasswordStrength(strSenha) < 50){
            showMessageDialog(this,"Senha não é forte o suficiente, misture entre letras maiúsculas,minúsculas, números e caracteres especiais!", "Senha fraca/mediana",2);
            txt_senha.requestFocus();
            return;
        }
        
        try{           
            String LoginAltera = txt_login.getText().trim();
            String FullNameAltera = txt_fullname.getText().trim();
            String PergAltera = txt_perg.getText().trim();
            String RespAltera = txt_resp.getText().trim();
            
            
            PreparedStatement stmt = var.con.prepareStatement("update Tabela_Usuarios set Login= ?,Nome = ?, Senha=?, perg_secreta=?, resp_secreta=?, Perfil=? where UserID = " + user_id + " ");   
            stmt.setString(1, LoginAltera);
            stmt.setString(2, FullNameAltera);
            stmt.setString(3, strSenha);
            stmt.setString(4, PergAltera);
            stmt.setString(5, RespAltera);
            stmt.setString(6, String.valueOf(eh_admin));  
    
            stmt.execute();
            stmt.close();
            var.con.close();                         
           
            showMessageDialog(this,"Usuário => " + LoginAltera + " alterado com sucesso!!", "Registo alterado", 1);
            limpar();         
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExlcuirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExlcuirActionPerformed
        var.conecta();
        if(Usuario == null){
            txt_login.requestFocus();
            showMessageDialog(this,"Consulte o usuário que deseja excluir primeiro!", "Consulte primeiro", 1);
            return;
        }
        try{
            int edit = var.stmt.executeUpdate("delete from Tabela_Usuarios where UserID = " + user_id + " ");
            if (edit!=0){
                showMessageDialog(this,"Usuário =>  " + txt_login.getText() + " excluido com sucesso!!", "Registo excluido", 1);
                limpar();
            }
            var.stmt.close();
            var.con.close();
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_btnExlcuirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void chk_showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_showMouseClicked
        if(chk_show.isSelected()){
            txt_senha.setEchoChar((char)0);
            txt_repete.setEchoChar((char)0);
        }
        else{
            txt_senha.setEchoChar('*');
            txt_repete.setEchoChar('*');
        }
    }//GEN-LAST:event_chk_showMouseClicked
    
    private void txt_senhaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyReleased
        char[] senha = txt_senha.getPassword();
        String strSenha = new String(senha);
                
        if(strSenha.isEmpty()){
            progresso_senha.setStringPainted(true);
            progresso_senha.setString("");
            progresso_senha.setForeground(Color.lightGray);
            progresso_senha.setBackground(Color.lightGray); 
            progresso_senha.setValue(0);
        }else{
                if (0 <= rt.checkPasswordStrength(strSenha) && rt.checkPasswordStrength(strSenha) <= 25)
                {
                    progresso_senha.setStringPainted(true); 
                    progresso_senha.setForeground(Color.red);
                    progresso_senha.setBackground(Color.red); 
                    progresso_senha.setString("SENHA FRACA");
                    progresso_senha.setValue(25);
                }
                if (26 <= rt.checkPasswordStrength(strSenha) && rt.checkPasswordStrength(strSenha) <= 50)
                {
                    progresso_senha.setStringPainted(true);
                    progresso_senha.setForeground(Color.orange); 
                    progresso_senha.setBackground(Color.orange);
                    progresso_senha.setString("SENHA MÉDIA");
                    progresso_senha.setValue(50);
                }
                if (51 <= rt.checkPasswordStrength(strSenha) && rt.checkPasswordStrength(strSenha) <= 75)
                {
                    progresso_senha.setStringPainted(true);
                    progresso_senha.setForeground(Color.blue);             
                    progresso_senha.setBackground(Color.blue);
                    progresso_senha.setString("SENHA BOA");
                    progresso_senha.setValue(75);
                }
                if (76 <= rt.checkPasswordStrength(strSenha) && rt.checkPasswordStrength(strSenha) <= 100)
                {
                    progresso_senha.setStringPainted(true);
                    progresso_senha.setForeground(Color.green); 
                    progresso_senha.setBackground(Color.green);
                    progresso_senha.setString("SENHA FORTE");
                    progresso_senha.setValue(100);
                }
            }
    }//GEN-LAST:event_txt_senhaKeyReleased

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

    private void txt_senhaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyTyped
        /* Setar o txt_senha(Senha) pra 10 caracteres apenas*/
        char[] senhaTyped = txt_senha.getPassword();
        String strSenhaTyped = new String(senhaTyped);
        if(strSenhaTyped.length() >= 10){
            evt.consume();
        }        
    }//GEN-LAST:event_txt_senhaKeyTyped

    private void txt_repeteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_repeteKeyTyped
        /* Setar o txt_repete(Repete Senha) pra 10 caracteres apenas*/
        char[] repeteTyped = txt_repete.getPassword();
        String strRepeteTyped = new String(repeteTyped);      
        if(strRepeteTyped.length() >= 10){
            evt.consume();
        }              
    }//GEN-LAST:event_txt_repeteKeyTyped

    private void txt_loginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loginKeyTyped
        /* Setar o txt_login(Login) pra 50 caracteres apenas*/
        String LoginTyped = txt_login.getText();
        if(LoginTyped.length() >= 50){
            evt.consume();
        }          
    }//GEN-LAST:event_txt_loginKeyTyped

    private void txt_pergKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pergKeyTyped
        /* Setar o txt_perg(Pegunta Secreta) pra 150 caracteres apenas*/
        String PergTyped = txt_perg.getText();
        if(PergTyped.length() >= 150){
            evt.consume();
        }   
    }//GEN-LAST:event_txt_pergKeyTyped

    private void txt_respKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_respKeyTyped
        /* Setar o txt_resp(Resposta Secreta) pra 10 caracteres apenas*/
        String RespTyped = txt_resp.getText();
        if(RespTyped.length() >= 150){
            evt.consume();
        } 
    }//GEN-LAST:event_txt_respKeyTyped

    private void txt_fullnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fullnameKeyTyped
       String NameTyped = txt_fullname.getText();
        if(NameTyped.length() >= 50){
            evt.consume();
        }    
    }//GEN-LAST:event_txt_fullnameKeyTyped
    

   private static int stringToInt(String string) {
        try{
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            if(string == null || string.equals("")){
                showMessageDialog(null,"Digite um UserID válido! ", "Digite um UserID", 1);
            }else{
                showMessageDialog(null,"Digite somente números para consultar a o UserID! ", "Somente números", 1);
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
            java.util.logging.Logger.getLogger(Controle_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Controle_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Controle_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Controle_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controle_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton botao_nao;
    private javax.swing.JRadioButton botao_sim;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExlcuir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSair;
    private javax.swing.JCheckBox chk_show;
    private javax.swing.ButtonGroup grupo_adm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JProgressBar progresso_senha;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_perg;
    private javax.swing.JPasswordField txt_repete;
    private javax.swing.JTextField txt_resp;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables


}
