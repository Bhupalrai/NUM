/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.num.interfaces;

import java.sql.Connection;

/**
 *
 * @author Bhupal
 */
public interface IDatabase {
    public  Connection getDbConnection();
    public void closeDbConnection();
}
