/**
 * 
 */
package cn.scholarprofile.util.email;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/** @author  pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月22日 下午1:05:04 
 * @Description : 
 * @version 1.0 
 */
public class MyAuthenticator extends Authenticator{   
    String userName=null;   
    String password=null;   
        
    public MyAuthenticator(){   
    }   
    public MyAuthenticator(String username, String password) {    
        this.userName = username;    
        this.password = password;    
    }    
    protected PasswordAuthentication getPasswordAuthentication(){   
        return new PasswordAuthentication(userName, password);   
    }   
}   
