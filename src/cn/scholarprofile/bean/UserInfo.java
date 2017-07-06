package cn.scholarprofile.bean;import java.util.Date;import java.util.HashSet;import java.util.Set;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.GeneratedValue;import javax.persistence.Id;import javax.persistence.JoinColumn;import javax.persistence.OneToMany;import javax.persistence.Table;import org.hibernate.annotations.Type;import org.springframework.format.annotation.DateTimeFormat;/** *  * @author pangchao E-mail: pangchao620@163.com * @date : 2015年12月7日 下午4:25:06 * @Description : UserInfo bean * @version 1.0 */@Entity@Table(name = "t_userinfo")public class UserInfo{	// field	/**  **/	private int id;	/** 用户名 **/	private String username;	/** 登录密码 **/	private String password;	/** 电子邮箱 **/	private String email;	/** 真实姓名 **/	private String realName;	/** 出生日期 **/	@DateTimeFormat(pattern = "yyyy-MM-dd")	private Date birthday;	/** 性别 **/	private String sex;	/** 最高学历 **/	private String maxDegree;	/** 工作年限 **/	private String worklife;	/** 工作地点 **/	private String workPlace;	/** 当前行业与职能 **/	private String industryAndFunctional;	/** 公司名 **/	private String companyName;	/** 职位 **/	private String curPosition;	/** 电话号码 **/	private String phone;	/** 感兴趣的领域 **/	private String interestField;	/** 注册的手机号 **/	private String registerNumber;	/** 注册类型 **/	private int registerType = 0;//0代表系统内部注册，1代表QQ注册，2代表微信注册，3代表新浪微博注册		/** 第三方登陆名 **/ 	private String thirdPartyUsername;	/** 用户创建的项目 **/	private Set<Project> projects = new HashSet<Project>();	/** 用户关注数  **/	private Set<Focus> focuses = new HashSet<Focus>();// 关注数	/*	 * @Id	 * 	 * @GenericGenerator(name = "fk_userinfo", strategy = "assigned")	 * 	 * @GeneratedValue(generator = "fk_userinfo")	 * 	 * public String getId() { return id; }	 * 	 * 	 * public void setId(String id) { this.id = id; }	 */		@Id	@GeneratedValue	public int getId() {		return id;	}	public void setId(int id) {		this.id = id;	}	/**	 * @return the username	 */	public String getUsername() {		return username;	}	/**	 * @param username	 *            the username to set	 */	public void setUsername(String username) {		this.username = username;	}	/**	 * @return the password	 */	public String getPassword() {		return password;	}	/**	 * @param password	 *            the password to set	 */	public void setPassword(String password) {		this.password = password;	}	/**	 * @return the email	 */	public String getEmail() {		return email;	}	/**	 * @param email	 *            the email to set	 */	public void setEmail(String email) {		this.email = email;	}	/**	 * @return the realName	 */	public String getRealName() {		return realName;	}	/**	 * @param realName	 *            the realName to set	 */	public void setRealName(String realName) {		this.realName = realName;	}	@Type(type="date")	public Date getBirthday() {		return birthday;	}	public void setBirthday(Date birthday) {		this.birthday = birthday;	}	/**	 * @return the sex	 */	public String getSex() {		return sex;	}	/**	 * @param sex	 *            the sex to set	 */	public void setSex(String sex) {		this.sex = sex;	}	/**	 * @return the maxDegree	 */	public String getMaxDegree() {		return maxDegree;	}	/**	 * @param maxDegree	 *            the maxDegree to set	 */	public void setMaxDegree(String maxDegree) {		this.maxDegree = maxDegree;	}		public String getWorklife() {		return worklife;	}	public void setWorklife(String worklife) {		this.worklife = worklife;	}	/**	 * @return the workPlace	 */	public String getWorkPlace() {		return workPlace;	}	/**	 * @param workPlace	 *            the workPlace to set	 */	public void setWorkPlace(String workPlace) {		this.workPlace = workPlace;	}	/**	 * @return the industryAndFunctional	 */	public String getIndustryAndFunctional() {		return industryAndFunctional;	}	/**	 * @param industryAndFunctional	 *            the industryAndFunctional to set	 */	public void setIndustryAndFunctional(String industryAndFunctional) {		this.industryAndFunctional = industryAndFunctional;	}	/**	 * @return the companyName	 */	public String getCompanyName() {		return companyName;	}	/**	 * @param companyName	 *            the companyName to set	 */	public void setCompanyName(String companyName) {		this.companyName = companyName;	}	/**	 * @return the curPosition	 */	public String getCurPosition() {		return curPosition;	}	/**	 * @param curPosition	 *            the curPosition to set	 */	public void setCurPosition(String curPosition) {		this.curPosition = curPosition;	}	/**	 * @return the phone	 */	public String getPhone() {		return phone;	}	/**	 * @param phone	 *            the phone to set	 */	public void setPhone(String phone) {		this.phone = phone;	}	/**	 * @return the interestField	 */	public String getInterestField() {		return interestField;	}	/**	 * @param interestField	 *            the interestField to set	 */	public void setInterestField(String interestField) {		this.interestField = interestField;	}	public int getRegisterType() {		return registerType;	}	public void setRegisterType(int registerType) {		this.registerType = registerType;	}	public String getThirdPartyUsername() {		return thirdPartyUsername;	}	public void setThirdPartyUsername(String thirdPartyUsername) {		this.thirdPartyUsername = thirdPartyUsername;	}	@OneToMany	// (cascade=CascadeType.PERSIST)	@JoinColumn(name = "userId")	public Set<Focus> getFocuses() {		return focuses;	}	public void setFocuses(Set<Focus> focuses) {		this.focuses = focuses;	}	public String getRegisterNumber() {		return registerNumber;	}	public void setRegisterNumber(String registerNumber) {		this.registerNumber = registerNumber;	}	@OneToMany(targetEntity=Project.class, mappedBy="userInfo", cascade=CascadeType.PERSIST)	public Set<Project> getProjects() {		return projects;	}	public void setProjects(Set<Project> projects) {		this.projects = projects;	}		}