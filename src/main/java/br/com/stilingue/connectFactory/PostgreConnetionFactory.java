package br.com.stilingue.connectFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConnetionFactory {

    private PostgreConnetionFactory(){

    }

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mensagens_DB", "postgres", "33720986");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
