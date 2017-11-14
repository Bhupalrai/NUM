/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.num.implementors;

import com.num.interfaces.IDatabase;
import java.sql.Connection;
/**
 *
 * @author Bhupal
 */
public class Database implements IDatabase {

    @Override
    public Connection getDbConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeDbConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
