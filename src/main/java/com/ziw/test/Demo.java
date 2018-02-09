package com.ziw.test;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Demo {

	public static ApplicationContext ac = new ClassPathXmlApplicationContext
			("spring/applicationContext.xml");
	
	public static void main(String[] args) {
//		UserController a = (UserController) ac.getBean("userController");
//		a.dododo();
	
		
//		MutablePropertyValues properties=new MutablePropertyValues();  
//        PropertyValue a = properties.getPropertyValue("${resource.AD1_WIDTH_B}");
		
//		String str = (String) ac.getBean("resource.AD1_WIDTH_B");
//		System.out.println(a);
	}
}
