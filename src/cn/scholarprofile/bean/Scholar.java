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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月21日 下午11:18:44
 * @Description :
 * @version 1.0
 */
@Entity
@Table(name="t_scholar")
public class Scholar {

	private int id;
	private String name;
	private String institution;//单位
	private String education;//教育水平
	private String position;//职称
	private int follow = 0;//关注数
	private int outcome = 0;//成果数
	private int reference = 0;//被引频次
	private int hindex = 0;// H-index
	private int gindex = 0;// G-index
    private String paperlist;
	private float journal_percent = 0; 
	private float conference_percent = 0; 
	private float booktitle_percent = 0; 
	private float other_percent = 0; 
	private float percent_journal;
	private float percent_booktitle;
	private float percent_conference;
	private float percent_other;
	
	
	
	public float getPercent_journal() {
		return percent_journal;
	}
	public void setPercent_journal(float percent_journal) {
		this.percent_journal = percent_journal;
	}
	public float getPercent_booktitle() {
		return percent_booktitle;
	}
	public void setPercent_booktitle(float percent_booktitle) {
		this.percent_booktitle = percent_booktitle;
	}
	public float getPercent_conference() {
		return percent_conference;
	}
	public void setPercent_conference(float percent_conference) {
		this.percent_conference = percent_conference;
	}
	public float getPercent_other() {
		return percent_other;
	}
	public void setPercent_other(float percent_other) {
		this.percent_other = percent_other;
	}
	public String getPaperlist() {
		return paperlist;
	}
	public void setPaperlist(String paperlist) {
		this.paperlist = paperlist;
	}
	
	public float getJournal_percent() {
		return journal_percent;
	}

	public void setJournal_percent(float journal_percent) {
		this.journal_percent = journal_percent;
	}

	public float getConference_percent() {
		return conference_percent;
	}

	public void setConference_percent(float conference_percent) {
		this.conference_percent = conference_percent;
	}

	public float getBooktitle_percent() {
		return booktitle_percent;
	}

	public void setBooktitle_percent(float booktitle_percent) {
		this.booktitle_percent = booktitle_percent;
	}

	public float getOther_percent() {
		return other_percent;
	}

	public void setOther_percent(float other_percent) {
		this.other_percent = other_percent;
	}

	public int getGindex() {
		return gindex;
	}

	public void setGindex(int gindex) {
		this.gindex = gindex;
	}

	public int getHindex() {
		return hindex;
	}

	public void setHindex(int hindex) {
		this.hindex = hindex;
	}

	private Set<Field> fields = new HashSet<Field>();

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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Type(type="text")
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	

	public int getFollow() {
		return follow;
	}

	public void setFollow(int follow) {
		this.follow = follow;
	}

	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	//@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@ManyToMany(fetch = FetchType.LAZY,cascade=CascadeType.PERSIST)
	// (cascade=CascadeType.ALL)
	@JoinTable(name = "field_scholar", joinColumns = { @JoinColumn(name = "scholar_id") }, inverseJoinColumns = { @JoinColumn(name = "field_id") })
	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}
