package folha_de_pagamento;

import static javax.swing.JOptionPane.*;
import java.sql.*;

public class conexao_banco {
    /* Variaveis de conexao no Banco*/
    ResultSet RS;
    Statement stmt;
    Connection con;
    String connectionUrl;
    PreparedStatement pstmt;
    /* Fim Variaveis de conexao no Banco*/
    
    
    /* Módulo de conexão do banco*/
    public void conecta(){        
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Base_FPagamento;user=sa;password=adminsa";
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
        }
        catch(SQLException e){
            showMessageDialog(null,"Problema para acessar o banco de dados");
        }
        catch( ClassNotFoundException e){      
            showMessageDialog( null, "Problemas na conexão com o SQLServer" );
        }   
    }
    /* Módulo de conexão do banco*/
    
    
    /* Módulo de conexão do banco para somente leitura*/
    public void conecta_lista(){        
        try{   
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Base_FPagamento;user=sa;password=adminsa";
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
        catch(SQLException e){
            showMessageDialog(null,"Problema para acessar o banco de dados");
        }
        catch( ClassNotFoundException e){      
            showMessageDialog( null, "Problemas na conexão com o SQLServer" );
        }   
    }
    /* Módulo de conexão do banco para somente leitura*/
}
