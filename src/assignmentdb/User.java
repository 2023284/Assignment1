/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentdb;

/**
 *
 * @author taimoor
 */
public class User {
     private int id;
    private String username;
    private String password;
    private String role;
    private String name;
    private String surname;
    private double grossIncome;
    private double taxCredits;
    private double taxOwed;

    // Constructors, getters, setters
    
    public User(int id, String username, String password, String role, String name, String surname, double grossIncome, double taxCredits, double taxOwed)
    {
         this.id = id;
         this.username = username;
         this.password = password;
         this.role = role;
         this.name = name;
         this.surname = surname;
         this.grossIncome = grossIncome;
         this.taxCredits = taxCredits;
         this.taxOwed = taxOwed;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getGrossIncome() {
        return grossIncome;
    }

    public double getTaxCredits() {
        return taxCredits;
    }

    public double getTaxOwed() {
        return taxOwed;
    }
    
    
    public String getRole()
    {
         return this.role;
    }
    
    public void setId(int id)
    {
         this.id = id;
    }
    
    public void setUserName(String username)
    {
         this.username = username;
    }
    
    public void setPassword(String password)
    {
         this.password = password;
    }
    
   
    public void setName(String name)
    {
         this.name = name;
    }
    
    public void setSurName(String surname)
    {
         this.surname = surname;
    }
    
    public void grossIncome(double grossIncome)
    {
         this.grossIncome = grossIncome;
    }
    
    public void taxCredits(double taxCredits)
    {
         this.taxCredits = taxCredits;
    }
    
    public void setRole(String role)
    {
         this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ",  name=" + name + ", surname=" + surname + ", Role=" + role + ",  grossIncome=" + grossIncome + ", taxCredits=" + taxCredits + ", taxOwed=" + taxOwed + '}';
    }
}
