/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

import assignment.db.UserDao;
import model.RegularUser;
import assignment.db.DBManager;
import assignment.db.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Operations;


/**
 *
 * @author danyal
 */
public class Assignment1{

     private static final Scanner scanner = new Scanner(System.in);
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBManager dbManager = new DBManager();
        
        
         System.out.println("Welcome to the Tax Calculator App!");

         Assignment.menu();
         
         
    }

    private static class UserManager {

         private Connection connection = null;

    public UserManager(Connection connection) {
        this.connection = connection;
    }

    public User loginUser(String username, String password) throws SQLException {
        // Check the database for the user with the given credentials
        // Return a User object if the user exists, otherwise return null
        // Use PreparedStatement to prevent SQL injection
        String query = "SELECT * FROM users WHERE username=? AND password=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(

                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getDouble("grossIncome"),
                        resultSet.getDouble("taxCredits"),
                        resultSet.getDouble("taxOwed")
                                
                       
                );
            }
      
        return null;
    }
    }

  

   

        
        
    }
    
    public static void menu()
    {
        
          try (Connection connection = DBManager.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            User user= null;
           
             UserManager userManager = new UserManager(connection);
             UserOperations uop = new UserOperations();
            System.out.println("Enter '1' for Admin, '2' for Regular User:");
            int userType = scanner.nextInt();
            
            if(userType == 1)
            {
            System.out.println("Enter username:");
            String username = scanner.next();

            System.out.println("Enter password:");
            String password = scanner.next();

             user = userManager.loginUser(username, password);
            }
            else 
            {
                 System.out.println("Enter '1' for Login , '2' for Registration of Reguler User");
                 int choose = scanner.nextInt();
                 
                 if(choose == 1)
                 {
                       System.out.println("Enter username:");
                       String username = scanner.next();

                       System.out.println("Enter password:");
                       String password = scanner.next();

                       user = userManager.loginUser(username, password);
                 }
                 else 
                 {
                       System.out.println("Enter the Name ");
                       String name = scanner.next();
                       System.out.println("Enter the Sur Name");
                       String surname = scanner.next();
                       System.out.println("Enter username:");
                       String username = scanner.next();

                       System.out.println("Enter password:");
                       String password = scanner.next();

                       
                       uop.registerUser(name, surname, username, password);
                       
                       System.out.println("User Registered Successfully ");
                       
                        Assignment.menu();
                       
                       
                 }
            }
            

       

            if (user != null) {
                if (userType == 1 && "Admin".equals(user.getRole())) {
                    // Admin operations
                    System.out.println("Logged in as Admin");
                    AdminOperations ao = new AdminOperations();
                    // Admin functionalities
    while (true) {
        System.out.println("1. Modify own profile");
        System.out.println("2. Access list of all users");
        System.out.println("3. Remove a user");
        System.out.println("4. Review operations performed by other users");
        System.out.println("0. Logout");

        int adminChoice = scanner.nextInt();
