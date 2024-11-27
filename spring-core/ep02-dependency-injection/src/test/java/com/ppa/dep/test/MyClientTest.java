package com.ppa.dep.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.ppa.depen.MyClient;

@SpringJUnitConfig(classes = MyClient.class)
public class MyClientTest {
	
	@Autowired
	private MyClient client;
	
	@Test
	void demo() {
		client.doBusiness();
	}

}
