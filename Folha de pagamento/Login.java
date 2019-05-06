package folha_de_pagamento;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JDialog;
import static javax.swing.JOptionPane.*;
import javax.swing.UIManager;

public class Login extends javax.swing.JFrame {
    public int UserID; 
    
    public int getUserID() {
        return this.UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    
    

    conexao_banco var = new conexao_banco();
    RotinasGlobais rt = new RotinasGlobais();
    Menu menu2 = new Menu();
    
    public Login() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lbl_esqueceu = new javax.swing.JLabel();
        txt_login = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login administrativo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setText("Login Administrativo");

        btnLogar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnLogar.setText("Logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lbl_esqueceu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbl_esqueceu.setText("Esqueci minha senha");
        lbl_esqueceu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbl_esqueceu.setName(""); // NOI18N
        lbl_esqueceu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_esqueceuMouseClicked(evt);
            }
        });

        txt_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_loginKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_loginKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Senha");

        txt_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_senhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnLogar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1)))
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_esqueceu)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogar)
                    .addComponent(btnSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(lbl_esqueceu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(381, 303));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        logar();
    }//GEN-LAST:event_btnLogarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void lbl_esqueceuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_esqueceuMouseClicked
        var.conecta();
        String nome;
        try{
            do{
                nome = showInputDialog(this, "Qual seu nome de usuário?", "Qual seu nome?", 3);
                if(nome == null){
                    return;
                }
                if(!nome.matches("^[a-zA-Z0-9@. ]*$")){
                    showMessageDialog(this, "Digite seu login sem caracteres especiais (exceto '@' e '.')", "Login inválido", 0);
                }
            }while(!nome.matches("^[a-zA-Z0-9@. ]*$"));
          
            var.RS= var.stmt.executeQuery("select * from Tabela_Usuarios where Login='" + nome +"'");
      
            boolean linhas = false;
            
            while (var.RS.next()){
                linhas = true;
                String perg = var.RS.getString("perg_secreta");
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.minimumSize",new Dimension(350,200));
                UIManager.put("OptionPane.background", Color.gray);
                UIManager.put("Panel.background", Color.lightGray);
                UIManager.put("OptionPane.errorDialog.titlePane.foreground", Color.lightGray);
                UIManager.put("OptionPane.errorDialog.titlePane.background", Color.black);
                UIManager.put("OptionPane.errorDialog.border.background", Color.white);
                String resp = showInputDialog(this, "Digite sua resposta secreta para criar uma nova senha", "Pergunta secreta => " + perg, 1);
                if(resp == null){
                    return;
                }else 
                    if(resp.equals(var.RS.getString("resp_secreta"))){
                    String senha;
                    do{
                        senha = showInputDialog(this, "Digite sua nova senha", "Nova senha", 1);       
                        if(senha == null){
                            showMessageDialog(this, "Senha inválida","Senha inválida",0);
                            return;
                        }
                        if (rt.checkPasswordStrength(senha) < 75){
                            showMessageDialog(this,"Senha não é forte o suficiente, misture entre letras maiúsculas,minúsculas, números e caracteres especiais!", "Senha fraca/mediana",0); 
                        } 
                        if (senha.length() > 10){
                            showMessageDialog(this,"Senha deve ter 10 ou menos caracteres!", "Senha muito longa",0); 
                        } 
                    }while (rt.checkPasswordStrength(senha) < 75 || senha.length() > 10);
                  
                    
                    setUserID(Integer.parseInt(var.RS.getString("UserID")));
                    int result = var.stmt.executeUpdate("update Tabela_Usuarios set Senha='" + senha + "' where UserID = " + getUserID() + " ");
                    if(result !=0){
                        showMessageDialog(this, "Senha alterada com sucesso", "Senha alterada com sucesso", 1);
                        txt_senha.setText("");
                        txt_login.setText("");
                        txt_login.setText(nome);
                        txt_senha.requestFocus();
                    }
                    return;
                }else{
                    showMessageDialog(this, "Resposta secreta errada!", "Resposta errada", 0);
                }
            }

            if (!linhas){
                showMessageDialog(this, "Usuário Inválido !", "Usuário inválido", 0);
            }
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }
    }//GEN-LAST:event_lbl_esqueceuMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       var.conecta();
       txt_login.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void txt_loginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loginKeyReleased
        //txt_login.setText(txt_login.getText().replaceAll("[^A-Z | ^a-z | ^0-9]", ""));
    }//GEN-LAST:event_txt_loginKeyReleased

    private void txt_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_loginKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           logar();
	}
    }//GEN-LAST:event_txt_loginKeyPressed

    private void txt_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_senhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
           logar();
	}
    }//GEN-LAST:event_txt_senhaKeyPressed
    
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = showConfirmDialog(null, "Deseja realmente sair do programa ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
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

    public void logar(){
        var.conecta();
        String status;
        String is_admin;
        int cont_bloq;
        try{        
            String Login = txt_login.getText().replaceAll("\\s+", " ");
            txt_login.setText(Login);
            if(!Login.matches("^[a-zA-Z0-9@. ]*$")){
                showMessageDialog(this, "Digite seu login sem caracteres especiais (exceto '@' e '.')", "Login inválido", 0);
                txt_login.setText("");
                txt_login.requestFocus();
                return;
            }
            
            char[] Password = txt_senha.getPassword();
            String strPassword = new String(Password);
            
            //var.RS= var.stmt.executeQuery("select * from Tabela_Usuarios where Nome='" + Login +"'");
            PreparedStatement stmt = var.con.prepareStatement("SELECT * FROM Tabela_Usuarios where login = ?");
            stmt.setString(1, Login);
            var.RS = stmt.executeQuery();
            boolean Consulta = false;
             
            while (var.RS.next()){
                Consulta = true;
                status = var.RS.getString("Status");
                is_admin = var.RS.getString("Perfil");
                setUserID(Integer.parseInt(var.RS.getString("UserID")));     
                if(status.equals("1")){
                    showMessageDialog(this, "Usuário está bloqueado, consulte um admin", "Usuário bloqueado", 0);
                    return;
                }
                if(strPassword.equals("")){   
                    showMessageDialog(this, "Digite sua senha!", "Senha inválida", 1);
                    txt_senha.requestFocus();
                    return;
                }
                if (strPassword.equals(var.RS.getString("Senha"))){     
                    menu2.setLocationRelativeTo(null);
                    menu2.setVisible(true);
                    menu2.enviaid(this, getUserID());
                    var.stmt.executeUpdate("update Tabela_Usuarios set cont_bloq ='0' where UserID = " + getUserID() + " ");
                    this.dispose();
                }else{                      
                    showMessageDialog(this, "Senha Inválida!", "Senha inválida", 1);
                    txt_senha.setText("");
                    txt_senha.requestFocus();
                    if(is_admin.equals("1")){
                        //Nao fazer nada
                    }else{         
                        cont_bloq = Integer.parseInt(var.RS.getString("cont_bloq"));
                        if(cont_bloq == 5){
                            showMessageDialog(this, "Usuário foi bloqueado por muitas tentativas de login", "Usuário foi bloqueado", 0);
                            var.stmt.executeUpdate("update Tabela_Usuarios set Status='1' where UserID = " + getUserID() + " ");
                            return;
                        }else{
                            var.stmt.executeUpdate("update Tabela_Usuarios set cont_bloq = cont_bloq + 1 where UserID = " + getUserID() + " ");
                            return;
                        }
                    }                  
               }
            }
            if (!Consulta){
                showMessageDialog(this, "Usuário Inválido!", "Usuário inválido", 1);
                txt_login.requestFocus();
            }
            var.RS.close();
            var.stmt.close();
            var.con.close();          
        }
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_esqueceu;
    private javax.swing.JTextField txt_login;
    private javax.swing.JPasswordField txt_senha;
    // End of variables declaration//GEN-END:variables
}
