/**
 * 
 */
package cn.scholarprofile.util;

import cn.scholarprofile.util.email.MailSenderInfo;
import cn.scholarprofile.util.email.SimpleMailSender;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月22日 下午12:38:43
 * @Description :
 * @version 1.0
 */
public class EmailUtil {

	public static boolean sendMailboxVerificationCode(String targetMailbox, String content) {
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("pangchao620@163.com");
		mailInfo.setPassword("JHSC1314PANG,.");// 您的邮箱密码
		mailInfo.setFromAddress("pangchao620@163.com");
		mailInfo.setToAddress(targetMailbox);
		mailInfo.setSubject("scholarprofile");		
		mailInfo.setContent("尊敬的" + targetMailbox + "用户你好：\n"
				+ "    你此次重置密码的验证码如下，请在 30 分钟内输入验证码进行下一步操作。 如非你本人操作，请忽略此邮件。"
				+ "    " + content);
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		return sms.sendTextMail(mailInfo);// 发送文体格式
	}

	public static void main(String[] args) {
		EmailUtil.sendMailboxVerificationCode("773897474@qq.com", "7rG34r");
	}
	/*public static void main(String[] args) {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setUserName("pangchao620@163.com");
		mailInfo.setPassword("JHSC1314PANG,.");// 您的邮箱密码
		mailInfo.setFromAddress("pangchao620@163.com");
		mailInfo.setToAddress("773897474@qq.com");
		mailInfo.setSubject("scholarprofile");
		mailInfo.setContent("亲爱的773897474@qq.com用户你好：\n"
				+ "    你此次重置密码的验证码如下，请在 30 分钟内输入验证码进行下一步操作。 如非你本人操作，请忽略此邮件。"
				+ "    119922");
		// 这个类主要来发送邮件
		SimpleMailSender sms = new SimpleMailSender();
		boolean result = sms.sendTextMail(mailInfo);// 发送文体格式
		// sms.sendHtmlMail(mailInfo);//发送html格式
		System.out.println(result);
	}*/
}
