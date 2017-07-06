package cn.scholarprofile.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年04月20日 下午3:35:55
 * @Description : 全局领域热度表
 * @version 1.0
 */
@Entity
@Table(name = "t_globalheat")
public class GlobalHeat {

	private int id;
	/** 领域外键 **/
	private int fieldId;
	/** 领域的热度 **/
	private float hot;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFieldId() {
		return fieldId;
	}

	public void setFieldId(int fieldId) {
		this.fieldId = fieldId;
	}

	public float getHot() {
		return hot;
	}

	public void setHot(float hot) {
		this.hot = hot;
	}

}
