/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.ConexaoSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edmilson Nhabinde
 */
public class ModuloConexao {
     public static Connection conector() {
        java.sql.Connection conexao = null;
        //a linha abaixo chama o driver  
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbpoo";
        String user = "root";
        String password = "";
        
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        }catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
}
