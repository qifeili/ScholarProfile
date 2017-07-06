/**
 * 
 */
package cn.scholarprofile.service;


/** @author  pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月22日 下午5:57:56 
 * @Description : 多线程测试类
 * @version 1.0 
 */
public class ThreadTest {

	public void test() {
		System.out.println("主线程");
		EmailThread emailThread = new EmailThread();
		emailThread.start();
		System.out.println("--->主线程");
	}
	
	public static void main(String[] args) {

		ThreadTest test = new ThreadTest();
		test.test();
	}
	
	class EmailThread extends Thread {

		@Override
		public void run() {
			System.out.println("-------> EmailThread");
		}
		
	}

}
