package com.moli.manager.bootstrap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceBootStrap {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		context.start();
		
		Object obj = context.getBean("tbItemServiceImpl");
		System.out.println(obj);
		
		//将当期主线程休眠，spring的子线程可以继续
		while(true){
			Thread.sleep(Long.MAX_VALUE);
		}
	}

}
