/**
 * 
 */
package cn.scholarprofile.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月23日 下午10:01:41
 * @Description :
 * @version 1.0
 */
@Entity
@Table(name = "t_interest")
public class Interest {

	private int id;
	private String scholarName;// 感兴趣的学者名
	private String fields;// 感兴趣的领域串

	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScholarName() {
		return scholarName;
	}

	public void setScholarName(String scholarName) {
		this.scholarName = scholarName;
	}

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

}
