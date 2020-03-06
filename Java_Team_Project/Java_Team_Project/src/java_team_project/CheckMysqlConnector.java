/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_team_project;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckMysqlConnector {
    
    public static void main(String[] args)
    {
        String className = "com.mysql.cj.jdbc.Driver";
        try { 
            Class.forName(className);
            System.out.println("Driver loaded Successfully");
           
        } catch (ClassNotFoundException ex) {
            
            System.out.println("Driver failed To load successfully");
            System.out.println(ex.getMessage());
        }
    }
            
            
}
