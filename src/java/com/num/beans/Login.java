package com.num.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession; 

import com.num.dao.LoginDAO;
import com.num.util.SessionUtils;
import com.num.util.ReadProperty;
import java.net.URL;
import java.net.URLClassLoader;
import static javax.servlet.SessionTrackingMode.URL;

@ManagedBean()
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;
	
	private String pwd;
        
	private String msg;
	         
        private String user;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	//validate login
	public String validateUsernamePassword() {
                //boolean valid = LoginDAO.validate(user, pwd);

                // debug code
                // bypass login page while developing
                boolean valid = true;
                // eof debug code

                System.out.println(valid);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
			return "views/dashboard?faces-redirect=true";
		} else {
                        //FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
//			FacesContext.getCurrentInstance().addMessage(
//					null,
//					new FacesMessage(FacesMessage.SEVERITY_FATAL,
//							"Incorrect username or passowrd",
//							"Please enter correct username and Password"));


// message is not shown, seems bug in this version
                        FacesContext fc =  FacesContext.getCurrentInstance();
                        FacesMessage fm = new FacesMessage("Invalid username or password");
                        fc.addMessage("fm_id:login-btn", fm);   
                        
                        
                        
                        return "login";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}
}
