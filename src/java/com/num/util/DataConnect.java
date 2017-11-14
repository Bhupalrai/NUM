package com.num.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
public class DataConnect {

    public static Connection getConnection() {

        Map<String, String> db_creds = new HashMap<>();    
        ReadProperty rp = new ReadProperty();
        db_creds = rp.getProperties("database");       
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                                "jdbc:mysql://"+db_creds.get("server")+":"+
                                db_creds.get("port")+"/"+db_creds.get("database"),
                                db_creds.get("username"),db_creds.get("password"));
                return con;
        } catch (Exception ex) {
                System.out.println("Database.getConnection() Error------------------->"
                                + ex.getMessage());
                return null;
        }
    }

    public static void close(Connection con) {
            try {
                    con.close();
            } catch (Exception ex) {
            }
    }
}