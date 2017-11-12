package com.num.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

// database.properties file content--------------------
//server = 192.168.100.xxx
//port = 3306
//database = db_name
//username = user01
//password = user01-pwd

public class ReadProperty {
    public Map getProperties(String p_type){
        Properties prop = new Properties();
        InputStream input = null;
        Map<String, String> property_dictnry = new HashMap<>();
        
        if (p_type == "database"){
            try {
                input = new FileInputStream("database.properties");
                prop.load(input);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadProperty.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
            String server = prop.getProperty("server");
            String port = prop.getProperty("port");
            String database = prop.getProperty("database");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");  

            property_dictnry.put("server", server);
            property_dictnry.put("port", port);
            property_dictnry.put("database", database);
            property_dictnry.put("username", username);
            property_dictnry.put("password", password);
        }
        else if (p_type == "message" ){
            try {
                input = new FileInputStream("database.properties");
                prop.load(input);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReadProperty.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReadProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
            String project_name = prop.getProperty("project_name");
            
            property_dictnry.put("project_name", project_name);
        }
        else {
            System.out.println("property type " + p_type +" not found");
        }
        
        return property_dictnry;
    }
}
