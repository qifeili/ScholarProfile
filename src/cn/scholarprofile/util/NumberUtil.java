/**
 * 
 */
package cn.scholarprofile.util;

import java.util.Random;

/** @author  pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月22日 下午2:36:27 
 * @Description : 数字工具类
 * @version 1.0 
 */
public class NumberUtil {
	
	// 随机产生数字与字母组合的字符串  
	private final static String randString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";  
	// 验证码的长度
	private final static int length = 6;
	/**
	 * @Description:生成一随机的六位数的验证码
	 * @exception:
	 */
	public static String getNumbers(){  
        Random random = new Random();  
        String result = random.nextInt(1000000) +"";  
          
        if(result.length() != length){  
            return getNumbers();  
        }  
        return result;  
    }  
	
	/**
	 * @Description:生成6位字幕加数字的验证码
	 * @exception:
	 */
	public static String getNumbersAndAlphabet() {
		
		Random random = new Random(); 
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i ++) {
			sb.append(getRandomString(random.nextInt(randString.length())));
		}
		
		return sb.toString();
	}
	
	/* 
     * 获取随机的字符 
     */  
    private static String getRandomString(int num) {  
        return String.valueOf(randString.charAt(num));  
    } 
	
	public static void main(String[] args) {
		for (int j = 0; j < 1000; j++) {  
            System.out.println(NumberUtil.getNumbersAndAlphabet());  
        }  

	}

}
