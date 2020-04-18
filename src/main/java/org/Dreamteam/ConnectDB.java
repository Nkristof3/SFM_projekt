package org.Dreamteam;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    public Connection getConnection(){
        String dbName = "Filmek";
        String userName = "root";
        String passWd = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,passWd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
