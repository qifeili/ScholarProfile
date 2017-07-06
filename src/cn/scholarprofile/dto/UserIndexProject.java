/**
 * 
 */
package cn.scholarprofile.dto;

/**
 * @author 作者名 E-mail: 作者邮箱
 * @date : 2016年3月9日 下午3:38:11
 * @Description :
 * @version 1.0
 */
public class UserIndexProject {

	private int id;
	private String title; // 一句话表述需求，即标题
	private String stage = "暂无状态信息";// 项目所处阶段，一共5个阶段,0->暂无状态信息,1->配服务商;2->选择服务商，签约;3->服务商工作;4->验收工作，满意后付款
	private int status = 0;// 项目所处状态，0表示未发布，1表示已发布

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
