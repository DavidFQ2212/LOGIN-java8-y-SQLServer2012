
package login;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class LOGIN {

    
 
        Connection conexion = null;
        Integer resultado = 0;
        String url = "dbc:sqlserver://WIN7:1433;" + "database=login;" + "user=sa;" + "password=perrogato2;";
                public void Conectar(){
                    try{
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        conexion = conexion = DriverManager.getConnection(url);
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,e);
                        
                    }
                }
                public int Login(String user , String password){
                    try{
                        PreparedStatement ps;
                        ResultSet rs;
                        ps = conexion.prepareStatement("SELECT usuario,contraseña FROM usuario WHERE usuario = ? and contraseña = ?");
                        ps.setString(1, user);
                        ps.setString(2,password);
                        rs = ps.executeQuery();
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Bienvenido");
                            resultado = 1;
                            
                        }else{
                            JOptionPane.showMessageDialog(null,"Bienvenido");
                            resultado = 0;
                            
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Usuario y/o Contraseña son incorrectas");
                        
                    }
                    return resultado;
                }
       
    
    
}
