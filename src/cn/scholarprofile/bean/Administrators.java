package cn.scholarprofile.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 李齐飞 
 * @date : 2016年07月29日 
 * @Email:  716716fei@sina.com
 */
@Entity
@Table(name="t_administrators")
public class Administrators {
  private int id;
  private String username;
  private String password;
  
 @Id
@GeneratedValue 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
} 
  
}
