package com.briup;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.briup.bean.TestExample;

@SpringBootTest
class CmsApplicationTests {
	
	@Test
	void contextLoads() {
		String str = "/user/*";
		String test = "/user/dasd";
		int lastIndexOf = str.lastIndexOf("/");
		String substring = str.substring(0, lastIndexOf);
		String substring2 = test.substring(0, lastIndexOf);
		System.out.println(substring.equals(substring2));
		System.out.println(str.substring(lastIndexOf+1).equals("*"));
		
	}

}
