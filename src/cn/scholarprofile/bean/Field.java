/**
 * 
 */
package cn.scholarprofile.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:35:55
 * @Description : 对应field表
 * @version 1.0
 */
@Entity
@Table(name="t_field")
public class Field {

	/** 领域id **/
	private int id;
	/** 领域名称 **/
	private String name;
	/** 父领域id **/
	private int parentId = 1;
	private Set<Scholar> scholars = new HashSet<Scholar>();
	private Set<Project> projects = new HashSet<Project>();
	/** 领域关键字 **/
	private String keyword;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	//@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToMany(mappedBy="fields",cascade=CascadeType.PERSIST,fetch = FetchType.LAZY)
	//,cascade=CascadeType.ALL
	public Set<Scholar> getScholars() {
		return scholars;
	}

	public void setScholars(Set<Scholar> scholars) {
		this.scholars = scholars;
	}

	@OneToMany(targetEntity=Project.class, mappedBy="field", cascade=CascadeType.PERSIST)
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
