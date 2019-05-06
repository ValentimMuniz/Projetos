package folha_de_pagamento;

import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Consulta_Usuarios extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();
    public int UserIDConsulta = -1;
    public String Usuario = null;
    
    public Consulta_Usuarios() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_bloqueado = new javax.swing.JTextField();
        txt_login = new javax.swing.JTextField();
        txt_userid = new javax.swing.JTextField();
        txt_perfil = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txt_fullname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consulta de usuários");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txt_bloqueado.setEditable(false);
        txt_bloqueado.setToolTipText("Status");

        txt_login.setEditable(false);
        txt_login.setToolTipText("Nome");
        txt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_loginActionPerformed(evt);
            }
        });

        txt_userid.setEditable(false);
        txt_userid.setToolTipText("UserID");
        txt_userid.setName("teste"); // NOI18N

        txt_perfil.setEditable(false);
        txt_perfil.setToolTipText("É um admin?");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("UserID");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Status");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel4.setText("É um admin?");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        jLabel5.setText("Consulta de usuários");

        btnConsultar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txt_fullname.setEditable(false);
        txt_fullname.setToolTipText("Status");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("Nome Completo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnConsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_fullname)
                            .addComponent(txt_bloqueado)
                            .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_userid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_fullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_bloqueado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar)
                    .addComponent(btnSair))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(435, 332));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        var.conecta();
        String status;
        String is_admin;        
        Object[] Opcoes = {"UserID", "Login"};
	int consultar = showOptionDialog(null,"Você deseja consultar por qual método ?","Consulta de usuário",0, 3,null,Opcoes,Opcoes[0]);
        
        if(consultar == 0){
            try{
                while (UserIDConsulta == -1) {
                    Usuario = showInputDialog(this, "Digite o ID de usuário que você deseja consultar", "Qual Id do usuário?", 3);
                    UserIDConsulta = stringToInt(Usuario);
                }

                if(Usuario == null){
                    UserIDConsulta = -1;
                    return;         
                }
                boolean consultaID = false;
                var.RS = var.stmt.executeQuery("select * from Tabela_Usuarios where UserID = " + UserIDConsulta + "");
                
                while(var.RS.next()){
                    consultaID = true;
                    status = var.RS.getString("Status");
                    is_admin = var.RS.getString("Perfil");
                    txt_userid.setText(var.RS.getString("UserID"));
                    txt_login.setText(var.RS.getString("Login"));
                    txt_fullname.setText(var.RS.getString("Nome"));
                    if(status.equals("1"))
                    {
                        txt_bloqueado.setText("Usuário está bloqueado");
                    }
                    else
                    {
                        txt_bloqueado.setText("Usuário está desbloqueado");
                    }
                    if(is_admin.equals("1"))
                    {
                        txt_perfil.setText("Usuário é um administrador");
                    }
                    else{
                        txt_perfil.setText("Usuário não é um administrador");
                    }
                    UserIDConsulta = -1;                 
                }
                if(!consultaID){
                    showMessageDialog(this,"Id de usuário => " + UserIDConsulta + " não existe", "UserID inválida", 1);
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
                String usuario2 = null;
                do{
                    Usuario = showInputDialog(this, "Digite o Login de usuário que você deseja consultar", "Qual login do usuário?", 3);
                    if(Usuario == null){
                        showMessageDialog(this,"Login Inválido!", "Login Inválido", 1);    
                        return;
                    }
                    if (Usuario.matches("^[a-zA-Z0-9@.]*$")) {
                        usuario2 = Usuario;   
                    } else {
                        showMessageDialog(this,"Digite o Login sem caracteres especiais (exceto '@' e '.')", "Login inválido", 1);
                    }
                }   while (!Usuario.matches("^[a-zA-Z0-9@.]*$"));
                               
                
                if(Usuario == null){
                    showMessageDialog(this,"Login Inválido!", "Login Inválido", 1);    
                    return;
                }
                                
                boolean consultaNome = false;
                var.RS = var.stmt.executeQuery("select * from Tabela_Usuarios where Login = '" + usuario2 +"'");
                while(var.RS.next()){
                    consultaNome = true;
                    status = var.RS.getString("Status");
                    is_admin = var.RS.getString("Perfil");
                    txt_userid.setText(var.RS.getString("UserID"));
                    txt_fullname.setText(var.RS.getString("Nome"));
                    txt_login.setText(var.RS.getString("Login"));
                    if(status.equals("1")){
                        txt_bloqueado.setText("Usuário está bloqueado");
                    }else{
                        txt_bloqueado.setText("Usuário está desbloqueado");
                    }
                    if(is_admin.equals("1")){
                        txt_perfil.setText("Usuário é um administrador");
                    }else{
                        txt_perfil.setText("Usuário não é um administrador");
                    }
                    UserIDConsulta = -1;                   
                }
                if(!consultaNome){
                    showMessageDialog(this,"Usuário => " + Usuario + " não existe", "Usuário inválido", 1);
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

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int sair = showConfirmDialog(null, "Deseja realmente sair desta tela ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair) {
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
        int sair = showConfirmDialog(null, "Deseja realmente sair do programa ?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair) {
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

    private void txt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_loginActionPerformed
    
    public void limpar(){
        UserIDConsulta = -1;
        Usuario = null;
        txt_login.setText("");
        txt_fullname.setText("");
        txt_userid.setText("");
        txt_bloqueado.setText("");
        txt_perfil.setText("");
    }
   private static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException e) {
            if(string == null || string.equals("")){
                showMessageDialog(null,"Digite um UserID válido! ", "Digite um UserID", 1);
            }
            else{
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
            java.util.logging.Logger.getLogger(Consulta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_bloqueado;
    private javax.swing.JTextField txt_fullname;
    private javax.swing.JTextField txt_login;
    private javax.swing.JTextField txt_perfil;
    private javax.swing.JTextField txt_userid;
    // End of variables declaration//GEN-END:variables
}
