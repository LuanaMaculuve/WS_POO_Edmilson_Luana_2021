/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.*;

/**
 *
 * @author Edmilson Nhabinde
 */
public class ModuloConexao {

    //Metodo responsavel por estabelecer a conexao com o banco de dados 
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
