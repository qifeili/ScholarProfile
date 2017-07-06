/**
 * 
 */
package cn.scholarprofile.bean;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** @author  pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月22日 下午1:54:06 
 * @Description : 存储为某个用户生成的找回验证码的表
 * @version 1.0 
 */
@Entity
@Table(name="t_verificationcode")
public class VerificationCode {

	private int id;
	/** 电子邮箱 **/
	private String email;
	/** 时间戳 **/
	private Timestamp sendTime;
	/** 验证码  **/
	private String verificationCode;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
}
