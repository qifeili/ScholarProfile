/**
 * 
 */
package cn.scholarprofile.dto;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年1月15日 下午3:13:10
 * @Description :
 * @version 1.0
 */
public class ProjectInfoStep02 {

	private String title; // 一句话表述需求，即标题
	private String fieldName;// 项目所属领域的名字
	private String developmentCycle;//开发周期
	private String tagsName;//用户添加的子标题，数据是一个约定分割符分割的字符串，例如"项目背景@#￥%*&张三"
	private String tagsinfo;//用户添加的子标题的内容，数据也是一个约定分割符分割的字符串。例如"王五@#￥%*&李四"
	private String upLoadDataSetFileDis;//数据文件描述，数据是一个约定分割符分割的字符串，例如"项目背景@#￥%*&张三"
	private String upLoadDataSetFieldDis;//数据字段描述，数据也是一个约定分割符分割的字符串。例如"王五@#￥%*&李四

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getDevelopmentCycle() {
		return developmentCycle;
	}

	public void setDevelopmentCycle(String developmentCycle) {
		this.developmentCycle = developmentCycle;
	}

	public String getTagsName() {
		return tagsName;
	}

	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}

	public String getTagsinfo() {
		return tagsinfo;
	}

	public void setTagsinfo(String tagsinfo) {
		this.tagsinfo = tagsinfo;
	}

	public String getUpLoadDataSetFileDis() {
		return upLoadDataSetFileDis;
	}

	public void setUpLoadDataSetFileDis(String upLoadDataSetFileDis) {
		this.upLoadDataSetFileDis = upLoadDataSetFileDis;
	}

	public String getUpLoadDataSetFieldDis() {
		return upLoadDataSetFieldDis;
	}

	public void setUpLoadDataSetFieldDis(String upLoadDataSetFieldDis) {
		this.upLoadDataSetFieldDis = upLoadDataSetFieldDis;
	}
	
	

}
