package querybuilder;

import static javax.swing.JOptionPane.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexao_banco {
    /* Variaveis de conexao no Banco*/
    ResultSet RS;
    Statement stmt;
    Connection con;
    String connectionUrl;
   // PreparedStatement pstmt;
    /* Fim Variaveis de conexao no Banco*/
    Connection conect;
    
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
    

    
        public void Conectar() {
            //System.out.println("Conectando ao banco...");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conect =  DriverManager.getConnection("jdbc:mysql://192.168.3.13/voicedb_hcs_rails_producao","root","voice");
                stmt = conect.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                //System.out.println("Conectado.");
            } 
            catch (ClassNotFoundException ex) {
                System.out.println("Classe não encontrada, adicione o driver nas bibliotecas.");
                Logger.getLogger(conexao_banco.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(SQLException e) {
                System.out.println(e);
                throw new RuntimeException(e);
            }
        }   
}
