/**
 * 
 */
package cn.scholarprofile.dto;

import cn.scholarprofile.bean.Scholar;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年3月17日 下午8:54:48
 * @Description :index.jsp页九宫格数据bean
 * @version 1.0
 */
public class HotFieldCell {

	private String fieldName;
	private Scholar scholar1;
	private Scholar scholar2;
	private Scholar scholar3;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Scholar getScholar1() {
		return scholar1;
	}

	public void setScholar1(Scholar scholar1) {
		this.scholar1 = scholar1;
	}

	public Scholar getScholar2() {
		return scholar2;
	}

	public void setScholar2(Scholar scholar2) {
		this.scholar2 = scholar2;
	}

	public Scholar getScholar3() {
		return scholar3;
	}

	public void setScholar3(Scholar scholar3) {
		this.scholar3 = scholar3;
	}

}
