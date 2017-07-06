package cn.scholarprofile.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="officialbaiduscholar")
public class Baiduscholar {
private int id;
private String name;
private String university;
private String paperlist;

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
public String getUniversity() {
	return university;
}
public void setUniversity(String university) {
	this.university = university;
}
public String getPaperlist() {
	return paperlist;
}
public void setPaperlist(String paperlist) {
	this.paperlist = paperlist;
}
}
