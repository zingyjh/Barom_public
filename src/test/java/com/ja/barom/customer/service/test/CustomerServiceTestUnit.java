package com.ja.barom.customer.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ja.barom.customer.service.CustomerService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/wepapp/WEB-INF/spring/root-context.xml"})
public class CustomerServiceTestUnit {

	@Autowired
	CustomerService customerService;
	
	@Test
	public void test1() {
		
		assertNotEquals(customerService.getReppleLikeList(), null);
	}
	
	@Test
	public void test2() {
		int a = 10;
		assertEquals(a, 11);
		
	}

	@Test
	public void test3() {
		int a = 10;
		assertEquals(a, 10);
		
	}

}
