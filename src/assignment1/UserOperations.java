/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import assignmentdb.DBManager;
import assignmentdb.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Operations;

/**
 *
 * @author Dell
 */
public class UserOperations {
     Connection connection = null;
    
      
    public int modifyProfile(int id, String name, String surname) throws SQLException
    {
        connection =  DBManager.getConnection();
        
        String query   =  "update users set name= '"+name+"', surname='"+surname+"' where role = 'User' and id = '"+id+"' ";
        PreparedStatement stat = connection.prepareStatement(query);
        int result = stat.executeUpdate();
        
        String date=LocalDate.now().toString();
        String time=LocalTime.now().toString();
        String operationQuery = "INSERT INTO `useroperations`"
                + "(`operation`, `date`, `time`, `user_id`) VALUES ('Updating User Profie : Name => "+name+"  SurName  => "+surname+"','"+date+"','"+time+"','"+id+"')";
                PreparedStatement sta = connection.prepareStatement(operationQuery);
                sta.executeUpdate();
        return result;
        
         
    }
    
    public int registerUser(String name, String surname,String username, String password) throws SQLException
    {
        connection =  DBManager.getConnection();
        
        String query = "INSERT INTO `users`(`name`, `surname`, `username`, `password`, `role`, `grossIncome`, `taxCredits`, `taxOwed`)"
                + "                        VALUES ('"+name+"', '"+surname+"', '"+username+"', '"+password+"', 'User', '0', '0', '0' )";
        PreparedStatement sta = connection.prepareStatement(query);
        
        int result = sta.executeUpdate();
        return result;
    }
   public int saveTaxRescord(int id, double grossIncome, double taxCredit, double taxOwed) throws SQLException
   {
        connection =  DBManager.getConnection();
        
        String query = "INSERT INTO `taxcalculate`(`user_id`, `grossIncome`, `taxCredits`, `taxOwed`) VALUES ('"+id+"', '"+grossIncome+"', '"+taxCredit+"',  '"+taxOwed+"')";
        PreparedStatement sta = connection.prepareStatement(query);
        
        int result = sta.executeUpdate();
        
        
        String date=LocalDate.now().toString();
        String time=LocalTime.now().toString();
        String operationQuery = "INSERT INTO `useroperations`"
                + "(`operation`, `date`, `time`, `user_id`) VALUES ('User Tax Calculation :  Gross Income =>  "+grossIncome+", Tax Credit => "+taxCredit+", Tax Owed => "+taxOwed+" ','"+date+"','"+time+"','"+id+"')";
                PreparedStatement stat = connection.prepareStatement(operationQuery);
                stat.executeUpdate();
        
        return result;
   }
   
   public double calculateTax(double grossIncome, double taxCredit) {
        // Implement tax calculation logic based on income, tax credits, etc.
        // For simplicity, let's assume a basic formula
        double tax = grossIncome * 0.2 - taxCredit;
        return Math.max(0, tax); // Ensure the calculated tax is non-negative
    }
    public List<User> getAllUsers() throws SQLException
    {
        connection = DBManager.getConnection();
        List<User> userList =  new ArrayList();
        
        String query = "select *from users";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        while(rs.next())
        {
               int id = Integer.parseInt(rs.getString("id"));
               String name = rs.getString("name");
               String surname =rs.getString("surname");
               String role = rs.getString("role");
               String username=rs.getString("username");
               String password = rs.getString("password");
               double grossIncome = rs.getDouble("grossIncome");
               double taxCredits = rs.getDouble("taxCredits");
               double taxOwed = rs.getDouble("taxOwed");
               
               User user = new User(id , username, password, role, name, surname, grossIncome, taxCredits, taxOwed);
               userList.add(user);
               
               
               
                       
                      
               
        }
        return userList;
    }
    
    public List<Operations> reviewUserOperations() throws SQLException
    {
        connection =  DBManager.getConnection();
        List<Operations> operationsList = new ArrayList();
         String query = "select users.id as uid, users.name, users.username, useroperations.id uop_id,"
                 + " useroperations.operation, useroperations.date, useroperations.time from users INNER JOIN "
                 + "useroperations on users.id = useroperations.user_id ";
         PreparedStatement pstmt = connection.prepareStatement(query);
         
         ResultSet rs = pstmt.executeQuery();
         while(rs.next())
         {
              String id =  rs.getString("uop_id");
              String username = rs.getString("username");
              String operation = rs.getString("operation");
              String date = rs.getString("date");
              String time= rs.getString("time");
              
              Operations op = new Operations(id, username, operation, date, time);
              
              operationsList.add(op);
                      
         }
         return operationsList;
         
    }
    
}
