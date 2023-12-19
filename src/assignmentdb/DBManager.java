/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author taimor
 */
public class DBManager {
     Connection connection = null;
    public static final String DB_URL = "jdbc:mysql://localhost:3306/tax_calculator";
    public static final String DB_USER = "ooc2023";
    public static final String DB_PASSWORD = "ooc2023";
    
   public DBManager()
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/oocdb", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         if(connection != null)
         {
              
         }
         else 
         {
              System.out.println("Connection Failed ");
         }
    }
   
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/oocdb", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return connection;
    }
   
   
    
}
