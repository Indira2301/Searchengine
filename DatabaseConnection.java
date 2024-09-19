package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    static Connection connection = null;
    public static Connection getConnnection(){
        if(connection!=null){
            return connection;
        }
        String user = "root";
        String pwd= "nanditha@123";
        String db= "searchengine";
        return getConnection(user,pwd,db);
    }
    //overloading getconnection
    private static Connection getConnection(String user,String pwd,String db){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + db + "?user=" + user + "&password=" + pwd);
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        catch(ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
        return connection;
        }
}
