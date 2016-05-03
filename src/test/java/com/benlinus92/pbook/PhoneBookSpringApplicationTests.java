package com.benlinus92.pbook;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.benlinus92.pbook.config.PhoneBookSpringApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PhoneBookSpringApplication.class)
@WebAppConfiguration
public class PhoneBookSpringApplicationTests {

	@Test
	public void contextLoads() {
	}

}
