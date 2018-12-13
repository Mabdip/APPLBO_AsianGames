
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angga
 */
public class koneksiDB {
     public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/asiangames","root","");    
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
        
        return con;
    }
}
