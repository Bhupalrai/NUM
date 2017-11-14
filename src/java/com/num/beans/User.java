/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.num.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bhupal
 */
@ManagedBean
@SessionScoped
public class User {

    /**
     * Creates a new instance of User
     */
    public User() {
    }
    
    private String name;
    private String user_name;
    private String group;
    private String accout_type;
    private List<String> devices_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAccout_type() {
        return accout_type;
    }

    public void setAccout_type(String accout_type) {
        this.accout_type = accout_type;
    }

    public List<String> getDevices_id() {
        return devices_id;
    }

    public void setDevices_id(List<String> devices_id) {
        this.devices_id = devices_id;
    }
    
}
