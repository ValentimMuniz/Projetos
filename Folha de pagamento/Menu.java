package folha_de_pagamento;

import java.sql.*;
import static javax.swing.JOptionPane.*;

public class Menu extends javax.swing.JFrame {

    conexao_banco var = new conexao_banco();
    RotinasGlobais rt = new RotinasGlobais();
    
    int id_usu;
    String is_admin;
    String nome;
    public Menu() {
        initComponents();
    }

    public void enviaid(Login VeioID, int user_id){
        id_usu = user_id;  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbl_nome = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_usu = new javax.swing.JMenu();
        menu_controleusu = new javax.swing.JMenu();
        itemConsultar = new javax.swing.JMenuItem();
        item_cotrolausu = new javax.swing.JMenuItem();
        item_navegausu = new javax.swing.JMenuItem();
        item_listausu = new javax.swing.JMenuItem();
        item_bloqueados = new javax.swing.JMenuItem();
        menu_func = new javax.swing.JMenu();
        item_controlefunc = new javax.swing.JMenuItem();
        item_navegafunc = new javax.swing.JMenuItem();
        item_listafunc = new javax.swing.JMenuItem();
        menu_venc = new javax.swing.JMenu();
        item_controlevenc = new javax.swing.JMenuItem();
        item_navegavenc = new javax.swing.JMenuItem();
        item_listavenc = new javax.swing.JMenuItem();
        menu_desconto = new javax.swing.JMenu();
        item_controledesc = new javax.swing.JMenuItem();
        item_navegadesc = new javax.swing.JMenuItem();
        item_listadesc = new javax.swing.JMenuItem();
        menu_sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu Principal");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folha_de_pagamento/fsa1.png"))); // NOI18N

        menu_usu.setText("Usuários");
        menu_usu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        menu_controleusu.setText("Controle de usuários");
        menu_controleusu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        itemConsultar.setText("Consultar usuários");
        itemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultarActionPerformed(evt);
            }
        });
        menu_controleusu.add(itemConsultar);

        item_cotrolausu.setText("Cadastrar/Excluir/Alterar");
        item_cotrolausu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_cotrolausuActionPerformed(evt);
            }
        });
        menu_controleusu.add(item_cotrolausu);

        menu_usu.add(menu_controleusu);

        item_navegausu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_navegausu.setText("Navegação de usuários");
        item_navegausu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_navegausuActionPerformed(evt);
            }
        });
        menu_usu.add(item_navegausu);

        item_listausu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_listausu.setText("Listar/ Salvar usuários");
        item_listausu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_listausuActionPerformed(evt);
            }
        });
        menu_usu.add(item_listausu);

        item_bloqueados.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_bloqueados.setText("Bloqueados");
        item_bloqueados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_bloqueadosActionPerformed(evt);
            }
        });
        menu_usu.add(item_bloqueados);

        jMenuBar1.add(menu_usu);

        menu_func.setText("Funcionários");
        menu_func.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        item_controlefunc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_controlefunc.setText("Controle de Funcionários");
        item_controlefunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_controlefuncActionPerformed(evt);
            }
        });
        menu_func.add(item_controlefunc);

        item_navegafunc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_navegafunc.setText("Navegação de funcionários");
        item_navegafunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_navegafuncActionPerformed(evt);
            }
        });
        menu_func.add(item_navegafunc);

        item_listafunc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_listafunc.setText("Listar / Salvar funcionários");
        item_listafunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_listafuncActionPerformed(evt);
            }
        });
        menu_func.add(item_listafunc);

        jMenuBar1.add(menu_func);

        menu_venc.setText("Vencimentos");
        menu_venc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        item_controlevenc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_controlevenc.setText("Controle de vencimentos");
        item_controlevenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_controlevencActionPerformed(evt);
            }
        });
        menu_venc.add(item_controlevenc);

        item_navegavenc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_navegavenc.setText("Navegação de vencimentos");
        item_navegavenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_navegavencActionPerformed(evt);
            }
        });
        menu_venc.add(item_navegavenc);

        item_listavenc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_listavenc.setText("Listar / Salvar vencimentos");
        item_listavenc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_listavencActionPerformed(evt);
            }
        });
        menu_venc.add(item_listavenc);

        jMenuBar1.add(menu_venc);

        menu_desconto.setText("Descontos");
        menu_desconto.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        item_controledesc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_controledesc.setText("Controle de descontos");
        item_controledesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_controledescActionPerformed(evt);
            }
        });
        menu_desconto.add(item_controledesc);

        item_navegadesc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_navegadesc.setText("Navegação de descontos");
        item_navegadesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_navegadescActionPerformed(evt);
            }
        });
        menu_desconto.add(item_navegadesc);

        item_listadesc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        item_listadesc.setText("Listar / Salvar descontos");
        item_listadesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_listadescActionPerformed(evt);
            }
        });
        menu_desconto.add(item_listadesc);

        jMenuBar1.add(menu_desconto);

        menu_sair.setText("Sair");
        menu_sair.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        menu_sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_sairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_sair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(586, 434));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        var.conecta();
        try{   
            var.RS = var.stmt.executeQuery("select * from Tabela_Usuarios where UserID= " + id_usu + " ");
            boolean Consulta_Admin = false;
            
            while(var.RS.next()){
                Consulta_Admin = true;
                is_admin = var.RS.getString("Perfil");
                nome = var.RS.getString("Nome");
                lbl_nome.setText(String.format("<html>%s<b>%s</b></html>",  "Bem vindo: ", nome));
                if(is_admin.equals("1")){                  
                    item_bloqueados.setVisible(true);
                    item_controlefunc.setVisible(true);
                    item_cotrolausu.setVisible(true);
                    item_controledesc.setVisible(true);
                } else{
                    item_bloqueados.setVisible(false);
                    item_controlefunc.setVisible(false);
                    item_cotrolausu.setVisible(false);
                    item_controledesc.setVisible(false);
                }
            }
            if (!Consulta_Admin){
              showMessageDialog(this, "Usuário Inválido", "Usuário inválido", 1);
            }
            var.RS.close();
            var.stmt.close();
            var.con.close();
        }  
        catch( SQLException e){
            showMessageDialog(this, "Comando SQL com problemas " + e.getMessage() );
        }     
    }//GEN-LAST:event_formWindowOpened

    private void item_navegausuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_navegausuActionPerformed
        new Navegacao_Usuarios().setVisible(true);
    }//GEN-LAST:event_item_navegausuActionPerformed

    private void item_listausuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_listausuActionPerformed
        new Listar_Usuarios().setVisible(true);
    }//GEN-LAST:event_item_listausuActionPerformed

    private void menu_sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_sairMouseClicked
        int sair = showConfirmDialog(null, "Deseja realmente sair?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair){
            case YES_OPTION:
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes
                new Login().setVisible(true);
                this.dispose();
                break;
            case CANCEL_OPTION:
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//cancel
                break;
            default:
                setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//no
                break;
        }
    }//GEN-LAST:event_menu_sairMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int sair = showConfirmDialog(null, "Deseja realmente sair?",  "Deseja sair?", YES_NO_CANCEL_OPTION);
        switch (sair){
            case YES_OPTION:
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);//yes
                new Login().setVisible(true);
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

    private void itemConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultarActionPerformed
        new Consulta_Usuarios().setVisible(true);
    }//GEN-LAST:event_itemConsultarActionPerformed

    private void item_cotrolausuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_cotrolausuActionPerformed
        new Controle_Usuarios().setVisible(true);
    }//GEN-LAST:event_item_cotrolausuActionPerformed

    private void item_controlefuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_controlefuncActionPerformed
        new Controle_Funcionarios().setVisible(true);
    }//GEN-LAST:event_item_controlefuncActionPerformed

    private void item_bloqueadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_bloqueadosActionPerformed
        new Usuarios_Bloqueados().setVisible(true);
    }//GEN-LAST:event_item_bloqueadosActionPerformed

    private void item_navegafuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_navegafuncActionPerformed
        new Navegacao_Funcionarios().setVisible(true);
    }//GEN-LAST:event_item_navegafuncActionPerformed

    private void item_listafuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_listafuncActionPerformed
        new Listar_Funcionarios().setVisible(true);
    }//GEN-LAST:event_item_listafuncActionPerformed

    private void item_controlevencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_controlevencActionPerformed
        new Controle_Vencimentos().setVisible(true);
    }//GEN-LAST:event_item_controlevencActionPerformed

    private void item_navegavencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_navegavencActionPerformed
        new Navegacao_Vencimentos().setVisible(true);
    }//GEN-LAST:event_item_navegavencActionPerformed

    private void item_listavencActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_listavencActionPerformed
        new Listar_Vencimentos().setVisible(true);
    }//GEN-LAST:event_item_listavencActionPerformed

    private void item_controledescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_controledescActionPerformed
        new Controle_Descontos().setVisible(true);
    }//GEN-LAST:event_item_controledescActionPerformed

    private void item_navegadescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_navegadescActionPerformed
        new Navegacao_Descontos().setVisible(true);
    }//GEN-LAST:event_item_navegadescActionPerformed

    private void item_listadescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_listadescActionPerformed
        new Listar_Descontos().setVisible(true);
    }//GEN-LAST:event_item_listadescActionPerformed

   
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemConsultar;
    private javax.swing.JMenuItem item_bloqueados;
    private javax.swing.JMenuItem item_controledesc;
    private javax.swing.JMenuItem item_controlefunc;
    private javax.swing.JMenuItem item_controlevenc;
    private javax.swing.JMenuItem item_cotrolausu;
    private javax.swing.JMenuItem item_listadesc;
    private javax.swing.JMenuItem item_listafunc;
    private javax.swing.JMenuItem item_listausu;
    private javax.swing.JMenuItem item_listavenc;
    private javax.swing.JMenuItem item_navegadesc;
    private javax.swing.JMenuItem item_navegafunc;
    private javax.swing.JMenuItem item_navegausu;
    private javax.swing.JMenuItem item_navegavenc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_nome;
    private javax.swing.JMenu menu_controleusu;
    private javax.swing.JMenu menu_desconto;
    private javax.swing.JMenu menu_func;
    private javax.swing.JMenu menu_sair;
    private javax.swing.JMenu menu_usu;
    private javax.swing.JMenu menu_venc;
    // End of variables declaration//GEN-END:variables
}
