package cn.scholarprofile.dto;


/**
 * @author yongliu
 * @date : 2016年3月16日 下午3:08:44
 * @Description : 计算学者顺序的数据封装类
 * @version 1.0
 */
public class ScholarSort implements Comparable<ScholarSort>{
	// solr 属性
	private int id; //mysql数据库中的id
	private float score = 0; //solr搜索得出的评分值 
	
	// musql 属性
	private int follow = 0;// 关注数
	private int outcome = 0;// 成果数
	private int reference = 0;// 被引频次
	private int hindex = 0;// H-index
	private int gindex = 0;// G-index
	private float journal_percent = 0; 
	private float conference_percent = 0; 
	private float booktitle_percent = 0; 
	private float other_percent = 0; 
	
	// 由于数据缺失，暂时未用到的属性
	private String institution;// 单位   重点、非重点等属性
	private String education;// 教育水平  本科、硕士、博士
	private String position;// 职称      讲师、副教授、教授
	
	// 排序算法最终得出的结果值
	private float resultscore = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
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

	public int getHindex() {
		return hindex;
	}

	public void setHindex(int hindex) {
		this.hindex = hindex;
	}

	public int getGindex() {
		return gindex;
	}

	public void setGindex(int gindex) {
		this.gindex = gindex;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public float getResultscore() {
		return resultscore;
	}

	public void setResultscore(float resultscore) {
		this.resultscore = resultscore;
	}
	
	// 排序算法中，计算一个scholar最终得分值的公式
	public float calculateResultscore() {
		float result = 0;
		if (this.score == 0) {
			//不是通过solr搜索出的结果，是mysql中的数据
			this.resultscore = this.score * this.reference;
		}else {
			//是通过solr搜索出的结果，mysql中可能有，也可能没有
			this.resultscore = this.score * this.reference;
		}
		return result;
	}

	@Override
	public int compareTo(ScholarSort o) {
		// TODO Auto-generated method stub
		float otherresultscore = o.getResultscore();
		return this.resultscore > otherresultscore ? -1 : 1;
	}
}
