package org.Dreamteam;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection connection;
    public Connection getConnection(){
        String dbName = "filmek";
        String userName = "root";
        String passWd = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,passWd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
